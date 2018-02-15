package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Validation;

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
public class ValidationController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Validation.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Validation getService() {
		return context.getBean(Validation.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Validation/getCommits", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.history.CommitInfo>>
>   getCommitsPublished(@RequestParam(value = "operationFilter", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] operationFilter, @RequestParam(value = "timeLowerBound", required=false) java.lang.String timeLowerBound, @RequestParam(value = "timeUpperBound") java.lang.String timeUpperBound, @RequestParam(value = "operationSorting", required=false, defaultValue="Unordered") it.uniroma2.art.semanticturkey.services.core.History.SortingDirection operationSorting, @RequestParam(value = "timeSorting", required=false, defaultValue="Descending") it.uniroma2.art.semanticturkey.services.core.History.SortingDirection timeSorting, @RequestParam(value = "page", required=false, defaultValue="0") long page, @RequestParam(value = "limit", required=false, defaultValue="100") long limit) 
	{
	
		
		Validation fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.history.CommitInfo> body = fun.getCommits(operationFilter, timeLowerBound, timeUpperBound, operationSorting, timeSorting, page, limit);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Validation/getStagedCommitSummary", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.history.ValidationPaginationInfo>
>   getStagedCommitSummaryPublished(@RequestParam(value = "operationFilter", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] operationFilter, @RequestParam(value = "timeLowerBound", required=false) java.lang.String timeLowerBound, @RequestParam(value = "timeUpperBound", required=false) java.lang.String timeUpperBound, @RequestParam(value = "limit", required=false, defaultValue="100") long limit) 
	{
	
		
		Validation fun = getService();
		it.uniroma2.art.semanticturkey.services.core.history.ValidationPaginationInfo body = fun.getStagedCommitSummary(operationFilter, timeLowerBound, timeUpperBound, limit);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Validation/reject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   rejectPublished(@RequestParam(value = "validatableCommit") org.eclipse.rdf4j.model.IRI validatableCommit) 
	{
	
		String body;

		Validation fun = getService();
		fun.reject(validatableCommit);		
		body = ServletUtilities.getService().createReplyResponse("reject", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Validation/accept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   acceptPublished(@RequestParam(value = "validatableCommit") org.eclipse.rdf4j.model.IRI validatableCommit) 
	{
	
		String body;

		Validation fun = getService();
		fun.accept(validatableCommit);		
		body = ServletUtilities.getService().createReplyResponse("accept", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}