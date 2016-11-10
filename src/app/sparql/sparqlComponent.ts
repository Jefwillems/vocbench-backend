import {Component} from "@angular/core";
import {SparqlServices} from "../services/sparqlServices";
import {MetadataServices} from "../services/metadataServices";
import {ModalServices} from '../widget/modal/modalServices';

@Component({
    selector: "sparql-component",
    templateUrl: "./sparqlComponent.html",
    host: { class: "pageComponent" }
})
export class SparqlComponent {
    
    private sampleQuery: string = "SELECT * WHERE {\n    ?s ?p ?o .\n} LIMIT 10";
    private tabs: Array<any> = [];
    private activeTab;
    
    constructor(private sparqlService:SparqlServices, private metadataService: MetadataServices, private modalService: ModalServices) {}
    
    ngOnInit() {
        this.metadataService.getNSPrefixMappings().subscribe(
            mappings => {
                //collect the prefix namespace mappings
                var prefixImports: string = "";
                for (var i = 0; i < mappings.length; i++) {
                    prefixImports += "PREFIX " + mappings[i].prefix + ": <" + mappings[i].namespace + ">\n";
                }
                //set them as suffix of sampleQuery
                this.sampleQuery = prefixImports + "\n" + this.sampleQuery;
                //initialize the first tab
                this.tabs.push({
                    query: this.sampleQuery,
                    queryMode: "query",
                    respSparqlJSON: null, //keep the "sparql" JSON object contained in the response
                    resultType: null, //graph / tuple / boolean
                    headers: null,
                    queryResult: null,
                    queryInProgress: false,
                    queryValid: true,
                    queryTime: null,
                    inferred: false,
                    removable: false,
                    active: true
                });
                this.activeTab = this.tabs[0];
            }
        )
    }
    
    private doQuery(tab) {
        var initTime = new Date().getTime();
        tab.queryResult = null;
        document.getElementById("blockDivFullScreen").style.display = "block";
        this.sparqlService.resolveQuery(tab.query, "SPARQL", tab.inferred, tab.queryMode).subscribe(
            data => {
                tab.respSparqlJSON = data.sparql;
                //calculates the time spent in query
                var finishTime = new Date().getTime();
                var diffTime = finishTime - initTime;
                tab.queryTime = this.getPrettyPrintTime(diffTime);
                //process result
                tab.resultType = data.resulttype;
                if (data.resulttype == "tuple" || data.resulttype == "graph") {
                    tab.headers = data.sparql.head.vars;
                    tab.queryResult = data.sparql.results.bindings;
                } else if (data.resulttype ==  "boolean") {
                    tab.headers = ["boolean"];
                    tab.queryResult = Boolean(data.sparql.boolean);
                }
                document.getElementById("blockDivFullScreen").style.display = "none";
            },
            err => {
                document.getElementById("blockDivFullScreen").style.display = "none";
            }
        );
    }

    /**
     * Listener of event querychange, emitted from YasquiComponent.
     * Event is an object {query: string, valid: boolean, mode} where
     * query is the code written in the textarea
     * valid tells wheter the query is syntactically correct
     * mode tells the query mode (query/update) 
     */
    private onQueryChange(event) {
        this.activeTab.query = event.query;
        this.activeTab.queryValid = event.valid;
        this.activeTab.queryMode = event.mode;
    }

    private clear(tab) {
        tab.respSparqlJSON = null;
        tab.headers = null;
        tab.queryResult = null;
        tab.queryTime = null;
    }
    
    private exportAsJSON(tab) {
        this.downloadSavedResult(JSON.stringify(tab.respSparqlJSON), "json");
    }

    private exportAsCSV(tab) {
        //https://www.w3.org/TR/sparql11-results-csv-tsv/#csv
        var serialization = "";
        var separator = ",";

        if (tab.resultType == "tuple" || tab.resultType == "graph") {
            //headers
            var headers = tab.headers;
            for (var i = 0; i < headers.length; i++) {
                serialization += headers[i] + separator;
            }
            serialization = serialization.slice(0, -1); //remove last separator
            serialization += "\n"; //and add new line
            //results
            var res: Array<any> = tab.queryResult;
            for (var j = 0; j < res.length; j++) {
                for (var i = 0; i < headers.length; i++) {
                    if (res[j][headers[i]] != undefined) {
                        serialization += this.escapeForCSV(res[j][headers[i]]) + separator;
                    } else {
                        serialization += separator;
                    }
                }
                serialization = serialization.slice(0, -1); //remove last separator
                serialization += "\n"; //and add new line
            }
        } else if (tab.resultType == "boolean") {
            serialization += "result\n" + tab.queryResult;
        }

        this.downloadSavedResult(serialization, "csv");
    }

    /**
     * Field is an object {value, type} like the bindings in the sparql response of tuple query
     */
    private escapeForCSV(field: any): string {
        var value: string = field.value;
        /* Fields containing any of 
        " (QUOTATION MARK, code point 34),
        , (COMMA, code point 44),
        LF (code point 10) or CR (code point 13)
        must be quoted using a pair of quotation marks " 
        Blank nodes use the _:label form from Turtle and SPARQL */
        if (field.type == "bnode" && !value.startsWith("_:")) {
            value = "_:" + value;
        } else if (value.includes(String.fromCodePoint(34)) || value.includes(String.fromCodePoint(44)) ||
            value.includes(String.fromCodePoint(10)) || value.includes(String.fromCodePoint(13))) {
            // Within quote strings " is written using a pair of quotation marks "".
            value = value.replace(/"/g, "\"\"");
            value = "\"" + value + "\"";
        }
        return value;
    }

    private exportAsTSV(tab) {
        //https://www.w3.org/TR/sparql11-results-csv-tsv/#csv
        var serialization = "";
        var separator = "\t";

        if (tab.resultType == "tuple" || tab.resultType == "graph") {
            //headers
            //Variables are serialized in SPARQL syntax, using question mark ? character followed by the variable name
            var headers = tab.headers;
            for (var i = 0; i < headers.length; i++) {
                serialization += "?" + headers[i] + separator;
            }
            serialization = serialization.slice(0, -1); //remove last separator
            serialization += "\n"; //and add new line
            //results
            var res: Array<any> = tab.queryResult;
            for (var j = 0; j < res.length; j++) {
                for (var i = 0; i < headers.length; i++) {
                    if (res[j][headers[i]] != undefined) {
                        serialization += this.escapeForTSV(res[j][headers[i]]) + separator;
                    } else {
                        serialization += separator;
                    }
                }
                serialization = serialization.slice(0, -1); //remove last separator
                serialization += "\n"; //and add new line
            }
        } else if (tab.resultType == "boolean") {
            serialization += "?result\n" + tab.queryResult;
        }

        this.downloadSavedResult(serialization, "tsv");
    }

    /**
     * Field is an object {value, type} like the bindings in the sparql response of tuple query
     * if type is literal, it may contains an attribute "xml:lang" or "datatype"
     */
    private escapeForTSV(field: any): string {
        var value: string = field.value;
        /* IRIs enclosed in <...>,
        literals are enclosed with double quotes "..." or single quotes ' ...' with optional @lang or ^^ for datatype.
        Tab, newline and carriage return characters (codepoints 0x09, 0x0A, 0x0D) are encoded as \t, \n and \r
        Blank nodes use the _:label form from Turtle and SPARQL */
        if (field.type == "uri") {
            value = "<" + value + ">";
        } else if (field.type == "bnode" && !value.startsWith("_:")) {
            value = "_:" + value;
        } else if (field.type == "literal") {
            value = value.replace(/\t/g, "\\t");
            value = value.replace(/\n/g, "\\n");
            value = value.replace(/\r/g, "\\r");
            value = "\"" + value + "\"";
            if (field["xml:lang"] != undefined) {
                value += "@" + field["xml:lang"]; 
            }
            if (field["datatype"] != undefined) {
                value += "^^" + field["^^"];
            }
        }
        return value;
    }
    
    /**
     * Prepares a json or text file containing the given content and shows a modal to download it.
     */
    private downloadSavedResult(fileContent: string, type: "csv" | "tsv" | "json") {
        var data = new Blob([fileContent], {type: 'text/plain'});
        var textFile = window.URL.createObjectURL(data);
        var fileName = "result." + type;
        this.modalService.downloadLink("Save SPARQL results", null, textFile, fileName).then(
            done => { window.URL.revokeObjectURL(textFile); },
            () => {}
        );
    }
    
    private getPrettyPrintTime(time) {
        if (time < 1000) {
            return time + " millisec";
        } else {
            var sec = Math.floor(time / 1000);
            var millisec: any = time % 1000;
            if (millisec < 10) {
                millisec = "00" + millisec;
            } else if (millisec < 100) {
                millisec = "0" + millisec;
            }
            return sec + "," + millisec + " sec";
        }
    }
    
    //TAB HANDLER
    
    addTab() {
        this.activeTab.active = false;
        this.tabs.push({
            query: this.sampleQuery,
            queryMode: "query",
            headers: null,
            queryResult: null,
            queryInProgress: false,
            queryValid: true,
            queryTime: null,
            inferred: false,
            removable: true,
            active: true
        });
        this.activeTab = this.tabs[this.tabs.length-1];
    }
    
    selectTab(t) {
        this.activeTab.active = false;
        t.active = true;
        this.activeTab = t;
    }
    
    closeTab(t) {
        var tabIdx = this.tabs.indexOf(t);
        //if the closed tab is active, change the active tab
        if (t.active) {
            if (tabIdx == this.tabs.length-1) { //if the closed tab was the last one, active the previous
                this.tabs[tabIdx-1].active = true;
                this.activeTab = this.tabs[tabIdx-1];
            } else { //otherwise active the next
                this.tabs[tabIdx+1].active = true;
                this.activeTab = this.tabs[tabIdx+1];
            }
        }
        this.tabs.splice(tabIdx, 1);
    }
}