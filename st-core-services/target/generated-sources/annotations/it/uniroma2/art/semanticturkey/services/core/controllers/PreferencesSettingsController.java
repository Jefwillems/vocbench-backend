package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.PreferencesSettings;

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
public class PreferencesSettingsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(PreferencesSettings.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public PreferencesSettings getService() {
		return context.getBean(PreferencesSettings.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/getDefaultProjectSettings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getDefaultProjectSettingsPublished(@RequestParam(value = "properties") java.util.List<java.lang.String> properties, @RequestParam(value = "pluginID", required=false) java.lang.String pluginID)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		PreferencesSettings fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getDefaultProjectSettings(properties, pluginID);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setProjectSetting", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setProjectSettingPublished(@RequestParam(value = "property") java.lang.String property, @RequestParam(value = "value", required=false) java.lang.String value, @RequestParam(value = "projectName", required=false) java.lang.String projectName)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException, org.json.JSONException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setProjectSetting(property, value, projectName);		
		body = ServletUtilities.getService().createReplyResponse("setProjectSetting", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setShowFlags", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setShowFlagsPublished(@RequestParam(value = "show") boolean show)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setShowFlags(show);		
		body = ServletUtilities.getService().createReplyResponse("setShowFlags", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setShowInstancesNumb", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setShowInstancesNumbPublished(@RequestParam(value = "show") boolean show)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setShowInstancesNumb(show);		
		body = ServletUtilities.getService().createReplyResponse("setShowInstancesNumb", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/getStartupSystemSettings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getStartupSystemSettingsPublished()  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		PreferencesSettings fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getStartupSystemSettings();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/getProjectSettings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getProjectSettingsPublished(@RequestParam(value = "properties") java.util.List<java.lang.String> properties, @RequestParam(value = "projectName", required=false) java.lang.String projectName, @RequestParam(value = "pluginID", required=false) java.lang.String pluginID)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		PreferencesSettings fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getProjectSettings(properties, projectName, pluginID);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/getSystemSettings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getSystemSettingsPublished(@RequestParam(value = "properties") java.util.List<java.lang.String> properties, @RequestParam(value = "pluginID", required=false) java.lang.String pluginID)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		PreferencesSettings fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getSystemSettings(properties, pluginID);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setActiveSchemes", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setActiveSchemesPublished(@RequestParam(value = "schemes", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemes)  throws java.lang.IllegalStateException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setActiveSchemes(schemes);		
		body = ServletUtilities.getService().createReplyResponse("setActiveSchemes", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setProjectTheme", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setProjectThemePublished(@RequestParam(value = "themeId") int themeId)  throws it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setProjectTheme(themeId);		
		body = ServletUtilities.getService().createReplyResponse("setProjectTheme", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/getProjectPreferences", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getProjectPreferencesPublished(@RequestParam(value = "properties") java.util.List<java.lang.String> properties, @RequestParam(value = "pluginID", required=false) java.lang.String pluginID)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		PreferencesSettings fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getProjectPreferences(properties, pluginID);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/getActiveSchemes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>>
>   getActiveSchemesPublished(@RequestParam(value = "projectName") java.lang.String projectName)  throws java.lang.IllegalStateException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		PreferencesSettings fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>> body = fun.getActiveSchemes(projectName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setProjectPreference", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setProjectPreferencePublished(@RequestParam(value = "property") java.lang.String property, @RequestParam(value = "value", required=false) java.lang.String value)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException, org.json.JSONException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setProjectPreference(property, value);		
		body = ServletUtilities.getService().createReplyResponse("setProjectPreference", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setLanguages", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setLanguagesPublished(@RequestParam(value = "languages") java.util.Collection<java.lang.String> languages)  throws it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setLanguages(languages);		
		body = ServletUtilities.getService().createReplyResponse("setLanguages", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/PreferencesSettings/setSystemSetting", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setSystemSettingPublished(@RequestParam(value = "property") java.lang.String property, @RequestParam(value = "value") java.lang.String value)  throws it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		PreferencesSettings fun = getService();
		fun.setSystemSetting(property, value);		
		body = ServletUtilities.getService().createReplyResponse("setSystemSetting", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}