package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.DatasetMetadata;

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
public class DatasetMetadataController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(DatasetMetadata.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public DatasetMetadata getService() {
		return context.getBean(DatasetMetadata.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/DatasetMetadata/setDatasetMetadata", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   setDatasetMetadataPublished(@RequestParam(value = "exporterId") java.lang.String exporterId, @RequestParam(value = "extensionPointProperties") java.util.Map<java.lang.String,java.lang.Object> extensionPointProperties, @RequestParam(value = "pluginProperties") java.util.Map<java.lang.String,java.lang.Object> pluginProperties)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException, it.uniroma2.art.semanticturkey.properties.STPropertyUpdateException
	{
	
		String body;

		DatasetMetadata fun = getService();
		fun.setDatasetMetadata(exporterId, extensionPointProperties, pluginProperties);		
		body = ServletUtilities.getService().createReplyResponse("setDatasetMetadata", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/DatasetMetadata/export", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  void   exportPublished( javax.servlet.http.HttpServletResponse oRes, @RequestParam(value = "exporterSpecification") it.uniroma2.art.semanticturkey.plugin.PluginSpecification exporterSpecification, @RequestParam(value = "outputFormat", required=false, defaultValue="TURTLE") org.eclipse.rdf4j.rio.RDFFormat outputFormat)  throws java.lang.ClassNotFoundException, it.uniroma2.art.semanticturkey.properties.WrongPropertiesException, it.uniroma2.art.semanticturkey.plugin.configuration.UnsupportedPluginConfigurationException, it.uniroma2.art.semanticturkey.plugin.configuration.UnloadablePluginConfigurationException, java.io.IOException, it.uniroma2.art.semanticturkey.plugin.extpts.DatasetMetadataExporterException, it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		DatasetMetadata fun = getService();
		fun.export(oRes, exporterSpecification, outputFormat);
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/DatasetMetadata/getDatasetMetadata", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.metadata.ExporterSettingsInfo>
>   getDatasetMetadataPublished(@RequestParam(value = "exporterId") java.lang.String exporterId)  throws it.uniroma2.art.semanticturkey.properties.STPropertyAccessException
	{
	
		
		DatasetMetadata fun = getService();
		it.uniroma2.art.semanticturkey.services.core.metadata.ExporterSettingsInfo body = fun.getDatasetMetadata(exporterId);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}