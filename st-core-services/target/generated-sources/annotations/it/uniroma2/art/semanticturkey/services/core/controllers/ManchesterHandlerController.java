package it.uniroma2.art.semanticturkey.services.core.controllers;

import it.uniroma2.art.semanticturkey.services.core.ManchesterHandler;

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
public class ManchesterHandlerController 
    implements ApplicationContextAware, IntrospectableController {
    ApplicationContext context;
    
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
		
	}
	
	@Override
	public ServiceSpecies getServiceSpecies() {
		Object serviceBean = context.getBean(ManchesterHandler.class);
		
		return ServiceSpecies.speciesOf(serviceBean);
	}
	
	@Override
	public ManchesterHandler getService() {
		return context.getBean(ManchesterHandler.class);
	}
	
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ManchesterHandler/getExpression", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.String>
>   getExpressionPublished(@RequestParam(value = "bnode") org.eclipse.rdf4j.model.BNode bnode, @RequestParam(value = "usePrefixes", required=false, defaultValue="true") boolean usePrefixes, @RequestParam(value = "useUppercaseSyntax", required=false, defaultValue="true") boolean useUppercaseSyntax)  throws it.uniroma2.art.semanticturkey.exceptions.NotClassAxiomException
	{
	
		
		ManchesterHandler fun = getService();
		java.lang.String body = fun.getExpression(bnode, usePrefixes, useUppercaseSyntax);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ManchesterHandler/createRestriction", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.BNode>>
>   createRestrictionPublished(@RequestParam(value = "classIri") org.eclipse.rdf4j.model.IRI classIri, @RequestParam(value = "exprType") org.eclipse.rdf4j.model.IRI exprType, @RequestParam(value = "manchExpr") java.lang.String manchExpr)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException
	{
	
		
		ManchesterHandler fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.BNode> body = fun.createRestriction(classIri, exprType, manchExpr);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ManchesterHandler/removeExpression", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<String
>   removeExpressionPublished(@RequestParam(value = "classIri", required=false) org.eclipse.rdf4j.model.IRI classIri, @RequestParam(value = "exprType", required=false) org.eclipse.rdf4j.model.IRI exprType, @RequestParam(value = "bnode") org.eclipse.rdf4j.model.BNode bnode)  throws it.uniroma2.art.semanticturkey.exceptions.NotClassAxiomException
	{
	
		String body;

		ManchesterHandler fun = getService();
		fun.removeExpression(classIri, exprType, bnode);		
		body = ServletUtilities.getService().createReplyResponse("removeExpression", RepliesStatus.ok, SerializationType.json).getResponseContent();
		HttpHeaders responseHeaders = new HttpHeaders();
   		
  		return new HttpEntity<>(body, responseHeaders);	 
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ManchesterHandler/getAllDLExpression", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.util.Map<java.lang.String,java.util.Map<java.lang.String,java.lang.String>>>
>   getAllDLExpressionPublished(@RequestParam(value = "classIri") org.eclipse.rdf4j.model.IRI classIri, @RequestParam(value = "usePrefixes", required=false, defaultValue="true") boolean usePrefixes, @RequestParam(value = "useUppercaseSyntax", required=false, defaultValue="true") boolean useUppercaseSyntax) 
	{
	
		
		ManchesterHandler fun = getService();
		java.util.Map<java.lang.String,java.util.Map<java.lang.String,java.lang.String>> body = fun.getAllDLExpression(classIri, usePrefixes, useUppercaseSyntax);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ManchesterHandler/updateExpression", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.BNode>>
>   updateExpressionPublished(@RequestParam(value = "newManchExpr") java.lang.String newManchExpr, @RequestParam(value = "bnode") org.eclipse.rdf4j.model.BNode bnode)  throws it.uniroma2.art.semanticturkey.exceptions.ManchesterParserException, it.uniroma2.art.semanticturkey.exceptions.NotClassAxiomException
	{
	
		
		ManchesterHandler fun = getService();
		it.uniroma2.art.semanticturkey.services.AnnotatedValue<org.eclipse.rdf4j.model.BNode> body = fun.updateExpression(newManchExpr, bnode);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ManchesterHandler/isClassAxiom", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.Boolean>
>   isClassAxiomPublished(@RequestParam(value = "bnode") org.eclipse.rdf4j.model.BNode bnode) 
	{
	
		
		ManchesterHandler fun = getService();
		java.lang.Boolean body = fun.isClassAxiom(bnode);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
     
    @RequestMapping(value = "it.uniroma2.art.semanticturkey/st-core-services/ManchesterHandler/checkExpression", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public  HttpEntity<Response<java.lang.Boolean>
>   checkExpressionPublished(@RequestParam(value = "manchExpr") java.lang.String manchExpr) 
	{
	
		
		ManchesterHandler fun = getService();
		java.lang.Boolean body = fun.checkExpression(manchExpr);
		HttpHeaders responseHeaders = new HttpHeaders();
   		
	return new HttpEntity<>(new Response<>(body), responseHeaders);	
    }
}