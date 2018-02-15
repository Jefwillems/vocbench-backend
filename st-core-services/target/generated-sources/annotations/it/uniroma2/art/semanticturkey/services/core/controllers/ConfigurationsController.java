package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Configurations;

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
public class ConfigurationsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Configurations.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Configurations getService() {
		return context.getBean(Configurations.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Configurations/getConfiguration", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.config.Configuration>
>   getConfigurationPublished(@RequestParam(value = "componentID") java.lang.String componentID, @RequestParam(value = "relativeReference") java.lang.String relativeReference)  throws it.uniroma2.art.semanticturkey.extension.NoSuchConfigurationManager, java.io.IOException, it.uniroma2.art.semanticturkey.config.ConfigurationNotFoundException, it.uniroma2.art.semanticturkey.properties.WrongPropertiesException
	{
	
		
		Configurations fun = getService();
		it.uniroma2.art.semanticturkey.config.Configuration body = fun.getConfiguration(componentID, relativeReference);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Configurations/getConfigurationReferences", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.resources.Reference>>
>   getConfigurationReferencesPublished(@RequestParam(value = "componentID") java.lang.String componentID)  throws it.uniroma2.art.semanticturkey.extension.NoSuchConfigurationManager
	{
	
		
		Configurations fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.resources.Reference> body = fun.getConfigurationReferences(componentID);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Configurations/storeConfiguration", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   storeConfigurationPublished(@RequestParam(value = "componentID") java.lang.String componentID, @RequestParam(value = "relativeReference") java.lang.String relativeReference, @RequestParam(value = "configuration") java.util.Map<java.lang.String,java.lang.Object> configuration)  throws it.uniroma2.art.semanticturkey.extension.NoSuchConfigurationManager, java.io.IOException, it.uniroma2.art.semanticturkey.properties.WrongPropertiesException
	{
	
		String body;

		Configurations fun = getService();
		fun.storeConfiguration(componentID, relativeReference, configuration);		
		body = ServletUtilities.getService().createReplyResponse("storeConfiguration", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}