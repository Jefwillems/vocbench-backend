package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Repositories;

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
public class RepositoriesController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Repositories.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Repositories getService() {
		return context.getBean(Repositories.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Repositories/getRemoteRepositories", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<org.eclipse.rdf4j.repository.manager.RepositoryInfo>>
>   getRemoteRepositoriesPublished(@RequestParam(value = "serverURL") java.lang.String serverURL, @RequestParam(value = "username", required=false) java.lang.String username, @RequestParam(value = "password", required=false) java.lang.String password) 
	{
	
		
		Repositories fun = getService();
		java.util.Collection<org.eclipse.rdf4j.repository.manager.RepositoryInfo> body = fun.getRemoteRepositories(serverURL, username, password);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}