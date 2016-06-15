import {Component, Input, Output, EventEmitter, ViewChildren, ViewChild, QueryList} from "@angular/core";
import {ARTURIResource, ResAttribute} from "../../../utils/ARTResources";
import {VBEventHandler} from "../../../utils/VBEventHandler";
import {VocbenchCtx} from "../../../utils/VocbenchCtx";
import {SkosServices} from "../../../services/skosServices";
import {RdfResourceComponent} from "../../../widget/rdfResource/rdfResourceComponent";

@Component({
	selector: "scheme-list-node",
	templateUrl: "app/src/skos/scheme/schemeList/schemeListNodeComponent.html",
    directives: [RdfResourceComponent],
    providers: [SkosServices],
})
export class SchemeListNodeComponent {
    @Input() node: ARTURIResource;
    @Output() itemSelected = new EventEmitter<ARTURIResource>();
    
    private eventSubscriptions = [];
    
	constructor(private skosService:SkosServices, private eventHandler:VBEventHandler, private vbCtx: VocbenchCtx) {
        this.eventSubscriptions.push(eventHandler.resourceRenamedEvent.subscribe(
            data => this.onResourceRenamed(data.oldResource, data.newResource)));
        this.eventSubscriptions.push(eventHandler.skosPrefLabelSetEvent.subscribe(
            data => this.onPrefLabelSet(data.resource, data.label, data.lang)));
        this.eventSubscriptions.push(eventHandler.skosxlPrefLabelSetEvent.subscribe(
            data => this.onPrefLabelSet(data.resource, data.label, data.lang)));
        this.eventSubscriptions.push(eventHandler.skosPrefLabelRemovedEvent.subscribe(
            data => this.onPrefLabelRemoved(data.resource, data.label, data.lang)));
        this.eventSubscriptions.push(eventHandler.skosxlPrefLabelRemovedEvent.subscribe(
            data => this.onPrefLabelRemoved(data.resource, data.label, data.lang)));
    }
    
    ngOnDestroy() {
        this.eventHandler.unsubscribeAll(this.eventSubscriptions);
    }
    
    /**
     * Called when a node in the tree is clicked. This function emit an event 
     */
    private selectNode() {
        this.itemSelected.emit(this.node);
    }
    
    //EVENT LISTENERS
    
    private onResourceRenamed(oldResource: ARTURIResource, newResource: ARTURIResource) {
        if (oldResource.getURI() == this.node.getURI()) {
            if (this.vbCtx.getHumanReadable()) {
                this.skosService.getShow(newResource, this.vbCtx.getContentLanguage()).subscribe(
                    show => {
                        this.node['show'] = show;
                        this.node['uri'] = newResource.getURI();
                    }
                )
            } else {//human readable disabled, just replace the show (localName)
                this.node['show'] = newResource.getShow();
                this.node['uri'] = newResource.getURI();
            }
        }
    }
    
    private onPrefLabelSet(resource: ARTURIResource, label: string, lang: string) {
        if (this.vbCtx.getHumanReadable() && this.vbCtx.getContentLanguage() == lang && resource.getURI() == this.node.getURI()) {
            this.node['show'] = label;
        }
    }
    
    private onPrefLabelRemoved(resource: ARTURIResource, label: string, lang: string) {
        if (this.vbCtx.getHumanReadable() && this.vbCtx.getContentLanguage() == lang && resource.getURI() == this.node.getURI()) {
            this.skosService.getShow(resource, this.vbCtx.getContentLanguage()).subscribe(
                show => {
                    this.node['show'] = show;
                }
            )
        }
    }
    
}