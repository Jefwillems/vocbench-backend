package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Extensions;

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
public class ExtensionsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Extensions.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Extensions getService() {
		return context.getBean(Extensions.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Extensions/getExtensions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.extension.ExtensionFactory<?>>>
>   getExtensionsPublished(@RequestParam(value = "extensionPointID") java.lang.String extensionPointID) 
	{
	
		
		Extensions fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.extension.ExtensionFactory<?>> body = fun.getExtensions(extensionPointID);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Extensions/getExtensionPoints", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.extension.ExtensionPoint>>
>   getExtensionPointsPublished(@RequestParam(value = "scopes", required=false, defaultValue="") it.uniroma2.art.semanticturkey.resources.Scope[] scopes) 
	{
	
		
		Extensions fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.extension.ExtensionPoint> body = fun.getExtensionPoints(scopes);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Extensions/getExtensionPoint", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.extension.ExtensionPoint>
>   getExtensionPointPublished(@RequestParam(value = "identifier") java.lang.String identifier) 
	{
	
		
		Extensions fun = getService();
		it.uniroma2.art.semanticturkey.extension.ExtensionPoint body = fun.getExtensionPoint(identifier);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}