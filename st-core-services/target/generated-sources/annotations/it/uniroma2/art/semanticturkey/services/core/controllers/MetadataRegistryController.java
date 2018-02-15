package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.MetadataRegistry;

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
public class MetadataRegistryController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(MetadataRegistry.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public MetadataRegistry getService() {
		return context.getBean(MetadataRegistry.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/MetadataRegistry/deleteDatasetMetadata", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   deleteDatasetMetadataPublished(@RequestParam(value = "baseURI") java.lang.String baseURI)  throws it.uniroma2.art.semanticturkey.resources.DatasetMetadataRepositoryWritingException, it.uniroma2.art.semanticturkey.resources.NoSuchDatasetMetadataException
	{
	
		String body;

		MetadataRegistry fun = getService();
		fun.deleteDatasetMetadata(baseURI);		
		body = ServletUtilities.getService().createReplyResponse("deleteDatasetMetadata", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/MetadataRegistry/listDatasets", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.DatasetInfo>>
>   listDatasetsPublished() 
	{
	
		
		MetadataRegistry fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.DatasetInfo> body = fun.listDatasets();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/MetadataRegistry/editDatasetMetadata", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   editDatasetMetadataPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "newBaseURI") java.lang.String newBaseURI, @RequestParam(value = "newTitle") java.lang.String newTitle, @RequestParam(value = "newSparqlEndpoint") java.lang.String newSparqlEndpoint, @RequestParam(value = "newDereferenceable") boolean newDereferenceable)  throws it.uniroma2.art.semanticturkey.resources.NoSuchDatasetMetadataException, it.uniroma2.art.semanticturkey.resources.DatasetMetadataRepositoryWritingException, it.uniroma2.art.semanticturkey.resources.DuplicateDatasetMetadataException
	{
	
		String body;

		MetadataRegistry fun = getService();
		fun.editDatasetMetadata(baseURI, newBaseURI, newTitle, newSparqlEndpoint, newDereferenceable);		
		body = ServletUtilities.getService().createReplyResponse("editDatasetMetadata", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/MetadataRegistry/addDatasetMetadata", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   addDatasetMetadataPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "title") java.lang.String title, @RequestParam(value = "sparqlEndpoint") java.lang.String sparqlEndpoint, @RequestParam(value = "dereferenceable") boolean dereferenceable)  throws it.uniroma2.art.semanticturkey.resources.DuplicateDatasetMetadataException, it.uniroma2.art.semanticturkey.resources.DatasetMetadataRepositoryWritingException
	{
	
		String body;

		MetadataRegistry fun = getService();
		fun.addDatasetMetadata(baseURI, title, sparqlEndpoint, dereferenceable);		
		body = ServletUtilities.getService().createReplyResponse("addDatasetMetadata", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/MetadataRegistry/getDatasetMetadata", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.resources.DatasetMetadata>
>   getDatasetMetadataPublished(@RequestParam(value = "baseURI") java.lang.String baseURI)  throws it.uniroma2.art.semanticturkey.resources.NoSuchDatasetMetadataException
	{
	
		
		MetadataRegistry fun = getService();
		it.uniroma2.art.semanticturkey.resources.DatasetMetadata body = fun.getDatasetMetadata(baseURI);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}