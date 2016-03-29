import {Component, Input, Output, EventEmitter, ViewChild} from "angular2/core";
import {ClassTreeComponent} from "../classTree/classTreeComponent";
import {InstanceListComponent} from "../instanceList/instanceListComponent";
import {SearchServices} from "../../services/searchServices";
import {OwlServices} from "../../services/owlServices";
import {ModalServices} from "../../widget/modal/modalServices";
import {ARTURIResource} from "../../utils/ARTResources";
import {RDF, OWL} from "../../utils/Vocabulary";
import {RDFResourceRolesEnum} from "../../utils/Enums";

@Component({
	selector: "class-tree-panel",
	templateUrl: "app/src/owl/classTreePanel/classTreePanelComponent.html",
	directives: [ClassTreeComponent, InstanceListComponent],
    providers: [OwlServices, SearchServices],
})
export class ClassTreePanelComponent {
    @Input('rootclass') rootClass:ARTURIResource;
    @Output() classSelected = new EventEmitter<ARTURIResource>();
    @Output() instanceSelected = new EventEmitter<ARTURIResource>();
    
    @ViewChild(ClassTreeComponent) viewChildTree: ClassTreeComponent;
    @ViewChild(InstanceListComponent) viewChildInstanceList: InstanceListComponent;
    
    private selectedClass:ARTURIResource;
    private selectedInstance:ARTURIResource;
    
	constructor(private owlService:OwlServices, private searchService: SearchServices, private modalService: ModalServices) {}
    
    ngOnInit() {
        if (this.rootClass == undefined) {
            this.rootClass = OWL.thing;
        }
    }
    
    private createClass() {
        //currently uses prompt instead of newResource since createClass service doesn't allow to provide a label
        this.modalService.prompt("Create new owl:Class", "Name", true).then(
            result => {
                this.owlService.createClass(this.rootClass, result).subscribe(
                    stResp => { },
                    err => { }
                )
            },
            () => {}
        );
        
    }
    
    private createSubClass() {
        //currently uses prompt instead of newResource since createClass service doesn't allow to provide a label
        this.modalService.prompt("Create new owl:Class", "Name", true).then(
            result => {
                this.owlService.createClass(this.selectedClass, result).subscribe(
                    stResp => { },
                    err => { }
                );
            },
            () => {}
        );
    }
    
    private deleteClass() {
        if (this.selectedClass.getAdditionalProperty("numInst") != 0) {
            this.modalService.alert("Operation denied", "Cannot delete " + this.selectedClass.getURI() + 
                " since it has instance(s). Please delete the instance(s) and retry.", "warning");
            return;
        }
        this.owlService.removeClass(this.selectedClass).subscribe(
            stResp => {
                this.selectedClass = null;
                this.classSelected.emit(undefined);
            },
            err => { }
        );
    }
    
    private createInstance() {
        //currently uses prompt instead of newResource since createInstance service doesn't allow to provide a label
        this.modalService.prompt("Create new instance", "Name", true).then(
            result => {
                this.owlService.createInstance(this.selectedClass, result).subscribe(
                    stResp => { },
                    err => { }
                );
            },
            () => {}
        );
    }
    
    private deleteInstance() {
        this.owlService.removeInstance(this.selectedInstance, this.selectedClass).subscribe(
            stResp => {
                this.selectedInstance = null;
                this.instanceSelected.emit(undefined);
                //no more selected instance => select the class, so the resource view show the description of this class
                if (this.selectedClass != null) {
                    this.classSelected.emit(this.selectedClass);
                }
            }
        )
    }
    
    private doSearch(searchedText: string) {
        if (searchedText.trim() == "") {
            this.modalService.alert("Search", "Please enter a valid string to search", "error");
        } else {
            this.searchService.searchResource(searchedText, [RDFResourceRolesEnum.cls, RDFResourceRolesEnum.individual], true, "contain").subscribe(
                searchResult => {
                    if (searchResult.length == 0) {
                        this.modalService.alert("Search", "No results found for '" + searchedText + "'", "warning");
                    } else { //1 or more results
                        if (searchResult.length == 1) {
                            this.selectSearchedResource(searchResult[0]);
                        } else { //multiple results, ask the user which one select
                            this.modalService.selectResource("Search", searchResult.length + " results found.", searchResult).then(
                                selectedResource => {
                                    this.selectSearchedResource(selectedResource);
                                },
                                () => {}
                            );
                        }
                    }
                },
                err => { }
            );
        }
    }
    
    /**
     * If resource is a class expands the class tree and select the resource,
     * otherwise (resource is an instance) expands the class tree to the class of the instance and
     * select the instance in the instance list
     */
    private selectSearchedResource(resource: ARTURIResource) {
        if (resource.getRole() == RDFResourceRolesEnum.cls) {
            this.viewChildTree.openTreeAt(resource);
        } else { // resource is an instance
            //get type of instance, then open the tree to that class
            this.owlService.getDirectNamedTypes(resource).subscribe(
                types => {
                    this.viewChildTree.openTreeAt(types[0]);
                    //center instanceList to the individual
                    this.viewChildInstanceList.selectSearchedInstance(types[0], resource);
                }
            )
        }
    }
    
    /**
     * Handles the keydown event in search text field (when enter key is pressed execute the search)
     */
    private searchKeyHandler(key, searchedText) {
        if (key == "13") {
            this.doSearch(searchedText);           
        }
    }
    
    //EVENT LISTENERS
    private onClassSelected(cls:ARTURIResource) {
        this.selectedClass = cls;
        if (this.selectedInstance != null) {
            this.selectedInstance.setAdditionalProperty("selected", false);
            this.selectedInstance = null;    
        }
        this.classSelected.emit(cls);
    }
    
    private onInstanceSelected(instance:ARTURIResource) {
        this.selectedInstance = instance;
        this.instanceSelected.emit(instance);
    }
}