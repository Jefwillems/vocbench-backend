package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Properties;

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
public class PropertiesController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Properties.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Properties getService() {
		return context.getBean(Properties.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getTopProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getTopPropertiesPublished() 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getTopProperties();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getTopRDFProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getTopRDFPropertiesPublished() 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getTopRDFProperties();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/removePropertyRange", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removePropertyRangePublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "range") org.eclipse.rdf4j.model.Resource range) 
	{
	
		String body;

		Properties fun = getService();
		fun.removePropertyRange(property, range);		
		body = ServletUtilities.getService().createReplyResponse("removePropertyRange", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getSubProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getSubPropertiesPublished(@RequestParam(value = "superProperty") org.eclipse.rdf4j.model.Resource superProperty) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getSubProperties(superProperty);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getRelevantPropertiesForClass", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getRelevantPropertiesForClassPublished(@RequestParam(value = "classUri") org.eclipse.rdf4j.model.Resource classUri) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getRelevantPropertiesForClass(classUri);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/addPropertyDomain", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addPropertyDomainPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "domain") org.eclipse.rdf4j.model.Resource domain) 
	{
	
		String body;

		Properties fun = getService();
		fun.addPropertyDomain(property, domain);		
		body = ServletUtilities.getService().createReplyResponse("addPropertyDomain", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/removeDataranges", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeDatarangesPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "datarange") org.eclipse.rdf4j.model.BNode datarange) 
	{
	
		String body;

		Properties fun = getService();
		fun.removeDataranges(property, datarange);		
		body = ServletUtilities.getService().createReplyResponse("removeDataranges", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/removeValueFromDatarange", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeValueFromDatarangePublished(@RequestParam(value = "datarange") org.eclipse.rdf4j.model.Resource datarange, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		String body;

		Properties fun = getService();
		fun.removeValueFromDatarange(datarange, literal);		
		body = ServletUtilities.getService().createReplyResponse("removeValueFromDatarange", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/deleteProperty", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deletePropertyPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		Properties fun = getService();
		fun.deleteProperty(property);		
		body = ServletUtilities.getService().createReplyResponse("deleteProperty", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getRange", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   getRangePublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property) 
	{
	
		
		Properties fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.getRange(property);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getRelevantRangeClasses", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getRelevantRangeClassesPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.Resource property) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getRelevantRangeClasses(property);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/updateDataranges", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateDatarangesPublished(@RequestParam(value = "datarange") org.eclipse.rdf4j.model.BNode datarange, @RequestParam(value = "literals") java.util.List<org.eclipse.rdf4j.model.Literal> literals) 
	{
	
		String body;

		Properties fun = getService();
		fun.updateDataranges(datarange, literals);		
		body = ServletUtilities.getService().createReplyResponse("updateDataranges", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getTopOntologyProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getTopOntologyPropertiesPublished() 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getTopOntologyProperties();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getDatarangeLiterals", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Literal>>>
>   getDatarangeLiteralsPublished(@RequestParam(value = "datarange") org.eclipse.rdf4j.model.BNode datarange) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Literal>> body = fun.getDatarangeLiterals(datarange);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getTopObjectProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getTopObjectPropertiesPublished() 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getTopObjectProperties();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/removePropertyDomain", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removePropertyDomainPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "domain") org.eclipse.rdf4j.model.Resource domain) 
	{
	
		String body;

		Properties fun = getService();
		fun.removePropertyDomain(property, domain);		
		body = ServletUtilities.getService().createReplyResponse("removePropertyDomain", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getTopAnnotationProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getTopAnnotationPropertiesPublished() 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getTopAnnotationProperties();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/setDataRange", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setDataRangePublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "predicate", required=false) org.eclipse.rdf4j.model.IRI predicate, @RequestParam(value = "literals") java.util.List<org.eclipse.rdf4j.model.Literal> literals) 
	{
	
		String body;

		Properties fun = getService();
		fun.setDataRange(property, predicate, literals);		
		body = ServletUtilities.getService().createReplyResponse("setDataRange", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/addValueToDatarange", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addValueToDatarangePublished(@RequestParam(value = "datarange") org.eclipse.rdf4j.model.Resource datarange, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		String body;

		Properties fun = getService();
		fun.addValueToDatarange(datarange, literal);		
		body = ServletUtilities.getService().createReplyResponse("addValueToDatarange", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getRelevantDomainClasses", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getRelevantDomainClassesPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.Resource property) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getRelevantDomainClasses(property);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/removeSuperProperty", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeSuperPropertyPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "superProperty") org.eclipse.rdf4j.model.IRI superProperty) 
	{
	
		String body;

		Properties fun = getService();
		fun.removeSuperProperty(property, superProperty);		
		body = ServletUtilities.getService().createReplyResponse("removeSuperProperty", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getSuperProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getSuperPropertiesPublished(@RequestParam(value = "subProperty") org.eclipse.rdf4j.model.Resource subProperty) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getSuperProperties(subProperty);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/createProperty", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>
>   createPropertyPublished(@RequestParam(value = "propertyType") org.eclipse.rdf4j.model.IRI propertyType, @RequestParam(value = "newProperty") org.eclipse.rdf4j.model.IRI newProperty, @RequestParam(value = "superProperty", required=false) org.eclipse.rdf4j.model.IRI superProperty, @RequestParam(value = "customFormValue", required=false) it.uniroma2.art.semanticturkey.customform.CustomFormValue customFormValue)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.exceptions.CODAException, it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		Properties fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI> body = fun.createProperty(propertyType, newProperty, superProperty, customFormValue);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/addValuesToDatarange", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addValuesToDatarangePublished(@RequestParam(value = "datarange") org.eclipse.rdf4j.model.Resource datarange, @RequestParam(value = "literals") java.util.List<org.eclipse.rdf4j.model.Literal> literals) 
	{
	
		String body;

		Properties fun = getService();
		fun.addValuesToDatarange(datarange, literals);		
		body = ServletUtilities.getService().createReplyResponse("addValuesToDatarange", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/hasValueInDatarange", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.Boolean>
>   hasValueInDatarangePublished(@RequestParam(value = "datarange") org.eclipse.rdf4j.model.Resource datarange, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		
		Properties fun = getService();
		java.lang.Boolean body = fun.hasValueInDatarange(datarange, literal);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getTopDatatypeProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getTopDatatypePropertiesPublished() 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getTopDatatypeProperties();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/addSuperProperty", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addSuperPropertyPublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "superProperty") org.eclipse.rdf4j.model.IRI superProperty) 
	{
	
		String body;

		Properties fun = getService();
		fun.addSuperProperty(property, superProperty);		
		body = ServletUtilities.getService().createReplyResponse("addSuperProperty", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/addPropertyRange", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addPropertyRangePublished(@RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property, @RequestParam(value = "range") org.eclipse.rdf4j.model.Resource range) 
	{
	
		String body;

		Properties fun = getService();
		fun.addPropertyRange(property, range);		
		body = ServletUtilities.getService().createReplyResponse("addPropertyRange", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getRelevantPropertiesForResource", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getRelevantPropertiesForResourcePublished(@RequestParam(value = "res") org.eclipse.rdf4j.model.Resource res) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getRelevantPropertiesForResource(res);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Properties/getPropertiesInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getPropertiesInfoPublished(@RequestParam(value = "propList") org.eclipse.rdf4j.model.IRI[] propList) 
	{
	
		
		Properties fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getPropertiesInfo(propList);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}