package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Search;

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
public class SearchController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Search.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Search getService() {
		return context.getBean(Search.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Search/searchInstancesOfClass", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   searchInstancesOfClassPublished(@RequestParam(value = "cls") org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "searchString") java.lang.String searchString, @RequestParam(value = "useLocalName") boolean useLocalName, @RequestParam(value = "useURI") boolean useURI, @RequestParam(value = "searchMode") it.uniroma2.art.semanticturkey.search.SearchMode searchMode, @RequestParam(value = "langs", required=false) java.util.List<java.lang.String> langs, @RequestParam(value = "includeLocales", required=false, defaultValue="false") boolean includeLocales)  throws java.lang.IllegalStateException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Search fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.searchInstancesOfClass(cls, searchString, useLocalName, useURI, searchMode, langs, includeLocales);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Search/searchResource", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   searchResourcePublished(@RequestParam(value = "searchString") java.lang.String searchString, @RequestParam(value = "rolesArray") java.lang.String[] rolesArray, @RequestParam(value = "useLocalName") boolean useLocalName, @RequestParam(value = "useURI") boolean useURI, @RequestParam(value = "searchMode") it.uniroma2.art.semanticturkey.search.SearchMode searchMode, @RequestParam(value = "schemes", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemes, @RequestParam(value = "langs", required=false) java.util.List<java.lang.String> langs, @RequestParam(value = "includeLocales", required=false, defaultValue="false") boolean includeLocales)  throws java.lang.IllegalStateException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Search fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.searchResource(searchString, rolesArray, useLocalName, useURI, searchMode, schemes, langs, includeLocales);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Search/searchURIList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<java.lang.String>>
>   searchURIListPublished(@RequestParam(value = "searchString") java.lang.String searchString, @RequestParam(value = "rolesArray", required=false) java.lang.String[] rolesArray, @RequestParam(value = "searchMode") it.uniroma2.art.semanticturkey.search.SearchMode searchMode, @RequestParam(value = "schemes", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemes, @RequestParam(value = "cls", required=false) org.eclipse.rdf4j.model.IRI cls)  throws java.lang.IllegalStateException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Search fun = getService();
		java.util.Collection<java.lang.String> body = fun.searchURIList(searchString, rolesArray, searchMode, schemes, cls);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Search/searchStringList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<java.lang.String>>
>   searchStringListPublished(@RequestParam(value = "searchString") java.lang.String searchString, @RequestParam(value = "rolesArray", required=false) java.lang.String[] rolesArray, @RequestParam(value = "useLocalName") boolean useLocalName, @RequestParam(value = "searchMode") it.uniroma2.art.semanticturkey.search.SearchMode searchMode, @RequestParam(value = "schemes", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemes, @RequestParam(value = "langs", required=false) java.util.List<java.lang.String> langs, @RequestParam(value = "cls", required=false) org.eclipse.rdf4j.model.IRI cls, @RequestParam(value = "includeLocales", required=false, defaultValue="false") boolean includeLocales)  throws java.lang.IllegalStateException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		Search fun = getService();
		java.util.Collection<java.lang.String> body = fun.searchStringList(searchString, rolesArray, useLocalName, searchMode, schemes, langs, cls, includeLocales);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Search/getPathFromRoot", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getPathFromRootPublished(@RequestParam(value = "role") it.uniroma2.art.semanticturkey.data.role.RDFResourceRole role, @RequestParam(value = "resourceURI") org.eclipse.rdf4j.model.IRI resourceURI, @RequestParam(value = "schemesIRI", required=false) java.util.List<org.eclipse.rdf4j.model.IRI> schemesIRI, @RequestParam(value = "root", required=false, defaultValue="<http://www.w3.org/2002/07/owl#Thing>") org.eclipse.rdf4j.model.IRI root)  throws java.security.InvalidParameterException
	{
	
		
		Search fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getPathFromRoot(role, resourceURI, schemesIRI, root);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Search/updateIndexes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   updateIndexesPublished()  throws java.lang.Exception
	{
	
		String body;

		Search fun = getService();
		fun.updateIndexes();		
		body = ServletUtilities.getService().createReplyResponse("updateIndexes", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Search/createIndexes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   createIndexesPublished()  throws java.lang.Exception
	{
	
		String body;

		Search fun = getService();
		fun.createIndexes();		
		body = ServletUtilities.getService().createReplyResponse("createIndexes", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}