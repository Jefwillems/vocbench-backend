package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Metadata;

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
public class MetadataController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Metadata.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Metadata getService() {
		return context.getBean(Metadata.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/getDefaultNamespace", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   getDefaultNamespacePublished() 
	{
	
		
		Metadata fun = getService();
		java.lang.String body = fun.getDefaultNamespace();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/getImports", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   getImportsPublished()  throws org.eclipse.rdf4j.repository.RepositoryException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.getImports();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/setNSPrefixMapping", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setNSPrefixMappingPublished(@RequestParam(value = "prefix") java.lang.String prefix, @RequestParam(value = "namespace") java.lang.String namespace)  throws it.uniroma2.art.semanticturkey.ontology.NSPrefixMappingUpdateException
	{
	
		String body;

		Metadata fun = getService();
		fun.setNSPrefixMapping(prefix, namespace);		
		body = ServletUtilities.getService().createReplyResponse("setNSPrefixMapping", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/removeImport", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeImportPublished(@RequestParam(value = "baseURI") java.lang.String baseURI)  throws org.eclipse.rdf4j.RDF4JException, it.uniroma2.art.semanticturkey.ontology.OntologyManagerException, java.io.IOException
	{
	
		String body;

		Metadata fun = getService();
		fun.removeImport(baseURI);		
		body = ServletUtilities.getService().createReplyResponse("removeImport", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/addFromWebToMirror", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   addFromWebToMirrorPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "altUrl", required=false) java.lang.String altUrl, @RequestParam(value = "mirrorFile") java.lang.String mirrorFile, @RequestParam(value = "rdfFormat", required=false) org.eclipse.rdf4j.rio.RDFFormat rdfFormat, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance)  throws org.eclipse.rdf4j.RDF4JException, java.net.MalformedURLException, it.uniroma2.art.semanticturkey.ontology.OntologyManagerException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.addFromWebToMirror(baseURI, altUrl, mirrorFile, rdfFormat, transitiveImportAllowance);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/addFromLocalFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   addFromLocalFilePublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "localFile") org.springframework.web.multipart.MultipartFile localFile, @RequestParam(value = "mirrorFile") java.lang.String mirrorFile, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance)  throws org.eclipse.rdf4j.RDF4JException, it.uniroma2.art.semanticturkey.ontology.OntologyManagerException, java.io.IOException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.addFromLocalFile(baseURI, localFile, mirrorFile, transitiveImportAllowance);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/addFromMirror", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   addFromMirrorPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "mirrorFile") java.lang.String mirrorFile, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance)  throws org.eclipse.rdf4j.RDF4JException, java.net.MalformedURLException, it.uniroma2.art.semanticturkey.ontology.OntologyManagerException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.addFromMirror(baseURI, mirrorFile, transitiveImportAllowance);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/setDefaultNamespace", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setDefaultNamespacePublished(@RequestParam(value = "namespace") java.lang.String namespace)  throws it.uniroma2.art.semanticturkey.exceptions.ProjectUpdateException
	{
	
		String body;

		Metadata fun = getService();
		fun.setDefaultNamespace(namespace);		
		body = ServletUtilities.getService().createReplyResponse("setDefaultNamespace", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/downloadFromWebToMirror", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   downloadFromWebToMirrorPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "altUrl", required=false) java.lang.String altUrl, @RequestParam(value = "mirrorFile") java.lang.String mirrorFile, @RequestParam(value = "rdfFormat", required=false) org.eclipse.rdf4j.rio.RDFFormat rdfFormat, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance)  throws org.eclipse.rdf4j.RDF4JException, java.net.MalformedURLException, it.uniroma2.art.semanticturkey.exceptions.ImportManagementException, java.io.IOException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.downloadFromWebToMirror(baseURI, altUrl, mirrorFile, rdfFormat, transitiveImportAllowance);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/getFromLocalFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   getFromLocalFilePublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "localFile") org.springframework.web.multipart.MultipartFile localFile, @RequestParam(value = "mirrorFile") java.lang.String mirrorFile, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance)  throws org.eclipse.rdf4j.RDF4JException, java.net.MalformedURLException, it.uniroma2.art.semanticturkey.exceptions.ImportManagementException, java.io.IOException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.getFromLocalFile(baseURI, localFile, mirrorFile, transitiveImportAllowance);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/expandQName", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   expandQNamePublished(@RequestParam(value = "qname") java.lang.String qname)  throws java.lang.IllegalArgumentException
	{
	
		
		Metadata fun = getService();
		java.lang.String body = fun.expandQName(qname);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/addFromWeb", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   addFromWebPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "altUrl", required=false) java.lang.String altUrl, @RequestParam(value = "rdfFormat", required=false) org.eclipse.rdf4j.rio.RDFFormat rdfFormat, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance)  throws org.eclipse.rdf4j.RDF4JException, java.net.MalformedURLException, it.uniroma2.art.semanticturkey.ontology.OntologyManagerException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.addFromWeb(baseURI, altUrl, rdfFormat, transitiveImportAllowance);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/getBaseURI", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   getBaseURIPublished() 
	{
	
		
		Metadata fun = getService();
		java.lang.String body = fun.getBaseURI();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/getNamedGraphs", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getNamedGraphsPublished()  throws org.eclipse.rdf4j.repository.RepositoryException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getNamedGraphs();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/getNamespaceMappings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.Metadata.PrefixMapping>>
>   getNamespaceMappingsPublished()  throws it.uniroma2.art.semanticturkey.ontology.OntologyManagerException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.Metadata.PrefixMapping> body = fun.getNamespaceMappings();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/changeNSPrefixMapping", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   changeNSPrefixMappingPublished(@RequestParam(value = "prefix") java.lang.String prefix, @RequestParam(value = "namespace") java.lang.String namespace)  throws it.uniroma2.art.semanticturkey.ontology.NSPrefixMappingUpdateException
	{
	
		String body;

		Metadata fun = getService();
		fun.changeNSPrefixMapping(prefix, namespace);		
		body = ServletUtilities.getService().createReplyResponse("changeNSPrefixMapping", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/downloadFromWeb", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport>>
>   downloadFromWebPublished(@RequestParam(value = "baseURI") java.lang.String baseURI, @RequestParam(value = "altUrl", required=false) java.lang.String altUrl, @RequestParam(value = "rdfFormat", required=false) org.eclipse.rdf4j.rio.RDFFormat rdfFormat, @RequestParam(value = "transitiveImportAllowance") it.uniroma2.art.semanticturkey.ontology.TransitiveImportMethodAllowance transitiveImportAllowance)  throws org.eclipse.rdf4j.RDF4JException, java.net.MalformedURLException, it.uniroma2.art.semanticturkey.exceptions.ImportManagementException, java.io.IOException
	{
	
		
		Metadata fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.core.metadata.OntologyImport> body = fun.downloadFromWeb(baseURI, altUrl, rdfFormat, transitiveImportAllowance);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Metadata/removeNSPrefixMapping", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeNSPrefixMappingPublished(@RequestParam(value = "namespace") java.lang.String namespace)  throws it.uniroma2.art.semanticturkey.ontology.NSPrefixMappingUpdateException
	{
	
		String body;

		Metadata fun = getService();
		fun.removeNSPrefixMapping(namespace);		
		body = ServletUtilities.getService().createReplyResponse("removeNSPrefixMapping", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
}