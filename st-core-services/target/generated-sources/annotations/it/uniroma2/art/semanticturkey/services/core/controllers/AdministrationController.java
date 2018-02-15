package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Administration;

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
public class AdministrationController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Administration.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Administration getService() {
		return context.getBean(Administration.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/updateCapabilityForRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateCapabilityForRolePublished(@RequestParam(value = "role") java.lang.String role, @RequestParam(value = "oldCapability") java.lang.String oldCapability, @RequestParam(value = "newCapability") java.lang.String newCapability)  throws it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		String body;

		Administration fun = getService();
		fun.updateCapabilityForRole(role, oldCapability, newCapability);		
		body = ServletUtilities.getService().createReplyResponse("updateCapabilityForRole", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/getAdministrationConfig", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getAdministrationConfigPublished()  throws org.json.JSONException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Administration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getAdministrationConfig();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/getProjectUserBinding", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getProjectUserBindingPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "email") java.lang.String email)  throws it.uniroma2.art.semanticturkey.user.PUBindingException, org.json.JSONException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Administration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getProjectUserBinding(projectName, email);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/cloneRole", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   cloneRolePublished(@RequestParam(value = "sourceRoleName") java.lang.String sourceRoleName, @RequestParam(value = "targetRoleName") java.lang.String targetRoleName)  throws it.uniroma2.art.semanticturkey.user.RoleCreationException, it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		String body;

		Administration fun = getService();
		fun.cloneRole(sourceRoleName, targetRoleName);		
		body = ServletUtilities.getService().createReplyResponse("cloneRole", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/updateLanguagesOfUserInProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateLanguagesOfUserInProjectPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "email") java.lang.String email, @RequestParam(value = "languages") java.util.Collection<java.lang.String> languages)  throws it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		String body;

		Administration fun = getService();
		fun.updateLanguagesOfUserInProject(projectName, email, languages);		
		body = ServletUtilities.getService().createReplyResponse("updateLanguagesOfUserInProject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/createRole", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   createRolePublished(@RequestParam(value = "roleName") java.lang.String roleName)  throws it.uniroma2.art.semanticturkey.user.RoleCreationException
	{
	
		String body;

		Administration fun = getService();
		fun.createRole(roleName);		
		body = ServletUtilities.getService().createReplyResponse("createRole", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/removeAllRolesFromUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeAllRolesFromUserPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "email") java.lang.String email)  throws it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		String body;

		Administration fun = getService();
		fun.removeAllRolesFromUser(projectName, email);		
		body = ServletUtilities.getService().createReplyResponse("removeAllRolesFromUser", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/deleteRole", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteRolePublished(@RequestParam(value = "roleName") java.lang.String roleName)  throws it.uniroma2.art.semanticturkey.user.PUBindingException
	{
	
		String body;

		Administration fun = getService();
		fun.deleteRole(roleName);		
		body = ServletUtilities.getService().createReplyResponse("deleteRole", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/listRoles", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listRolesPublished(@RequestParam(value = "projectName", required=false) java.lang.String projectName)  throws org.json.JSONException, it.uniroma2.art.semanticturkey.rbac.RBACException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		Administration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listRoles(projectName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/updateAdministrationConfig", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateAdministrationConfigPublished(@RequestParam(value = "emailAdminAddress") java.lang.String emailAdminAddress, @RequestParam(value = "emailFromAddress") java.lang.String emailFromAddress, @RequestParam(value = "emailFromPassword") java.lang.String emailFromPassword, @RequestParam(value = "emailFromAlias") java.lang.String emailFromAlias, @RequestParam(value = "emailFromHost") java.lang.String emailFromHost, @RequestParam(value = "emailFromPort") java.lang.String emailFromPort)  throws it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		Administration fun = getService();
		fun.updateAdministrationConfig(emailAdminAddress, emailFromAddress, emailFromPassword, emailFromAlias, emailFromHost, emailFromPort);		
		body = ServletUtilities.getService().createReplyResponse("updateAdministrationConfig", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/addRolesToUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addRolesToUserPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "email") java.lang.String email, @RequestParam(value = "roles") java.lang.String[] roles)  throws it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		String body;

		Administration fun = getService();
		fun.addRolesToUser(projectName, email, roles);		
		body = ServletUtilities.getService().createReplyResponse("addRolesToUser", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/removeRoleFromUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeRoleFromUserPublished(@RequestParam(value = "projectName") java.lang.String projectName, @RequestParam(value = "email") java.lang.String email, @RequestParam(value = "role") java.lang.String role)  throws it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		String body;

		Administration fun = getService();
		fun.removeRoleFromUser(projectName, email, role);		
		body = ServletUtilities.getService().createReplyResponse("removeRoleFromUser", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/importRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   importRolePublished(@RequestParam(value = "inputFile") org.springframework.web.multipart.MultipartFile inputFile, @RequestParam(value = "newRoleName") java.lang.String newRoleName)  throws java.io.IOException, it.uniroma2.art.semanticturkey.customform.CustomFormException, it.uniroma2.art.semanticturkey.rbac.RBACException, it.uniroma2.art.semanticturkey.user.RoleCreationException
	{
	
		String body;

		Administration fun = getService();
		fun.importRole(inputFile, newRoleName);		
		body = ServletUtilities.getService().createReplyResponse("importRole", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/removeCapabilityFromRole", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeCapabilityFromRolePublished(@RequestParam(value = "role") java.lang.String role, @RequestParam(value = "capability") java.lang.String capability)  throws it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		String body;

		Administration fun = getService();
		fun.removeCapabilityFromRole(role, capability);		
		body = ServletUtilities.getService().createReplyResponse("removeCapabilityFromRole", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/listCapabilities", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listCapabilitiesPublished(@RequestParam(value = "projectName", required=false) java.lang.String projectName, @RequestParam(value = "role") java.lang.String role)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		
		Administration fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listCapabilities(projectName, role);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/exportRole", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  void   exportRolePublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "roleName") java.lang.String roleName)  throws it.uniroma2.art.semanticturkey.rbac.RBACException, java.io.IOException
	{
	
		Administration fun = getService();
		fun.exportRole(oRes, roleName);
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Administration/addCapabilityToRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addCapabilityToRolePublished(@RequestParam(value = "role") java.lang.String role, @RequestParam(value = "capability") java.lang.String capability)  throws it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		String body;

		Administration fun = getService();
		fun.addCapabilityToRole(role, capability);		
		body = ServletUtilities.getService().createReplyResponse("addCapabilityToRole", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}