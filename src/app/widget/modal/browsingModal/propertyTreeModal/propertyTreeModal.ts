import {Component} from "@angular/core";
import {BSModalContext} from 'angular2-modal/plugins/bootstrap';
import {DialogRef, ModalComponent} from "angular2-modal";
import {ARTURIResource} from '../../../../utils/ARTResources';

export class PropertyTreeModalData extends BSModalContext {
    /**
     * @param resource optional, if provided the returned propertyTree contains 
     * just the properties that have as domain the type of the resource 
     */
    constructor(
        public title: string = 'Modal Title',
        public resource: ARTURIResource
    ) {
        super();
    }
}

@Component({
    selector: "class-tree-modal",
    templateUrl: "./propertyTreeModal.html",
})
export class PropertyTreeModal implements ModalComponent<PropertyTreeModalData> {
    context: PropertyTreeModalData;
    
    private selectedProperty: ARTURIResource;
    private domainRes: ARTURIResource;
    
    constructor(public dialog: DialogRef<PropertyTreeModalData>) {
        this.context = dialog.context;
    }
    
    ngOnInit() {
        this.domainRes = this.context.resource;
    }
    
    private onPropertySelected(property: ARTURIResource) {
        this.selectedProperty = property;
    }
    
    /**
     * When the checkbox "select all properties" changes status
     * Resets the selectedProperty and update the domainRes that represents 
     * the resource which its type should be the domain of the properties in the tree
     */
    private onCheckboxChange(checked: boolean) {
        this.selectedProperty = null;
        if (checked) {
            this.domainRes = null;
        } else {
            this.domainRes = this.context.resource;
        }
    }

    ok(event: Event) {
        event.stopPropagation();
        event.preventDefault();
        this.dialog.close(this.selectedProperty);
    }

    cancel() {
        this.dialog.dismiss();
    }
    
}