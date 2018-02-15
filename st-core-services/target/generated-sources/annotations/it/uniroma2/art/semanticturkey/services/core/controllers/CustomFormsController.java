package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.CustomForms;

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
public class CustomFormsController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(CustomForms.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public CustomForms getService() {
		return context.getBean(CustomForms.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getCustomFormConfigMap", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getCustomFormConfigMapPublished() 
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getCustomFormConfigMap();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/importCustomForm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   importCustomFormPublished(@RequestParam(value = "inputFile") org.springframework.web.multipart.MultipartFile inputFile, @RequestParam(value = "newId", required=false) java.lang.String newId)  throws java.io.IOException, it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.importCustomForm(inputFile, newId);		
		body = ServletUtilities.getService().createReplyResponse("importCustomForm", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getGraphObjectDescription", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Map<java.lang.String,it.uniroma2.art.semanticturkey.services.core.resourceview.ResourceViewSection>>
>   getGraphObjectDescriptionPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.Resource resource, @RequestParam(value = "predicate") org.eclipse.rdf4j.model.IRI predicate)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.coda.exception.RDFModelNotSetException, it.uniroma2.art.coda.exception.parserexception.PRParserException
	{
	
		
		CustomForms fun = getService();
		java.util.Map<java.lang.String,it.uniroma2.art.semanticturkey.services.core.resourceview.ResourceViewSection> body = fun.getGraphObjectDescription(resource, predicate);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/executeLiteralConverter", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   executeLiteralConverterPublished(@RequestParam(value = "converter") java.lang.String converter, @RequestParam(value = "value") java.lang.String value, @RequestParam(value = "datatype", required=false) java.lang.String datatype, @RequestParam(value = "lang", required=false) java.lang.String lang)  throws it.uniroma2.art.coda.provisioning.ComponentProvisioningException, it.uniroma2.art.coda.exception.ConverterException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.executeLiteralConverter(converter, value, datatype, lang);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/validatePearl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   validatePearlPublished(@RequestParam(value = "pearl") java.lang.String pearl, @RequestParam(value = "formType") java.lang.String formType)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.coda.exception.RDFModelNotSetException, it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.validatePearl(pearl, formType);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/updateCustomForm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateCustomFormPublished(@RequestParam(value = "id") java.lang.String id, @RequestParam(value = "name") java.lang.String name, @RequestParam(value = "description") java.lang.String description, @RequestParam(value = "ref") java.lang.String ref, @RequestParam(value = "showPropChain", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> showPropChain)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.updateCustomForm(id, name, description, ref, showPropChain);		
		body = ServletUtilities.getService().createReplyResponse("updateCustomForm", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getBrokenCustomForms", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getBrokenCustomFormsPublished() 
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getBrokenCustomForms();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/isFormLinkedToCollection", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   isFormLinkedToCollectionPublished(@RequestParam(value = "id") java.lang.String id) 
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.isFormLinkedToCollection(id);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/exportCustomForm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  void   exportCustomFormPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "id") java.lang.String id)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException, java.io.IOException
	{
	
		CustomForms fun = getService();
		fun.exportCustomForm(oRes, id);
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/createFormCollection", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   createFormCollectionPublished(@RequestParam(value = "id") java.lang.String id)  throws it.uniroma2.art.semanticturkey.customform.DuplicateIdException
	{
	
		String body;

		CustomForms fun = getService();
		fun.createFormCollection(id);		
		body = ServletUtilities.getService().createReplyResponse("createFormCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/exportFormCollection", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  void   exportFormCollectionPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "id") java.lang.String id)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException, java.io.IOException
	{
	
		CustomForms fun = getService();
		fun.exportFormCollection(oRes, id);
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/cloneCustomForm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   cloneCustomFormPublished(@RequestParam(value = "sourceId") java.lang.String sourceId, @RequestParam(value = "targetId") java.lang.String targetId)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.cloneCustomForm(sourceId, targetId);		
		body = ServletUtilities.getService().createReplyResponse("cloneCustomForm", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/updateFromCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateFromCollectionPublished(@RequestParam(value = "formCollectionId") java.lang.String formCollectionId, @RequestParam(value = "customFormIds") java.util.List<java.lang.String> customFormIds, @RequestParam(value = "suggestions") java.util.List<org.eclipse.rdf4j.model.IRI> suggestions)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.updateFromCollection(formCollectionId, customFormIds, suggestions);		
		body = ServletUtilities.getService().createReplyResponse("updateFromCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/executeURIConverter", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   executeURIConverterPublished(@RequestParam(value = "converter") java.lang.String converter, @RequestParam(value = "value", required=false) java.lang.String value)  throws it.uniroma2.art.coda.provisioning.ComponentProvisioningException, it.uniroma2.art.coda.exception.ConverterException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.executeURIConverter(converter, value);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getAllFormCollections", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getAllFormCollectionsPublished() 
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getAllFormCollections();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getCustomConstructors", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getCustomConstructorsPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getCustomConstructors(resource);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getCustomFormRepresentation", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getCustomFormRepresentationPublished(@RequestParam(value = "id") java.lang.String id)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.coda.exception.parserexception.PRParserException, it.uniroma2.art.coda.exception.RDFModelNotSetException, it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getCustomFormRepresentation(id);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/validateShowPropertyChain", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   validateShowPropertyChainPublished(@RequestParam(value = "propChain") java.lang.String propChain)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.validateShowPropertyChain(propChain);		
		body = ServletUtilities.getService().createReplyResponse("validateShowPropertyChain", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/deleteFormCollection", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteFormCollectionPublished(@RequestParam(value = "id") java.lang.String id)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.deleteFormCollection(id);		
		body = ServletUtilities.getService().createReplyResponse("deleteFormCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/deleteCustomForm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteCustomFormPublished(@RequestParam(value = "id") java.lang.String id, @RequestParam(value = "deleteEmptyColl", required=false, defaultValue="false") boolean deleteEmptyColl)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.deleteCustomForm(id, deleteEmptyColl);		
		body = ServletUtilities.getService().createReplyResponse("deleteCustomForm", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/removeReifiedResource", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeReifiedResourcePublished(@RequestParam(value = "subject") org.eclipse.rdf4j.model.IRI subject, @RequestParam(value = "predicate") org.eclipse.rdf4j.model.IRI predicate, @RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.coda.exception.parserexception.PRParserException, it.uniroma2.art.coda.exception.RDFModelNotSetException
	{
	
		String body;

		CustomForms fun = getService();
		fun.removeReifiedResource(subject, predicate, resource);		
		body = ServletUtilities.getService().createReplyResponse("removeReifiedResource", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getFormCollection", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getFormCollectionPublished(@RequestParam(value = "id") java.lang.String id)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getFormCollection(id);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/removeFormCollectionOfResource", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeFormCollectionOfResourcePublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.removeFormCollectionOfResource(resource);		
		body = ServletUtilities.getService().createReplyResponse("removeFormCollectionOfResource", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/cloneFormCollection", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   cloneFormCollectionPublished(@RequestParam(value = "sourceId") java.lang.String sourceId, @RequestParam(value = "targetId") java.lang.String targetId)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.cloneFormCollection(sourceId, targetId);		
		body = ServletUtilities.getService().createReplyResponse("cloneFormCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/createCustomForm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   createCustomFormPublished(@RequestParam(value = "type") java.lang.String type, @RequestParam(value = "id") java.lang.String id, @RequestParam(value = "name") java.lang.String name, @RequestParam(value = "description") java.lang.String description, @RequestParam(value = "ref") java.lang.String ref, @RequestParam(value = "showPropChain", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> showPropChain)  throws it.uniroma2.art.semanticturkey.customform.DuplicateIdException
	{
	
		String body;

		CustomForms fun = getService();
		fun.createCustomForm(type, id, name, description, ref, showPropChain);		
		body = ServletUtilities.getService().createReplyResponse("createCustomForm", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/addFormsMapping", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addFormsMappingPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource, @RequestParam(value = "formCollId") java.lang.String formCollId, @RequestParam(value = "replace", required=false, defaultValue="false") boolean replace)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.addFormsMapping(resource, formCollId, replace);		
		body = ServletUtilities.getService().createReplyResponse("addFormsMapping", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/importFormCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   importFormCollectionPublished(@RequestParam(value = "inputFile") org.springframework.web.multipart.MultipartFile inputFile, @RequestParam(value = "newId", required=false) java.lang.String newId)  throws java.io.IOException, it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.importFormCollection(inputFile, newId);		
		body = ServletUtilities.getService().createReplyResponse("importFormCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getCustomForm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getCustomFormPublished(@RequestParam(value = "id") java.lang.String id)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getCustomForm(id);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/updateReplace", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateReplacePublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource, @RequestParam(value = "replace") boolean replace)  throws it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		String body;

		CustomForms fun = getService();
		fun.updateReplace(resource, replace);		
		body = ServletUtilities.getService().createReplyResponse("updateReplace", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/CustomForms/getAllCustomForms", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getAllCustomFormsPublished() 
	{
	
		
		CustomForms fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getAllCustomForms();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}