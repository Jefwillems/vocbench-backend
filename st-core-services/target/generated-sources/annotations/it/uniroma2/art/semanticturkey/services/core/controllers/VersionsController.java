package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Versions;

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
public class VersionsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Versions.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Versions getService() {
		return context.getBean(Versions.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Versions/closeVersion", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   closeVersionPublished(@RequestParam(value = "versionId") java.lang.String versionId) 
	{
	
		String body;

		Versions fun = getService();
		fun.closeVersion(versionId);		
		body = ServletUtilities.getService().createReplyResponse("closeVersion", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Versions/getVersions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.List<it.uniroma2.art.semanticturkey.project.VersionInfo>>
>   getVersionsPublished(@RequestParam(value = "setRepositoryStatus", required=false, defaultValue="false") boolean setRepositoryStatus)  throws com.fasterxml.jackson.core.JsonParseException, com.fasterxml.jackson.databind.JsonMappingException, java.io.IOException
	{
	
		
		Versions fun = getService();
		java.util.List<it.uniroma2.art.semanticturkey.project.VersionInfo> body = fun.getVersions(setRepositoryStatus);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Versions/createVersionDump", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.project.VersionInfo>
>   createVersionDumpPublished(@RequestParam(value = "repositoryAccess", required=false) it.uniroma2.art.semanticturkey.project.RepositoryAccess repositoryAccess, @RequestParam(value = "repositoryId", required=false) java.lang.String repositoryId, @RequestParam(value = "repoConfigurerSpecification", required=false, defaultValue="{\"factoryId\" : \"it.uniroma2.art.semanticturkey.plugin.impls.repositoryimplconfigurer.PredefinedRepositoryImplConfigurerFactory\"}") it.uniroma2.art.semanticturkey.plugin.PluginSpecification repoConfigurerSpecification, @RequestParam(value = "backendType", required=false) java.lang.String backendType, @RequestParam(value = "versionId") java.lang.String versionId)  throws it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingRepositoryException, com.fasterxml.jackson.core.JsonProcessingException, it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException, it.uniroma2.art.semanticturkey.exceptions.ReservedPropertyUpdateException, java.lang.Exception
	{
	
		
		Versions fun = getService();
		it.uniroma2.art.semanticturkey.project.VersionInfo body = fun.createVersionDump(repositoryAccess, repositoryId, repoConfigurerSpecification, backendType, versionId);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}