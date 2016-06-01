import {Component, Input, Output, EventEmitter, ViewChildren, ViewChild, QueryList} from "@angular/core";
import {ARTURIResource, ResAttribute} from "../../utils/ARTResources";
import {VBEventHandler} from "../../utils/VBEventHandler";
import {OWL} from "../../utils/Vocabulary";
import {OwlServices} from "../../services/owlServices";
import {RdfResourceComponent} from "../../widget/rdfResource/rdfResourceComponent";

@Component({
	selector: "class-tree-node",
	templateUrl: "app/src/owl/classTree/classTreeNodeComponent.html",
    directives: [RdfResourceComponent, ClassTreeNodeComponent],
    providers: [OwlServices],
})
export class ClassTreeNodeComponent {
	@Input() node:ARTURIResource;
    @Output() itemSelected = new EventEmitter<ARTURIResource>();
    
    //get an element in the view referenced with #treeNodeElement (useful to apply scrollIntoView in the search function)
    @ViewChild('treeNodeElement') treeNodeElement;
    //ClassTreeNodeComponent children of this Component (useful to open tree for the search)
    @ViewChildren(ClassTreeNodeComponent) viewChildrenNode: QueryList<ClassTreeNodeComponent>;
    //structure to support the tree opening
    private pendingSearch = {
        pending: false, //tells if there is a pending search waiting that children view are initialized 
        path: [], //remaining path of the tree to open
    }
    
    private eventSubscriptions = [];
    
	constructor(private owlService:OwlServices, private eventHandler:VBEventHandler) {
        this.eventSubscriptions.push(eventHandler.subClassCreatedEvent.subscribe(
            data => this.onSubClassCreated(data.subClass, data.superClass)));
        this.eventSubscriptions.push(eventHandler.classDeletedEvent.subscribe(
            cls => this.onClassDeleted(cls)));
        this.eventSubscriptions.push(eventHandler.subClassRemovedEvent.subscribe(
            data => this.onSubClassRemoved(data.cls, data.subClass)));
        this.eventSubscriptions.push(eventHandler.resourceRenamedEvent.subscribe(
            data => this.onResourceRenamed(data.oldResource, data.newResource)));
        this.eventSubscriptions.push(eventHandler.instanceDeletedEvent.subscribe(
            data => this.onInstanceDeleted(data.cls)));
        this.eventSubscriptions.push(eventHandler.instanceCreatedEvent.subscribe(
            data => this.onInstanceCreated(data.cls)));
        this.eventSubscriptions.push(eventHandler.typeRemovedEvent.subscribe(
            data => this.onInstanceDeleted(data.type)));
        this.eventSubscriptions.push(eventHandler.typeAddedEvent.subscribe(
            data => this.onInstanceCreated(data.type)));
    }
    
    ngOnInit() {
        if (this.node.getURI() == OWL.thing.getURI() && this.node.getAdditionalProperty(ResAttribute.MORE) == "1") {
            this.expandNode();
        }
    }
    
    ngAfterViewInit() {
        //when ClassTreeNodeComponent children are added, looks for a pending search to resume
        this.viewChildrenNode.changes.subscribe(
            c => {
                if (this.pendingSearch.pending) {//there is a pending search
                    this.expandPath(this.pendingSearch.path);
                }
            });
    }
    
    ngOnDestroy() {
        this.eventHandler.unsubscribeAll(this.eventSubscriptions);
    }
    
    /**
     * Expand recursively the given path untill the final node.
     * If the given path is empty then the current node is the searched one, otherwise
     * the current node expands itself (if is closed), looks among its children for the following node of the path,
     * then call recursively expandPath() for the child node.
     */
    public expandPath(path: ARTURIResource[]) {
        if (path.length == 0) { //this is the last node of the path (so, the searched node). Focus it in the tree
            this.treeNodeElement.nativeElement.scrollIntoView();
            //not sure if it has to be selected (this method could be used in some scenarios where there's no need to select the node)
            if (!this.node.getAdditionalProperty(ResAttribute.SELECTED)) { //select the searched node only if is not yet selected
                this.selectNode();    
            }
        } else {
            if (!this.node.getAdditionalProperty(ResAttribute.OPEN)) { //if node is close, expand itself
                this.expandNode();
            }
            var nodeChildren = this.viewChildrenNode.toArray();
            if (nodeChildren.length == 0) {//Still no children ConceptTreeNodeComponent (view not yet initialized)
                //save pending search so it can resume when the children are initialized
                this.pendingSearch.pending = true;
                this.pendingSearch.path = path;
            } else if (this.pendingSearch.pending) {
                //the tree expansion is resumed, reset the pending search
                this.pendingSearch.pending = false;
                this.pendingSearch.path = [];
            }
            for (var i = 0; i < nodeChildren.length; i++) {//for every ConceptTreeNodeComponent child
                if (nodeChildren[i].node.getURI() == path[0].getURI()) { //look for the next node of the path
                    //let the child node expand the remaining path
                    path.splice(0, 1);
                    nodeChildren[i].expandPath(path);
                    break;
                }
            }
        }
    }
    
    /**
	 * Function called when "+" button is clicked.
	 * Gets a node as parameter and retrieve with an http call the subClass of the node,
	 * then expands the subtree div.
	 */
    public expandNode() {
        this.owlService.getSubClasses(this.node, true, true).subscribe(
            subClasses => {
                this.node.setAdditionalProperty(ResAttribute.CHILDREN, subClasses); //append the retrieved node as child of the expanded node
                this.node.setAdditionalProperty(ResAttribute.OPEN, true);
            }
        );
    }
    
    /**
   	 * Function called when "-" button is clicked.
   	 * Collapse the subtree div.
   	 */
    private collapseNode() {
        this.node.setAdditionalProperty(ResAttribute.OPEN, false);
        this.node.setAdditionalProperty(ResAttribute.CHILDREN, []);
    }
    
    /**
     * Called when a node in the tree is clicked. This function emit an event 
     */
    private selectNode() {
        this.itemSelected.emit(this.node);
    }
    
    //EVENT LISTENERS
    
    private onNodeSelected(node: ARTURIResource) {
        this.itemSelected.emit(node);
    }
    
    private onClassDeleted(cls: ARTURIResource) {
        var children = this.node.getAdditionalProperty(ResAttribute.CHILDREN);
        for (var i=0; i<children.length; i++) {
            if (children[i].getURI() == cls.getURI()) {
                children.splice(i, 1);
                //if node has no more children change info of node so the UI will update
   				if (children.length == 0) {
   					this.node.setAdditionalProperty(ResAttribute.MORE, 0);
   					this.node.setAdditionalProperty(ResAttribute.OPEN, false);
   				}
                break;
            }
        }
    }
    
    private onSubClassCreated(subClass: ARTURIResource, superClass: ARTURIResource) {
        //add the new class as children only if the parent is the current class
        if (this.node.getURI() == superClass.getURI()) {
            this.node.getAdditionalProperty(ResAttribute.CHILDREN).push(subClass);
            this.node.setAdditionalProperty(ResAttribute.MORE, 1);
        }
    }
    
    private onSubClassRemoved(cls: ARTURIResource, subClass: ARTURIResource) {
        if (cls.getURI() == this.node.getURI()) {
            this.onClassDeleted(subClass);
        }
    }
    
    private onResourceRenamed(oldResource: ARTURIResource, newResource: ARTURIResource) {
        if (oldResource.getURI() == this.node.getURI()) {
            this.node[ResAttribute.SHOW] = newResource.getShow();
            this.node['uri'] = newResource.getURI();
        }
    }
	
    //decrease numInst property when an instance of the current class is deleted
    onInstanceDeleted(cls: ARTURIResource) {
        if (this.node.getURI() == cls.getURI()) {
            var numInst = this.node.getAdditionalProperty(ResAttribute.NUM_INST);
            this.node.setAdditionalProperty(ResAttribute.NUM_INST, numInst-1);
        }
    }
    
    //increase numInst property when an instance of the current class is created
    onInstanceCreated(cls: ARTURIResource) {
        if (this.node.getURI() == cls.getURI()) {
            var numInst = this.node.getAdditionalProperty(ResAttribute.NUM_INST);
            this.node.setAdditionalProperty(ResAttribute.NUM_INST, numInst+1);
        }
    }
}