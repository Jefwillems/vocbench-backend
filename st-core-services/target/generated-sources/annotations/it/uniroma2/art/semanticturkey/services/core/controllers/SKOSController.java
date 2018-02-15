package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.SKOS;

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
public class SKOSController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(SKOS.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public SKOS getService() {
		return context.getBean(SKOS.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getNarrowerConcepts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getNarrowerConceptsPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.Resource concept, @RequestParam(value = "schemes", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemes) 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getNarrowerConcepts(concept, schemes);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getBroaderConcepts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getBroaderConceptsPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.Resource concept, @RequestParam(value = "schemes", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemes) 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getBroaderConcepts(concept, schemes);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addFirstToOrderedCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addFirstToOrderedCollectionPublished(@RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection, @RequestParam(value = "element") org.eclipse.rdf4j.model.Resource element)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.addFirstToOrderedCollection(collection, element);		
		body = ServletUtilities.getService().createReplyResponse("addFirstToOrderedCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addTopConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addTopConceptPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		SKOS fun = getService();
		fun.addTopConcept(concept, scheme);		
		body = ServletUtilities.getService().createReplyResponse("addTopConcept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removeFromCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeFromCollectionPublished(@RequestParam(value = "element") org.eclipse.rdf4j.model.Resource element, @RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.removeFromCollection(element, collection);		
		body = ServletUtilities.getService().createReplyResponse("removeFromCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removeFromOrderedCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeFromOrderedCollectionPublished(@RequestParam(value = "element") org.eclipse.rdf4j.model.Resource element, @RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.removeFromOrderedCollection(element, collection);		
		body = ServletUtilities.getService().createReplyResponse("removeFromOrderedCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/isSchemeEmpty", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.Boolean>
>   isSchemeEmptyPublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		
		SKOS fun = getService();
		java.lang.Boolean body = fun.isSchemeEmpty(scheme);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/deleteConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteConceptPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.deleteConcept(concept);		
		body = ServletUtilities.getService().createReplyResponse("deleteConcept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removeHiddenLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeHiddenLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		String body;

		SKOS fun = getService();
		fun.removeHiddenLabel(concept, literal);		
		body = ServletUtilities.getService().createReplyResponse("removeHiddenLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getTopConcepts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getTopConceptsPublished(@RequestParam(value = "schemes", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemes) 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getTopConcepts(schemes);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/failingReadServiceContainingUpdate", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   failingReadServiceContainingUpdatePublished() 
	{
	
		String body;

		SKOS fun = getService();
		fun.failingReadServiceContainingUpdate();		
		body = ServletUtilities.getService().createReplyResponse("failingReadServiceContainingUpdate", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addToCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addToCollectionPublished(@RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection, @RequestParam(value = "element") org.eclipse.rdf4j.model.Resource element)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.addToCollection(collection, element);		
		body = ServletUtilities.getService().createReplyResponse("addToCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removeConceptFromScheme", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeConceptFromSchemePublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		SKOS fun = getService();
		fun.removeConceptFromScheme(concept, scheme);		
		body = ServletUtilities.getService().createReplyResponse("removeConceptFromScheme", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addLastToOrderedCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addLastToOrderedCollectionPublished(@RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection, @RequestParam(value = "element") org.eclipse.rdf4j.model.Resource element)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.addLastToOrderedCollection(collection, element);		
		body = ServletUtilities.getService().createReplyResponse("addLastToOrderedCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removeAltLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeAltLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		String body;

		SKOS fun = getService();
		fun.removeAltLabel(concept, literal);		
		body = ServletUtilities.getService().createReplyResponse("removeAltLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/createConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>
>   createConceptPublished(@RequestParam(value = "newConcept", required=false) org.eclipse.rdf4j.model.IRI newConcept, @RequestParam(value = "label", required=false) org.eclipse.rdf4j.model.Literal label, @RequestParam(value = "broaderConcept", required=false) org.eclipse.rdf4j.model.Resource broaderConcept, @RequestParam(value = "conceptSchemes") java.util.List<org.eclipse.rdf4j.model.IRI> conceptSchemes, @RequestParam(value = "conceptCls", required=false) org.eclipse.rdf4j.model.IRI conceptCls, @RequestParam(value = "customFormValue", required=false) it.uniroma2.art.semanticturkey.customform.CustomFormValue customFormValue, @RequestParam(value = "checkExistingAltLabel", required=false, defaultValue="true") boolean checkExistingAltLabel)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.customform.CustomFormException, it.uniroma2.art.semanticturkey.exceptions.CODAException, it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException, it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException, it.uniroma2.art.semanticturkey.exceptions.PrefAltLabelClashException
	{
	
		
		SKOS fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI> body = fun.createConcept(newConcept, label, broaderConcept, conceptSchemes, conceptCls, customFormValue, checkExistingAltLabel);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addBroaderConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addBroaderConceptPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "broaderConcept") org.eclipse.rdf4j.model.IRI broaderConcept) 
	{
	
		String body;

		SKOS fun = getService();
		fun.addBroaderConcept(concept, broaderConcept);		
		body = ServletUtilities.getService().createReplyResponse("addBroaderConcept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/deleteConceptScheme", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteConceptSchemePublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		SKOS fun = getService();
		fun.deleteConceptScheme(scheme);		
		body = ServletUtilities.getService().createReplyResponse("deleteConceptScheme", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addAltLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addAltLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal)  throws it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException
	{
	
		String body;

		SKOS fun = getService();
		fun.addAltLabel(concept, literal);		
		body = ServletUtilities.getService().createReplyResponse("addAltLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addInPositionToOrderedCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addInPositionToOrderedCollectionPublished(@RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection, @RequestParam(value = "element") org.eclipse.rdf4j.model.Resource element, @RequestParam(value = "index") int index)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.addInPositionToOrderedCollection(collection, element, index);		
		body = ServletUtilities.getService().createReplyResponse("addInPositionToOrderedCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removeTopConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeTopConceptPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		SKOS fun = getService();
		fun.removeTopConcept(concept, scheme);		
		body = ServletUtilities.getService().createReplyResponse("removeTopConcept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getNestedCollections", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getNestedCollectionsPublished(@RequestParam(value = "container") org.eclipse.rdf4j.model.Resource container) 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getNestedCollections(container);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/deleteCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteCollectionPublished(@RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.deleteCollection(collection);		
		body = ServletUtilities.getService().createReplyResponse("deleteCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getRootCollections", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getRootCollectionsPublished() 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getRootCollections();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/deleteOrderedCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteOrderedCollectionPublished(@RequestParam(value = "collection") org.eclipse.rdf4j.model.Resource collection)  throws it.uniroma2.art.semanticturkey.exceptions.DeniedOperationException
	{
	
		String body;

		SKOS fun = getService();
		fun.deleteOrderedCollection(collection);		
		body = ServletUtilities.getService().createReplyResponse("deleteOrderedCollection", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addConceptToScheme", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addConceptToSchemePublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		SKOS fun = getService();
		fun.addConceptToScheme(concept, scheme);		
		body = ServletUtilities.getService().createReplyResponse("addConceptToScheme", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addHiddenLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addHiddenLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		String body;

		SKOS fun = getService();
		fun.addHiddenLabel(concept, literal);		
		body = ServletUtilities.getService().createReplyResponse("addHiddenLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getAltLabels", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Literal>>>
>   getAltLabelsPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "language") java.lang.String language) 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Literal>> body = fun.getAltLabels(concept, language);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removeBroaderConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeBroaderConceptPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "broaderConcept") org.eclipse.rdf4j.model.IRI broaderConcept) 
	{
	
		String body;

		SKOS fun = getService();
		fun.removeBroaderConcept(concept, broaderConcept);		
		body = ServletUtilities.getService().createReplyResponse("removeBroaderConcept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getAllSchemes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getAllSchemesPublished() 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getAllSchemes();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/addNote", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addNotePublished(@RequestParam(value = "resource") org.eclipse.rdf4j.model.IRI resource, @RequestParam(value = "predicate", required=false) org.eclipse.rdf4j.model.IRI predicate, @RequestParam(value = "value") it.uniroma2.art.semanticturkey.customform.SpecialValue value)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.exceptions.CODAException
	{
	
		String body;

		SKOS fun = getService();
		fun.addNote(resource, predicate, value);		
		body = ServletUtilities.getService().createReplyResponse("addNote", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/getSchemesMatrixPerConcept", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getSchemesMatrixPerConceptPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.Resource concept) 
	{
	
		
		SKOS fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getSchemesMatrixPerConcept(concept);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/setPrefLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setPrefLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal, @RequestParam(value = "checkExistingAltLabel", required=false, defaultValue="true") boolean checkExistingAltLabel)  throws it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException, it.uniroma2.art.semanticturkey.exceptions.PrefAltLabelClashException
	{
	
		String body;

		SKOS fun = getService();
		fun.setPrefLabel(concept, literal, checkExistingAltLabel);		
		body = ServletUtilities.getService().createReplyResponse("setPrefLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/createConceptScheme", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>
>   createConceptSchemePublished(@RequestParam(value = "newScheme", required=false) org.eclipse.rdf4j.model.IRI newScheme, @RequestParam(value = "label", required=false) org.eclipse.rdf4j.model.Literal label, @RequestParam(value = "schemeCls", required=false) org.eclipse.rdf4j.model.IRI schemeCls, @RequestParam(value = "customFormValue", required=false) it.uniroma2.art.semanticturkey.customform.CustomFormValue customFormValue, @RequestParam(value = "checkExistingAltLabel", required=false, defaultValue="true") boolean checkExistingAltLabel)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.customform.CustomFormException, it.uniroma2.art.semanticturkey.exceptions.CODAException, it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException, it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException, it.uniroma2.art.semanticturkey.exceptions.PrefAltLabelClashException
	{
	
		
		SKOS fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI> body = fun.createConceptScheme(newScheme, label, schemeCls, customFormValue, checkExistingAltLabel);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/removePrefLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removePrefLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		String body;

		SKOS fun = getService();
		fun.removePrefLabel(concept, literal);		
		body = ServletUtilities.getService().createReplyResponse("removePrefLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOS/createCollection", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>
>   createCollectionPublished(@RequestParam(value = "collectionType") org.eclipse.rdf4j.model.IRI collectionType, @RequestParam(value = "newCollection", required=false) org.eclipse.rdf4j.model.IRI newCollection, @RequestParam(value = "label", required=false) org.eclipse.rdf4j.model.Literal label, @RequestParam(value = "containingCollection", required=false) org.eclipse.rdf4j.model.IRI containingCollection, @RequestParam(value = "collectionCls", required=false) org.eclipse.rdf4j.model.IRI collectionCls, @RequestParam(value = "bnodeCreationMode", required=false, defaultValue="false") boolean bnodeCreationMode, @RequestParam(value = "customFormValue", required=false) it.uniroma2.art.semanticturkey.customform.CustomFormValue customFormValue, @RequestParam(value = "checkExistingAltLabel", required=false, defaultValue="true") boolean checkExistingAltLabel)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.customform.CustomFormException, it.uniroma2.art.semanticturkey.exceptions.CODAException, java.lang.IllegalAccessException, it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException, it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException, it.uniroma2.art.semanticturkey.exceptions.PrefAltLabelClashException
	{
	
		
		SKOS fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource> body = fun.createCollection(collectionType, newCollection, label, containingCollection, collectionCls, bnodeCreationMode, customFormValue, checkExistingAltLabel);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}