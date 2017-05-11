import {Injectable} from '@angular/core';
import {VBEventHandler} from "../utils/VBEventHandler";
import {HttpManager} from "../utils/HttpManager";
import {Deserializer} from "../utils/Deserializer";
import {ARTResource, ARTURIResource, ARTLiteral, ResAttribute, RDFResourceRolesEnum} from "../models/ARTResources";

@Injectable()
export class SkosxlServices {

    private serviceName_old = "skosxl";
    private oldTypeService_old = true;

    private serviceName = "SKOSXL";
    private oldTypeService = false;
    

    constructor(private httpMgr: HttpManager, private eventHandler: VBEventHandler) { }
    
    //====== Concept services ======
    
    /**
     * Creates a top concept in the given scheme. Emits a topConceptCreatedEvent with concept and scheme.
     * NB: although the service server-side has both label and newConcept optional, here only newConcept is optional,
     * so the user is forced to write at least the label.
     * @param label preferred label of the concept (comprehensive of the lang)
     * @param conceptSchemes scheme where new concept should belong
     * @param newConcept URI concept
     * @param conceptCls class of the concept that is creating (a subclass of skos:Concept, if not provided the default is skos:Concept)
     * @param customFormId id of the custom form that set additional info to the concept
     * @param userPromptMap json map object of key - value of the custom form
     * @return 
     */
    createTopConcept_NEW(label: ARTLiteral, conceptSchemes: ARTURIResource[], newConcept?: ARTURIResource, conceptCls?: ARTURIResource,
            customFormId?: string, userPromptMap?: any) {
        console.log("[SkosxlServices] createConcept");
        var params: any = {
            label: label,
            conceptSchemes: conceptSchemes,
        };
        if (newConcept != null) {
            params.newConcept = newConcept
        }
        if (conceptCls != null) {
            params.conceptCls = conceptCls;
        }
        if (customFormId != null && userPromptMap != null) {
            params.customFormId = customFormId;
            params.userPromptMap = JSON.stringify(userPromptMap);
        }
        return this.httpMgr.doPost(this.serviceName, "createConcept", params, this.oldTypeService, true).map(
            stResp => {
                var newConc = Deserializer.createURI(stResp);
                newConc.setAdditionalProperty(ResAttribute.CHILDREN, []);
                this.eventHandler.topConceptCreatedEvent.emit({concept: newConc, schemes: conceptSchemes});
                return {concept: newConc, schemes: conceptSchemes};
            }
        );
    }
    
    /**
     * Creates a narrower of the given concept. Emits a narrowerCreatedEvent with narrower (the created narrower) and broader
     * @param label preferred label of the concept (comprehensive of the lang)
     * @param broaderConcept broader of the new created concept
     * @param conceptSchemes scheme where new concept should belong
     * @param newConcept URI concept
     * @param conceptCls class of the concept that is creating (a subclass of skos:Concept, if not provided the default is skos:Concept)
     * @param customFormId id of the custom form that set additional info to the concept
     * @param userPromptMap json map object of key - value of the custom form
     * @return the new concept
     */
    createNarrower(label: ARTLiteral, broaderConcept: ARTURIResource, conceptSchemes: ARTURIResource[], newConcept?: ARTURIResource,
            conceptCls?: ARTURIResource, customFormId?: string, userPromptMap?: any) {
        console.log("[SkosxlServices] createConcept");
        var params: any = {
            label: label,
            conceptSchemes: conceptSchemes,
            broaderConcept: broaderConcept
        };
        if (newConcept != null) {
            params.newConcept = newConcept
        }
        if (conceptCls != null) {
            params.conceptCls = conceptCls;
        }
        if (customFormId != null && userPromptMap != null) {
            params.customFormId = customFormId;
            params.userPromptMap = JSON.stringify(userPromptMap);
        }
        return this.httpMgr.doPost(this.serviceName, "createConcept", params, this.oldTypeService, true).map(
            stResp => {
                var newConc = Deserializer.createURI(stResp);
                newConc.setAdditionalProperty(ResAttribute.CHILDREN, []);
                this.eventHandler.narrowerCreatedEvent.emit({narrower: newConc, broader: broaderConcept});
                return newConc;
            }
        );
    }
    
    /**
     * Deletes the given concept. Emits a conceptDeletedEvent with the deleted concept
     * @param concept the concept to delete
     */
    deleteConcept(concept: ARTURIResource) {
        console.log("[SkosxlServices] deleteConcept");
        var params: any = {
            concept: concept.getURI(),
        };
        return this.httpMgr.doGet(this.serviceName_old, "deleteConcept", params, this.oldTypeService_old).map(
            stResp => {
                this.eventHandler.conceptDeletedEvent.emit(concept);
                return stResp;
            }
        );
    }
    
    
    //====== Scheme services ======
    
    /**
     * Creates a new scheme
     * @param label the lexical form of the pref label
     * @param newScheme the (optional) uri of the scheme
     * @param schemeCls class of the scheme that is creating (a subclass of skos:ConceptScheme, if not provided the default is skos:ConceptScheme)
     * @param customFormId id of the custom form that set additional info to the concept
     * @param userPromptMap json map object of key - value of the custom form
     * @return the new scheme
     */
    createConceptScheme(label: ARTLiteral, newScheme?: ARTURIResource, schemeCls?: ARTURIResource, customFormId?: string, userPromptMap?: any) {
        console.log("[SkosxlServices] createConceptScheme");
        var params: any = {
            label: label
        };
        if (newScheme != undefined) {
            params.newScheme = newScheme;
        };
        if (schemeCls != undefined) {
            params.schemeCls = schemeCls;
        };
        if (customFormId != null && userPromptMap != null) {
            params.customFormId = customFormId;
            params.userPromptMap = JSON.stringify(userPromptMap);
        }
        return this.httpMgr.doPost(this.serviceName, "createConceptScheme", params, this.oldTypeService, true).map(
            stResp => {
                var newScheme = Deserializer.createURI(stResp);
                return newScheme;
            }
        );
    }
    
    /**
     * Deletes a scheme. Throws an Error if forceDeleteDanglingConcepts is not passed and the scheme is not empty
     * @param scheme the scheme to delete
     * @param forceDeleteDanglingConcepts tells whether the dangling concept should be deleted
     */
    deleteScheme(scheme: ARTURIResource, forceDeleteDanglingConcepts?: boolean) {
        console.log("[SkosxlServices] deleteScheme");
        var params: any = {
            scheme: scheme.getURI(),
            setForceDeleteDanglingConcepts: forceDeleteDanglingConcepts != undefined,
        };
        if (forceDeleteDanglingConcepts != undefined) {
            params.forceDeleteDanglingConcepts = forceDeleteDanglingConcepts;
        }
        //last param skips the "Error" alert in case the scheme has concept, so I can handle it in the component
        return this.httpMgr.doGet(this.serviceName_old, "deleteScheme", params, this.oldTypeService_old, false, true);
    }
    
    //====== Label services ======

    /**
     * Returns the preferred skosxl label for the given concept in the given language
     * @param concept
     * @param lang
     */
    getPrefLabel(concept: ARTURIResource, lang: string) {
        console.log("[SkosxlServices] getPrefLabel");
        var params: any = {
            concept: concept.getURI(),
            lang: lang
        };
        return this.httpMgr.doGet(this.serviceName_old, "getPrefLabel", params, this.oldTypeService_old).map(
            stResp => {
                return Deserializer.createRDFResource(stResp.children[0]);
            }
        );
    }
    
    /**
     * Sets a preferred label to the given concept (or scheme). Emits a skosxlPrefLabelSetEvent with
     * resource, label and lang)
     * @param concept
     * @param label lexical value of the label
     * @param lang
     * @param mode available values: uri or bnode
     */
    setPrefLabel(concept: ARTURIResource, label: string, lang: string, mode: string) {
        console.log("[SkosxlServices] setPrefLabel");
        var params: any = {
            concept: concept.getURI(),
            label: label,
            lang: lang,
            mode: mode,
        };
        return this.httpMgr.doGet(this.serviceName_old, "setPrefLabel", params, this.oldTypeService_old).map(
            stResp => {
                this.eventHandler.skosxlPrefLabelSetEvent.emit({resource: concept, label: label, lang: lang});
                return stResp;
            }
        );
    }
    
    /**
     * Removes a preferred label from the given concept (or scheme). Emits a skosxlPrefLabelRemovedEvent with
     * resource, label and lang)
     * @param concept 
     * @param label label to remove
     * @param lang
     */
    removePrefLabel(concept: ARTURIResource, label: string, lang?: string) {
        console.log("[SkosxlServices] removePrefLabel");
        var params: any = {
            concept: concept.getURI(),
            label: label,
        };
        if (lang != undefined) {
            params.lang = lang;
        }
        return this.httpMgr.doGet(this.serviceName_old, "removePrefLabel", params, this.oldTypeService_old).map(
            stResp => {
                this.eventHandler.skosxlPrefLabelRemovedEvent.emit({resource: concept, label: label, lang: lang});
                return stResp;
            }
        );
	}

    /**
     * Returns the alternative skosxl labels for the given concept in the given language
     * @param concept
     * @param lang
     */
    getAltLabels(concept: ARTURIResource, lang: string) {
        console.log("[SkosxlServices] getAltLabels");
        var params: any = {
            concept: concept.getURI(),
            lang: lang,
        };
        return this.httpMgr.doGet(this.serviceName_old, "getAltLabels", params, this.oldTypeService_old).map(
            stResp => {
                return Deserializer.createRDFNodeArray(stResp);
            }
        );
    }
    
    /**
     * Adds an alternative label to the given concept (or scheme)
     * @param concept
     * @param label lexical value of the label
     * @param lang
     * @param mode available values: uri or bnode
     */
    addAltLabel(concept: ARTURIResource, label: string, lang: string, mode: string) {
        console.log("[SkosxlServices] addAltLabel");
        var params: any = {
            concept: concept.getURI(),
            label: label,
            lang: lang,
            mode: mode,
        };
        return this.httpMgr.doGet(this.serviceName_old, "addAltLabel", params, this.oldTypeService_old);
    }
    
    /**
     * Removes an alternative label from the given concept (or scheme)
     * @param concept 
     * @param label label to remove
     * @param lang
     */
    removeAltLabel(concept: ARTURIResource, label: string, lang?: string) {
        console.log("[SkosxlServices] removeAltLabel");
        var params: any = {
            concept: concept.getURI(),
            label: label,
        };
        if (lang != undefined) {
            params.lang = lang;
        }
        return this.httpMgr.doGet(this.serviceName_old, "removeAltLabel", params, this.oldTypeService_old);
	}
    
    /**
     * Adds an hidden label to the given concept (or scheme)
     * @param concept
     * @param label lexical value of the label
     * @param lang
     * @param mode available values: uri or bnode
     */
    addHiddenLabel(concept: ARTURIResource, label: string, lang: string, mode: string) {
        console.log("[SkosxlServices] addHiddenLabel");
        var params: any = {
            concept: concept.getURI(),
            label: label,
            lang: lang,
            mode: mode,
        };
        return this.httpMgr.doGet(this.serviceName_old, "addHiddenLabel", params, this.oldTypeService_old);
    }
    
    /**
     * Removes an hidden label from the given concept (or scheme)
     * @param concept 
     * @param label label to remove
     * @param lang
     */
    removeHiddenLabel(concept: ARTURIResource, label: string, lang?: string) {
        console.log("[SkosxlServices] removeHiddenLabel");
        var params: any = {
            concept: concept.getURI(),
            label: label,
        };
        if (lang != undefined) {
            params.lang = lang;
        }
        return this.httpMgr.doGet(this.serviceName_old, "removeHiddenLabel", params, this.oldTypeService_old);
	}

    /**
     * Updates the info (literal form or language) about an xLabel
     * @param xLabel
     * @param label
     * @param lang
     */
    changeLabelInfo(xLabel: ARTResource, label: string, lang?: string) {
        console.log("[SkosxlServices] changeLabelInfo");
        var params: any = {
            xlabelURI: xLabel.getNominalValue(),
            label: label,
        };
        if (lang != undefined) {
            params.lang = lang;
        }
        return this.httpMgr.doGet(this.serviceName_old, "changeLabelInfo", params, this.oldTypeService_old);
    }

    /**
     * Set a preferred label as alternative.
     * @param concept
     * @param xLabel
     */
    prefToAtlLabel(concept: ARTURIResource, xLabel: ARTResource) {
        console.log("[SkosxlServices] prefToAtlLabel");
        var params: any = {
            concept: concept.getURI(),
            xlabelURI: xLabel.getNominalValue()
        };
        return this.httpMgr.doGet(this.serviceName_old, "prefToAtlLabel", params, this.oldTypeService_old);
    }

    /**
     * Set an alternative label as preferred.
     * @param concept
     * @param xLabel
     */
    altToPrefLabel(concept: ARTURIResource, xLabel: ARTResource) {
        console.log("[SkosxlServices] altToPrefLabel");
        var params: any = {
            concept: concept.getURI(),
            xlabelURI: xLabel.getNominalValue()
        };
        return this.httpMgr.doGet(this.serviceName_old, "altToPrefLabel", params, this.oldTypeService_old);
    }

    //====== Collection services ======
    
    /**
     * Creates a root collection
     * @param collectioType the type of the collection (skos:Collection or skos:OrderedCollection)
     * @param label the preferred label
     * @param newCollection the (optional) uri of the collection
     * @param collectionCls class of the collection that is creating (a subclass of skos:Collection, if not provided the default is skos:Collection)
     * @param customFormId id of the custom form that set additional info to the collection
     * @param userPromptMap json map object of key - value of the custom form
     * @return the new collection
     */
    createRootCollection(collectionType: ARTURIResource, label: ARTLiteral, newCollection?: ARTURIResource, collectionCls?: ARTURIResource, 
        customFormId?: string, userPromptMap?: any) {
        console.log("[SkosServices] createCollection");
        var params: any = {
            collectionType: collectionType,
            label: label
        };
        if (newCollection != null) {
            params.newCollection = newCollection
        }
        if (collectionCls != null) {
            params.collectionCls = collectionCls;
        }
        if (customFormId != null && userPromptMap != null) {
            params.customFormId = customFormId;
            params.userPromptMap = JSON.stringify(userPromptMap);
        }
        return this.httpMgr.doPost(this.serviceName, "createCollection", params, this.oldTypeService, true).map(
            stResp => {
                var newColl = Deserializer.createURI(stResp);
                newColl.setAdditionalProperty(ResAttribute.CHILDREN, []);
                this.eventHandler.rootCollectionCreatedEvent.emit(newColl);
                return newColl;
            }
        );
    }

    /**
     * Creates a root collection
     * @param collectioType the type of the collection (skos:Collection or skos:OrderedCollection)
     * @param containingCollection the collection which the new collection is member
     * @param newCollection the (optional) uri of the collection
     * @param collectionCls class of the collection that is creating (a subclass of skos:Collection, if not provided the default is skos:Collection)
     * @param customFormId id of the custom form that set additional info to the collection
     * @param userPromptMap json map object of key - value of the custom form
     * @return the new collection
     */
    createNestedCollection(collectionType: ARTURIResource, containingCollection: ARTURIResource, label: ARTLiteral, 
        newCollection?: ARTURIResource, collectionCls?: ARTURIResource, customFormId?: string, userPromptMap?: any) {
        console.log("[SkosServices] createCollection");
        var params: any = {
            collectionType: collectionType,
            containingCollection: containingCollection,
            label: label
        };
        if (newCollection != null) {
            params.newCollection = newCollection
        }
        if (collectionCls != null) {
            params.collectionCls = collectionCls;
        }
        if (customFormId != null && userPromptMap != null) {
            params.customFormId = customFormId;
            params.userPromptMap = JSON.stringify(userPromptMap);
        }
        return this.httpMgr.doPost(this.serviceName, "createCollection", params, this.oldTypeService, true).map(
            stResp => {
                var newColl = Deserializer.createURI(stResp);
                newColl.setAdditionalProperty(ResAttribute.CHILDREN, []);
                this.eventHandler.nestedCollectionCreatedEvent.emit({nested: newColl, container: containingCollection});
                return newColl;
            }
        );
    }

}