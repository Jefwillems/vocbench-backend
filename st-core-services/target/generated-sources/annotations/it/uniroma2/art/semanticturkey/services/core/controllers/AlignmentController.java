package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Alignment;

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
public class AlignmentController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Alignment.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Alignment getService() {
		return context.getBean(Alignment.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/getMappingProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>>
>   getMappingPropertiesPublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource, @RequestParam(value = "allMappingProps", required=false, defaultValue="false") boolean allMappingProps)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException
	{
	
		
		Alignment fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>> body = fun.getMappingProperties(resource, allMappingProps);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/changeRelation", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   changeRelationPublished(@RequestParam(value = "entity1") org.eclipse.rdf4j.model.IRI entity1, @RequestParam(value = "entity2") org.eclipse.rdf4j.model.IRI entity2, @RequestParam(value = "relation") java.lang.String relation) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.changeRelation(entity1, entity2, relation);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/addAlignment", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addAlignmentPublished(@RequestParam(value = "sourceResource") org.eclipse.rdf4j.model.Resource sourceResource, @RequestParam(value = "predicate") org.eclipse.rdf4j.model.IRI predicate, @RequestParam(value = "targetResource") org.eclipse.rdf4j.model.IRI targetResource) 
	{
	
		String body;

		Alignment fun = getService();
		fun.addAlignment(sourceResource, predicate, targetResource);		
		body = ServletUtilities.getService().createReplyResponse("addAlignment", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/acceptAllAbove", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   acceptAllAbovePublished(@RequestParam(value = "threshold") float threshold) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.acceptAllAbove(threshold);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/applyValidation", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   applyValidationPublished(@RequestParam(value = "deleteRejected", required=false, defaultValue="false") boolean deleteRejected) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.applyValidation(deleteRejected);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/loadAlignment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   loadAlignmentPublished(@RequestParam(value = "inputFile") org.springframework.web.multipart.MultipartFile inputFile)  throws it.uniroma2.art.semanticturkey.alignment.AlignmentInitializationException, java.io.IOException
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.loadAlignment(inputFile);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/acceptAlignment", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   acceptAlignmentPublished(@RequestParam(value = "entity1") org.eclipse.rdf4j.model.IRI entity1, @RequestParam(value = "entity2") org.eclipse.rdf4j.model.IRI entity2, @RequestParam(value = "relation") java.lang.String relation, @RequestParam(value = "forcedProperty", required=false) org.eclipse.rdf4j.model.IRI forcedProperty, @RequestParam(value = "setAsDefault", required=false, defaultValue="false") boolean setAsDefault) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.acceptAlignment(entity1, entity2, relation, forcedProperty, setAsDefault);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/listCells", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listCellsPublished(@RequestParam(value = "pageIdx", required=false, defaultValue="0") int pageIdx, @RequestParam(value = "range", required=false, defaultValue="0") int range) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listCells(pageIdx, range);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/getSuggestedProperties", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>>
>   getSuggestedPropertiesPublished(@RequestParam(value = "entity") org.eclipse.rdf4j.model.IRI entity, @RequestParam(value = "relation") java.lang.String relation)  throws it.uniroma2.art.semanticturkey.alignment.InvalidAlignmentRelationException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException
	{
	
		
		Alignment fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>> body = fun.getSuggestedProperties(entity, relation);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/rejectAlignment", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   rejectAlignmentPublished(@RequestParam(value = "entity1") org.eclipse.rdf4j.model.IRI entity1, @RequestParam(value = "entity2") org.eclipse.rdf4j.model.IRI entity2, @RequestParam(value = "relation") java.lang.String relation) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.rejectAlignment(entity1, entity2, relation);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/acceptAllAlignment", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   acceptAllAlignmentPublished() 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.acceptAllAlignment();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/rejectAllUnder", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   rejectAllUnderPublished(@RequestParam(value = "threshold") float threshold) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.rejectAllUnder(threshold);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/rejectAllAlignment", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   rejectAllAlignmentPublished() 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.rejectAllAlignment();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/changeMappingProperty", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   changeMappingPropertyPublished(@RequestParam(value = "entity1") org.eclipse.rdf4j.model.IRI entity1, @RequestParam(value = "entity2") org.eclipse.rdf4j.model.IRI entity2, @RequestParam(value = "mappingProperty") org.eclipse.rdf4j.model.IRI mappingProperty) 
	{
	
		
		Alignment fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.changeMappingProperty(entity1, entity2, mappingProperty);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/closeSession", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   closeSessionPublished() 
	{
	
		String body;

		Alignment fun = getService();
		fun.closeSession();		
		body = ServletUtilities.getService().createReplyResponse("closeSession", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Alignment/exportAlignment", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  void   exportAlignmentPublished( javax.servlet.http.HttpServletResponse oRes)  throws java.io.IOException
	{
	
		Alignment fun = getService();
		fun.exportAlignment(oRes);
    }
}