package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Resources;

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
public class ResourcesController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Resources.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Resources getService() {
		return context.getBean(Resources.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Resources/removeValue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeValuePublished(@RequestParam(value = "subject") org.eclipse.rdf4j.model.Resource subject, @RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "value") org.eclipse.rdf4j.model.Value value) 
	{
	
		String body;

		Resources fun = getService();
		fun.removeValue(subject, property, value);		
		body = ServletUtilities.getService().createReplyResponse("removeValue", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Resources/getResourcesInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getResourcesInfoPublished(@RequestParam(value = "resources") org.eclipse.rdf4j.model.IRI[] resources) 
	{
	
		
		Resources fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getResourcesInfo(resources);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Resources/getResourcePosition", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   getResourcePositionPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		Resources fun = getService();
		java.lang.String body = fun.getResourcePosition(resource);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Resources/setDeprecated", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setDeprecatedPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource) 
	{
	
		String body;

		Resources fun = getService();
		fun.setDeprecated(resource);		
		body = ServletUtilities.getService().createReplyResponse("setDeprecated", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Resources/updateTriple", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateTriplePublished(@RequestParam(value = "subject") org.eclipse.rdf4j.model.Resource subject, @RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "value") org.eclipse.rdf4j.model.Value value, @RequestParam(value = "newValue") org.eclipse.rdf4j.model.Value newValue) 
	{
	
		String body;

		Resources fun = getService();
		fun.updateTriple(subject, property, value, newValue);		
		body = ServletUtilities.getService().createReplyResponse("updateTriple", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Resources/addValue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addValuePublished(@RequestParam(value = "subject") org.eclipse.rdf4j.model.Resource subject, @RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "value") it.uniroma2.art.semanticturkey.customform.SpecialValue value)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.exceptions.CODAException
	{
	
		String body;

		Resources fun = getService();
		fun.addValue(subject, property, value);		
		body = ServletUtilities.getService().createReplyResponse("addValue", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Resources/getResourceDescription", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>
>   getResourceDescriptionPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.Resource resource) 
	{
	
		
		Resources fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource> body = fun.getResourceDescription(resource);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}