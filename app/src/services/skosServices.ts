import {Injectable} from 'angular2/core';
import {Http} from 'angular2/http';
import {HttpManager} from "../utils/HttpManager";

@Injectable()
export class SkosServices {
    
    private serviceName = "skos";
    private oldTypeService = true;
    
	constructor(public http:Http, private httpMgr:HttpManager) {}
    
    //Concept services 
    
    getTopConcepts(scheme?:string) {
        console.log("[SkosServices] getTopConcepts");
        var params:any = {};
        if (scheme != undefined) {
            params.scheme = scheme;
        }
        return this.httpMgr.doGet(this.serviceName, "getTopConcepts", params, this.oldTypeService);
    }
    
    getNarrowerConcepts(concept:string, scheme:string) {
        console.log("[SkosServices] getNarrowerConcepts");
        var params:any = {
            "concept" : concept,
			"treeView" : true,
        };
        if (scheme != undefined) {
            params.scheme = scheme;
        }
        return this.httpMgr.doGet(this.serviceName, "getNarrowerConcepts", params, this.oldTypeService);
    }
    
    createConcept(concept:string, scheme:string, prefLabel:string, prefLabelLang:string) {
        console.log("[SkosServices] createConcept");
        var params:any = {
            "concept" : concept,
			"scheme" : scheme,
        };
        if (prefLabel != undefined && prefLabelLang != undefined) {
            params.prefLabel = prefLabel;
            params.prefLabelLang = prefLabelLang;
        }
        return this.httpMgr.doGet(this.serviceName, "createConcept", params, this.oldTypeService);
    }
    
    deleteConcept(concept:string) {
        console.log("[SkosServices] deleteConcept");
        var params:any = {
            "concept" : concept,
        };
        return this.httpMgr.doGet(this.serviceName, "deleteConcept", params, this.oldTypeService);
    }
    
    createNarrower(concept:string, broader:string, scheme:string, prefLabel:string, prefLabelLang:string) {
        console.log("[SkosServices] createNarrower");
        var params:any = {
            "concept" : concept,
			"broaderConcept" : broader,
			"scheme" : scheme,
        };
        if (prefLabel != undefined && prefLabelLang != undefined) {
            params.prefLabel = prefLabel;
            params.prefLabelLang = prefLabelLang;
        }
        return this.httpMgr.doGet(this.serviceName, "createConcept", params, this.oldTypeService);
    }
    
    //Scheme services
    
    getAllSchemesList() {
        console.log("[SkosServices] getAllSchemesList");
        var params:any = {};
        return this.httpMgr.doGet(this.serviceName, "getAllSchemesList", params, this.oldTypeService);
    }
    
    createScheme(scheme:string, prefLabel:string, prefLabelLang:string) {
        console.log("[SkosServices] createScheme");
        var params:any = {
            "scheme" : scheme,
        };
        if (prefLabel != undefined && prefLabelLang != undefined) {
            params.prefLabel = prefLabel;
            params.prefLabelLang = prefLabelLang;
        }
        return this.httpMgr.doGet(this.serviceName, "createScheme", params, this.oldTypeService);
    }
    
    deleteScheme(scheme:string, forceDeleteDanglingConcepts?:boolean) {
        console.log("[SkosServices] deleteScheme");
        var params:any = {
            "scheme" : scheme,
            "setForceDeleteDanglingConcepts" : forceDeleteDanglingConcepts != undefined,
        };
        if (forceDeleteDanglingConcepts != undefined) {
            params.forceDeleteDanglingConcepts = forceDeleteDanglingConcepts;
        }
        return this.httpMgr.doGet(this.serviceName, "deleteScheme", params, this.oldTypeService);
    }

}