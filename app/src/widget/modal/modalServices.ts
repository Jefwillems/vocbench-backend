import {Injectable, Injector, provide} from 'angular2/core';
import {Modal, ModalConfig, ModalDialogInstance, ICustomModal} from 'angular2-modal/angular2-modal';
import {PromptModal, PromptModalContent} from "./promptModal/promptModal";
import {ConfirmModal, ConfirmModalContent} from "./confirmModal/confirmModal";
import {AlertModal, AlertModalContent} from "./alertModal/alertModal";
import {NewResourceModal, NewResourceModalContent} from "./newResourceModal/newResourceModal";
import {NewLiteralLangModal, NewLiteralLangModalContent} from "./newLiteralLangModal/newLiteralLangModal";

type ModalType = "info" | "error" | "warning";

@Injectable()
export class ModalServices {
    
    constructor(private modal: Modal) {}
    
    /**
     * Opens a modal with an input text and two buttons (Ok and Cancel) with the given title and content message.
     * Returns a Promise with the result.
     * @param title the title of the modal dialog
     * @param label the label of the input field
     * @param inputSanitized tells if the text in the input field should be sanitized
     * @return if the modal closes with ok returns a promise containing the input text
     */
    prompt(title: string, label: string, inputSanitized?: boolean) {
        let dialog: Promise<ModalDialogInstance>;
        let component = PromptModal;
        
        //inject the modal content in the modal Component
        var modalContent = new PromptModalContent(title, label, false, "Ok", "Cancel", false, inputSanitized);
        let bindings = Injector.resolve([provide(ICustomModal, {useValue: modalContent})]);
        
        //set the modal configuration (small dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("md", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog.then(
            resultPromise => {
                return resultPromise.result;
            }
        );
    }
    
    /**
     * Opens a modal with two buttons (Yes and No) with the given title and content message.
     * Returns a Promise with the result
     * @param title the title of the modal dialog
     * @param message the message to show in the modal dialog body
     * @param type tells the type of the dialog. Determines the style of the message in the dialog.
     * Available values: info (default), error, warning
     * @return if the modal closes with ok returns a promise containing a boolean true
     */
    confirm(title: string, message: string, type?: ModalType) {
        let dialog: Promise<ModalDialogInstance>;
        let component = ConfirmModal;
        
        var modalType = type ? type : "warning"; //set default type to warning if not defined
        
        //inject the modal content in the modal Component
        var modalContent = new ConfirmModalContent(title, message, modalType);
        let bindings = Injector.resolve([provide(ICustomModal, {useValue: modalContent})]);
        
        //set the modal configuration (small dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("md", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog.then(
            resultPromise => {
                return resultPromise.result;
            }
        );
    }
    
    /**
     * Opens a modal with an info message and a single button to dismiss the modal.
     * @param title the title of the modal dialog
     * @param message the message to show in the modal dialog body
     * @param type tells the type of the dialog. Determines the style of the message in the dialog.
     * Available values: info (default), error, warning
     */
    alert(title: string, message: string, type?: ModalType) {
        let dialog: Promise<ModalDialogInstance>;
        let component = AlertModal;
        
        var modalType = type ? type : "info"; //set default type to info if not defined
        
        //inject the modal content in the modal Component
        var modalContent = new AlertModalContent(title, message, modalType);
        let bindings = Injector.resolve([provide(ICustomModal, {useValue: modalContent})]);
        
        //set the modal configuration (small dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("md", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog;
    }
    
    /**
     * Opens a modal to create a new resource with name, label and language tag
     * @param title the title of the modal dialog
     * @return if the modal closes with ok returns a promise containing an object with name, label and lang
     */
    newResource(title: string) {
        let dialog: Promise<ModalDialogInstance>;
        let component = NewResourceModal;
        
        //inject the modal content in the modal Component
        var modalContent = new NewResourceModalContent(title);
        let bindings = Injector.resolve([provide(ICustomModal, {useValue: modalContent})]);
        
        //set the modal configuration (medium dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("md", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog.then(
            resultPromise => {
                return resultPromise.result;
            }
        );
    }
    
    /**
     * Opens a modal to create a new literal with language tag
     * @param title the title of the modal dialog
     * @return if the modal closes with ok returns a promise containing an object with value and lang
     */
    newLiteralLang(title: string) {
        let dialog: Promise<ModalDialogInstance>;
        let component = NewLiteralLangModal;
        
        //inject the modal content in the modal Component
        var modalContent = new NewLiteralLangModalContent(title);
        let bindings = Injector.resolve([provide(ICustomModal, {useValue: modalContent})]);
        
        //set the modal configuration (medium dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("md", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog.then(
            resultPromise => {
                return resultPromise.result;
            }
        );
    }
    
}