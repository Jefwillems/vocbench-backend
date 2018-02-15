package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.ResourceView;

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
public class ResourceViewController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(ResourceView.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public ResourceView getService() {
		return context.getBean(ResourceView.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ResourceView/getResourceView", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Map<java.lang.String,it.uniroma2.art.semanticturkey.services.core.resourceview.ResourceViewSection>>
>   getResourceViewPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.Resource resource, @RequestParam(value = "resourcePosition", required=false) it.uniroma2.art.semanticturkey.data.access.ResourcePosition resourcePosition, @RequestParam(value = "includeInferred", required=false, defaultValue="false") boolean includeInferred)  throws java.lang.Exception
	{
	
		
		ResourceView fun = getService();
		java.util.Map<java.lang.String,it.uniroma2.art.semanticturkey.services.core.resourceview.ResourceViewSection> body = fun.getResourceView(resource, resourcePosition, includeInferred);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ResourceView/getLexicalizationProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.List<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>>
>   getLexicalizationPropertiesPublished(@RequestParam(value = "resource", required=false) org.eclipse.rdf4j.model.Resource resource, @RequestParam(value = "resourcePosition", required=false) it.uniroma2.art.semanticturkey.data.access.ResourcePosition resourcePosition)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException
	{
	
		
		ResourceView fun = getService();
		java.util.List<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>> body = fun.getLexicalizationProperties(resource, resourcePosition);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}