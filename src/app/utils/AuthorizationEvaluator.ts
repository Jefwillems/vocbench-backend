import { Injectable } from '@angular/core';
import { VBContext } from "./VBContext";
import { User } from "../models/User";
import { ARTResource, RDFResourceRolesEnum } from "../models/ARTResources";
import { ResViewPartition } from "../models/ResourceView";

enum Actions {
    ALIGNMENT_ADD_ALIGNMENT,
    ALIGNMENT_LOAD_ALIGNMENT,
    CLASSES_CREATE_CLASS,
    CLASSES_CREATE_CLASS_AXIOM,
    CLASSES_CREATE_INDIVIDUAL,
    CLASSES_DELETE_CLASS,
    CLASSES_DELETE_INDIVIDUAL,
    CLASSES_REMOVE_CLASS_AXIOM,
    CUSTOM_FORMS_READ, //represents the generic "read" of the CustomForm aspects (used to access to CF page)
    INDIVIDUALS_ADD_TYPE,
    INDIVIDUALS_REMOVE_TYPE,
    PROPERTIES_ADD_PROPERTY_DOMAIN,
    PROPERTIES_ADD_PROPERTY_RANGE,
    PROPERTIES_ADD_SUPERPROPERTY,
    PROPERTIES_CREATE_PROPERTY,
    PROPERTIES_DELETE_PROPERTY,
    PROPERTIES_REMOVE_PROPERTY_DOMAIN,
    PROPERTIES_REMOVE_PROPERTY_RANGE,
    PROPERTIES_REMOVE_SUPERPROPERTY,
    REFACTOR_CHANGE_RESOURCE_URI,
    REFACTOR_SPAWN_NEW_CONCEPT_FROM_LABEL,
    RESOURCES_ADD_VALUE,
    RESOURCES_REMOVE_VALUE,
    RESOURCES_SET_DEPRECATED,
    RESOURCES_UPDATE_TRIPLE,
    SKOS_ADD_BROADER_CONCEPT,
    SKOS_ADD_CONCEPT_TO_SCHEME,
    SKOS_ADD_LEXICALIZATION,
    SKOS_ADD_TO_COLLECTION,
    SKOS_ADD_TOP_CONCEPT,
    SKOS_CREATE_COLLECTION,
    SKOS_CREATE_CONCEPT,
    SKOS_CREATE_SCHEME,
    SKOS_DELETE_COLLECTION,
    SKOS_DELETE_CONCEPT,
    SKOS_DELETE_SCHEME,
    SKOS_REMOVE_BROADER_CONCEPT,
    SKOS_REMOVE_FROM_COLLECTION,
    SKOS_REMOVE_CONCEPT_FROM_SCHEME,
    SKOS_REMOVE_LEXICALIZATION,
    SKOS_REMOVE_TOP_CONCEPT,
    SPARQL_EXECUTE_QUERY
}

export class AuthorizationEvaluator {

    private static resRole: string = "%resource_role%";

    public static Actions = Actions;

    private static actionAuthGoalMap: { [key: number ]: string } = {
        [Actions.ALIGNMENT_ADD_ALIGNMENT] : "auth('rdf(" + AuthorizationEvaluator.resRole + ", alignment)', 'C').",
        [Actions.ALIGNMENT_LOAD_ALIGNMENT] : "auth('rdf(resource, alignment)', 'R').",
        [Actions.CLASSES_CREATE_CLASS] :  "auth('rdf(cls)', 'C').",
        [Actions.CLASSES_CREATE_CLASS_AXIOM] :  "auth('rdf(cls, taxonomy)', 'C').", //@PreAuthorize of addOneOf/UnionOf/IntersectionOf...
        [Actions.CLASSES_CREATE_INDIVIDUAL] :  "auth('rdf(individual)', 'C').",
        [Actions.CLASSES_DELETE_CLASS] :  "auth('rdf(cls)', 'D').",
        [Actions.CLASSES_DELETE_INDIVIDUAL] :  "auth('rdf(individual)', 'D').",
        [Actions.CLASSES_REMOVE_CLASS_AXIOM] :  "auth('rdf(cls, taxonomy)', 'D').", //@PreAuthorize of removeOneOf/UnionOf/IntersectionOf...
        [Actions.CUSTOM_FORMS_READ] :  "auth('cform(formCollection)', 'R').", //@PreAuthorize of getCustomFormConfigMap
        [Actions.INDIVIDUALS_ADD_TYPE] : "auth('rdf(" + AuthorizationEvaluator.resRole + ")', 'U').",
        [Actions.INDIVIDUALS_REMOVE_TYPE] : "auth('rdf(" + AuthorizationEvaluator.resRole + ")', 'D').",
        [Actions.PROPERTIES_ADD_PROPERTY_DOMAIN] : "auth('rdf(property)', 'C').",
        [Actions.PROPERTIES_ADD_PROPERTY_RANGE] : "auth('rdf(property)', 'C').",
        [Actions.PROPERTIES_ADD_SUPERPROPERTY] : "auth('rdf(property, taxonomy)', 'C').",
        [Actions.PROPERTIES_CREATE_PROPERTY] : "auth('rdf(property)', 'C').", 
        [Actions.PROPERTIES_DELETE_PROPERTY] : "auth('rdf(property)', 'D').",
        [Actions.PROPERTIES_REMOVE_PROPERTY_DOMAIN] : "auth('rdf(property)', 'D').",
        [Actions.PROPERTIES_REMOVE_PROPERTY_RANGE] : "auth('rdf(property)', 'D').",
        [Actions.PROPERTIES_REMOVE_SUPERPROPERTY] : "auth('rdf(property, taxonomy)', 'C').",
        [Actions.REFACTOR_CHANGE_RESOURCE_URI] : "auth('rdf(" + AuthorizationEvaluator.resRole + ")', 'U').",
        [Actions.REFACTOR_SPAWN_NEW_CONCEPT_FROM_LABEL] : "auth('rdf(concept)', 'C').", 
        [Actions.RESOURCES_ADD_VALUE] : "auth('rdf(" + AuthorizationEvaluator.resRole + ", values)', 'C')", 
        [Actions.RESOURCES_REMOVE_VALUE] : "auth('rdf(" + AuthorizationEvaluator.resRole + ", values)', 'D')", 
        [Actions.RESOURCES_SET_DEPRECATED] : "auth('rdf(" + AuthorizationEvaluator.resRole + ")', 'U')",
        [Actions.RESOURCES_UPDATE_TRIPLE] : "auth('rdf(" + AuthorizationEvaluator.resRole + ", values)', 'U')", 
        [Actions.SKOS_ADD_BROADER_CONCEPT] : "auth('rdf(concept, taxonomy)', 'C').", 
        [Actions.SKOS_ADD_CONCEPT_TO_SCHEME] : "auth('rdf(concept, schemes)', 'C').", 
        [Actions.SKOS_ADD_LEXICALIZATION] : "auth('rdf(" + AuthorizationEvaluator.resRole + ", lexicalization)', 'C').",
        [Actions.SKOS_ADD_TO_COLLECTION] : "auth('rdf(skosCollection)', 'U').", //TODO is it ok? or add values (add)
        [Actions.SKOS_ADD_TOP_CONCEPT] : "auth('rdf(concept, schemes)', 'C').",
        [Actions.SKOS_CREATE_COLLECTION] : "auth('rdf(skosCollection)', 'C').", 
        [Actions.SKOS_CREATE_CONCEPT] : "auth('rdf(concept)', 'C').", 
        [Actions.SKOS_CREATE_SCHEME] : "auth('rdf(conceptScheme)', 'C').", 
        [Actions.SKOS_DELETE_COLLECTION] : "auth('rdf(skosCollection)', 'D').", 
        [Actions.SKOS_DELETE_CONCEPT] : "auth('rdf(concept)', 'D').", 
        [Actions.SKOS_DELETE_SCHEME] : "auth('rdf(conceptScheme)', 'D').", 
        [Actions.SKOS_REMOVE_BROADER_CONCEPT] : "auth('rdf(concept, taxonomy)', 'D').",
        [Actions.SKOS_REMOVE_CONCEPT_FROM_SCHEME] : "auth('rdf(concept, schemes)', 'D').",
        [Actions.SKOS_REMOVE_FROM_COLLECTION] : "auth('rdf(skosCollection)', 'U').", //TODO is it ok? or add values
        [Actions.SKOS_REMOVE_LEXICALIZATION] : "auth('rdf(" + AuthorizationEvaluator.resRole + ", lexicalization)', 'D').",
        [Actions.SKOS_REMOVE_TOP_CONCEPT] : "auth('rdf(concept, schemes)', 'D').",
        [Actions.SPARQL_EXECUTE_QUERY] : "auth('rdf(sparql)', 'RU').",
    };

    private static authCache: { [goal: string]: boolean } = {}
    
    /**
     * @param action 
     * @param resource If provided, is used to get its role 
     */
    public static isAuthorized(action: Actions, resource?: ARTResource): boolean {
        var user: User = VBContext.getLoggedUser()
        if (user.isAdmin()) {
            return true;
        } else {
            //evaluate if the user capabilities satisfy the authorization requirement
            let goal: string = this.actionAuthGoalMap[action];
            if (goal.includes(AuthorizationEvaluator.resRole)) {//dynamic goal (depending on resource role)
                if (resource != null) {
                    goal = goal.replace(AuthorizationEvaluator.resRole, resource.getRole());
                } else {
                    throw new Error("Cannot resolve the authorization goal: goal depends on resource role, but resource is undefined");
                }
            }
            let cachedAuth: boolean = this.authCache[goal];
            if (cachedAuth != null) { //if it was chached => return it
                // console.log("authorization cached", cachedAuth);
                return cachedAuth;
            } else { //...otherwise compute authorization
                let authorized: boolean = this.evaulatePrologGoal(goal); //cache the result of the evaluation for the given goal
                this.authCache[goal] = authorized;
                return authorized;
            }
        }
    }

    private static evaulatePrologGoal(goal: string): boolean {
        // console.log("evaluating", goal);
        // console.log("user capabilities", VBContext.getLoggedUser().getCapabilities());
        return true;
    }

    //AUTHORIZATIONS FOR ADD/UPDATE/REMOVE IN RESOURCE VIEW PARTITION
    public static ResourceView = {
        isAddAuthorized(partition: ResViewPartition, resource?: ARTResource): boolean {
            return (
                (partition == ResViewPartition.types && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.INDIVIDUALS_ADD_TYPE, resource)) ||
                (partition == ResViewPartition.classaxioms && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.CLASSES_CREATE_CLASS_AXIOM)) ||
                (partition == ResViewPartition.topconceptof && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_ADD_TOP_CONCEPT)) ||
                (partition == ResViewPartition.schemes && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_ADD_CONCEPT_TO_SCHEME)) ||
                (partition == ResViewPartition.broaders && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_ADD_BROADER_CONCEPT)) ||
                (partition == ResViewPartition.superproperties && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_ADD_SUPERPROPERTY)) ||
                (partition == ResViewPartition.domains && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_ADD_PROPERTY_DOMAIN)) ||
                (partition == ResViewPartition.ranges && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_ADD_PROPERTY_RANGE)) ||
                (partition == ResViewPartition.facets && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_ADD_VALUE, resource)) ||
                (partition == ResViewPartition.lexicalizations && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_ADD_LEXICALIZATION, resource)) ||
                (partition == ResViewPartition.notes && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_ADD_VALUE, resource)) ||
                (partition == ResViewPartition.members && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_ADD_TO_COLLECTION)) ||
                (partition == ResViewPartition.membersOrdered && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_ADD_TO_COLLECTION)) ||
                (partition == ResViewPartition.labelRelations && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_ADD_VALUE, resource)) ||
                (partition == ResViewPartition.properties && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_ADD_VALUE, resource))
            );
        },
        isEditAuthorized(partition: ResViewPartition, resource?: ARTResource): boolean {
            return (AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_UPDATE_TRIPLE, resource));
        },
        isRemoveAuthorized(partition: ResViewPartition, resource?: ARTResource): boolean {
            return (
                (partition == ResViewPartition.types && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.INDIVIDUALS_REMOVE_TYPE, resource)) ||
                (partition == ResViewPartition.classaxioms && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.CLASSES_REMOVE_CLASS_AXIOM)) ||
                (partition == ResViewPartition.topconceptof && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_REMOVE_TOP_CONCEPT)) ||
                (partition == ResViewPartition.schemes && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_REMOVE_CONCEPT_FROM_SCHEME)) ||
                (partition == ResViewPartition.broaders && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_REMOVE_BROADER_CONCEPT)) ||
                (partition == ResViewPartition.superproperties && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_REMOVE_SUPERPROPERTY)) ||
                (partition == ResViewPartition.domains && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_REMOVE_PROPERTY_DOMAIN)) ||
                (partition == ResViewPartition.ranges && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_REMOVE_PROPERTY_RANGE)) ||
                (partition == ResViewPartition.facets && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_REMOVE_VALUE, resource)) ||
                (partition == ResViewPartition.lexicalizations && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_REMOVE_LEXICALIZATION, resource)) ||
                (partition == ResViewPartition.notes && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_REMOVE_VALUE, resource)) ||
                (partition == ResViewPartition.members && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_REMOVE_FROM_COLLECTION)) ||
                (partition == ResViewPartition.membersOrdered && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_REMOVE_FROM_COLLECTION)) ||
                (partition == ResViewPartition.labelRelations && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_REMOVE_VALUE, resource)) ||
                (partition == ResViewPartition.properties && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.RESOURCES_REMOVE_VALUE, resource))
            );
        }
    }

    //AUTHORIZATIONS FOR CRATE/DELETE IN TREES/LISTS
    public static Tree = {
        isCreateAuthorized(role: RDFResourceRolesEnum) {
            return (
                (role == RDFResourceRolesEnum.concept && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_CREATE_CONCEPT)) ||
                (role == RDFResourceRolesEnum.conceptScheme && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_CREATE_SCHEME)) ||
                (role == RDFResourceRolesEnum.skosCollection && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_CREATE_COLLECTION)) ||
                (role == RDFResourceRolesEnum.cls && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.CLASSES_CREATE_CLASS)) ||
                (role == RDFResourceRolesEnum.individual && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.CLASSES_CREATE_INDIVIDUAL)) ||
                (role == RDFResourceRolesEnum.property && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_CREATE_PROPERTY))
            );
        },
        isDeleteAuthorized(role: RDFResourceRolesEnum) {
            return (
                (role == RDFResourceRolesEnum.concept && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_DELETE_CONCEPT)) ||
                (role == RDFResourceRolesEnum.conceptScheme && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_DELETE_SCHEME)) ||
                (role == RDFResourceRolesEnum.skosCollection && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.SKOS_DELETE_COLLECTION)) ||
                (role == RDFResourceRolesEnum.cls && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.CLASSES_DELETE_CLASS)) ||
                (role == RDFResourceRolesEnum.individual && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.CLASSES_DELETE_INDIVIDUAL)) ||
                (role == RDFResourceRolesEnum.property && AuthorizationEvaluator.isAuthorized(AuthorizationEvaluator.Actions.PROPERTIES_DELETE_PROPERTY))
            );
        }
    }

}