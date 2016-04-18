import {Component, Input, Output, EventEmitter, ViewChild, ViewChildren, QueryList} from "angular2/core";
import {ARTURIResource} from "../../../utils/ARTResources";
import {VBEventHandler} from "../../../utils/VBEventHandler";
import {RDFResourceRolesEnum} from "../../../utils/Enums";
import {SkosServices} from "../../../services/skosServices";
import {SearchServices} from "../../../services/searchServices";
import {ConceptTreeNodeComponent} from "./conceptTreeNodeComponent";

@Component({
    selector: "concept-tree",
    templateUrl: "app/src/skos/concept/conceptTree/conceptTreeComponent.html",
    directives: [ConceptTreeNodeComponent],
    providers: [SkosServices, SearchServices],
    host: { class: "blockingDivHost" }
})
export class ConceptTreeComponent {
    @Input() scheme: ARTURIResource;
    @Input() schemeChangeable: boolean = false;//if true, on top of tree there is a menu that allows to change scheme dynamically
    @Output() itemSelected = new EventEmitter<ARTURIResource>();
    
    //ConceptTreeNodeComponent children of this Component (useful to open tree during the search)
    @ViewChildren(ConceptTreeNodeComponent) viewChildrenNode: QueryList<ConceptTreeNodeComponent>;
    
    //get the element in the view referenced with #blockDivTree
    @ViewChild('blockDivTree') blockDivElement;

    public roots: ARTURIResource[];
    private selectedNode: ARTURIResource;
    
    private schemeList: Array<ARTURIResource>;
    private selectedScheme: ARTURIResource; //keep track of the selected scheme 
        //(useful expecially when schemeChangeable is true so changes don't effect the scheme in context)

    private eventSubscriptions = [];

    constructor(private skosService: SkosServices, private searchService: SearchServices, private eventHandler: VBEventHandler) {
        this.eventSubscriptions.push(eventHandler.topConceptCreatedEvent.subscribe(
            data => this.onTopConceptCreated(data.concept, data.scheme)));
        this.eventSubscriptions.push(eventHandler.conceptDeletedEvent.subscribe(
            deletedConcept => this.onConceptDeleted(deletedConcept)));
        this.eventSubscriptions.push(eventHandler.conceptRemovedFromSchemeEvent.subscribe(
            data => this.onConceptRemovedFromScheme(data.concept, data.scheme)));
        this.eventSubscriptions.push(eventHandler.conceptRemovedAsTopConceptEvent.subscribe(
            data => this.onConceptRemovedFromScheme(data.concept, data.scheme)));
    }
    
    ngOnInit() {
        this.selectedScheme = this.scheme;
        if (this.schemeChangeable) {
            this.skosService.getAllSchemesList().subscribe(
                schemes => {
                    this.schemeList = schemes;
                    if (this.scheme != undefined) {
                        // take selected scheme from the passed input scheme
                        for (var i = 0; i < this.schemeList.length; i++) {
                            if (this.schemeList[i].getURI() == this.scheme.getURI()) {
                                this.selectedScheme = this.schemeList[i];
                                console.log("selected scheme updated " + JSON.stringify(this.selectedScheme));
                                break;
                            }
                        }
                    }
                }
            );
        }
    }
    
    /**
     * Here I use ngAfterViewInit instead of ngOnInit because I need to wait that 
     * the view #blockDivTree is initialized
     */
    ngAfterViewInit() {
        this.initTree();
    }
    
    private initTree() {
        console.log("init tree with scheme " + JSON.stringify(this.selectedScheme));
        this.blockDivElement.nativeElement.style.display = "block";
        this.skosService.getTopConcepts(this.selectedScheme).subscribe(
            topConcepts => {
                this.roots = topConcepts;
            },
            err => { },
            () => this.blockDivElement.nativeElement.style.display = "none"
        );
    }
    
    ngOnDestroy() {
        this.eventHandler.unsubscribeAll(this.eventSubscriptions);
    }
    
    public openTreeAt(node: ARTURIResource) {
        this.searchService.getPathFromRoot(node, RDFResourceRolesEnum.concept, this.selectedScheme).subscribe(
            path => {
                var childrenNodeComponent = this.viewChildrenNode.toArray();
                //open tree from root to node
                for (var i = 0; i < childrenNodeComponent.length; i++) {//looking for first node (root) to expand
                    if (childrenNodeComponent[i].node.getURI() == path[0].getURI()) {
                        //let the found node expand itself and the remaining path
                        path.splice(0, 1);
                        childrenNodeComponent[i].expandPath(path);
                        break;
                    }
                }
            }
        );
    }
    
    /**
     * Listener to <select> element that allows to change dynamically the scheme of the 
     * concept tree (visible only if @Input schemeChangeable is true).
     * Input object could be an ARTURIResource (a scheme) or a string ("---" for no-scheme mode)
     */
    private changeSelectedScheme(scheme: any) {
        if (scheme instanceof ARTURIResource) {
            this.selectedScheme = scheme;
        } else { //selected <option> is "---", so no-scheme mode
            this.selectedScheme = null;
        }
        this.initTree();
    }
    
    
    //EVENT LISTENERS
    
    private onNodeSelected(node: ARTURIResource) {
        if (this.selectedNode == undefined) {
            this.selectedNode = node;
            this.selectedNode.setAdditionalProperty("selected", true);
        } else {
            this.selectedNode.deleteAdditionalProperty("selected");
            this.selectedNode = node;
            this.selectedNode.setAdditionalProperty("selected", true);
        }
        this.itemSelected.emit(node);
    }

    private onTopConceptCreated(concept: ARTURIResource, scheme: ARTURIResource) {
        if (this.scheme == undefined) {//in no-scheme mode add always to the roots
            this.roots.push(concept);
        } else if (this.scheme.getURI() == scheme.getURI()) {//otherwise add it only if it's been created in the current scheme 
            this.roots.push(concept);       
        }
    }

    private onConceptDeleted(deletedConcept: ARTURIResource) {
        //check if the concept to delete is a root
        for (var i = 0; i < this.roots.length; i++) {
            if (this.roots[i].getURI() == deletedConcept.getURI()) {
                this.roots.splice(i, 1);
                break;
            }
        }
        //reset the selected item
        this.itemSelected.emit(undefined);
    }
    
    //data contains "concept" and "scheme"
    private onConceptRemovedFromScheme(concept: ARTURIResource, scheme: ARTURIResource) {
        if (this.selectedScheme != undefined && this.selectedScheme.getURI() == scheme.getURI()) {
            this.onConceptDeleted(concept);
        }
    }

}