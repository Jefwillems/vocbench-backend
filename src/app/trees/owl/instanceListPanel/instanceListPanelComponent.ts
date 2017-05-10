import { Component, Input, Output, EventEmitter, ViewChild } from "@angular/core";
import { AbstractPanel } from "../../abstractPanel"
import { InstanceListComponent } from "../instanceList/instanceListComponent";
import { SearchServices } from "../../../services/searchServices";
import { OwlServices } from "../../../services/owlServices";
import { ClassesServices } from "../../../services/classesServices";
import { DeleteServices } from "../../../services/deleteServices";
import { CustomFormsServices } from "../../../services/customFormsServices";
import { BasicModalServices } from "../../../widget/modal/basicModal/basicModalServices";
import { CreationModalServices } from "../../../widget/modal/creationModal/creationModalServices";
import { ARTURIResource } from "../../../models/ARTResources";
import { UIUtils } from "../../../utils/UIUtils";

@Component({
    selector: "instance-list-panel",
    templateUrl: "./instanceListPanelComponent.html",
})
export class InstanceListPanelComponent extends AbstractPanel {
    @Input() hideSearch: boolean = false; //if true hide the search bar
    @Input() cls: ARTURIResource; //class of the instances

    @ViewChild(InstanceListComponent) viewChildInstanceList: InstanceListComponent;

    rendering: boolean = false; //override the value in AbstractPanel

    constructor(private classesService: ClassesServices, private owlService: OwlServices, private deleteService: DeleteServices, 
        private searchService: SearchServices, private creationModals: CreationModalServices,
        cfService: CustomFormsServices, basicModals: BasicModalServices) {
        super(cfService, basicModals);
    }

    private create() {
        this.creationModals.newResourceCf("Create a new instance of " + this.cls.getShow(), this.cls, false).then(
            (data: any) => {
                this.classesService.createInstance(data.uriResource, this.cls, data.cfId, data.cfValueMap).subscribe();
            },
            () => {}
        );
    }

    delete() {
        UIUtils.startLoadingDiv(this.viewChildInstanceList.blockDivElement.nativeElement);
        this.deleteService.removeInstance(this.selectedNode, this.cls).subscribe(
            stResp => {
                this.selectedNode = null;
                this.nodeSelected.emit(this.selectedNode);
                UIUtils.stopLoadingDiv(this.viewChildInstanceList.blockDivElement.nativeElement);
            },
            err => { UIUtils.stopLoadingDiv(this.viewChildInstanceList.blockDivElement.nativeElement); }
        )
    }

    refresh() {
        this.selectedNode = null;
        this.nodeSelected.emit(this.selectedNode);
        this.viewChildInstanceList.initList();
    }

    //search handlers

    doSearch(searchedText: string) {
        if (searchedText.trim() == "") {
            this.basicModals.alert("Search", "Please enter a valid string to search", "error");
        } else {
            this.searchService.searchInstancesOfClass(this.cls, searchedText, true, true, "contain").subscribe(
                searchResult => {
                    if (searchResult.length == 0) {
                        this.basicModals.alert("Search", "No results found for '" + searchedText + "'", "warning");
                    } else { //1 or more results
                        if (searchResult.length == 1) {
                            this.selectSearchedInstance(this.cls, searchResult[0]);
                        } else { //multiple results, ask the user which one select
                            this.basicModals.selectResource("Search", searchResult.length + " results found.", searchResult).then(
                                (selectedResource: any) => {
                                    this.selectSearchedInstance(this.cls, selectedResource);
                                },
                                () => { }
                            );
                        }
                    }
                }
            );
        }
    }

    //this is public so it can be invoked from classIndividualTreePanelComponent
    selectSearchedInstance(cls: ARTURIResource, instance: ARTURIResource) {
        this.viewChildInstanceList.selectSearchedInstance(cls, instance);
    }

    onNodeSelected(node: ARTURIResource) {
        this.selectedNode = node;
        this.nodeSelected.emit(node);
    }

}