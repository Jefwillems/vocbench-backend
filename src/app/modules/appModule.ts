import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule, RouteReuseStrategy } from "@angular/router";

import { CustomReuseStrategy } from "../a2Customization/CustomReuseStrategy";

import { STServicesModule } from "./stServicesModule";
import { SharedModule } from "./sharedModule";
import { VBModalModule } from "./vbModalModule";
import { CustomFormModule } from "./customFormModule";
import { TreeAndListModule } from "./treeAndListModule";
import { ResourceViewModule } from "./resourceViewModule";
import { ICVModule } from "./icvModule";
import { AdministrationModule } from "./administrationModule";
import { UserModule } from "./userModule";
import { MetadataModule } from "./metadataModule";

import { ModalModule } from 'angular2-modal';
import { BootstrapModalModule } from 'angular2-modal/plugins/bootstrap';

import { AppComponent } from "../appComponent";
import { appRouting } from '../appRoutes';

import { HttpManager } from "../utils/HttpManager";
import { VBPreferences } from "../utils/VBPreferences";
import { VBEventHandler } from "../utils/VBEventHandler";
import { GUARD_PROVIDERS } from "../utils/CanActivateGuards";
import { UserResolver } from "../utils/UserResolver";

//Components
import { HomeComponent } from "../homeComponent";
import { ProjectComponent } from "../project/projectComponent";
import { DataComponent } from "../data/dataComponent";
import { SparqlComponent } from "../sparql/sparqlComponent";
import { AlignmentValidationComponent } from "../alignment/alignmentValidation/alignmentValidationComponent";
import { CustomFormConfigComponent } from "../customForms/customFormConfComponent";
import { ImportProjectComponent } from "../project/importProject/importProjectComponent";
import { CreateProjectComponent } from "../project/createProject/createProjectComponent";
import { IcvComponent } from "../icv/icvComponent";
import { HistoryComponent } from "../historyValidation/historyComponent";
import { ValidationComponent } from "../historyValidation/validationComponent";
import { LoadDataComponent } from "../config/dataManagement/loadData/loadDataComponent";
import { ExportDataComponent } from "../config/dataManagement/exportData/exportDataComponent";
import { RefactorComponent } from "../config/dataManagement/refactor/refactorComponent";
import { VersioningComponent } from "../config/dataManagement/versioning/versioningComponent";
import { VocbenchSettingsComponent } from "../settings/vocbenchSettingsComponent";
import { ConfigBarComponent } from "../config/configBar/configBarComponent";
import { AdministrationComponent } from "../administration/administrationComponent";

@NgModule({
      imports: [
            RouterModule,
            BrowserModule,
            FormsModule, //check if this is still necessary when declarated component are reduced in favor of more imported modules

            SharedModule, VBModalModule, TreeAndListModule, ResourceViewModule,
            UserModule, ICVModule, AdministrationModule, CustomFormModule, MetadataModule,

            STServicesModule,
            appRouting,
            ModalModule.forRoot(), BootstrapModalModule //Modules of angular2-modal
      ],
      //services with application scope
      providers: [
            HttpManager, VBEventHandler, VBPreferences, GUARD_PROVIDERS, UserResolver,
            { provide: RouteReuseStrategy, useClass: CustomReuseStrategy }
      ],
      declarations: [
            AppComponent,
            ConfigBarComponent,
            HomeComponent,
            ProjectComponent,
            ImportProjectComponent,
            CreateProjectComponent,
            DataComponent,
            SparqlComponent,
            IcvComponent,
            HistoryComponent,
            ValidationComponent,
            AlignmentValidationComponent,
            CustomFormConfigComponent,
            LoadDataComponent,
            ExportDataComponent,
            RefactorComponent,
            VersioningComponent,
            VocbenchSettingsComponent,
            AdministrationComponent,
      ],
      bootstrap: [AppComponent],
})
export class AppModule { }
