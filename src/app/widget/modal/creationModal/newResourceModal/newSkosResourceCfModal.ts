import { Component, ViewChild, ElementRef } from "@angular/core";
import { BSModalContext } from 'angular2-modal/plugins/bootstrap';
import { DialogRef, ModalComponent } from "angular2-modal";
import { AbstractCustomConstructorModal } from "./abstractCustomConstructorModal"
import { CustomFormsServices } from "../../../../services/customFormsServices"
import { BasicModalServices } from "../../basicModal/basicModalServices"
import { BrowsingModalServices } from "../../browsingModal/browsingModalServices"
import { ARTLiteral, ARTURIResource } from "../../../../models/ARTResources"

export class NewSkosResourceCfModalData extends BSModalContext {
    constructor(
        public title: string = "Modal title",
        public cls: ARTURIResource, //class that this modal is creating
        public clsChangeable: boolean = true,
        public lang: string
    ) {
        super();
    }
}

@Component({
    selector: "new-skos-resource-cf-modal",
    templateUrl: "./newSkosResourceCfModal.html",
})
export class NewSkosResourceCfModal extends AbstractCustomConstructorModal implements ModalComponent<NewSkosResourceCfModalData> {
    context: NewSkosResourceCfModalData;

    @ViewChild("toFocus") inputToFocus: ElementRef;

    //standard form
    private label: string;
    private lang: string;
    private uri: string;

    constructor(public dialog: DialogRef<NewSkosResourceCfModalData>, cfService: CustomFormsServices,
        basicModals: BasicModalServices, browsingModals: BrowsingModalServices) {
        super(cfService, basicModals, browsingModals);
        this.context = dialog.context;
    }

    ngOnInit() {
        this.lang = this.context.lang;
        this.resourceClass = this.context.cls;
        this.selectCustomForm();
    }

    ngAfterViewInit() {
        this.inputToFocus.nativeElement.focus();
    }

    private onLangChange(newLang: string) {
        this.lang = newLang;
    }

    changeClass() {
        this.changeClassWithRoot(this.context.cls);
    }

    isStandardFormDataValid(): boolean {
        return (this.label != undefined && this.label.trim() != "");
    }

    ok(event: Event) {
        event.stopPropagation();
        event.preventDefault();

        var entryMap: any = this.collectCustomFormData();

        var returnedData: { uriResource: ARTURIResource, label: ARTLiteral, cls: ARTURIResource, cfId: string, cfValueMap: any} = {
            uriResource: null,
            label: new ARTLiteral(this.label, null, this.lang),
            cls: this.resourceClass,
            cfId: this.customFormId,
            cfValueMap: entryMap
        }
        //Set URI only if localName is not empty
        if (this.uri != null && this.uri.trim() != "") {
            returnedData.uriResource = new ARTURIResource(this.uri);
        }
        this.dialog.close(returnedData);
    }

    cancel() {
        this.dialog.dismiss();
    }

}