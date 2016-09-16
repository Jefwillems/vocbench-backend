import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {FilePickerComponent} from '../widget/filePicker/filePickerComponent';
import {LangPickerComponent} from '../widget/langPicker/langPickerComponent';
import {RdfResourceComponent} from '../widget/rdfResource/rdfResourceComponent';
import {SanitizerDirective} from "../widget/directives/sanitizerDirective";

import {CodemirrorComponent} from '../sparql/codemirrorComponent';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [FilePickerComponent, RdfResourceComponent, LangPickerComponent, SanitizerDirective, CodemirrorComponent],
    exports: [
        FilePickerComponent,
        RdfResourceComponent,
        SanitizerDirective, 
        LangPickerComponent,
        CodemirrorComponent
    ],
    providers: []
})
export class SharedModule { }