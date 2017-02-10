import {Injectable} from '@angular/core';
import {Modal, BSModalContextBuilder} from 'angular2-modal/plugins/bootstrap';
import {OverlayConfig} from 'angular2-modal';
import {ClassListCreatorModal, ClassListCreatorModalData} from "./classListCreatorModal";
import {InstanceListCreatorModal, InstanceListCreatorModalData} from "./instanceListCreatorModal";
import {EnrichPropertyModal, EnrichPropertyModalData} from "./enrichPropertyModal";
import {AddPropertyValueModal, AddPropertyValueModalData} from "./addPropertyValueModal";
import {CustomFormModal, CustomFormModalData} from "../../customRanges/customForm/customFormModal";
import {ARTResource, ARTURIResource} from '../../models/ARTResources';

/**
 * Service to open modals that allow to create a classes list or instances list
 */
@Injectable()
export class ResViewModalServices {
    
    constructor(private modal: Modal) {}
    
    /**
     * Opens a modal to create a list of classes (useful for class axioms)
     * @param title the title of the modal
     * @return if the modal closes with ok returns a promise containing an array of 
     * classes (ARTURIResource) and expressions (ARTBNode)
     */
    createClassList(title: string) {
        var modalData = new ClassListCreatorModalData(title);
        const builder = new BSModalContextBuilder<ClassListCreatorModalData>(
            modalData, undefined, ClassListCreatorModalData
        );
        builder.size("lg").keyboard(null);
        let overlayConfig: OverlayConfig = { context: builder.toJSON() };
        return this.modal.open(ClassListCreatorModal, overlayConfig).then(
            dialog => dialog.result
        );
    }
    
    /**
     * Opens a modal to create a list of instance (useful for class axioms)
     * @param title the title of the modal
     * @return if the modal closes with ok returns a promise containing an array of instances
     */
    createInstanceList(title: string) {
        var modalData = new InstanceListCreatorModalData(title);
        const builder = new BSModalContextBuilder<InstanceListCreatorModalData>(
            modalData, undefined, InstanceListCreatorModalData
        );
        builder.size("lg").keyboard(null);
        let overlayConfig: OverlayConfig = { context: builder.toJSON() };
        return this.modal.open(InstanceListCreatorModal, overlayConfig).then(
            dialog => dialog.result
        );
    }
    
    /**
     * Opens a modal to select a resource to set as value of a property with range "resource"
     * @param title the title of the modal
     * @param property property to enrich with a resource
     * @param ranges admitted range classes of the property
     * @return if the modal closes with ok returns a promise containing the selected resource
     */
    enrichProperty(title: string, property: ARTURIResource, ranges?: ARTURIResource[]) {
        var modalData = new EnrichPropertyModalData(title, property, ranges);
        const builder = new BSModalContextBuilder<EnrichPropertyModalData>(
            modalData, undefined, EnrichPropertyModalData
        );
        builder.size("lg").keyboard(null);
        let overlayConfig: OverlayConfig = { context: builder.toJSON() };
        return this.modal.open(EnrichPropertyModal, overlayConfig).then(
            dialog => dialog.result
        );
    }
    
    /**
     * Opens a modal with a custom form to enrich a property with a custom range.
     * @param title title of the dialog
     * @param creId custom range entry ID
     */
    enrichCustomForm(title: string, creId: string) {
        var modalData = new CustomFormModalData(title, creId);
        const builder = new BSModalContextBuilder<CustomFormModalData>(
            modalData, undefined, CustomFormModalData
        );
        let overlayConfig: OverlayConfig = { context: builder.keyboard(null).toJSON() };
        return this.modal.open(CustomFormModal, overlayConfig).then(
            dialog => dialog.result
        );
    }

    /**
     * Opens a modal that allows to select a property and add a value to it.
     * Returns and object containing "property" and "value".
     * @param title title of the dialog
     * @param resource resource that is going to enrich with the property-value pair.
     * @param property root property that the modal should allow to enrich
     * @param propChangeable tells whether the input property can be changed exploring the properties subtree.
     *  If false, the button to change property is hidden
     */
    addPropertyValue(title: string, resource: ARTResource, property: ARTURIResource, propChangeable?: boolean) {
        var modalData = new AddPropertyValueModalData(title, resource, property, propChangeable);
        const builder = new BSModalContextBuilder<AddPropertyValueModalData>(
            modalData, undefined, AddPropertyValueModalData
        );
        // builder.size("lg").keyboard(null);
        builder.keyboard(null);
        let overlayConfig: OverlayConfig = { context: builder.toJSON() };
        return this.modal.open(AddPropertyValueModal, overlayConfig).then(
            dialog => dialog.result
        );
    }
    
}