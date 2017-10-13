import { Injectable, EventEmitter } from '@angular/core';
import { ARTURIResource, ARTResource, ARTLiteral } from '../models/ARTResources';
import { ResourceViewMode } from '../utils/VBProperties';
import { VBContext } from '../utils/VBContext';

/**
 * This class need to be injected in constructor of every Component that throws or subscribes to an event.
 * To throw an event just call the emit() method of the EventEmitter instance, to subscribes add something like
 * eventHandler.<eventEmitterInstanceName>.subscribe(data => this.<callback>(data));
 * in the constructor of the Component
 */

@Injectable()
export class VBEventHandler {

    //CONCEPT EVENTS
    public topConceptCreatedEvent: EventEmitter<{ concept: ARTURIResource, schemes: ARTURIResource[] }> = new VBEventEmitter("topConceptCreatedEvent");
    public narrowerCreatedEvent: EventEmitter<{ narrower: ARTURIResource, broader: ARTURIResource }> = new VBEventEmitter("narrowerCreatedEvent");
    public broaderAddedEvent: EventEmitter<{ narrower: ARTURIResource, broader: ARTURIResource }> = new VBEventEmitter("broaderAddedEvent");
    //optional "broader" (if not top Concept) to tells the position where the concept should be attached in the tree
    //NOTE: this is still not used since the server support is missing (it needs a response that tells if the concept has broader)
    public conceptAddedToSchemeEvent: EventEmitter<{ concept: ARTURIResource, scheme: ARTURIResource, broader?: ARTURIResource }> = new VBEventEmitter("conceptAddedToSchemeEvent");
    public conceptDeletedEvent: EventEmitter<ARTURIResource> = new VBEventEmitter<ARTURIResource>("conceptDeletedEvent");
    public conceptRemovedFromSchemeEvent: EventEmitter<{ concept: ARTURIResource, scheme: ARTURIResource }> = new VBEventEmitter("conceptRemovedFromSchemeEvent");
    public conceptRemovedAsTopConceptEvent: EventEmitter<{ concept: ARTURIResource, scheme: ARTURIResource }> = new VBEventEmitter("conceptRemovedAsTopConceptEvent");
    public broaderRemovedEvent: EventEmitter<{ concept: ARTURIResource, broader: ARTURIResource }> = new VBEventEmitter("broaderRemovedEvent");

    //SCHEME EVENTS
    //event should contain the selected scheme
    public schemeChangedEvent: EventEmitter<ARTURIResource[]> = new VBEventEmitter("schemeChangedEvent");

    //COLLECTION EVENTS
    public rootCollectionCreatedEvent: EventEmitter<ARTResource> = new VBEventEmitter<ARTURIResource>("rootCollectionCreatedEvent");
    public nestedCollectionCreatedEvent: EventEmitter<{ nested: ARTResource, container: ARTResource }> = new VBEventEmitter("nestedCollectionCreatedEvent");
    public nestedCollectionAddedEvent: EventEmitter<{ nested: ARTResource, container: ARTResource }> = new VBEventEmitter("nestedCollectionAddedEvent");
    public nestedCollectionAddedFirstEvent: EventEmitter<{ nested: ARTResource, container: ARTResource }> = new VBEventEmitter("nestedCollectionAddedFirstEvent");
    public nestedCollectionAddedLastEvent: EventEmitter<{ nested: ARTResource, container: ARTResource }> = new VBEventEmitter("nestedCollectionAddedLastEvent");
    public nestedCollectionAddedInPositionEvent: EventEmitter<{ nested: ARTResource, container: ARTResource, position: number }> = new VBEventEmitter("nestedCollectionAddedInPositionEvent");
    public nestedCollectionRemovedEvent: EventEmitter<{ nested: ARTResource, container: ARTResource }> = new VBEventEmitter("nestedCollectionRemovedEvent");
    public collectionDeletedEvent: EventEmitter<ARTResource> = new VBEventEmitter<ARTResource>("collectionDeletedEvent");

    //CLASS EVENTS
    public subClassCreatedEvent: EventEmitter<{ subClass: ARTResource, superClass: ARTResource }> = new VBEventEmitter("subClassCreatedEvent");
    public superClassAddedEvent: EventEmitter<{ subClass: ARTResource, superClass: ARTResource }> = new VBEventEmitter("superClassAddedEvent");
    public classDeletedEvent: EventEmitter<ARTURIResource> = new VBEventEmitter<ARTURIResource>("classDeletedEvent");
    public typeRemovedEvent: EventEmitter<{ resource: ARTResource, type: ARTResource }> = new VBEventEmitter("typeRemovedEvent");
    public typeAddedEvent: EventEmitter<{ resource: ARTResource, type: ARTResource }> = new VBEventEmitter("typeAddedEvent");
    public superClassRemovedEvent: EventEmitter<{ superClass: ARTResource, subClass: ARTResource }> = new VBEventEmitter("superClassRemovedEvent");

    //INSTANCE EVENTS
    public instanceCreatedEvent: EventEmitter<{ instance: ARTResource, cls: ARTResource }> = new VBEventEmitter("instanceCreatedEvent");
    public instanceDeletedEvent: EventEmitter<{ instance: ARTResource, cls: ARTResource }> = new VBEventEmitter("instanceDeletedEvent");

    //PROPERTY EVENTS
    public topPropertyCreatedEvent: EventEmitter<ARTURIResource> = new VBEventEmitter<ARTURIResource>("topPropertyCreatedEvent");
    public subPropertyCreatedEvent: EventEmitter<{ subProperty: ARTURIResource, superProperty: ARTURIResource }> = new VBEventEmitter("subPropertyCreatedEvent");
    public superPropertyAddedEvent: EventEmitter<{ subProperty: ARTURIResource, superProperty: ARTURIResource }> = new VBEventEmitter("superPropertyAddedEvent");
    public propertyDeletedEvent: EventEmitter<ARTURIResource> = new VBEventEmitter<ARTURIResource>("propertyDeletedEvent");
    public superPropertyRemovedEvent: EventEmitter<{ property: ARTURIResource, superProperty: ARTURIResource }> = new VBEventEmitter("superPropertyRemovedEvent");

    //MISC EVENTS 
    //data loaded/imported/removed/refactored => trees/lists need to be resfreshed
    public refreshDataBroadcastEvent: EventEmitter<any> = new VBEventEmitter("refreshDataBroadcastEvent", true);

    //user changes resourceViewMode preference => resource view panel need to be updated
    public resViewModeChangedEvent: EventEmitter<ResourceViewMode> = new VBEventEmitter("resViewModeChangedEvent");
    public resViewTabSyncChangedEvent: EventEmitter<boolean> = new VBEventEmitter("resViewTabSyncChangedEvent");

    public resourceRenamedEvent: EventEmitter<{ oldResource: ARTResource, newResource: ARTResource }> = new VBEventEmitter("resourceRenamedEvent");

    constructor() { }

    /**
     * utility method to make a component unsubscribe from all the event to which has subscribed
     */
    public unsubscribeAll(subscriptions: any[]) {
        for (var i = 0; i < subscriptions.length; i++) {
            subscriptions[i].unsubscribe();
        }
    }

}

class VBEventEmitter<T> extends EventEmitter<T> {
    private eventName: string
    private onlyIfProjectNotChanged: boolean; //if true the event is fired only if project is not changed

    /**
     * 
     * @param eventName 
     * @param onlyIfProjectNotChanged if true the event is fired only if the project is not changed. Useful for example in 
     *      refreshDataBroadcastEvent (if project is changed, firing the event would cause exception since the refresh of data is based
     *      on scheme of old project)
     * @param isAsync 
     */
    constructor(eventName: string, onlyIfProjectNotChanged?: boolean, isAsync?: boolean) {
        super(isAsync);
        this.eventName = eventName;
        this.onlyIfProjectNotChanged = onlyIfProjectNotChanged;
    }

    emit(value?: T): void {
        //if the project is changed and onlyIfProjectNotChanged is true don't emit event 
        if (this.onlyIfProjectNotChanged && VBContext.isProjectChanged()) {
            return;
        }
        console.debug("[", this.eventName, "]", value);
        super.emit(value);
    }

}