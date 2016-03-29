import {Component, Injector, provide} from "angular2/core";
import {Modal, ModalConfig, ModalDialogInstance, ICustomModal} from 'angular2-modal/angular2-modal';
import {OntoMgrConfigModal, OntoMgrConfigModalContent} from "./ontoMgrConfigModal";
import {Router} from 'angular2/router';
import {ProjectServices} from "../../services/projectServices";
import {OntoManagerServices} from "../../services/ontoManagerServices";
import {PluginsServices} from "../../services/pluginsServices";
import {VocbenchCtx} from "../../utils/VocbenchCtx";
import {ModalServices} from "../../widget/modal/modalServices";

/**
 * extPointStructList is a list of structures with info about extension point. Each element is structured as follow:
 * 
 * id: "it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerator", //id of the extension point
 * plugins: ["NativeTemplateBasedURIGeneratorFactory", "CODAURIGeneratorFactory"], //available plugins of the extPoint
 * selectedExtPointPluginId: "NativeTemplateBasedURIGeneratorFactory", //id of the selected plugin
 * selectedExtPointPlugin: {    //structure describing the selected plugin for the selected extPoint
 *  	id: "NativeTemplateBasedURIGeneratorFactory",
 * 		configurations: [{      //array of available configuration for the selected plugin
 * 			editRequired: true/false,
 * 			shortName: "...",
 * 			type: "...",
 * 			params: [{description: "", name: "", required: "", value: ""},
 * 					{description: "", name: "", required: "", value: ""}]
 * 		}, {}, {}...],
 *  	selectedConfigType: , //id of the current selected configuration
 * }
 */

@Component({
	selector: "create-project-component",
	templateUrl: "app/src/project/createProject/createProjectComponent.html",
    providers: [ProjectServices, OntoManagerServices, PluginsServices],
    host: { class : "pageComponent" }
})
export class CreateProjectComponent {
    
    private projectName: string;
    private baseURI: string;
    private ontoType: string = "it.uniroma2.art.owlart.models.OWLModel";
    
    private ontoMgrId = "it.uniroma2.art.semanticturkey.ontology.sesame2.OntologyManagerFactorySesame2Impl";
    private ontoMgrConfigList: Array<any>;
    private selectedOntoMgrConfigType: string;
    private selectedOntoMgrConfig: any = {};
    //config represents the configuration of the ontology manager (shortName, type, params, ...)
    //open tells if the panel is open or close 
    
    private extPointList = [
        "it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerator",
        "it.uniroma2.art.semanticturkey.plugin.extpts.RenderingEngine"
    ];
    private extPointStructList: Array<any> = [];
    private extPointPanelOpen: boolean = false;
    
    private submitted: boolean = false;
    
    constructor(private projectService: ProjectServices, private ontMgrService: OntoManagerServices, 
        private pluginService: PluginsServices, private vbCtx: VocbenchCtx, private router: Router, 
        private modalService: ModalServices, private modal: Modal) {

        this.ontMgrService.getOntManagerParameters(this.ontoMgrId).subscribe(
            configList => {
                this.ontoMgrConfigList = configList;
                this.selectedOntoMgrConfig = this.ontoMgrConfigList[0];
                this.selectedOntoMgrConfigType = this.ontoMgrConfigList[0].type;
            }
        );
        
        for (var i = 0; i < this.extPointList.length; i++) {
            var extPoint: any = {};
            this.extPointStructList.push(extPoint);
            extPoint.id = this.extPointList[i];
            extPoint.selectedExtPointPluginId = "---";
            extPoint.selectedExtPointPlugin = { id: null, configurations: null, selectedConfigType: null};
            //extPoint.plugins
            this.pluginService.getAvailablePlugins(this.extPointList[i]).subscribe(
                extPointPlugins => {
                    var xp = extPointPlugins.extPoint;
                    var plugins = extPointPlugins.plugins;
                    for (var j = 0; j < this.extPointStructList.length; j++) {
                        if (this.extPointStructList[j].id == xp) {
                            this.extPointStructList[j].plugins = plugins;
                            break;
                        }
                    }
                }
            );
        }
        
    }
    
    //workaround for 2 way binding still not supported for <select> https://github.com/angular/angular/issues/4843
    private changeOntoMgr() {
        this.selectedOntoMgrConfig = this.ontoMgrConfigList.find(
            config => config.type == this.selectedOntoMgrConfigType
        );
    }
    
    /**
     * Opens a modal to configure ontology manager triple store
     */
    private configureOntoMgr() {
        this.openConfigurationModal(this.selectedOntoMgrConfig);
    }
    
    /**
     * opens/closes extension point panel
     */
    private toggleExtPointPanel() {
        this.extPointPanelOpen = !this.extPointPanelOpen;
    }
    
    /**
     * Called when change selection of the plugins menu of an extension point
     */
    private changeExtPointPlugin(extPointStruct) {
        if (extPointStruct.selectedExtPointPluginId == "---") {
            extPointStruct.selectedExtPointPlugin.configurations = null;
            extPointStruct.selectedExtPointPlugin.selectedConfigType = null;
        } else {
            this.pluginService.getPluginConfigurations(extPointStruct.selectedExtPointPluginId).subscribe(
                configurations => {
                    extPointStruct.selectedExtPointPlugin.configurations = configurations;
                    extPointStruct.selectedExtPointPlugin.selectedConfigType = configurations[0].type;
                }
            );       
        }
    }
    
    /**
     * Given the structure of an extension point, opens a modal to change its plugin configuration
     */
    private configurePluginConfig(extPointStruct) {
        //search in configurations the one with the given selectedConfigType
        for (var i = 0; i < extPointStruct.selectedExtPointPlugin.configurations.length; i++) {
            if (extPointStruct.selectedExtPointPlugin.configurations[i].type == extPointStruct.selectedExtPointPlugin.selectedConfigType) {
                this.openConfigurationModal(extPointStruct.selectedExtPointPlugin.configurations[i]);
                break;
            }
        }
    }
    
    /**
     * retrieves the new project setting and calls the newProject service
     */
    private create() {
        
        if (!this.projectName || this.projectName.trim() == "" || !this.baseURI || this.baseURI.trim() == "") {
            return; //project name or baseURI not valid
        }
        
        this.submitted = true;
        
        if (this.projectName && this.projectName.trim() != "" && this.baseURI && this.baseURI.trim() != "") {
            
            var uriGenFactoryID;
            var uriGenConfigurationClass;
            var uriGenConfigurationArray;
            var renderingEngineFactoryID;
            var renderingEngineConfigurationClass;
            var renderingEngineConfigurationArray;
            
            /* NOTE: currently I need to prepare the above parameters in a not-general way because 
             the newProject method gets precise parameters so they must be distinguished.
        	 We should generalize the request and then this operations will be generalized too.
             Otherwise we should change the service newProject so that it gets just the basic parameters,
             creates a project with basic plugin configurations and then we should allow to change them after the
             project creation. */
            for (var i = 0; i < this.extPointStructList.length; i++) {
                if (this.extPointStructList[i].id == "it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerator") {
                    if (this.extPointStructList[i].selectedExtPointPluginId != "---") {
                        uriGenFactoryID = this.extPointStructList[i].selectedExtPointPluginId;
                        uriGenConfigurationClass = this.extPointStructList[i].selectedExtPointPlugin.selectedConfigType;
                        for (var j = 0; j < this.extPointStructList[i].selectedExtPointPlugin.configurations.length; j++) {
                            if (this.extPointStructList[i].selectedExtPointPlugin.configurations[j].type == uriGenConfigurationClass) {
                                uriGenConfigurationArray = this.extPointStructList[i].selectedExtPointPlugin.configurations[j].params;
                                break;
                            }
                        }
                    }
                } else if (this.extPointStructList[i].id == "it.uniroma2.art.semanticturkey.plugin.extpts.RenderingEngine") {
                    if (this.extPointStructList[i].selectedExtPointPluginId != "---") {
                        renderingEngineFactoryID = this.extPointStructList[i].selectedExtPointPluginId;
                        renderingEngineConfigurationClass = this.extPointStructList[i].selectedExtPointPlugin.selectedConfigType;
                        for (var j = 0; j < this.extPointStructList[i].selectedExtPointPlugin.configurations.length; j++) {
                            if (this.extPointStructList[i].selectedExtPointPlugin.configurations[j].type == renderingEngineConfigurationClass) {
                                renderingEngineConfigurationArray = this.extPointStructList[i].selectedExtPointPlugin.configurations[j].params;
                                break;
                            }
                        }
                    }
                }
            }
            
            document.getElementById("blockDivFullScreen").style.display = "block";
            this.projectService.createProject(this.projectName, this.ontoType, this.baseURI, 
                this.ontoMgrId, this.selectedOntoMgrConfigType, this.selectedOntoMgrConfig.params,
                uriGenFactoryID, uriGenConfigurationClass, uriGenConfigurationArray,
                renderingEngineFactoryID, renderingEngineConfigurationClass, renderingEngineConfigurationArray).subscribe(
                stResp => {
                    this.modalService.alert("Create project", "Project created successfully").then(
                        () => this.router.navigate(['Projects'])
                    );
                },
                err => { },
                () => document.getElementById("blockDivFullScreen").style.display = "none"
            );
            
        }
    }
    
    /**
     * Opens a modal to change configurations
     */
    private openConfigurationModal(configuration: any) {
        let dialog: Promise<ModalDialogInstance>;
        let component = OntoMgrConfigModal;
        //inject the modal content in the modal Component
        var modalContent = new OntoMgrConfigModalContent(configuration);
        let bindings = Injector.resolve([provide(ICustomModal, {useValue: modalContent})]);
        //set the modal configuration (small dimension, blocking and without key to dismiss)
        var modConf = new ModalConfig("md", true, null);
        dialog = this.modal.open(<any>component, bindings, modConf);
        return dialog.then(
            resultPromise => {
                return resultPromise.result;
            }
        );
    }
    
}