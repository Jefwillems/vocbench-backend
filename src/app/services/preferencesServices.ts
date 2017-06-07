import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ARTURIResource } from "../models/ARTResources";
import { HttpManager } from "../utils/HttpManager";
import { Deserializer } from "../utils/Deserializer";

@Injectable()
export class PreferencesServices {

    private serviceName = "Preferences";

    constructor(private httpMgr: HttpManager) { }

    /**
     * Sets the rendering languages preference
     * @param languages list of languages, list with just one element "*" in order to set "all languages"
     * @param level tells at which level to set the property
     */
    setLanguages(languages: string[]) {
        console.log("[PreferencesServices] setLanguages");
        var params = {
            languages: languages
        };
        return this.httpMgr.doPost(this.serviceName, "setLanguages", params, true);
    }

    /**
     * Sets the show_flag preference
     * @param show 
     */
    setShowFlags(show: boolean) {
        console.log("[PreferencesServices] setShowFlags");
        var params = {
            show: show
        };
        return this.httpMgr.doPost(this.serviceName, "setShowFlags", params, true);
    }

    /**
     * Sets the show_instances_number preference
     * @param show 
     */
    setShowInstancesNumb(show: boolean) {
        console.log("[PreferencesServices] setShowInstancesNumb");
        var params = {
            show: show
        };
        return this.httpMgr.doPost(this.serviceName, "setShowInstancesNumb", params, true);
    }

    /**
     * Sets the default active skos concept schemes
     * @param scheme s
     */
    setActiveSchemes(schemes?: ARTURIResource[]) {
        console.log("[PreferencesServices] setActiveSchemes");
        var params: any = {}
        if (schemes != null) {
            params.schemes = schemes;
        }
        return this.httpMgr.doPost(this.serviceName, "setActiveSchemes", params, true);
    }

    /**
     * Returns the active schemes for the given project
     * @param projectName 
     */
    getActiveSchemes(projectName: string): Observable<ARTURIResource[]> {
        console.log("[PreferencesServices] getActiveSchemes");
        var params: any = {
            projectName: projectName
        }
        return this.httpMgr.doGet(this.serviceName, "getActiveSchemes", params, true).map(
            stResp => {
                if (stResp == null) {
                    return null;
                } else {
                    return Deserializer.createURIArray(stResp);
                }
            }
        );
    }

    /**
     * Gets the preferences of the currently logged user for the currently open project
     */
    getProjectPreferences() {
        console.log("[PreferencesServices] getProjectPreferences");
        var params = {};
        return this.httpMgr.doGet(this.serviceName, "getProjectPreferences", params, true);
    }

}