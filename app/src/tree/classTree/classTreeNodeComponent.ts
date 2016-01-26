import {Component, Input, Output, EventEmitter} from "angular2/core";
import {ARTURIResource} from "../../utils/ARTResources";
import {Deserializer} from "../../utils/Deserializer";
import {VBEventHandler} from "../../utils/VBEventHandler";
import {OwlServices} from "../../services/owlServices";
import {RdfResourceComponent} from "../../widget/rdfResource/rdfResourceComponent";

@Component({
	selector: "class-tree-node",
	templateUrl: "app/src/tree/classTree/classTreeNodeComponent.html",
    directives: [RdfResourceComponent, ClassTreeNodeComponent],
    providers: [OwlServices],
})
export class ClassTreeNodeComponent {
	@Input() node:ARTURIResource;
    
    private subscrClassDeleted;
    private subscrSubClassCreated;
    public subTreeStyle: string = "subTree subtreeClose"; //to change dynamically the subtree style (open/close) 
	
	constructor(private owlService:OwlServices, public deserializer:Deserializer, private eventHandler:VBEventHandler) {
        this.subscrClassDeleted = eventHandler.classDeletedEvent.subscribe(cls => this.onClassDeleted(cls));
        this.subscrSubClassCreated = eventHandler.subClassCreatedEvent.subscribe(data => this.onSubClassCreated(data));
    }
    
    ngOnDestroy() {
        this.subscrClassDeleted.unsubscribe();
        this.subscrSubClassCreated.unsubscribe();
    }
    
    /**
	 * Function called when "+" button is clicked.
	 * Gets a node as parameter and retrieve with an http call the subClass of the node,
	 * then expands the subtree div.
	 */
    public expandNode() {
        if (this.node.getAdditionalProperty("more") == 1) { //if node has children
    		this.owlService.getSubClasses(this.node.getURI())
                .subscribe(
                    stResp => {
                        var subClasses = this.deserializer.createRDFArray(stResp);
                        for (var i=0; i<subClasses.length; i++) {
                            subClasses[i].setAdditionalProperty("children", []);
                        }
                        this.node.setAdditionalProperty("children", subClasses); //append the retrieved node as child of the expanded node
                        //change the class of the subTree div from subtreeClose to subtreeOpen
                        this.subTreeStyle = this.subTreeStyle.replace("Close", "Open");
                    }
                );
            this.node.setAdditionalProperty("open", true);
        }
    }
    
    /**
   	 * Function called when "-" button is clicked.
   	 * Collapse the subtree div.
   	 */
    public collapseNode() {
		this.node.setAdditionalProperty("open", false);
		//instead of removing node.children (that will cause an immediate/not-animated collapse of the div), simply collapse the div
        this.subTreeStyle = this.subTreeStyle.replace("Open", "Close");
    }
    
    /**
     * Called when a node in the tree is clicked. This function emit an event 
     */
    public selectNode() {
        this.eventHandler.classTreeNodeSelectedEvent.emit(this.node);
    }
    
    //EVENT LISTENERS
    
    private onClassDeleted(cls:ARTURIResource) {
        var children = this.node.getAdditionalProperty("children");
        for (var i=0; i<children.length; i++) {
            if (children[i].getURI() == cls.getURI()) {
                children.splice(i, 1);
                //if node has no more children change info of node so the UI will update
   				if (children.length == 0) {
   					this.node.setAdditionalProperty("more", 0);
   					this.node.setAdditionalProperty("open", false);
   				}
                break;
            }
        }
    }
    
    //data contains "resource" and "parent"
    private onSubClassCreated(data) {
        //add the new class as children only if the parent is the current class
        if (this.node.getURI() == data.parent.getURI()) {
            this.node.getAdditionalProperty("children").push(data.resource);
            this.node.setAdditionalProperty("more", 1);
        }
    }
	
}