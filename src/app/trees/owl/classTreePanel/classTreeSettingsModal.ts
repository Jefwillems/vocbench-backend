import { Component } from "@angular/core";
import { BSModalContext } from 'ngx-modialog/plugins/bootstrap';
import { DialogRef, ModalComponent } from "ngx-modialog";
import { ARTURIResource, RDFResourceRolesEnum, ResourceUtils } from "../../../models/ARTResources";
import { OWL, RDFS } from "../../../models/Vocabulary";
import { Properties } from "../../../models/Properties";
import { BasicModalServices } from "../../../widget/modal/basicModal/basicModalServices";
import { BrowsingModalServices } from "../../../widget/modal/browsingModal/browsingModalServices";
import { ClassesServices } from "../../../services/classesServices";
import { ResourcesServices } from "../../../services/resourcesServices";
import { VBProperties, ClassTreePreference } from "../../../utils/VBProperties";
import { VBContext } from "../../../utils/VBContext";

@Component({
    selector: "class-tree-settings-modal",
    templateUrl: "./classTreeSettingsModal.html",
})
export class ClassTreeSettingsModal implements ModalComponent<BSModalContext> {
    context: BSModalContext;

    private rootClass: ARTURIResource;
    private filterEnabled: boolean;

    private filterMapRes: FilterMapEntry[] = [];
    private selectedFilteredClass: ARTURIResource;

    constructor(public dialog: DialogRef<BSModalContext>, private clsService: ClassesServices, private resourceService: ResourcesServices, 
        private vbProp: VBProperties, private basicModals: BasicModalServices , private browsingModals: BrowsingModalServices) {
        this.context = dialog.context;
    }

    ngOnInit() {
        let clsTreePref: ClassTreePreference = this.vbProp.getClassTreePreferences();
        this.filterEnabled = clsTreePref.filterEnabled;
        this.resourceService.getResourceDescription(new ARTURIResource(clsTreePref.rootClassUri)).subscribe(
            res => {
                this.rootClass = <ARTURIResource>res;
            }
        );

        let filteredClss: ARTURIResource[] = [];
        for (var key in clsTreePref.filterMap) {
            filteredClss.push(new ARTURIResource(key));
        }
        if (filteredClss.length > 0) {
            this.resourceService.getResourcesInfo(filteredClss).subscribe(
                resources => {
                    resources.forEach(r => {
                        this.filterMapRes.push({ cls: r, subClasses: null });
                    })
                }
            )
        }
        
    }

    /**
     * ROOT CLASS HANDLERS
     */

    private changeClass() {
        this.browsingModals.browseClassTree("Select root class", [RDFS.resource]).then(
            cls => {
                this.rootClass = cls;
            },
            () => {}
        );
    }

    private updateRootClass(clsURI: string) {
        let cls: ARTURIResource = new ARTURIResource(clsURI, null, RDFResourceRolesEnum.cls);
        //check if clsURI exist
        this.resourceService.getResourcePosition(cls).subscribe(
            position => {
                if (position.startsWith("local:")) {
                    this.rootClass = cls;
                } else {
                    this.basicModals.alert("Error", "Wrong URI: no resource with URI " + cls.getNominalValue() + " exists in the current project", "error");
                    //temporarly reset the root class and the restore it (in order to trigger the change detection editable-input)
                    let oldRootClass = this.rootClass;
                    this.rootClass = null;
                    setTimeout(() => this.rootClass = oldRootClass);
                }
            }
        )
        
    }


    /**
     * FILTER MAP HANDLERS
     */

    private selectFilteredClass(cls: ARTURIResource) {
        this.selectedFilteredClass = cls;

        let filterMapEntry: FilterMapEntry = this.getFilterMapEntry(this.selectedFilteredClass);
        if (filterMapEntry.subClasses == null) { //subclasses yet initialized for the given class
            this.clsService.getSubClasses(this.selectedFilteredClass, false).subscribe(
                classes => {
                    ResourceUtils.sortResources(classes, "show");
                    let projBaseURI: string = VBContext.getWorkingProject().getBaseURI();
                    let clsTreePref: ClassTreePreference = this.vbProp.getClassTreePreferences();
                    let filteredSubClssPref = clsTreePref.filterMap[this.selectedFilteredClass.getURI()];
    
                    filterMapEntry.subClasses = [];
    
                    classes.forEach(c => {
                        let graphs: ARTURIResource[] = c.getGraphs();
                        for (var i = 0; i < graphs.length; i++) {
                            if (graphs[i].getURI() == projBaseURI) {
                                return; //subclass not defined by a vocabulary, but defined in the main graph, so cannot be filtered
                            }
                        }
                        
                        if (filteredSubClssPref != null) { //exists a subclasses filter for the selected class
                            filterMapEntry.subClasses.push({ 
                                checked: filteredSubClssPref.indexOf(c.getURI()) == -1, //subClass not in the filter, so checked (visible)
                                disabled: c.getURI() == OWL.thing.getURI(), //owl:Thing cannot be filtered out
                                resource: c 
                            });
                        } else { //doesn't exist a subclasses filter for the selected class => every subclasses is checked
                        filterMapEntry.subClasses.push({ checked: true, disabled: c.getURI() == OWL.thing.getURI(), resource: c });
                        }
                    });
                }
            );
        }
    }

    private getFilterSubClasses(): SubClassFilterItem[] {
        if (this.selectedFilteredClass != null) {
            return this.getFilterMapEntry(this.selectedFilteredClass).subClasses;
        } else {
            return [];
        }
    }

    private addFilter() {
        this.browsingModals.browseClassTree("Select class", [RDFS.resource]).then(
            (cls: ARTURIResource) => {
                if (this.getFilterMapEntry(cls) == null) {
                    this.filterMapRes.push({ cls: cls, subClasses: null });
                } else {
                    this.basicModals.alert("Error", "A filter for class " + cls.getShow() + " already exists.", "warning");
                }
            },
            () => {}
        );
    }

    private removeFilter() {
        for (var i = 0; i < this.filterMapRes.length; i++) {
            if (this.filterMapRes[i].cls.getURI() == this.selectedFilteredClass.getURI()) {
                this.filterMapRes.splice(i, 1);
                return;
            }
        }
    }

    private checkAllClasses(checked: boolean) {
        this.getFilterMapEntry(this.selectedFilteredClass).subClasses.forEach((c: SubClassFilterItem) => {
            if (!c.disabled) {
                c.checked = checked;
            }
        });
    }

    private getFilterMapEntry(cls: ARTURIResource): FilterMapEntry {
        for (var i = 0; i < this.filterMapRes.length; i++) {
            if (this.filterMapRes[i].cls.getURI() == cls.getURI()) {
                return this.filterMapRes[i];
            }
        }
        return null;
    }

    ok(event: Event) {
        //convert filterMapRes to a map string: string[]
        let filterMap: {[key: string]: string[]} = {};
        this.filterMapRes.forEach(f => {
            let filteredSubClasses: string[] = [];
            if (f.subClasses == null) {
                //subClasses in filterMapRes not yet initialized => get it from the preference
                filteredSubClasses = this.vbProp.getClassTreePreferences().filterMap[f.cls.getURI()];
            } else {
                for (var i = 0; i < f.subClasses.length; i++) {
                    if (!f.subClasses[i].checked) {
                        filteredSubClasses.push(f.subClasses[i].resource.getURI());
                    }
                }
            }
            filterMap[f.cls.getURI()] = filteredSubClasses;
        })

        let ctPref: ClassTreePreference = {
            rootClassUri: this.rootClass.getURI(),
            filterEnabled: this.filterEnabled,
            filterMap: filterMap
        }

        let classTreePref = this.vbProp.getClassTreePreferences();
        this.vbProp.setClassTreePreference(ctPref);
        //only if the root class changed close the dialog (so that the class tree refresh)
        if (classTreePref.rootClassUri != ctPref.rootClassUri) {
            event.stopPropagation();
            event.preventDefault();
            this.dialog.close();
        } else { //for other changes simply dismiss the modal
            this.cancel();
        }
    }

    cancel() {
        this.dialog.dismiss();
    }

}

class FilterMapEntry {
    cls: ARTURIResource;
    subClasses: SubClassFilterItem[];
}

class SubClassFilterItem {
    checked: boolean;
    resource: ARTURIResource;
    disabled?: boolean;
}