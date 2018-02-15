package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Refactor;

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
public class RefactorController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Refactor.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Refactor getService() {
		return context.getBean(Refactor.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Refactor/SKOStoSKOSXL", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   SKOStoSKOSXLPublished(@RequestParam(value = "reifyNotes") boolean reifyNotes)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException
	{
	
		String body;

		Refactor fun = getService();
		fun.SKOStoSKOSXL(reifyNotes);		
		body = ServletUtilities.getService().createReplyResponse("SKOStoSKOSXL", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Refactor/changeResourceURI", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   changeResourceURIPublished(@RequestParam(value = "oldResource") org.eclipse.rdf4j.model.IRI oldResource, @RequestParam(value = "newResource") org.eclipse.rdf4j.model.IRI newResource)  throws it.uniroma2.art.semanticturkey.exceptions.DuplicatedResourceException
	{
	
		String body;

		Refactor fun = getService();
		fun.changeResourceURI(oldResource, newResource);		
		body = ServletUtilities.getService().createReplyResponse("changeResourceURI", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Refactor/spawnNewConceptFromLabel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI>>
>   spawnNewConceptFromLabelPublished(@RequestParam(value = "newConcept", required=false) org.eclipse.rdf4j.model.IRI newConcept, @RequestParam(value = "xLabel") org.eclipse.rdf4j.model.Resource xLabel, @RequestParam(value = "oldConcept", required=false) org.eclipse.rdf4j.model.IRI oldConcept, @RequestParam(value = "broaderConcept", required=false) org.eclipse.rdf4j.model.Resource broaderConcept, @RequestParam(value = "conceptSchemes") java.util.List<org.eclipse.rdf4j.model.IRI> conceptSchemes, @RequestParam(value = "customFormValue", required=false) it.uniroma2.art.semanticturkey.customform.CustomFormValue customFormValue)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.customform.CustomFormException, it.uniroma2.art.semanticturkey.exceptions.CODAException, it.uniroma2.art.semanticturkey.exceptions.NonExistingLiteralFormForResourceException
	{
	
		
		Refactor fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.IRI> body = fun.spawnNewConceptFromLabel(newConcept, xLabel, oldConcept, broaderConcept, conceptSchemes, customFormValue);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Refactor/moveXLabelToResource", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   moveXLabelToResourcePublished(@RequestParam(value = "sourceResource") org.eclipse.rdf4j.model.Resource sourceResource, @RequestParam(value = "predicate") org.eclipse.rdf4j.model.IRI predicate, @RequestParam(value = "xLabel") org.eclipse.rdf4j.model.Resource xLabel, @RequestParam(value = "targetResource") org.eclipse.rdf4j.model.Resource targetResource, @RequestParam(value = "force", required=false, defaultValue="false") java.lang.Boolean force)  throws it.uniroma2.art.semanticturkey.plugin.extpts.URIGenerationException, it.uniroma2.art.semanticturkey.exceptions.ProjectInconsistentException, it.uniroma2.art.semanticturkey.customform.CustomFormException, it.uniroma2.art.semanticturkey.exceptions.CODAException, it.uniroma2.art.semanticturkey.exceptions.NonExistingLiteralFormForResourceException, it.uniroma2.art.semanticturkey.exceptions.AlreadyExistingLiteralFormForResourceException
	{
	
		String body;

		Refactor fun = getService();
		fun.moveXLabelToResource(sourceResource, predicate, xLabel, targetResource, force);		
		body = ServletUtilities.getService().createReplyResponse("moveXLabelToResource", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Refactor/replaceBaseURI", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   replaceBaseURIPublished(@RequestParam(value = "sourceBaseURI", required=false) org.eclipse.rdf4j.model.IRI sourceBaseURI, @RequestParam(value = "targetBaseURI") org.eclipse.rdf4j.model.IRI targetBaseURI)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException
	{
	
		String body;

		Refactor fun = getService();
		fun.replaceBaseURI(sourceBaseURI, targetBaseURI);		
		body = ServletUtilities.getService().createReplyResponse("replaceBaseURI", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Refactor/migrateDefaultGraphToBaseURIGraph", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   migrateDefaultGraphToBaseURIGraphPublished(@RequestParam(value = "clearDestinationGraph", required=false, defaultValue="false") boolean clearDestinationGraph) 
	{
	
		String body;

		Refactor fun = getService();
		fun.migrateDefaultGraphToBaseURIGraph(clearDestinationGraph);		
		body = ServletUtilities.getService().createReplyResponse("migrateDefaultGraphToBaseURIGraph", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Refactor/SKOSXLtoSKOS", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   SKOSXLtoSKOSPublished(@RequestParam(value = "flattenNotes") boolean flattenNotes) 
	{
	
		String body;

		Refactor fun = getService();
		fun.SKOSXLtoSKOS(flattenNotes);		
		body = ServletUtilities.getService().createReplyResponse("SKOSXLtoSKOS", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}