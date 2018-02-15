package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Classes;

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
public class ClassesController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Classes.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Classes getService() {
		return context.getBean(Classes.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/addSuperCls", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addSuperClsPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "supercls") org.eclipse.rdf4j.model.IRI supercls) 
	{
	
		String body;

		Classes fun = getService();
		fun.addSuperCls(cls, supercls);		
		body = ServletUtilities.getService().createReplyResponse("addSuperCls", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/getInstances", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getInstancesPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls) 
	{
	
		
		Classes fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getInstances(cls);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/createInstance", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>
>   createInstancePublished(@RequestParam(value = "newInstance") org.eclipse.rdf4j.model.IRI newInstance, @RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "customFormValue", required=false) it.uniroma2.art.semanticturkey.customform.CustomFormValue customFormValue)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.exceptions.CODAException, it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		Classes fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI> body = fun.createInstance(newInstance, cls, customFormValue);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/addUnionOf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addUnionOfPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "clsDescriptions") java.util.List<java.lang.String> clsDescriptions)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException
	{
	
		String body;

		Classes fun = getService();
		fun.addUnionOf(cls, clsDescriptions);		
		body = ServletUtilities.getService().createReplyResponse("addUnionOf", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/removeIntersectionOf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeIntersectionOfPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "collectionBNode") org.eclipse.rdf4j.model.BNode collectionBNode)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException
	{
	
		String body;

		Classes fun = getService();
		fun.removeIntersectionOf(cls, collectionBNode);		
		body = ServletUtilities.getService().createReplyResponse("removeIntersectionOf", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/removeOneOf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeOneOfPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "collectionBNode") org.eclipse.rdf4j.model.BNode collectionBNode)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException
	{
	
		String body;

		Classes fun = getService();
		fun.removeOneOf(cls, collectionBNode);		
		body = ServletUtilities.getService().createReplyResponse("removeOneOf", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/removeUnionOf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeUnionOfPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "collectionBNode") org.eclipse.rdf4j.model.BNode collectionBNode)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException
	{
	
		String body;

		Classes fun = getService();
		fun.removeUnionOf(cls, collectionBNode);		
		body = ServletUtilities.getService().createReplyResponse("removeUnionOf", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/removeSuperCls", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeSuperClsPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "supercls") org.eclipse.rdf4j.model.IRI supercls) 
	{
	
		String body;

		Classes fun = getService();
		fun.removeSuperCls(cls, supercls);		
		body = ServletUtilities.getService().createReplyResponse("removeSuperCls", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/getClassesInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getClassesInfoPublished(@RequestParam(value = "classList") org.eclipse.rdf4j.model.IRI[] classList, @RequestParam(value = "numInst", required=false, defaultValue="true") boolean numInst) 
	{
	
		
		Classes fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getClassesInfo(classList, numInst);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/getSubClasses", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getSubClassesPublished(@RequestParam(value = "superClass") org.eclipse.rdf4j.model.IRI superClass, @RequestParam(value = "numInst", required=false, defaultValue="true") boolean numInst) 
	{
	
		
		Classes fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getSubClasses(superClass, numInst);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/addOneOf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addOneOfPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "individuals") java.util.List<org.eclipse.rdf4j.model.IRI> individuals)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException
	{
	
		String body;

		Classes fun = getService();
		fun.addOneOf(cls, individuals);		
		body = ServletUtilities.getService().createReplyResponse("addOneOf", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/addIntersectionOf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addIntersectionOfPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "clsDescriptions") java.util.List<java.lang.String> clsDescriptions)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException
	{
	
		String body;

		Classes fun = getService();
		fun.addIntersectionOf(cls, clsDescriptions);		
		body = ServletUtilities.getService().createReplyResponse("addIntersectionOf", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/deleteInstance", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteInstancePublished(@RequestParam(value = "instance") org.eclipse.rdf4j.model.IRI instance) 
	{
	
		String body;

		Classes fun = getService();
		fun.deleteInstance(instance);		
		body = ServletUtilities.getService().createReplyResponse("deleteInstance", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/deleteClass", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteClassPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		Classes fun = getService();
		fun.deleteClass(cls);		
		body = ServletUtilities.getService().createReplyResponse("deleteClass", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Classes/createClass", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>
>   createClassPublished(@RequestParam(value = "newClass") org.eclipse.rdf4j.model.IRI newClass, @RequestParam(value = "superClass") org.eclipse.rdf4j.model.IRI superClass, @RequestParam(value = "classType", required=false) org.eclipse.rdf4j.model.IRI classType, @RequestParam(value = "customFormValue", required=false) it.uniroma2.art.semanticturkey.customform.CustomFormValue customFormValue)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.exceptions.CODAException, it.uniroma2.art.semanticturkey.customform.CustomFormException
	{
	
		
		Classes fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI> body = fun.createClass(newClass, superClass, classType, customFormValue);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}