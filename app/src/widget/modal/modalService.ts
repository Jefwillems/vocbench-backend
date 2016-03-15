import {Injectable, Injector, provide} from 'angular2/core';
import {Modal, ModalConfig, ModalDialogInstance, ICustomModal} from 'angular2-modal/angular2-modal';
import {PromptModal, PromptModalContent} from "./promptModal/promptModal";
import {ConfirmModal, ConfirmModalContent} from "./confirmModal/confirmModal";
import {AlertModal, AlertModalContent} from "./alertModal/alertModal";

@Injectable()
export class ModalService {
    
    constructor(private modal: Modal) {}
    
    /**
     * Opens a modal with an input text and two buttons (Ok and Cancel) with the given title and content message.
     * Returns a Promise with the result.
     * @param title the title of the modal dialog
     * @param label the label of the input field
     */
    prompt(title: string, label: string) {
        let dialog: Promise<ModalDialogInstance>;
        let component = PromptModal;
        
        //bind the modal content
        var modalContent = new PromptModalContent(title, label, false);
        let bindings = Injector.resolve([
            provide(ICustomModal, {useValue: modalContent})
        ]);
        //set the modal configuration (small dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("sm", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog;
    }
    
    /**
     * Opens a modal with two buttons (Yes and No) with the given title and content message.
     * Returns a Promise with the result
     * @param title the title of the modal dialog
     * @param message the message to show in the modal dialog body
     * @param type tells the type of the dialog. Determines the style of the message in the dialog.
     * Available values: info (default), error, warning
     */
    confirm(title: string, message: string, type?: string) {
        let dialog: Promise<ModalDialogInstance>;
        let component = ConfirmModal;
        
        var modalType = type ? type : "warning"; //set default type to warning if not defined
        
        //bind the modal content
        var modalContent = new ConfirmModalContent(title, message, modalType);
        let bindings = Injector.resolve([
            provide(ICustomModal, {useValue: modalContent})
        ]);
        //set the modal configuration (small dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("sm", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog;
    }
    
    /**
     * Opens a modal with an info message and a single button to dismiss the modal.
     * @param title the title of the modal dialog
     * @param message the message to show in the modal dialog body
     * @param type tells the type of the dialog. Determines the style of the message in the dialog.
     * Available values: info (default), error, warning
     */
    alert(title: string, message: string, type?: string) {
        let dialog: Promise<ModalDialogInstance>;
        let component = AlertModal;
        
        var modalType = type ? type : "info"; //set default type to info if not defined
        
        //bind the modal content
        var modalContent = new AlertModalContent(title, message, modalType);
        let bindings = Injector.resolve([
            provide(ICustomModal, {useValue: modalContent})
        ]);
        //set the modal configuration (small dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("sm", true, null);
        
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog;
    }
    
}