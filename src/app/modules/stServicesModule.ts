import { NgModule } from '@angular/core';

import { HttpModule } from '@angular/http';

import { AdministrationServices } from "../services/administrationServices";
import { AlignmentServices } from "../services/alignmentServices";
import { AuthServices } from "../services/authServices";
import { ClassesServices } from "../services/classesServices";
import { CODAServices } from "../services/codaServices";
import { CustomRangeServices } from "../services/customRangeServices";
import { DeleteServices } from "../services/deleteServices";
import { ExportServices } from "../services/exportServices";
import { IcvServices } from "../services/icvServices";
import { IndividualsServices } from "../services/individualsServices";
import { InputOutputServices } from "../services/inputOutputServices";
import { ManchesterServices } from "../services/manchesterServices";
import { MetadataServices } from "../services/metadataServices";
import { OntoManagerServices } from "../services/ontoManagerServices";
import { OwlServices } from "../services/owlServices";
import { PluginsServices } from "../services/pluginsServices";
import { ProjectServices } from "../services/projectServices";
import { PropertyServices } from "../services/propertyServices";
import { RefactorServices } from "../services/refactorServices";
import { ResourceServices } from "../services/resourceServices";
import { ResourceViewServices } from "../services/resourceViewServices";
import { SearchServices } from "../services/searchServices";
import { SkosServices } from "../services/skosServices";
import { SkosxlServices } from "../services/skosxlServices";
import { SparqlServices } from "../services/sparqlServices";
import { UserServices } from "../services/userServices";

@NgModule({
    imports: [HttpModule],
    declarations: [],
    exports: [],
    providers: [
        AdministrationServices,
        AlignmentServices,
        AuthServices,
        ClassesServices,
        CODAServices,
        CustomRangeServices,
        DeleteServices,
        ExportServices,
        IcvServices,
        IndividualsServices,
        InputOutputServices,
        ManchesterServices,
        MetadataServices,
        OntoManagerServices,
        OwlServices,
        PluginsServices,
        ProjectServices,
        PropertyServices,
        RefactorServices,
        ResourceServices,
        ResourceViewServices,
        SearchServices,
        SkosServices,
        SkosxlServices,
        SparqlServices,
        UserServices
    ]
})
export class STServicesModule { }