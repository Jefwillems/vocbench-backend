package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.ICV;

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
public class ICVController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(ICV.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public ICV getService() {
		return context.getBean(ICV.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithNoLanguageTagForLabel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithNoLanguageTagForLabelPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithNoLanguageTagForLabel(rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/addAllConceptsToScheme", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addAllConceptsToSchemePublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		ICV fun = getService();
		fun.addAllConceptsToScheme(scheme);		
		body = ServletUtilities.getService().createReplyResponse("addAllConceptsToScheme", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/removeBroadersToConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeBroadersToConceptPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		ICV fun = getService();
		fun.removeBroadersToConcept(concept, scheme);		
		body = ServletUtilities.getService().createReplyResponse("removeBroadersToConcept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listBrokenAlignments", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listBrokenAlignmentsPublished(@RequestParam(value = "nsToLocationMap") java.util.Map<java.lang.String,java.lang.String> nsToLocationMap, @RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		ICV fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listBrokenAlignments(nsToLocationMap, rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listConceptSchemesWithNoTopConcept", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listConceptSchemesWithNoTopConceptPublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listConceptSchemesWithNoTopConcept();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/setBroaderForAllDangling", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setBroaderForAllDanglingPublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme, @RequestParam(value = "broader") org.eclipse.rdf4j.model.IRI broader) 
	{
	
		String body;

		ICV fun = getService();
		fun.setBroaderForAllDangling(scheme, broader);		
		body = ServletUtilities.getService().createReplyResponse("setBroaderForAllDangling", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/removeBroadersToAllConcepts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeBroadersToAllConceptsPublished() 
	{
	
		String body;

		ICV fun = getService();
		fun.removeBroadersToAllConcepts();		
		body = ServletUtilities.getService().createReplyResponse("removeBroadersToAllConcepts", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/setDanglingXLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setDanglingXLabelPublished(@RequestParam(value = "concept") org.eclipse.rdf4j.model.IRI concept, @RequestParam(value = "xlabelPred") org.eclipse.rdf4j.model.IRI xlabelPred, @RequestParam(value = "xlabel") org.eclipse.rdf4j.model.Resource xlabel) 
	{
	
		String body;

		ICV fun = getService();
		fun.setDanglingXLabel(concept, xlabelPred, xlabel);		
		body = ServletUtilities.getService().createReplyResponse("setDanglingXLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listConceptsWithNoScheme", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listConceptsWithNoSchemePublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listConceptsWithNoScheme();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/deleteAllDanglingConcepts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteAllDanglingConceptsPublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		ICV fun = getService();
		fun.deleteAllDanglingConcepts(scheme);		
		body = ServletUtilities.getService().createReplyResponse("deleteAllDanglingConcepts", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listConceptsExactMatchDisjoint", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listConceptsExactMatchDisjointPublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listConceptsExactMatchDisjoint();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesNoDef", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesNoDefPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray, @RequestParam(value = "languagesArray") java.lang.String[] languagesArray) 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesNoDef(rolesArray, languagesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listTopConceptsWithBroader", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listTopConceptsWithBroaderPublished() 
	{
	
		
		ICV fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listTopConceptsWithBroader();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listDanglingConcepts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listDanglingConceptsPublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listDanglingConcepts(scheme);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithOverlappedLabels", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithOverlappedLabelsPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithOverlappedLabels(rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/removeAllHierarchicalRedundancy", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeAllHierarchicalRedundancyPublished() 
	{
	
		String body;

		ICV fun = getService();
		fun.removeAllHierarchicalRedundancy();		
		body = ServletUtilities.getService().createReplyResponse("removeAllHierarchicalRedundancy", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithMorePrefLabelSameLang", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithMorePrefLabelSameLangPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithMorePrefLabelSameLang(rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listBrokenDefinitions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listBrokenDefinitionsPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray, @RequestParam(value = "property") org.eclipse.rdf4j.model.IRI property) 
	{
	
		
		ICV fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listBrokenDefinitions(rolesArray, property);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithNoSKOSXLPrefLabel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithNoSKOSXLPrefLabelPublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithNoSKOSXLPrefLabel();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithExtraSpacesInLabel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithExtraSpacesInLabelPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithExtraSpacesInLabel(rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/deleteAllDanglingXLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteAllDanglingXLabelPublished() 
	{
	
		String body;

		ICV fun = getService();
		fun.deleteAllDanglingXLabel();		
		body = ServletUtilities.getService().createReplyResponse("deleteAllDanglingXLabel", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listLocalInvalidURIs", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listLocalInvalidURIsPublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listLocalInvalidURIs();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/removeAllAsTopConceptsWithBroader", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeAllAsTopConceptsWithBroaderPublished() 
	{
	
		String body;

		ICV fun = getService();
		fun.removeAllAsTopConceptsWithBroader();		
		body = ServletUtilities.getService().createReplyResponse("removeAllAsTopConceptsWithBroader", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithSameLabels", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithSameLabelsPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithSameLabels(rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/setAllDanglingAsTopConcept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setAllDanglingAsTopConceptPublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		ICV fun = getService();
		fun.setAllDanglingAsTopConcept(scheme);		
		body = ServletUtilities.getService().createReplyResponse("setAllDanglingAsTopConcept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listDanglingXLabels", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listDanglingXLabelsPublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listDanglingXLabels();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listConceptsHierarchicalRedundancies", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listConceptsHierarchicalRedundanciesPublished(@RequestParam(value = "sameScheme", required=false, defaultValue="true") boolean sameScheme)  throws it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException
	{
	
		
		ICV fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listConceptsHierarchicalRedundancies(sameScheme);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesURIWithSpace", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesURIWithSpacePublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesURIWithSpace();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithAltNoPrefLabel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithAltNoPrefLabelPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.UnsupportedLexicalizationModelException
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithAltNoPrefLabel(rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesNoLexicalization", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesNoLexicalizationPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray, @RequestParam(value = "languagesArray") java.lang.String[] languagesArray) 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesNoLexicalization(rolesArray, languagesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/removeAllDanglingFromScheme", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeAllDanglingFromSchemePublished(@RequestParam(value = "scheme") org.eclipse.rdf4j.model.IRI scheme) 
	{
	
		String body;

		ICV fun = getService();
		fun.removeAllDanglingFromScheme(scheme);		
		body = ServletUtilities.getService().createReplyResponse("removeAllDanglingFromScheme", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listConceptsRelatedDisjoint", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listConceptsRelatedDisjointPublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listConceptsRelatedDisjoint();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listAlignedNamespaces", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listAlignedNamespacesPublished(@RequestParam(value = "rolesArray") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole[] rolesArray)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectAccessException
	{
	
		
		ICV fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listAlignedNamespaces(rolesArray);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listResourcesWithNoSKOSPrefLabel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   listResourcesWithNoSKOSPrefLabelPublished() 
	{
	
		
		ICV fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.listResourcesWithNoSKOSPrefLabel();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ICV/listConceptsHierarchicalCycles", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<com.fasterxml.jackson.databind.JsonNode>
>   listConceptsHierarchicalCyclesPublished() 
	{
	
		
		ICV fun = getService();
		com.fasterxml.jackson.databind.JsonNode body = fun.listConceptsHierarchicalCycles();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}