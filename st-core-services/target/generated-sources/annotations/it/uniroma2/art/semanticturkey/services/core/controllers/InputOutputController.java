package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.InputOutput;

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
public class InputOutputController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(InputOutput.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public InputOutput getService() {
		return context.getBean(InputOutput.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/InputOutput/getParserFormatForFileName", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   getParserFormatForFileNamePublished(@RequestParam(value = "fileName") java.lang.String fileName) 
	{
	
		
		InputOutput fun = getService();
		java.lang.String body = fun.getParserFormatForFileName(fileName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/InputOutput/getWriterFormatForFileName", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   getWriterFormatForFileNamePublished(@RequestParam(value = "fileName") java.lang.String fileName) 
	{
	
		
		InputOutput fun = getService();
		java.lang.String body = fun.getWriterFormatForFileName(fileName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/InputOutput/loadRDF", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   loadRDFPublished(@RequestParam(value = "inputFile") org.springframework.web.multipart.MultipartFile inputFile, @RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "rdfFormat") org.eclipse.rdf4j.rio.RDFFormat rdfFormat, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance, @RequestParam(value = "validateImplicitly", required=false, defaultValue="false") boolean validateImplicitly)  throws java.io.FileNotFoundException, java.io.IOException
	{
	
		
		InputOutput fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.loadRDF(inputFile, baseURI, rdfFormat, transitiveImportAllowance, validateImplicitly);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/InputOutput/clearData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   clearDataPublished()  throws org.eclipse.rdf4j.RDF4JException
	{
	
		String body;

		InputOutput fun = getService();
		fun.clearData();		
		body = ServletUtilities.getService().createReplyResponse("clearData", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}