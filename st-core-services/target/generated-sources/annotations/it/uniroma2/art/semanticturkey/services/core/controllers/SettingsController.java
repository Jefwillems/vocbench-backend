package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Settings;

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
public class SettingsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Settings.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Settings getService() {
		return context.getBean(Settings.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Settings/storeSettings", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   storeSettingsPublished(@RequestParam(value = "componentID") java.lang.String componentID, @RequestParam(value = "scope") it.uniroma2.art.semanticturkey.resources.Scope scope, @RequestParam(value = "settings") java.util.Map<java.lang.String,java.lang.Object> settings)  throws it.uniroma2.art.semanticturkey.extension.NoSuchSettingsManager, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.lang.IllegalStateException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException, it.uniroma2.art.semanticturkey.properties.WrongPropertiesException
	{
	
		String body;

		Settings fun = getService();
		fun.storeSettings(componentID, scope, settings);		
		body = ServletUtilities.getService().createReplyResponse("storeSettings", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Settings/getSettings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.extension.settings.Settings>
>   getSettingsPublished(@RequestParam(value = "componentID") java.lang.String componentID, @RequestParam(value = "scope") it.uniroma2.art.semanticturkey.resources.Scope scope)  throws it.uniroma2.art.semanticturkey.extension.NoSuchSettingsManager, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Settings fun = getService();
		it.uniroma2.art.semanticturkey.extension.settings.Settings body = fun.getSettings(componentID, scope);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Settings/getSettingsScopes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.resources.Scope>>
>   getSettingsScopesPublished(@RequestParam(value = "componentID") java.lang.String componentID)  throws it.uniroma2.art.semanticturkey.extension.NoSuchSettingsManager
	{
	
		
		Settings fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.resources.Scope> body = fun.getSettingsScopes(componentID);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}