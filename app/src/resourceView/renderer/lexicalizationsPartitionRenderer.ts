import {Component, Input, Output, EventEmitter} from "angular2/core";
import {VocbenchCtx} from "../../utils/VocbenchCtx";
import {ARTURIResource, ARTNode, ARTLiteral, ARTPredicateObjects} from "../../utils/ARTResources";
import {ResourceUtils} from "../../utils/ResourceUtils";
import {RDFS, SKOS, SKOSXL} from "../../utils/Vocabulary";
import {RDFTypesEnum} from "../../utils/Enums";
import {RdfResourceComponent} from "../../widget/rdfResource/rdfResourceComponent";
import {ModalServices} from "../../widget/modal/modalServices";
import {SkosServices} from "../../services/skosServices";
import {SkosxlServices} from "../../services/skosxlServices";
import {OwlServices} from "../../services/owlServices";
import {PropertyServices} from "../../services/propertyServices";

@Component({
	selector: "lexicalizations-renderer",
	templateUrl: "app/src/resourceView/renderer/lexicalizationsPartitionRenderer.html",
	directives: [RdfResourceComponent],
    providers: [SkosServices, SkosxlServices, OwlServices, PropertyServices],
})
export class LexicalizationsPartitionRenderer {
    
    @Input('pred-obj-list') predicateObjectList: ARTPredicateObjects[];
    @Input() resource:ARTURIResource;
    @Output() update = new EventEmitter();//something changed in this partition. Tells to ResView to update
    
    private showAllLexicalProp = false;
    
    private lexicalizationProperties = [
        SKOSXL.prefLabel, SKOSXL.altLabel, SKOSXL.hiddenLabel,
        SKOS.prefLabel, SKOS.altLabel, SKOS.hiddenLabel, RDFS.label
    ];
    
    constructor(private skosService:SkosServices, private owlService:OwlServices, private skosxlService: SkosxlServices,
        private propertyService:PropertyServices, private modalService: ModalServices, private vbCtx: VocbenchCtx) {}
    
    private add(predicate: ARTURIResource) {
        this.modalService.newLiteralLang("Add " + predicate.getShow()).then(
            result => {
                switch (predicate.getURI()) {
                    case SKOSXL.prefLabel.getURI():
                        this.skosxlService.setPrefLabel(this.resource, result.literal, result.lang, RDFTypesEnum.bnode).subscribe(
                            stResp => this.update.emit(null),
                            err => { this.modalService.alert("Error", err, "error"); console.error(err['stack']); }
                        );
                        break;
                    case SKOSXL.altLabel.getURI():
                        this.skosxlService.addAltLabel(this.resource, result.literal, result.lang, RDFTypesEnum.bnode).subscribe(
                            stResp => this.update.emit(null),
                            err => { this.modalService.alert("Error", err, "error"); console.error(err['stack']); }
                        );
                        break;
                    case SKOSXL.hiddenLabel.getURI():
                        this.skosxlService.addHiddenLabel(this.resource, result.literal, result.lang, RDFTypesEnum.bnode).subscribe(
                            stResp => this.update.emit(null),
                            err => { this.modalService.alert("Error", err, "error"); console.error(err['stack']); }
                        );
                        break;
                    case SKOS.prefLabel.getURI():
                        this.skosService.setPrefLabel(this.resource, result.literal, result.lang).subscribe(
                            stResp => this.update.emit(null),
                            err => { this.modalService.alert("Error", err, "error"); console.error(err['stack']); }
                        );
                        break;
                    case SKOS.altLabel.getURI():
                        this.skosService.addAltLabel(this.resource, result.literal, result.lang).subscribe(
                            stResp => this.update.emit(null),
                            err => { this.modalService.alert("Error", err, "error"); console.error(err['stack']); }
                        );
                        break;
                    case SKOS.hiddenLabel.getURI():
                        this.skosService.addHiddenLabel(this.resource, result.literal, result.lang).subscribe(
                            stResp => this.update.emit(null),
                            err => { this.modalService.alert("Error", err, "error"); console.error(err['stack']); }
                        );
                        break;
                    case RDFS.label.getURI():
                        this.propertyService.createAndAddPropValue(
                            this.resource, predicate, result.literal, null, RDFTypesEnum.plainLiteral, result.lang).subscribe(
                            stResp => this.update.emit(null),
                            err => { this.modalService.alert("Error", err, "error"); console.error(err['stack']); }
                        );
                        break;
                }
            }
        );
    }
    
    private removePredicateObject(predicate: ARTURIResource, object: ARTNode) {
        switch (predicate.getURI()) {
            case SKOSXL.prefLabel.getURI():
                this.skosxlService.removePrefLabel(this.resource, object.getShow(), object.getAdditionalProperty("lang")).subscribe(
                    stResp => this.update.emit(null),
                    err => { this.modalService.alert("Error", err, "error"); console.error(err.stack); }
                );
                break;
            case SKOSXL.altLabel.getURI():
                this.skosxlService.removeAltLabel(this.resource, object.getShow(), object.getAdditionalProperty("lang")).subscribe(
                    stResp => this.update.emit(null),
                    err => { this.modalService.alert("Error", err, "error"); console.error(err.stack); }
                );
                break;
            case SKOSXL.hiddenLabel.getURI():
                this.skosxlService.removeHiddenLabel(this.resource, object.getShow(), object.getAdditionalProperty("lang")).subscribe(
                    stResp => this.update.emit(null),
                    err => { this.modalService.alert("Error", err, "error"); console.error(err.stack); }
                );
                break;
            case SKOS.prefLabel.getURI():
                this.skosService.removePrefLabel(this.resource, (<ARTLiteral>object).getLabel(), (<ARTLiteral>object).getLang()).subscribe(
                    stResp => this.update.emit(null),
                    err => { this.modalService.alert("Error", err, "error"); console.error(err.stack); }
                );
                break;
            case SKOS.altLabel.getURI():
                this.skosService.removeAltLabel(this.resource, (<ARTLiteral>object).getLabel(), (<ARTLiteral>object).getLang()).subscribe(
                    stResp => this.update.emit(null),
                    err => { this.modalService.alert("Error", err, "error"); console.error(err.stack); }
                );
                break;
            case SKOS.hiddenLabel.getURI():
                this.skosService.removeHiddenLabel(this.resource, (<ARTLiteral>object).getLabel(), (<ARTLiteral>object).getLang()).subscribe(
                    stResp => this.update.emit(null),
                    err => { this.modalService.alert("Error", err, "error"); console.error(err.stack); }
                );
                break;
            case RDFS.label.getURI():
                this.propertyService.removePropValue(this.resource, predicate, (<ARTLiteral>object).getLabel(),
                    null, RDFTypesEnum.plainLiteral, (<ARTLiteral>object).getLang()).subscribe(
                        stResp => this.update.emit(null),
                        err => { this.modalService.alert("Error", err, "error"); console.error(err.stack); }
                    );
                break;
            }
    }
    
    /**
     * Given a lexicalization property, tells if it is compliant with the current project onto type.
     * If the property is one of the skosxl lexicalization properties, returns true if project is SKOS-XL
     * If the property is one of the skos lexicalization properties, returns true if project is SKOS
     * If the property is rdfs:label, returns true if the project is OWL
     */
    private isPropOntoTypeCompliant(property: ARTURIResource) {
        var ontoType = this.vbCtx.getProject().getPrettyPrintOntoType();
        return (
            this.showAllLexicalProp ||
            (
                property.getShow().startsWith("rdfs:") && ontoType == "OWL" ||
                property.getShow().startsWith("skos:") && ontoType == "SKOS" ||
                property.getShow().startsWith("skosxl:") && ontoType == "SKOS-XL"
            )
        );
    }
    
    private getAddPropImgTitle(predicate: ARTURIResource) {
        return "Add a " + predicate.getShow();
    }
    
    private getRemovePropImgTitle(predicate: ARTURIResource) {
        return "Remove " + predicate.getShow();
    }
    
    private getAddPropImgSrc(predicate: ARTURIResource) {
        return ResourceUtils.getActionPropImageSrc(predicate, "create");
    }
    
    private getRemovePropImgSrc(predicate: ARTURIResource) {
        return ResourceUtils.getActionPropImageSrc(predicate, "delete");
    }
}