package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Projects;

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
public class ProjectsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Projects.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Projects getService() {
		return context.getBean(Projects.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/updateAccessLevel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateAccessLevelPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "consumerName") java.lang.String consumerName, @RequestParam(value = "accessLevel", required=false) it.uniroma2.art.semanticturkey.project.ProjectACL.AccessLevel accessLevel)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException, it.uniroma2.art.semanticturkey.exceptions.ReservedPropertyUpdateException
	{
	
		String body;

		Projects fun = getService();
		fun.updateAccessLevel(projectName, consumerName, accessLevel);		
		body = ServletUtilities.getService().createReplyResponse("updateAccessLevel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/exportProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  void   exportProjectPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "projectName") java.lang.String projectName)  throws java.io.IOException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		Projects fun = getService();
		fun.exportProject(oRes, projectName);
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/getAccessStatusMap", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getAccessStatusMapPublished()  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.project.ForbiddenProjectAccessException
	{
	
		
		Projects fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getAccessStatusMap();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/accessProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   accessProjectPublished(@RequestParam(value = "consumer") it.uniroma2.art.semanticturkey.project.ProjectConsumer consumer, @RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "requestedAccessLevel") it.uniroma2.art.semanticturkey.project.ProjectACL.AccessLevel requestedAccessLevel, @RequestParam(value = "requestedLockLevel") it.uniroma2.art.semanticturkey.project.ProjectACL.LockLevel requestedLockLevel)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.project.ForbiddenProjectAccessException, it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		String body;

		Projects fun = getService();
		fun.accessProject(consumer, projectName, requestedAccessLevel, requestedLockLevel);		
		body = ServletUtilities.getService().createReplyResponse("accessProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/importProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   importProjectPublished(@RequestParam(value = "importPackage") org.springframework.web.multipart.MultipartFile importPackage, @RequestParam(value = "newProjectName") java.lang.String newProjectName)  throws java.io.IOException, it.uniroma2.art.semanticturkey.exceptions.ProjectCreationException, it.uniroma2.art.semanticturkey.exceptions.DuplicatedResourceException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		String body;

		Projects fun = getService();
		fun.importProject(importPackage, newProjectName);		
		body = ServletUtilities.getService().createReplyResponse("importProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/setProjectProperty", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setProjectPropertyPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "propName") java.lang.String propName, @RequestParam(value = "propValue") java.lang.String propValue)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException, it.uniroma2.art.semanticturkey.exceptions.ReservedPropertyUpdateException
	{
	
		String body;

		Projects fun = getService();
		fun.setProjectProperty(projectName, propName, propValue);		
		body = ServletUtilities.getService().createReplyResponse("setProjectProperty", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/getProjectPropertyMap", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.projects.ProjectPropertyInfo>>
>   getProjectPropertyMapPublished(@RequestParam(value = "projectName") java.lang.String projectName)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, java.io.IOException
	{
	
		
		Projects fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.projects.ProjectPropertyInfo> body = fun.getProjectPropertyMap(projectName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/createProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   createProjectPublished(@RequestParam(value = "consumer") it.uniroma2.art.semanticturkey.project.ProjectConsumer consumer, @RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "model") org.eclipse.rdf4j.model.IRI model, @RequestParam(value = "lexicalizationModel") org.eclipse.rdf4j.model.IRI lexicalizationModel, @RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "historyEnabled") boolean historyEnabled, @RequestParam(value = "validationEnabled") boolean validationEnabled, @RequestParam(value = "repositoryAccess") it.uniroma2.art.semanticturkey.project.RepositoryAccess repositoryAccess, @RequestParam(value = "coreRepoID") java.lang.String coreRepoID, @RequestParam(value = "coreRepoSailConfigurerSpecification", required=false, defaultValue="{\"factoryId\" : \"it.uniroma2.art.semanticturkey.plugin.impls.repositoryimplconfigurer.PredefinedRepositoryImplConfigurerFactory\"}") it.uniroma2.art.semanticturkey.plugin.PluginSpecification coreRepoSailConfigurerSpecification, @RequestParam(value = "coreBackendType", required=false) java.lang.String coreBackendType, @RequestParam(value = "supportRepoID") java.lang.String supportRepoID, @RequestParam(value = "supportRepoSailConfigurerSpecification", required=false, defaultValue="{\"factoryId\" : \"it.uniroma2.art.semanticturkey.plugin.impls.repositoryimplconfigurer.PredefinedRepositoryImplConfigurerFactory\"}") it.uniroma2.art.semanticturkey.plugin.PluginSpecification supportRepoSailConfigurerSpecification, @RequestParam(value = "supportBackendType", required=false) java.lang.String supportBackendType, @RequestParam(value = "uriGeneratorSpecification", required=false, defaultValue="{\"factoryId\" : \"it.uniroma2.art.semanticturkey.plugin.impls.urigen.NativeTemplateBasedURIGeneratorFactory\"}") it.uniroma2.art.semanticturkey.plugin.PluginSpecification uriGeneratorSpecification, @RequestParam(value = "renderingEngineSpecification", required=false) it.uniroma2.art.semanticturkey.plugin.PluginSpecification renderingEngineSpecification, @RequestParam(value = "creationDateProperty", required=false, defaultValue="<http://purl.org/dc/terms/created>") org.eclipse.rdf4j.model.IRI creationDateProperty, @RequestParam(value = "modificationDateProperty", required=false, defaultValue="<http://purl.org/dc/terms/modified>") org.eclipse.rdf4j.model.IRI modificationDateProperty, @RequestParam(value = "updateForRoles", required=false, defaultValue="resource") java.lang.String[] updateForRoles)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.project.ForbiddenProjectAccessException, it.uniroma2.art.semanticturkey.exceptions.DuplicatedResourceException, it.uniroma2.art.semanticturkey.exceptions.ProjectCreationException, java.lang.ClassNotFoundException, it.uniroma2.art.semanticturkey.properties.WrongPropertiesException, it.uniroma2.art.semanticturkey.plugin.configuration.UnsupportedPluginConfigurationException, it.uniroma2.art.semanticturkey.plugin.configuration.UnloadablePluginConfigurationException, it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		String body;

		Projects fun = getService();
		fun.createProject(consumer, projectName, model, lexicalizationModel, baseURI, historyEnabled, validationEnabled, repositoryAccess, coreRepoID, coreRepoSailConfigurerSpecification, coreBackendType, supportRepoID, supportRepoSailConfigurerSpecification, supportBackendType, uriGeneratorSpecification, renderingEngineSpecification, creationDateProperty, modificationDateProperty, updateForRoles);		
		body = ServletUtilities.getService().createReplyResponse("createProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/listProjects", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.List<it.uniroma2.art.semanticturkey.project.ProjectInfo>>
>   listProjectsPublished(@RequestParam(value = "consumer", required=false) it.uniroma2.art.semanticturkey.project.ProjectConsumer consumer, @RequestParam(value = "requestedAccessLevel", required=false, defaultValue="R") it.uniroma2.art.semanticturkey.project.ProjectACL.AccessLevel requestedAccessLevel, @RequestParam(value = "requestedLockLevel", required=false, defaultValue="NO") it.uniroma2.art.semanticturkey.project.ProjectACL.LockLevel requestedLockLevel, @RequestParam(value = "userDependent", required=false, defaultValue="false") boolean userDependent, @RequestParam(value = "onlyOpen", required=false, defaultValue="false") boolean onlyOpen)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		Projects fun = getService();
		java.util.List<it.uniroma2.art.semanticturkey.project.ProjectInfo> body = fun.listProjects(consumer, requestedAccessLevel, requestedLockLevel, userDependent, onlyOpen);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/updateLockLevel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateLockLevelPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "lockLevel") it.uniroma2.art.semanticturkey.project.ProjectACL.LockLevel lockLevel)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException, it.uniroma2.art.semanticturkey.exceptions.ReservedPropertyUpdateException
	{
	
		String body;

		Projects fun = getService();
		fun.updateLockLevel(projectName, lockLevel);		
		body = ServletUtilities.getService().createReplyResponse("updateLockLevel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/cloneProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   cloneProjectPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "newProjectName") java.lang.String newProjectName)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.DuplicatedResourceException, java.io.IOException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		String body;

		Projects fun = getService();
		fun.cloneProject(projectName, newProjectName);		
		body = ServletUtilities.getService().createReplyResponse("cloneProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/deleteProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteProjectPublished(@RequestParam(value = "consumer") it.uniroma2.art.semanticturkey.project.ProjectConsumer consumer, @RequestParam(value = "projectName") java.lang.String projectName)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectDeletionException, java.io.IOException
	{
	
		String body;

		Projects fun = getService();
		fun.deleteProject(consumer, projectName);		
		body = ServletUtilities.getService().createReplyResponse("deleteProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/getProjectPropertyFileContent", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   getProjectPropertyFileContentPublished(@RequestParam(value = "projectName") java.lang.String projectName)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, java.io.IOException
	{
	
		
		Projects fun = getService();
		java.lang.String body = fun.getProjectPropertyFileContent(projectName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/disconnectFromProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   disconnectFromProjectPublished(@RequestParam(value = "consumer") it.uniroma2.art.semanticturkey.project.ProjectConsumer consumer, @RequestParam(value = "projectName") java.lang.String projectName) 
	{
	
		String body;

		Projects fun = getService();
		fun.disconnectFromProject(consumer, projectName);		
		body = ServletUtilities.getService().createReplyResponse("disconnectFromProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/repairProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   repairProjectPublished(@RequestParam(value = "projectName") java.lang.String projectName)  throws java.io.IOException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException
	{
	
		String body;

		Projects fun = getService();
		fun.repairProject(projectName);		
		body = ServletUtilities.getService().createReplyResponse("repairProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Projects/saveProjectPropertyFileContent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   saveProjectPropertyFileContentPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "content") java.lang.String content)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, java.io.IOException
	{
	
		String body;

		Projects fun = getService();
		fun.saveProjectPropertyFileContent(projectName, content);		
		body = ServletUtilities.getService().createReplyResponse("saveProjectPropertyFileContent", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}