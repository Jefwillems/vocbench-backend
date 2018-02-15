package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Collaboration;

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
public class CollaborationController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Collaboration.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Collaboration getService() {
		return context.getBean(Collaboration.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/activateCollaboratioOnProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   activateCollaboratioOnProjectPublished(@RequestParam(value = "backendId") java.lang.String backendId, @RequestParam(value = "projectSettings") java.util.Map<java.lang.String,java.lang.Object> projectSettings, @RequestParam(value = "currentUserPreferences") java.util.Map<java.lang.String,java.lang.Object> currentUserPreferences)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException, it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException, it.uniroma2.art.semanticturkey.exceptions.ReservedPropertyUpdateException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException
	{
	
		String body;

		Collaboration fun = getService();
		fun.activateCollaboratioOnProject(backendId, projectSettings, currentUserPreferences);		
		body = ServletUtilities.getService().createReplyResponse("activateCollaboratioOnProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/createIssue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   createIssuePublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource, @RequestParam(value = "summary") java.lang.String summary, @RequestParam(value = "description", required=false) java.lang.String description, @RequestParam(value = "assignee", required=false) java.lang.String assignee, @RequestParam(value = "issueId", required=false) java.lang.String issueId)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException
	{
	
		String body;

		Collaboration fun = getService();
		fun.createIssue(resource, summary, description, assignee, issueId);		
		body = ServletUtilities.getService().createReplyResponse("createIssue", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/getProjectSettings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.properties.STProperties>
>   getProjectSettingsPublished(@RequestParam(value = "backendId") java.lang.String backendId)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Collaboration fun = getService();
		it.uniroma2.art.semanticturkey.properties.STProperties body = fun.getProjectSettings(backendId);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/listIssuesAssignedToResource", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listIssuesAssignedToResourcePublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException
	{
	
		
		Collaboration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listIssuesAssignedToResource(resource);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/getProjectPreferences", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.properties.STProperties>
>   getProjectPreferencesPublished(@RequestParam(value = "backendId") java.lang.String backendId)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Collaboration fun = getService();
		it.uniroma2.art.semanticturkey.properties.STProperties body = fun.getProjectPreferences(backendId);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/createProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   createProjectPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "projectKey") java.lang.String projectKey)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, com.fasterxml.jackson.core.JsonProcessingException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		Collaboration fun = getService();
		fun.createProject(projectName, projectKey);		
		body = ServletUtilities.getService().createReplyResponse("createProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/listProjects", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listProjectsPublished()  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException
	{
	
		
		Collaboration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listProjects();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/assignProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   assignProjectPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "projectKey") java.lang.String projectKey, @RequestParam(value = "projectId") java.lang.String projectId)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		Collaboration fun = getService();
		fun.assignProject(projectName, projectKey, projectId);		
		body = ServletUtilities.getService().createReplyResponse("assignProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/assignResourceToIssue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   assignResourceToIssuePublished(@RequestParam(value = "issue") java.lang.String issue, @RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException
	{
	
		String body;

		Collaboration fun = getService();
		fun.assignResourceToIssue(issue, resource);		
		body = ServletUtilities.getService().createReplyResponse("assignResourceToIssue", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/getCollaborationSystemStatus", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getCollaborationSystemStatusPublished(@RequestParam(value = "backendId") java.lang.String backendId)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Collaboration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getCollaborationSystemStatus(backendId);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/addPreferenceiesForCurrentUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addPreferenceiesForCurrentUserPublished(@RequestParam(value = "backendId") java.lang.String backendId, @RequestParam(value = "currentUserPreferences") java.util.Map<java.lang.String,java.lang.Object> currentUserPreferences)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException, it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException, it.uniroma2.art.semanticturkey.exceptions.ReservedPropertyUpdateException
	{
	
		String body;

		Collaboration fun = getService();
		fun.addPreferenceiesForCurrentUser(backendId, currentUserPreferences);		
		body = ServletUtilities.getService().createReplyResponse("addPreferenceiesForCurrentUser", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/listUsers", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listUsersPublished()  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException
	{
	
		
		Collaboration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listUsers();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Collaboration/listIssues", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listIssuesPublished()  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, java.io.IOException, it.uniroma2.art.semanticturkey.extension.extpts.collaboration.CollaborationBackendException
	{
	
		
		Collaboration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listIssues();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}