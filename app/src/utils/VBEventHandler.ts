import {Injectable, EventEmitter} from '@angular/core';
import {ARTURIResource, ARTResource} from './ARTResources';
import {Project} from './Project';

/**
 * This class need to be injected in constructor of every Component that throws or subscribes to an event.
 * To throw an event just call the emit() method of the EventEmitter instance, to subscribes add something like
 * eventHandler.<eventEmitterInstanceName>.subscribe(data => this.<callback>(data));
 * in the constructor of the Component
 */

@Injectable()
export class VBEventHandler {
    
    //CONCEPT EVENTS
    //event should contain an object with "concept" and "scheme"
    public topConceptCreatedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "narrower" (the narrower created) and "broader"
    public narrowerCreatedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain the deleted concept
    public conceptDeletedEvent: EventEmitter<ARTURIResource> = new EventEmitter<ARTURIResource>();
    //event should contain an object with "concept" and "scheme"
    public conceptRemovedFromSchemeEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "concept" and "scheme"
    public conceptRemovedAsTopConceptEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "concept" and "broader"
    public broaderRemovedEvent: EventEmitter<any> = new EventEmitter();

    //COLLECTION EVENTS
    //event should contain the created collection
    public rootCollectionCreatedEvent: EventEmitter<ARTResource> = new EventEmitter<ARTURIResource>();
    //event should contain an object with "nested" (the nested coll created) and "container"
    public nestedCollectionCreatedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "nested" (the nested coll added) and "container"
    public nestedCollectionAddedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "nested" (the nested coll removed) and "container"
    public nestedCollectionRemovedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain the deleted collection
    public collectionDeletedEvent: EventEmitter<ARTResource> = new EventEmitter<ARTResource>();
    
    //CLASS EVENTS
    //event should contain an object with "subClass" (the subClass created) and "superClass"
    public subClassCreatedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain the deleted class
    public classDeletedEvent: EventEmitter<ARTURIResource> = new EventEmitter<ARTURIResource>();
    //event should contain an object with "resource" and "type"
    public typeRemovedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "resource" and "type"
    public typeAddedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "cls" and "subClass"
    public subClassRemovedEvent: EventEmitter<any> = new EventEmitter();
    
    //INSTANCE EVENTS
    //event should contain an object with "instance" and "cls" (the class of the instance)
    public instanceCreatedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "instance" and "cls"
    public instanceDeletedEvent: EventEmitter<any> = new EventEmitter();
    
    //PROPERTY EVENTS
    public topPropertyCreatedEvent: EventEmitter<ARTURIResource> = new EventEmitter<ARTURIResource>();
    //event should contain an object with "subProperty" (the subproperty created) and "superProperty"
    public subPropertyCreatedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain the deleted property
    public propertyDeletedEvent: EventEmitter<ARTURIResource> = new EventEmitter<ARTURIResource>();
    //event should contain an object with "property" and "superProperty"
    public superPropertyRemovedEvent: EventEmitter<any> = new EventEmitter();
    
    //LABEL EVENTS
    //event should contain an object with "resource" (resource which the label has been set) "label" and "lang"
    public skosPrefLabelSetEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "resource" (resource which the label has been set) "label" and "lang"
    public skosPrefLabelRemovedEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "resource" (resource which the label has been set) "label" and "lang"
    public skosxlPrefLabelSetEvent: EventEmitter<any> = new EventEmitter();
    //event should contain an object with "resource" (resource which the label has been set) "label" and "lang"
    public skosxlPrefLabelRemovedEvent: EventEmitter<any> = new EventEmitter();
    
    
    //MISC EVENTS 
    
    //event should contain an object with "oldResource" and "newResource"
    public resourceRenamedEvent: EventEmitter<any> = new EventEmitter();
    
    //event contains the new content language
    public contentLangChangedEvent: EventEmitter<string> = new EventEmitter<string>();
    
    //event contains the project closed
    public projectClosedEvent: EventEmitter<Project> = new EventEmitter<Project>(); 
    
	constructor() {}
    
    /**
     * utility method to make a component unsubscribe from all the event to which has subscribed
     */
    public unsubscribeAll(subscriptions: any[]) {
        for (var i=0; i<subscriptions.length; i++) {
            subscriptions[i].unsubscribe();
        }
    }
    
}