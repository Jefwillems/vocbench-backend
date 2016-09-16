import {Component, Input} from "@angular/core";
import {ARTNode, ARTResource, ARTURIResource, ARTPredicateObjects} from "../../utils/ARTResources";
import {ResourceUtils} from "../../utils/ResourceUtils";
import {Deserializer} from "../../utils/Deserializer";
import {CustomRangeServices} from "../../services/customRangeServices";

@Component({
	selector: "reified-resource",
	templateUrl: "./reifiedResourceComponent.html",
})
export class ReifiedResourceComponent {
    
    @Input() predicate: ARTURIResource;
    @Input() resource: ARTNode; //BNode or URIResource
    
    private reifiedResource: ARTResource;
    private predicateObjectList: ARTPredicateObjects[];
    
    private open: boolean = false;
	
	constructor(private crService: CustomRangeServices) {}
    
    ngOnInit() {
        this.crService.getReifiedResourceDescription(this.predicate, this.resource).subscribe(
            stResp => {
                var resourceElement: Element = stResp.getElementsByTagName("resource")[0];
                this.reifiedResource = Deserializer.createRDFResource(resourceElement.getElementsByTagName("uri")[0]);
                
                var propElem = stResp.getElementsByTagName("properties")[0];
                if (propElem != undefined) { //only if resource has a reified description
                     this.predicateObjectList = Deserializer.createPredicateObjectsList(propElem.getElementsByTagName("collection")[0]);
                }
            }
        );
    }
    
    private toggle() {
        this.open = !this.open;
    }
    
    private resDblClicked() {
        console.log("double clicked");
    }

}