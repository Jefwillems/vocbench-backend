package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.OntManager;

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
public class OntManagerController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(OntManager.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public OntManager getService() {
		return context.getBean(OntManager.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/OntManager/deleteOntologyMirrorEntry", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteOntologyMirrorEntryPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "cacheFileName") java.lang.String cacheFileName) 
	{
	
		String body;

		OntManager fun = getService();
		fun.deleteOntologyMirrorEntry(baseURI, cacheFileName);		
		body = ServletUtilities.getService().createReplyResponse("deleteOntologyMirrorEntry", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/OntManager/getOntologyMirror", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.ontmanager.OntologyMirrorEntryInfo>>
>   getOntologyMirrorPublished() 
	{
	
		
		OntManager fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.ontmanager.OntologyMirrorEntryInfo> body = fun.getOntologyMirror();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/OntManager/updateOntologyMirrorEntry", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateOntologyMirrorEntryPublished(@RequestParam(value = "updateType") it.uniroma2.art.semanticturkey.services.core.OntManager.UpdateType updateType, @RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "mirrorFileName") java.lang.String mirrorFileName, @RequestParam(value = "alternativeURL", required=false) java.lang.String alternativeURL, @RequestParam(value = "inputFile", required=false) org.springframework.web.multipart.MultipartFile inputFile)  throws java.io.IOException
	{
	
		String body;

		OntManager fun = getService();
		fun.updateOntologyMirrorEntry(updateType, baseURI, mirrorFileName, alternativeURL, inputFile);		
		body = ServletUtilities.getService().createReplyResponse("updateOntologyMirrorEntry", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}