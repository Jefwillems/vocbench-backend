package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Sheet2RDF;

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
public class Sheet2RDFController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Sheet2RDF.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Sheet2RDF getService() {
		return context.getBean(Sheet2RDF.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/addTriples", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addTriplesPublished() 
	{
	
		String body;

		Sheet2RDF fun = getService();
		fun.addTriples();		
		body = ServletUtilities.getService().createReplyResponse("addTriples", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/updateHeader", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateHeaderPublished(@RequestParam(value = "headerId") java.lang.String headerId, @RequestParam(value = "headerResource", required=false) org.eclipse.rdf4j.model.IRI headerResource, @RequestParam(value = "applyToAll", required=false, defaultValue="false") boolean applyToAll)  throws it.uniroma2.art.coda.exception.parserexception.PRParserException
	{
	
		String body;

		Sheet2RDF fun = getService();
		fun.updateHeader(headerId, headerResource, applyToAll);		
		body = ServletUtilities.getService().createReplyResponse("updateHeader", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/getHeaders", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getHeadersPublished()  throws org.w3c.dom.DOMException
	{
	
		
		Sheet2RDF fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getHeaders();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/uploadPearl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   uploadPearlPublished(@RequestParam(value = "file") org.springframework.web.multipart.MultipartFile file)  throws java.io.IOException
	{
	
		
		Sheet2RDF fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.uploadPearl(file);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/getPearl", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getPearlPublished(@RequestParam(value = "skosSchema", required=false) org.eclipse.rdf4j.model.IRI skosSchema)  throws java.io.IOException
	{
	
		
		Sheet2RDF fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getPearl(skosSchema);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/exportTriples", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  void   exportTriplesPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "outputFormat") org.eclipse.rdf4j.rio.RDFFormat outputFormat)  throws java.io.IOException
	{
	
		Sheet2RDF fun = getService();
		fun.exportTriples(oRes, outputFormat);
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/validatePearl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   validatePearlPublished(@RequestParam(value = "pearlCode") java.lang.String pearlCode) 
	{
	
		
		Sheet2RDF fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.validatePearl(pearlCode);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/savePearl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   savePearlPublished(@RequestParam(value = "pearlCode") java.lang.String pearlCode)  throws java.io.FileNotFoundException
	{
	
		String body;

		Sheet2RDF fun = getService();
		fun.savePearl(pearlCode);		
		body = ServletUtilities.getService().createReplyResponse("savePearl", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/getTriplesPreview", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getTriplesPreviewPublished(@RequestParam(value = "maxTableRows") int maxTableRows)  throws org.apache.uima.UIMAException, it.uniroma2.art.coda.exception.parserexception.PRParserException, it.uniroma2.art.coda.provisioning.ComponentProvisioningException, it.uniroma2.art.coda.exception.ConverterException, it.uniroma2.art.coda.exception.DependencyException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.coda.exception.RDFModelNotSetException, it.uniroma2.art.coda.exception.ProjectionRuleModelNotSet, it.uniroma2.art.coda.exception.UnassignableFeaturePathException
	{
	
		
		Sheet2RDF fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getTriplesPreview(maxTableRows);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/getHeaderFromId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getHeaderFromIdPublished(@RequestParam(value = "headerId") java.lang.String headerId) 
	{
	
		
		Sheet2RDF fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getHeaderFromId(headerId);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/closeSession", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   closeSessionPublished() 
	{
	
		String body;

		Sheet2RDF fun = getService();
		fun.closeSession();		
		body = ServletUtilities.getService().createReplyResponse("closeSession", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/uploadSpreadsheet", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   uploadSpreadsheetPublished(@RequestParam(value = "file") org.springframework.web.multipart.MultipartFile file)  throws java.io.IOException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException
	{
	
		String body;

		Sheet2RDF fun = getService();
		fun.uploadSpreadsheet(file);		
		body = ServletUtilities.getService().createReplyResponse("uploadSpreadsheet", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Sheet2RDF/getTablePreview", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getTablePreviewPublished(@RequestParam(value = "maxRows") int maxRows) 
	{
	
		
		Sheet2RDF fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getTablePreview(maxRows);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}