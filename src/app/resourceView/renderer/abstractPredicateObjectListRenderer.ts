import { Component, Input, Output, EventEmitter } from "@angular/core";
import { ARTResource, ARTURIResource, ARTNode, ARTPredicateObjects, ResAttribute } from "../../utils/ARTResources";

@Component({
    selector: "pred-obj-list-renderer",
    templateUrl: "./predicateObjectListRenderer.html",
})
export abstract class AbstractPredicateObjectListRenderer {

    /**
     * INPUTS / OUTPUTS
     */

    @Input('pred-obj-list') predicateObjectList: ARTPredicateObjects[];
    @Input() resource: ARTResource; //resource described
    @Output() update = new EventEmitter(); //something changed in this partition. Tells to ResView to update
    @Output() dblclickObj: EventEmitter<ARTResource> = new EventEmitter<ARTResource>();

    /**
     * ATTRIBUTES
     */

    /**
     * Root property described in the partition
     */
    abstract rootProperty: ARTURIResource;
    /**
     * Label of the partition (e.g. rdf:type for types partition, skos:inScheme for schemes partition, ...)
     */
    abstract label: string;
    /**
     * Src of the "add" icon placed on the groupPanel outline.
     * This is specific of a partition.
     */
    abstract addBtnImgSrc: string;
    /**
     * Title show on mouseover on the "add" icon placed on the groupPanel outline.
     * This is specific of a partition.
     */
    abstract addBtnImgTitle: string;
    /**
     * Title shown on mouseover on the "-" button placed near an object in a subPanel body when just one property of the partition is enriched
     */
    abstract removeBtnImgTitle: string;

    /**
     * METHODS
     */

    /**
     * Should allow to enrich a property by opening a modal and selecting a value.
     * It can get an optional parameter "property".
     * This is fired when the add button is clicked (the one placed on the groupPanel outline) without property parameter,
     * or hen the "+" button of a specific property panel is clicked (placed in the subPanel heading) with the property provided.
     * If property is provided (add fired from specific property panel) the modal won't allow to change it allowing so
     * to enrich just that property, otherwise, if property is not provided (add fired from the generic partition panel),
     * the modal allow to change property to enrich.
     * @param predicate property to enrich.
     */
    abstract add(predicate?: ARTURIResource): void;
    /**
     * Removes an object related to the given predicate.
     * This is fired when the "-" button is clicked (near an object).
     */
    abstract removePredicateObject(predicate: ARTURIResource, object: ARTNode): void;
    
    /**
     * Returns the title of the "+" button placed in a subPanel heading.
     * This is specific of a predicate of a partition, so it depends from a predicate.
     */
    private getAddPropImgTitle(predicate: ARTURIResource): string {
        return "Add a " + predicate.getShow();
    }
    /**
     * Returns the title of the "-" button placed near an object in a subPanel body.
     * This is specific of a predicate of a partition, so it depends from a predicate.
     */
    private getRemovePropImgTitle(predicate: ARTURIResource): string {
        return "Remove " + predicate.getShow();
    }
    /**
     * Fired when an object in a subPanel is double clicked. It should simply emit a objectDblClick event.
     */
    private objectDblClick(obj: ARTNode) {
        if (obj.isResource()) {//emit double click only for resources (not for ARTLiteral that cannot be described in a ResView)
            this.dblclickObj.emit(<ARTResource>obj);
        }
    }
    /**
     * Tells if the given object need to be rendered as reifiedResource or as simple rdfResource.
     * A resource should be rendered as reifiedResource if the predicate has custom range and the object
     * is an ARTBNode or an ARTURIResource (so a reifiable object). Otherwise, if the object is a literal
     * or the predicate has no custom range, the object should be rendered as simple rdfResource
     * @param object object of the predicate object list to render in view.
     */
    private renderAsReified(predicate: ARTURIResource, object: ARTNode) {
        return (predicate.getAdditionalProperty(ResAttribute.HAS_CUSTOM_RANGE) && object.isResource());
    }

}