import { Component, Input, Output, EventEmitter } from "@angular/core";
import { AbstractPredicateObjectListRenderer } from "./abstractPredicateObjectListRenderer";
import { PropertyServices } from "../../services/propertyServices";
import { ResourceServices } from "../../services/resourceServices";
import { CustomRangeServices } from "../../services/customRangeServices";
import { ManchesterServices } from "../../services/manchesterServices";
import { ResViewModalServices } from "../resViewModals/resViewModalServices";
import { ARTNode, ARTURIResource, ResAttribute, RDFTypesEnum, RDFResourceRolesEnum } from "../../utils/ARTResources";
import { RDFS, XmlSchema } from "../../utils/Vocabulary";

@Component({
    selector: "ranges-renderer",
    templateUrl: "./predicateObjectListRenderer.html",
})
export class RangesPartitionRenderer extends AbstractPredicateObjectListRenderer {

    //inherited from AbstractPredicateObjectListRenderer
    // @Input('pred-obj-list') predicateObjectList: ARTPredicateObjects[];
    // @Input() resource:ARTURIResource;
    // @Output() update = new EventEmitter();//something changed in this partition. Tells to ResView to update
    // @Output() dblclickObj: EventEmitter<ARTResource> = new EventEmitter<ARTResource>();

    rootProperty: ARTURIResource = RDFS.range;
    label = "Ranges";
    addBtnImgTitle = "Add a range";
    addBtnImgSrc = require("../../../assets/images/class_create.png");
    removeBtnImgTitle = "Remove range";

    constructor(private propService: PropertyServices, private resourceService: ResourceServices, private crService: CustomRangeServices,
        private manchService: ManchesterServices, private rvModalService: ResViewModalServices) {
        super();
    }

    add(predicate?: ARTURIResource) {
        var propChangeable: boolean = predicate == null;
        this.rvModalService.addPropertyValue("Add a range", this.resource, this.rootProperty, propChangeable).then(
            (data: any) => {
                var prop: ARTURIResource = data.property;
                var value: any = data.value; //value can be a class, manchester Expression, or a datatype (if resource is a datatype prop)

                if (typeof value == "string") {
                    this.manchService.createRestriction(<ARTURIResource>this.resource, prop, value).subscribe(
                        stResp => this.update.emit(null)
                    );
                } else { //value is an ARTURIResource (a class selected from the tree or a datatype)
                    if (prop.getURI() == this.rootProperty.getURI()) { //it's using rdfs:range
                        this.propService.addPropertyRange(<ARTURIResource>this.resource, value).subscribe(
                            stResp => this.update.emit(null)
                        );
                    } else { //it's using a subProperty of rdfs:range
                        this.propService.addExistingPropValue(this.resource, prop, value.getURI(), RDFTypesEnum.resource).subscribe(
                            stResp => {
                                this.update.emit(null);
                            }
                        );
                    }
                }
            },
            () => { }
        )
    }

    removePredicateObject(predicate: ARTURIResource, object: ARTNode) {
        if (predicate.getAdditionalProperty(ResAttribute.HAS_CUSTOM_RANGE) && object.isResource()) {
            this.crService.removeReifiedResource(this.resource, predicate, object).subscribe(
                stResp => this.update.emit(null)
            );
        } else {
            if (object.getShow().startsWith("(") && object.getShow().startsWith(")") && object.isBNode()) { //class axiom
                this.manchService.removeExpression(<ARTURIResource>this.resource, predicate, object).subscribe(
                    stResp => this.update.emit(null)
                );
            } else { //removing a range class or datatype
                if (this.rootProperty.getURI() == predicate.getURI()) { //removing rdfs:range relation
                    this.propService.removePropertyRange(<ARTURIResource>this.resource, <ARTURIResource>object).subscribe(
                        stResp => this.update.emit(null)
                    );
                } else { //removing subProperty of rdfs:range
                    this.resourceService.removePropertyValue(this.resource, predicate, object).subscribe(
                        stResp => this.update.emit(null)
                    );
                }
            }
        }
    }

}