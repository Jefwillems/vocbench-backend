package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Users;

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
public class UsersController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Users.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Users getService() {
		return context.getBean(Users.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/resetPassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   resetPasswordPublished( javax.servlet.http.HttpServletRequest request, @RequestParam(value = "email") java.lang.String email, @RequestParam(value = "token") java.lang.String token)  throws java.lang.Exception
	{
	
		String body;

		Users fun = getService();
		fun.resetPassword(request, email, token);		
		body = ServletUtilities.getService().createReplyResponse("resetPassword", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserAvatarUrl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserAvatarUrlPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "avatarUrl", required=false) java.lang.String avatarUrl)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserAvatarUrl(email, avatarUrl);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserPhone", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserPhonePublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "phone", required=false) java.lang.String phone)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserPhone(email, phone);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserLanguageProficiencies", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserLanguageProficienciesPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "languageProficiencies") java.util.Collection<java.lang.String> languageProficiencies)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserLanguageProficiencies(email, languageProficiencies);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/getUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getUserPublished() 
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getUser();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserGender", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserGenderPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "gender", required=false) java.lang.String gender)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserGender(email, gender);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserCountry", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserCountryPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "country") java.lang.String country)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserCountry(email, country);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserGivenName", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserGivenNamePublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "givenName") java.lang.String givenName)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserGivenName(email, givenName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserAddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserAddressPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "address", required=false) java.lang.String address)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserAddress(email, address);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserUrl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserUrlPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "url", required=false) java.lang.String url)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserUrl(email, url);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserEmail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserEmailPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "newEmail") java.lang.String newEmail)  throws it.uniroma2.art.semanticturkey.user.UserException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserEmail(email, newEmail);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/forgotPassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   forgotPasswordPublished( javax.servlet.http.HttpServletRequest request, @RequestParam(value = "email") java.lang.String email, @RequestParam(value = "vbHostAddress") java.lang.String vbHostAddress)  throws java.lang.Exception
	{
	
		String body;

		Users fun = getService();
		fun.forgotPassword(request, email, vbHostAddress);		
		body = ServletUtilities.getService().createReplyResponse("forgotPassword", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/listUsersBoundToProject", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listUsersBoundToProjectPublished(@RequestParam(value = "projectName") java.lang.String projectName)  throws it.uniroma2.art.semanticturkey.exceptions.InvalidProjectNameException, it.uniroma2.art.semanticturkey.exceptions.ProjectInexistentException, it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listUsersBoundToProject(projectName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserAffiliation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserAffiliationPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "affiliation", required=false) java.lang.String affiliation)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserAffiliation(email, affiliation);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/listUsers", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listUsersPublished() 
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listUsers();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/enableUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   enableUserPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "enabled") boolean enabled)  throws it.uniroma2.art.semanticturkey.user.UserException, it.uniroma2.art.semanticturkey.user.PUBindingException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.enableUser(email, enabled);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/registerUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   registerUserPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "password") java.lang.String password, @RequestParam(value = "givenName") java.lang.String givenName, @RequestParam(value = "familyName") java.lang.String familyName, @RequestParam(value = "iri", required=false) org.eclipse.rdf4j.model.IRI iri, @RequestParam(value = "birthday", required=false) java.lang.String birthday, @RequestParam(value = "gender", required=false) java.lang.String gender, @RequestParam(value = "country", required=false) java.lang.String country, @RequestParam(value = "address", required=false) java.lang.String address, @RequestParam(value = "affiliation", required=false) java.lang.String affiliation, @RequestParam(value = "url", required=false) java.lang.String url, @RequestParam(value = "avatarUrl", required=false) java.lang.String avatarUrl, @RequestParam(value = "phone", required=false) java.lang.String phone, @RequestParam(value = "languageProficiencies", required=false) java.util.Collection<java.lang.String> languageProficiencies)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException, it.uniroma2.art.semanticturkey.user.UserException, java.text.ParseException, it.uniroma2.art.semanticturkey.user.PUBindingException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		Users fun = getService();
		fun.registerUser(email, password, givenName, familyName, iri, birthday, gender, country, address, affiliation, url, avatarUrl, phone, languageProficiencies);		
		body = ServletUtilities.getService().createReplyResponse("registerUser", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/deleteUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteUserPublished(@RequestParam(value = "email") java.lang.String email)  throws java.lang.Exception
	{
	
		String body;

		Users fun = getService();
		fun.deleteUser(email);		
		body = ServletUtilities.getService().createReplyResponse("deleteUser", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/listUserCapabilities", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listUserCapabilitiesPublished()  throws alice.tuprolog.MalformedGoalException, alice.tuprolog.NoSolutionException, alice.tuprolog.NoMoreSolutionException, it.uniroma2.art.semanticturkey.rbac.RBACException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listUserCapabilities();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserFamilyName", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserFamilyNamePublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "familyName") java.lang.String familyName)  throws it.uniroma2.art.semanticturkey.user.UserException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserFamilyName(email, familyName);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Users/updateUserBirthday", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.node.ObjectNode>
>   updateUserBirthdayPublished(@RequestParam(value = "email") java.lang.String email, @RequestParam(value = "birthday") java.lang.String birthday)  throws it.uniroma2.art.semanticturkey.user.UserException, java.text.ParseException
	{
	
		
		Users fun = getService();
		com.fasterxml.jackson.databind.node.ObjectNode body = fun.updateUserBirthday(email, birthday);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}