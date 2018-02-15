// Generated from it/uniroma2/art/semanticturkey/syntax/manchester/owl2/ManchesterOWL2SyntaxParser.g4 by ANTLR 4.7
package it.uniroma2.art.semanticturkey.syntax.manchester.owl2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ManchesterOWL2SyntaxParserParser}.
 */
public interface ManchesterOWL2SyntaxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(ManchesterOWL2SyntaxParserParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(ManchesterOWL2SyntaxParserParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#descriptionInner}.
	 * @param ctx the parse tree
	 */
	void enterDescriptionInner(ManchesterOWL2SyntaxParserParser.DescriptionInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#descriptionInner}.
	 * @param ctx the parse tree
	 */
	void exitDescriptionInner(ManchesterOWL2SyntaxParserParser.DescriptionInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(ManchesterOWL2SyntaxParserParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(ManchesterOWL2SyntaxParserParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#notRestriction}.
	 * @param ctx the parse tree
	 */
	void enterNotRestriction(ManchesterOWL2SyntaxParserParser.NotRestrictionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#notRestriction}.
	 * @param ctx the parse tree
	 */
	void exitNotRestriction(ManchesterOWL2SyntaxParserParser.NotRestrictionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ManchesterOWL2SyntaxParserParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ManchesterOWL2SyntaxParserParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#restriction}.
	 * @param ctx the parse tree
	 */
	void enterRestriction(ManchesterOWL2SyntaxParserParser.RestrictionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#restriction}.
	 * @param ctx the parse tree
	 */
	void exitRestriction(ManchesterOWL2SyntaxParserParser.RestrictionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#objectPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void enterObjectPropertyExpression(ManchesterOWL2SyntaxParserParser.ObjectPropertyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#objectPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void exitObjectPropertyExpression(ManchesterOWL2SyntaxParserParser.ObjectPropertyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#atomic}.
	 * @param ctx the parse tree
	 */
	void enterAtomic(ManchesterOWL2SyntaxParserParser.AtomicContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#atomic}.
	 * @param ctx the parse tree
	 */
	void exitAtomic(ManchesterOWL2SyntaxParserParser.AtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#dataPrimary}.
	 * @param ctx the parse tree
	 */
	void enterDataPrimary(ManchesterOWL2SyntaxParserParser.DataPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#dataPrimary}.
	 * @param ctx the parse tree
	 */
	void exitDataPrimary(ManchesterOWL2SyntaxParserParser.DataPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#dataAtomic}.
	 * @param ctx the parse tree
	 */
	void enterDataAtomic(ManchesterOWL2SyntaxParserParser.DataAtomicContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#dataAtomic}.
	 * @param ctx the parse tree
	 */
	void exitDataAtomic(ManchesterOWL2SyntaxParserParser.DataAtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ManchesterOWL2SyntaxParserParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ManchesterOWL2SyntaxParserParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ManchesterOWL2SyntaxParserParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ManchesterOWL2SyntaxParserParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDatatype(ManchesterOWL2SyntaxParserParser.DatatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDatatype(ManchesterOWL2SyntaxParserParser.DatatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#datatypeIRI}.
	 * @param ctx the parse tree
	 */
	void enterDatatypeIRI(ManchesterOWL2SyntaxParserParser.DatatypeIRIContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#datatypeIRI}.
	 * @param ctx the parse tree
	 */
	void exitDatatypeIRI(ManchesterOWL2SyntaxParserParser.DatatypeIRIContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#literalList}.
	 * @param ctx the parse tree
	 */
	void enterLiteralList(ManchesterOWL2SyntaxParserParser.LiteralListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#literalList}.
	 * @param ctx the parse tree
	 */
	void exitLiteralList(ManchesterOWL2SyntaxParserParser.LiteralListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#nonNegativeInteger}.
	 * @param ctx the parse tree
	 */
	void enterNonNegativeInteger(ManchesterOWL2SyntaxParserParser.NonNegativeIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#nonNegativeInteger}.
	 * @param ctx the parse tree
	 */
	void exitNonNegativeInteger(ManchesterOWL2SyntaxParserParser.NonNegativeIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#individualList}.
	 * @param ctx the parse tree
	 */
	void enterIndividualList(ManchesterOWL2SyntaxParserParser.IndividualListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#individualList}.
	 * @param ctx the parse tree
	 */
	void exitIndividualList(ManchesterOWL2SyntaxParserParser.IndividualListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#individual}.
	 * @param ctx the parse tree
	 */
	void enterIndividual(ManchesterOWL2SyntaxParserParser.IndividualContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#individual}.
	 * @param ctx the parse tree
	 */
	void exitIndividual(ManchesterOWL2SyntaxParserParser.IndividualContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#dataPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void enterDataPropertyExpression(ManchesterOWL2SyntaxParserParser.DataPropertyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#dataPropertyExpression}.
	 * @param ctx the parse tree
	 */
	void exitDataPropertyExpression(ManchesterOWL2SyntaxParserParser.DataPropertyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#objectPropertyIRI}.
	 * @param ctx the parse tree
	 */
	void enterObjectPropertyIRI(ManchesterOWL2SyntaxParserParser.ObjectPropertyIRIContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#objectPropertyIRI}.
	 * @param ctx the parse tree
	 */
	void exitObjectPropertyIRI(ManchesterOWL2SyntaxParserParser.ObjectPropertyIRIContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#inverseObjectProperty}.
	 * @param ctx the parse tree
	 */
	void enterInverseObjectProperty(ManchesterOWL2SyntaxParserParser.InverseObjectPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#inverseObjectProperty}.
	 * @param ctx the parse tree
	 */
	void exitInverseObjectProperty(ManchesterOWL2SyntaxParserParser.InverseObjectPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#classIRI}.
	 * @param ctx the parse tree
	 */
	void enterClassIRI(ManchesterOWL2SyntaxParserParser.ClassIRIContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#classIRI}.
	 * @param ctx the parse tree
	 */
	void exitClassIRI(ManchesterOWL2SyntaxParserParser.ClassIRIContext ctx);
	/**
	 * Enter a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#prefixedName}.
	 * @param ctx the parse tree
	 */
	void enterPrefixedName(ManchesterOWL2SyntaxParserParser.PrefixedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ManchesterOWL2SyntaxParserParser#prefixedName}.
	 * @param ctx the parse tree
	 */
	void exitPrefixedName(ManchesterOWL2SyntaxParserParser.PrefixedNameContext ctx);
}