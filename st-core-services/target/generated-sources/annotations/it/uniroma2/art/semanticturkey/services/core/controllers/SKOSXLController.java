package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.SKOSXL;

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
public class SKOSXLController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(SKOSXL.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public SKOSXL getService() {
		return context.getBean(SKOSXL.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/getAltLabels", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getAltLabelsPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "lang", required=false, defaultValue="*") java.lang.String lang) 
	{
	
		
		SKOSXL fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getAltLabels(concept, lang);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/addAltLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addAltLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal, @RequestParam(value = "mode") it.uniroma2.art.semanticturkey.services.core.SKOSXL.XLabelCreationMode mode)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException, it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException
	{
	
		String body;

		SKOSXL fun = getService();
		fun.addAltLabel(concept, literal, mode);		
		body = ServletUtilities.getService().createReplyResponse("addAltLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/altToPrefLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   altToPrefLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "xlabel") org.eclipse.rdf4j.model.Resource xlabel) 
	{
	
		String body;

		SKOSXL fun = getService();
		fun.altToPrefLabel(concept, xlabel);		
		body = ServletUtilities.getService().createReplyResponse("altToPrefLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/removeAltLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeAltLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "xlabel") org.eclipse.rdf4j.model.Resource xlabel) 
	{
	
		String body;

		SKOSXL fun = getService();
		fun.removeAltLabel(concept, xlabel);		
		body = ServletUtilities.getService().createReplyResponse("removeAltLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/setPrefLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setPrefLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal, @RequestParam(value = "mode") it.uniroma2.art.semanticturkey.services.core.SKOSXL.XLabelCreationMode mode, @RequestParam(value = "checkExistingAltLabel", required=false, defaultValue="true") boolean checkExistingAltLabel)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException, it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException, it.uniroma2.art.semanticturkey.exceptions.PrefAltLabelClashException
	{
	
		String body;

		SKOSXL fun = getService();
		fun.setPrefLabel(concept, literal, mode, checkExistingAltLabel);		
		body = ServletUtilities.getService().createReplyResponse("setPrefLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/prefToAtlLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   prefToAtlLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "xlabel") org.eclipse.rdf4j.model.Resource xlabel) 
	{
	
		String body;

		SKOSXL fun = getService();
		fun.prefToAtlLabel(concept, xlabel);		
		body = ServletUtilities.getService().createReplyResponse("prefToAtlLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/removeHiddenLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeHiddenLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "xlabel") org.eclipse.rdf4j.model.Resource xlabel) 
	{
	
		String body;

		SKOSXL fun = getService();
		fun.removeHiddenLabel(concept, xlabel);		
		body = ServletUtilities.getService().createReplyResponse("removeHiddenLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/changeLabelInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   changeLabelInfoPublished(@RequestParam(value = "xlabel") org.eclipse.rdf4j.model.Resource xlabel, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal) 
	{
	
		String body;

		SKOSXL fun = getService();
		fun.changeLabelInfo(xlabel, literal);		
		body = ServletUtilities.getService().createReplyResponse("changeLabelInfo", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/removePrefLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removePrefLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "xlabel") org.eclipse.rdf4j.model.Resource xlabel) 
	{
	
		String body;

		SKOSXL fun = getService();
		fun.removePrefLabel(concept, xlabel);		
		body = ServletUtilities.getService().createReplyResponse("removePrefLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/getPrefLabel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getPrefLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "lang", required=false, defaultValue="*") java.lang.String lang) 
	{
	
		
		SKOSXL fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getPrefLabel(concept, lang);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/getHiddenLabels", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getHiddenLabelsPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "lang", required=false, defaultValue="*") java.lang.String lang) 
	{
	
		
		SKOSXL fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getHiddenLabels(concept, lang);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/SKOSXL/addHiddenLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addHiddenLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "literal") org.eclipse.rdf4j.model.Literal literal, @RequestParam(value = "mode") it.uniroma2.art.semanticturkey.services.core.SKOSXL.XLabelCreationMode mode)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException
	{
	
		String body;

		SKOSXL fun = getService();
		fun.addHiddenLabel(concept, literal, mode);		
		body = ServletUtilities.getService().createReplyResponse("addHiddenLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}