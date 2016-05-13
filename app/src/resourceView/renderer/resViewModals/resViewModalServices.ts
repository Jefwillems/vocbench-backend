import {Injectable} from '@angular/core';
import {Modal} from 'angular2-modal/plugins/bootstrap';
import {ClassListCreatorModal, ClassListCreatorModalData} from "./classListCreatorModal";
import {InstanceListCreatorModal, InstanceListCreatorModalData} from "./instanceListCreatorModal";
import {EnrichPropertyModal, EnrichPropertyModalData} from "./enrichPropertyModal";
import {ARTURIResource} from '../../../utils/ARTResources';

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
        return this.modal.open(ClassListCreatorModal, modalData).then(
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
        return this.modal.open(InstanceListCreatorModal, modalData).then(
            dialog => dialog.result
        );
    }
    
    /**
     * Opens a modal to select a resource to set as value of a property with range "resource"
     * @param title the title of the modal
     * @return if the modal closes with ok returns a promise containing the selected resource
     */
    enrichProperty(title: string, property: ARTURIResource, ranges: ARTURIResource[]) {
        var modalData = new EnrichPropertyModalData(title, property, ranges);
        return this.modal.open(EnrichPropertyModal, modalData).then(
            dialog => dialog.result
        );
    }
    
}