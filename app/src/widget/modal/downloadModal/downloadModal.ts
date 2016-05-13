import {Component} from "@angular/core";
import {BSModalContext} from 'angular2-modal/plugins/bootstrap';
import {DialogRef, ModalComponent} from "angular2-modal";

export class DownloadModalData extends BSModalContext {
    /**
     * @param title modal title
     * @param message modal message
     * @param downloadLink link to download the attached file
     * @param fileName name of the file to download
     */
    constructor(
        public title: string = 'Modal Title',
        public message: string,
        public downloadLink: string,
        public fileName: string
    ) {
        super();
    }
}

@Component({
    selector: "download-modal",
    templateUrl: "app/src/widget/modal/downloadModal/downloadModal.html",
})
export class DownloadModal implements ModalComponent<DownloadModalData> {
    context: DownloadModalData;
    
    constructor(public dialog: DialogRef<DownloadModalData>) {
        this.context = dialog.context;
    }
    
    ngOnInit() {
        document.getElementById("toFocus").focus();
    }

    ok(event) {
        event.stopPropagation();
        this.dialog.close(true);
    }

}