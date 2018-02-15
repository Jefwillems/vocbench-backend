package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Individuals;

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
public class IndividualsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Individuals.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Individuals getService() {
		return context.getBean(Individuals.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Individuals/addType", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addTypePublished(@RequestParam(value = "individual") org.eclipse.rdf4j.model.Resource individual, @RequestParam(value = "type") org.eclipse.rdf4j.model.Resource type) 
	{
	
		String body;

		Individuals fun = getService();
		fun.addType(individual, type);		
		body = ServletUtilities.getService().createReplyResponse("addType", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Individuals/removeType", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeTypePublished(@RequestParam(value = "individual") org.eclipse.rdf4j.model.Resource individual, @RequestParam(value = "type") org.eclipse.rdf4j.model.Resource type) 
	{
	
		String body;

		Individuals fun = getService();
		fun.removeType(individual, type);		
		body = ServletUtilities.getService().createReplyResponse("removeType", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Individuals/getNamedTypes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getNamedTypesPublished(@RequestParam(value = "individual") org.eclipse.rdf4j.model.Resource individual) 
	{
	
		
		Individuals fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getNamedTypes(individual);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}