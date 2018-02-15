package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.Export;

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
public class ExportController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(Export.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public Export getService() {
		return context.getBean(Export.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Export/getNamedGraphs", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>>>
>   getNamedGraphsPublished()  throws java.lang.Exception
	{
	
		
		Export fun = getService();
		java.util.Collection<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.Resource>> body = fun.getNamedGraphs();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Export/getOutputFormats", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Collection<org.eclipse.rdf4j.rio.RDFFormat>>
>   getOutputFormatsPublished()  throws java.lang.Exception
	{
	
		
		Export fun = getService();
		java.util.Collection<org.eclipse.rdf4j.rio.RDFFormat> body = fun.getOutputFormats();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/Export/export", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  void   exportPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "graphs", required=false, defaultValue="") org.eclipse.rdf4j.model.IRI[] graphs, @RequestParam(value = "filteringPipeline", required=false, defaultValue="[]") it.uniroma2.art.semanticturkey.services.core.export.FilteringPipeline filteringPipeline, @RequestParam(value = "includeInferred", required=false, defaultValue="false") boolean includeInferred, @RequestParam(value = "outputFormat", required=false, defaultValue="TRIG") org.eclipse.rdf4j.rio.RDFFormat outputFormat, @RequestParam(value = "force", required=false, defaultValue="false") boolean force)  throws java.lang.Exception
	{
	
		Export fun = getService();
		fun.export(oRes, graphs, filteringPipeline, includeInferred, outputFormat, force);
    }
}