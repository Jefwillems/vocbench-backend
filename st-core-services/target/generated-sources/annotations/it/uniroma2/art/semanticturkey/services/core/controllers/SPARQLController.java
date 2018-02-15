package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.SPARQL;

import it.uniroma2.art.semanticturkey.mvc.IntrospectableController;
import it.uniroma2.art.semanticturkey.services.ServiceSpecies;
import it.uniroma2.art.semanticturkey.services.NewStyleService;
import it.uniroma2.art.semanticturkey.services.Response;
import it.uniroma2.art.semanticturkey.servlet.ServiceVocabulary.RepliesStatus;
import it.uniroma2.art.semanticturkey.servlet.ServletUtilities;
import it.uniroma2.art.semanticturkey.servlet.ServiceVocabulary.SerializationType;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SPARQLController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(SPARQL.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public SPARQL getService() {
		return context.getBean(SPARQL.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SPARQL/exportQueryResultAsSpreadsheet", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  void   exportQueryResultAsSpreadsheetPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "format") java.lang.String format, @RequestParam(value = "query") java.lang.String query, @RequestParam(value = "ql", required=false, defaultValue="SPARQL") org.eclipse.rdf4j.query.QueryLanguage ql, @RequestParam(value = "includeInferred", required=false, defaultValue="true") boolean includeInferred, @RequestParam(value = "bindings", required=false, defaultValue="{}") java.util.Map<java.lang.String,org.eclipse.rdf4j.model.Value> bindings, @RequestParam(value = "maxExecTime", required=false, defaultValue="0") int maxExecTime, @RequestParam(value = "defaultGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] defaultGraphs, @RequestParam(value = "namedGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] namedGraphs)  throws com.fasterxml.jackson.core.JsonProcessingException, java.io.IOException
	{
	
		SPARQL fun = getService();
		fun.exportQueryResultAsSpreadsheet(oRes, format, query, ql, includeInferred, bindings, maxExecTime, defaultGraphs, namedGraphs);
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SPARQL/evaluateQuery", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   evaluateQueryPublished(@RequestParam(value = "query") java.lang.String query, @RequestParam(value = "ql", required=false, defaultValue="SPARQL") org.eclipse.rdf4j.query.QueryLanguage ql, @RequestParam(value = "includeInferred", required=false, defaultValue="true") boolean includeInferred, @RequestParam(value = "bindings", required=false, defaultValue="{}") java.util.Map<java.lang.String,org.eclipse.rdf4j.model.Value> bindings, @RequestParam(value = "maxExecTime", required=false, defaultValue="0") int maxExecTime, @RequestParam(value = "defaultGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] defaultGraphs, @RequestParam(value = "namedGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] namedGraphs)  throws com.fasterxml.jackson.core.JsonProcessingException, java.io.IOException
	{
	
		
		SPARQL fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.evaluateQuery(query, ql, includeInferred, bindings, maxExecTime, defaultGraphs, namedGraphs);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SPARQL/executeUpdate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   executeUpdatePublished(@RequestParam(value = "query") java.lang.String query, @RequestParam(value = "ql", required=false, defaultValue="SPARQL") org.eclipse.rdf4j.query.QueryLanguage ql, @RequestParam(value = "includeInferred", required=false, defaultValue="true") boolean includeInferred, @RequestParam(value = "bindings", required=false, defaultValue="{}") java.util.Map<java.lang.String,org.eclipse.rdf4j.model.Value> bindings, @RequestParam(value = "maxExecTime", required=false, defaultValue="0") int maxExecTime, @RequestParam(value = "defaultGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] defaultGraphs, @RequestParam(value = "namedGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] namedGraphs, @RequestParam(value = "defaultInsertGraph", required=false) org.eclipse.rdf4j.model.IRI defaultInsertGraph, @RequestParam(value = "defaultRemoveGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] defaultRemoveGraphs)  throws com.fasterxml.jackson.core.JsonProcessingException, java.io.IOException
	{
	
		String body;

		SPARQL fun = getService();
		fun.executeUpdate(query, ql, includeInferred, bindings, maxExecTime, defaultGraphs, namedGraphs, defaultInsertGraph, defaultRemoveGraphs);		
		body = ServletUtilities.getService().createReplyResponse("executeUpdate", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SPARQL/exportGraphQueryResultAsRdf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  void   exportGraphQueryResultAsRdfPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "query") java.lang.String query, @RequestParam(value = "ql", required=false, defaultValue="SPARQL") org.eclipse.rdf4j.query.QueryLanguage ql, @RequestParam(value = "includeInferred", required=false, defaultValue="true") boolean includeInferred, @RequestParam(value = "bindings", required=false, defaultValue="{}") java.util.Map<java.lang.String,org.eclipse.rdf4j.model.Value> bindings, @RequestParam(value = "maxExecTime", required=false, defaultValue="0") int maxExecTime, @RequestParam(value = "defaultGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] defaultGraphs, @RequestParam(value = "namedGraphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] namedGraphs, @RequestParam(value = "filteringPipeline", required=false, defaultValue="[]") it.uniroma2.art.semanticturkey.services.core.export.FilteringPipeline filteringPipeline, @RequestParam(value = "outputFormat", required=false, defaultValue="TURTLE") org.eclipse.rdf4j.rio.RDFFormat outputFormat)  throws java.io.IOException, java.lang.ClassNotFoundException, it.uniroma2.art.semanticturkey.plugin.configuration.UnsupportedPluginConfigurationException, it.uniroma2.art.semanticturkey.plugin.configuration.UnloadablePluginConfigurationException, it.uniroma2.art.semanticturkey.properties.WrongPropertiesException, it.uniroma2.art.semanticturkey.services.core.ExportPreconditionViolationException
	{
	
		SPARQL fun = getService();
		fun.exportGraphQueryResultAsRdf(oRes, query, ql, includeInferred, bindings, maxExecTime, defaultGraphs, namedGraphs, filteringPipeline, outputFormat);
    }
}