package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.XMLSchema;

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
public class XMLSchemaController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(XMLSchema.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public XMLSchema getService() {
		return context.getBean(XMLSchema.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/XMLSchema/formatDate", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue>
>   formatDatePublished(@RequestParam(value = "year") int year, @RequestParam(value = "month") int month, @RequestParam(value = "day") int day)  throws java.text.ParseException
	{
	
		
		XMLSchema fun = getService();
		it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue body = fun.formatDate(year, month, day);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/XMLSchema/formatDuration", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue>
>   formatDurationPublished(@RequestParam(value = "isPositive", required=false, defaultValue="true") boolean isPositive, @RequestParam(value = "year", required=false, defaultValue="0") int year, @RequestParam(value = "month", required=false, defaultValue="0") int month, @RequestParam(value = "day", required=false, defaultValue="0") int day, @RequestParam(value = "hour", required=false, defaultValue="0") int hour, @RequestParam(value = "minute", required=false, defaultValue="0") int minute, @RequestParam(value = "second", required=false, defaultValue="0") int second)  throws java.text.ParseException
	{
	
		
		XMLSchema fun = getService();
		it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue body = fun.formatDuration(isPositive, year, month, day, hour, minute, second);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/XMLSchema/formatCurrentLocalDateTime", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue>
>   formatCurrentLocalDateTimePublished() 
	{
	
		
		XMLSchema fun = getService();
		it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue body = fun.formatCurrentLocalDateTime();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/XMLSchema/formatDateTime", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue>
>   formatDateTimePublished(@RequestParam(value = "year") int year, @RequestParam(value = "month") int month, @RequestParam(value = "day") int day, @RequestParam(value = "hour") int hour, @RequestParam(value = "minute") int minute, @RequestParam(value = "second") int second, @RequestParam(value = "offset", required=false, defaultValue="Z") java.lang.String offset)  throws java.text.ParseException
	{
	
		
		XMLSchema fun = getService();
		it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue body = fun.formatDateTime(year, month, day, hour, minute, second, offset);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/XMLSchema/formatTime", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue>
>   formatTimePublished(@RequestParam(value = "hour") int hour, @RequestParam(value = "minute") int minute, @RequestParam(value = "second") int second)  throws java.text.ParseException
	{
	
		
		XMLSchema fun = getService();
		it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue body = fun.formatTime(hour, minute, second);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/XMLSchema/formatCurrentUTCDateTime", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue>
>   formatCurrentUTCDateTimePublished() 
	{
	
		
		XMLSchema fun = getService();
		it.uniroma2.art.semanticturkey.services.core.xmlschema.FormattedValue body = fun.formatCurrentUTCDateTime();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}