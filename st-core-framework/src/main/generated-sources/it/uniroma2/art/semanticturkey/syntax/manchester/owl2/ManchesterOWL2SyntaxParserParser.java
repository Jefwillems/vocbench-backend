// Generated from it/uniroma2/art/semanticturkey/syntax/manchester/owl2/ManchesterOWL2SyntaxParser.g4 by ANTLR 4.7
package it.uniroma2.art.semanticturkey.syntax.manchester.owl2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ManchesterOWL2SyntaxParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, WS=11, NEWLINE=12, COMMENT=13, MULTILINE_COMMENT=14, IRIREF=15, 
		OR=16, AND=17, NOT=18, SOME=19, ONLY=20, MIN=21, MAX=22, EXACTLY=23, VALUE=24, 
		SELF=25, THAT=26, INVERSE=27, INTEGER=28, PNAME_NS=29, PNAME_LN=30, LANGTAG=31, 
		STRING_LITERAL1=32, STRING_LITERAL2=33, AST_BASECLASS=34, AST_OR=35, AST_AND=36, 
		AST_NOT=37, AST_SOME=38, AST_ONLY=39, AST_CARDINALITY=40, AST_VALUE=41, 
		AST_ONEOFLIST=42, AST_PREFIXED_NAME=43;
	public static final int
		RULE_description = 0, RULE_descriptionInner = 1, RULE_conjunction = 2, 
		RULE_notRestriction = 3, RULE_primary = 4, RULE_restriction = 5, RULE_objectPropertyExpression = 6, 
		RULE_atomic = 7, RULE_dataPrimary = 8, RULE_dataAtomic = 9, RULE_literal = 10, 
		RULE_string = 11, RULE_datatype = 12, RULE_datatypeIRI = 13, RULE_literalList = 14, 
		RULE_nonNegativeInteger = 15, RULE_individualList = 16, RULE_individual = 17, 
		RULE_dataPropertyExpression = 18, RULE_objectPropertyIRI = 19, RULE_inverseObjectProperty = 20, 
		RULE_classIRI = 21, RULE_prefixedName = 22;
	public static final String[] ruleNames = {
		"description", "descriptionInner", "conjunction", "notRestriction", "primary", 
		"restriction", "objectPropertyExpression", "atomic", "dataPrimary", "dataAtomic", 
		"literal", "string", "datatype", "datatypeIRI", "literalList", "nonNegativeInteger", 
		"individualList", "individual", "dataPropertyExpression", "objectPropertyIRI", 
		"inverseObjectProperty", "classIRI", "prefixedName"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "'^^'", "'integer'", "'decimal'", "'float'", 
		"'string'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WS", 
		"NEWLINE", "COMMENT", "MULTILINE_COMMENT", "IRIREF", "OR", "AND", "NOT", 
		"SOME", "ONLY", "MIN", "MAX", "EXACTLY", "VALUE", "SELF", "THAT", "INVERSE", 
		"INTEGER", "PNAME_NS", "PNAME_LN", "LANGTAG", "STRING_LITERAL1", "STRING_LITERAL2", 
		"AST_BASECLASS", "AST_OR", "AST_AND", "AST_NOT", "AST_SOME", "AST_ONLY", 
		"AST_CARDINALITY", "AST_VALUE", "AST_ONEOFLIST", "AST_PREFIXED_NAME"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ManchesterOWL2SyntaxParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ManchesterOWL2SyntaxParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DescriptionContext extends ParserRuleContext {
		public DescriptionInnerContext descriptionInner() {
			return getRuleContext(DescriptionInnerContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ManchesterOWL2SyntaxParserParser.EOF, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			descriptionInner();
			setState(47);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionInnerContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ManchesterOWL2SyntaxParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ManchesterOWL2SyntaxParserParser.OR, i);
		}
		public DescriptionInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionInner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterDescriptionInner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitDescriptionInner(this);
		}
	}

	public final DescriptionInnerContext descriptionInner() throws RecognitionException {
		DescriptionInnerContext _localctx = new DescriptionInnerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_descriptionInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			conjunction();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(50);
				match(OR);
				setState(51);
				conjunction();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctionContext extends ParserRuleContext {
		public ClassIRIContext classIRI() {
			return getRuleContext(ClassIRIContext.class,0);
		}
		public TerminalNode THAT() { return getToken(ManchesterOWL2SyntaxParserParser.THAT, 0); }
		public List<NotRestrictionContext> notRestriction() {
			return getRuleContexts(NotRestrictionContext.class);
		}
		public NotRestrictionContext notRestriction(int i) {
			return getRuleContext(NotRestrictionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ManchesterOWL2SyntaxParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ManchesterOWL2SyntaxParserParser.AND, i);
		}
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitConjunction(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_conjunction);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				classIRI();
				setState(58);
				match(THAT);
				setState(59);
				notRestriction();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(60);
					match(AND);
					setState(61);
					notRestriction();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				primary();
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(68);
					match(AND);
					setState(69);
					primary();
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotRestrictionContext extends ParserRuleContext {
		public Token not;
		public RestrictionContext restriction() {
			return getRuleContext(RestrictionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ManchesterOWL2SyntaxParserParser.NOT, 0); }
		public NotRestrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notRestriction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterNotRestriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitNotRestriction(this);
		}
	}

	public final NotRestrictionContext notRestriction() throws RecognitionException {
		NotRestrictionContext _localctx = new NotRestrictionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_notRestriction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(77);
				((NotRestrictionContext)_localctx).not = match(NOT);
				}
			}

			setState(80);
			restriction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public Token not;
		public RestrictionContext restriction() {
			return getRuleContext(RestrictionContext.class,0);
		}
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ManchesterOWL2SyntaxParserParser.NOT, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(82);
				((PrimaryContext)_localctx).not = match(NOT);
				}
			}

			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(85);
				restriction();
				}
				break;
			case 2:
				{
				setState(86);
				atomic();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RestrictionContext extends ParserRuleContext {
		public Token type;
		public ObjectPropertyExpressionContext objectPropertyExpression() {
			return getRuleContext(ObjectPropertyExpressionContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode SOME() { return getToken(ManchesterOWL2SyntaxParserParser.SOME, 0); }
		public TerminalNode ONLY() { return getToken(ManchesterOWL2SyntaxParserParser.ONLY, 0); }
		public IndividualContext individual() {
			return getRuleContext(IndividualContext.class,0);
		}
		public TerminalNode VALUE() { return getToken(ManchesterOWL2SyntaxParserParser.VALUE, 0); }
		public TerminalNode SELF() { return getToken(ManchesterOWL2SyntaxParserParser.SELF, 0); }
		public NonNegativeIntegerContext nonNegativeInteger() {
			return getRuleContext(NonNegativeIntegerContext.class,0);
		}
		public TerminalNode MIN() { return getToken(ManchesterOWL2SyntaxParserParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(ManchesterOWL2SyntaxParserParser.MAX, 0); }
		public TerminalNode EXACTLY() { return getToken(ManchesterOWL2SyntaxParserParser.EXACTLY, 0); }
		public DataPropertyExpressionContext dataPropertyExpression() {
			return getRuleContext(DataPropertyExpressionContext.class,0);
		}
		public DataPrimaryContext dataPrimary() {
			return getRuleContext(DataPrimaryContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public RestrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restriction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterRestriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitRestriction(this);
		}
	}

	public final RestrictionContext restriction() throws RecognitionException {
		RestrictionContext _localctx = new RestrictionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_restriction);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				objectPropertyExpression();
				setState(90);
				((RestrictionContext)_localctx).type = match(SOME);
				setState(91);
				primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				objectPropertyExpression();
				setState(94);
				((RestrictionContext)_localctx).type = match(ONLY);
				setState(95);
				primary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				objectPropertyExpression();
				setState(98);
				((RestrictionContext)_localctx).type = match(VALUE);
				setState(99);
				individual();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				objectPropertyExpression();
				setState(102);
				((RestrictionContext)_localctx).type = match(SELF);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(104);
				objectPropertyExpression();
				setState(105);
				((RestrictionContext)_localctx).type = match(MIN);
				setState(106);
				nonNegativeInteger();
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << IRIREF) | (1L << NOT) | (1L << INVERSE) | (1L << PNAME_LN))) != 0)) {
					{
					setState(107);
					primary();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
				objectPropertyExpression();
				setState(111);
				((RestrictionContext)_localctx).type = match(MAX);
				setState(112);
				nonNegativeInteger();
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << IRIREF) | (1L << NOT) | (1L << INVERSE) | (1L << PNAME_LN))) != 0)) {
					{
					setState(113);
					primary();
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(116);
				objectPropertyExpression();
				setState(117);
				((RestrictionContext)_localctx).type = match(EXACTLY);
				setState(118);
				nonNegativeInteger();
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << IRIREF) | (1L << NOT) | (1L << INVERSE) | (1L << PNAME_LN))) != 0)) {
					{
					setState(119);
					primary();
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(122);
				dataPropertyExpression();
				setState(123);
				((RestrictionContext)_localctx).type = match(SOME);
				setState(124);
				dataPrimary();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(126);
				dataPropertyExpression();
				setState(127);
				((RestrictionContext)_localctx).type = match(ONLY);
				setState(128);
				dataPrimary();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(130);
				dataPropertyExpression();
				setState(131);
				((RestrictionContext)_localctx).type = match(VALUE);
				setState(132);
				literal();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(134);
				dataPropertyExpression();
				setState(135);
				((RestrictionContext)_localctx).type = match(MIN);
				setState(136);
				nonNegativeInteger();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << IRIREF) | (1L << NOT) | (1L << PNAME_LN))) != 0)) {
					{
					setState(137);
					dataPrimary();
					}
				}

				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(140);
				dataPropertyExpression();
				setState(141);
				((RestrictionContext)_localctx).type = match(MAX);
				setState(142);
				nonNegativeInteger();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << IRIREF) | (1L << NOT) | (1L << PNAME_LN))) != 0)) {
					{
					setState(143);
					dataPrimary();
					}
				}

				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(146);
				dataPropertyExpression();
				setState(147);
				((RestrictionContext)_localctx).type = match(EXACTLY);
				setState(148);
				nonNegativeInteger();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << IRIREF) | (1L << NOT) | (1L << PNAME_LN))) != 0)) {
					{
					setState(149);
					dataPrimary();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectPropertyExpressionContext extends ParserRuleContext {
		public ObjectPropertyIRIContext objectPropertyIRI() {
			return getRuleContext(ObjectPropertyIRIContext.class,0);
		}
		public InverseObjectPropertyContext inverseObjectProperty() {
			return getRuleContext(InverseObjectPropertyContext.class,0);
		}
		public ObjectPropertyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPropertyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterObjectPropertyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitObjectPropertyExpression(this);
		}
	}

	public final ObjectPropertyExpressionContext objectPropertyExpression() throws RecognitionException {
		ObjectPropertyExpressionContext _localctx = new ObjectPropertyExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_objectPropertyExpression);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				objectPropertyIRI();
				}
				break;
			case INVERSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				inverseObjectProperty();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicContext extends ParserRuleContext {
		public ClassIRIContext classIRI() {
			return getRuleContext(ClassIRIContext.class,0);
		}
		public IndividualListContext individualList() {
			return getRuleContext(IndividualListContext.class,0);
		}
		public DescriptionInnerContext descriptionInner() {
			return getRuleContext(DescriptionInnerContext.class,0);
		}
		public AtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitAtomic(this);
		}
	}

	public final AtomicContext atomic() throws RecognitionException {
		AtomicContext _localctx = new AtomicContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atomic);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				classIRI();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(T__0);
				setState(160);
				individualList();
				setState(161);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(T__2);
				setState(164);
				descriptionInner();
				setState(165);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataPrimaryContext extends ParserRuleContext {
		public Token not;
		public DataAtomicContext dataAtomic() {
			return getRuleContext(DataAtomicContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ManchesterOWL2SyntaxParserParser.NOT, 0); }
		public DataPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterDataPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitDataPrimary(this);
		}
	}

	public final DataPrimaryContext dataPrimary() throws RecognitionException {
		DataPrimaryContext _localctx = new DataPrimaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dataPrimary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(169);
				((DataPrimaryContext)_localctx).not = match(NOT);
				}
			}

			setState(172);
			dataAtomic();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataAtomicContext extends ParserRuleContext {
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public LiteralListContext literalList() {
			return getRuleContext(LiteralListContext.class,0);
		}
		public DataAtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataAtomic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterDataAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitDataAtomic(this);
		}
	}

	public final DataAtomicContext dataAtomic() throws RecognitionException {
		DataAtomicContext _localctx = new DataAtomicContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dataAtomic);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case IRIREF:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				datatype();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(T__0);
				setState(176);
				literalList();
				setState(177);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode LANGTAG() { return getToken(ManchesterOWL2SyntaxParserParser.LANGTAG, 0); }
		public ClassIRIContext classIRI() {
			return getRuleContext(ClassIRIContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			string();
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LANGTAG:
				{
				setState(182);
				match(LANGTAG);
				}
				break;
			case T__4:
				{
				{
				setState(183);
				match(T__4);
				setState(184);
				classIRI();
				}
				}
				break;
			case EOF:
			case T__1:
			case T__3:
			case T__9:
			case OR:
			case AND:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL1() { return getToken(ManchesterOWL2SyntaxParserParser.STRING_LITERAL1, 0); }
		public TerminalNode STRING_LITERAL2() { return getToken(ManchesterOWL2SyntaxParserParser.STRING_LITERAL2, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==STRING_LITERAL1 || _la==STRING_LITERAL2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatatypeContext extends ParserRuleContext {
		public Token abbr;
		public DatatypeIRIContext datatypeIRI() {
			return getRuleContext(DatatypeIRIContext.class,0);
		}
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitDatatype(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_datatype);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				datatypeIRI();
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				((DatatypeContext)_localctx).abbr = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
					((DatatypeContext)_localctx).abbr = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatatypeIRIContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(ManchesterOWL2SyntaxParserParser.IRIREF, 0); }
		public PrefixedNameContext prefixedName() {
			return getRuleContext(PrefixedNameContext.class,0);
		}
		public DatatypeIRIContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatypeIRI; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterDatatypeIRI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitDatatypeIRI(this);
		}
	}

	public final DatatypeIRIContext datatypeIRI() throws RecognitionException {
		DatatypeIRIContext _localctx = new DatatypeIRIContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_datatypeIRI);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(IRIREF);
				}
				break;
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				prefixedName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralListContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public LiteralListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterLiteralList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitLiteralList(this);
		}
	}

	public final LiteralListContext literalList() throws RecognitionException {
		LiteralListContext _localctx = new LiteralListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_literalList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			literal();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(198);
				match(T__9);
				setState(199);
				literal();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonNegativeIntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ManchesterOWL2SyntaxParserParser.INTEGER, 0); }
		public NonNegativeIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonNegativeInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterNonNegativeInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitNonNegativeInteger(this);
		}
	}

	public final NonNegativeIntegerContext nonNegativeInteger() throws RecognitionException {
		NonNegativeIntegerContext _localctx = new NonNegativeIntegerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_nonNegativeInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndividualListContext extends ParserRuleContext {
		public List<IndividualContext> individual() {
			return getRuleContexts(IndividualContext.class);
		}
		public IndividualContext individual(int i) {
			return getRuleContext(IndividualContext.class,i);
		}
		public IndividualListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individualList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterIndividualList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitIndividualList(this);
		}
	}

	public final IndividualListContext individualList() throws RecognitionException {
		IndividualListContext _localctx = new IndividualListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_individualList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			individual();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(208);
				match(T__9);
				setState(209);
				individual();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndividualContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(ManchesterOWL2SyntaxParserParser.IRIREF, 0); }
		public PrefixedNameContext prefixedName() {
			return getRuleContext(PrefixedNameContext.class,0);
		}
		public IndividualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterIndividual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitIndividual(this);
		}
	}

	public final IndividualContext individual() throws RecognitionException {
		IndividualContext _localctx = new IndividualContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_individual);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(IRIREF);
				}
				break;
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				prefixedName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataPropertyExpressionContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(ManchesterOWL2SyntaxParserParser.IRIREF, 0); }
		public PrefixedNameContext prefixedName() {
			return getRuleContext(PrefixedNameContext.class,0);
		}
		public DataPropertyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataPropertyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterDataPropertyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitDataPropertyExpression(this);
		}
	}

	public final DataPropertyExpressionContext dataPropertyExpression() throws RecognitionException {
		DataPropertyExpressionContext _localctx = new DataPropertyExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dataPropertyExpression);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(IRIREF);
				}
				break;
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				prefixedName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectPropertyIRIContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(ManchesterOWL2SyntaxParserParser.IRIREF, 0); }
		public PrefixedNameContext prefixedName() {
			return getRuleContext(PrefixedNameContext.class,0);
		}
		public ObjectPropertyIRIContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPropertyIRI; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterObjectPropertyIRI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitObjectPropertyIRI(this);
		}
	}

	public final ObjectPropertyIRIContext objectPropertyIRI() throws RecognitionException {
		ObjectPropertyIRIContext _localctx = new ObjectPropertyIRIContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_objectPropertyIRI);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				match(IRIREF);
				}
				break;
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				prefixedName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InverseObjectPropertyContext extends ParserRuleContext {
		public TerminalNode INVERSE() { return getToken(ManchesterOWL2SyntaxParserParser.INVERSE, 0); }
		public ObjectPropertyIRIContext objectPropertyIRI() {
			return getRuleContext(ObjectPropertyIRIContext.class,0);
		}
		public InverseObjectPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inverseObjectProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterInverseObjectProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitInverseObjectProperty(this);
		}
	}

	public final InverseObjectPropertyContext inverseObjectProperty() throws RecognitionException {
		InverseObjectPropertyContext _localctx = new InverseObjectPropertyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inverseObjectProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(INVERSE);
			setState(228);
			objectPropertyIRI();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassIRIContext extends ParserRuleContext {
		public TerminalNode IRIREF() { return getToken(ManchesterOWL2SyntaxParserParser.IRIREF, 0); }
		public PrefixedNameContext prefixedName() {
			return getRuleContext(PrefixedNameContext.class,0);
		}
		public ClassIRIContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classIRI; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterClassIRI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitClassIRI(this);
		}
	}

	public final ClassIRIContext classIRI() throws RecognitionException {
		ClassIRIContext _localctx = new ClassIRIContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_classIRI);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IRIREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(IRIREF);
				}
				break;
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				prefixedName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixedNameContext extends ParserRuleContext {
		public TerminalNode PNAME_LN() { return getToken(ManchesterOWL2SyntaxParserParser.PNAME_LN, 0); }
		public PrefixedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).enterPrefixedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ManchesterOWL2SyntaxParserListener ) ((ManchesterOWL2SyntaxParserListener)listener).exitPrefixedName(this);
		}
	}

	public final PrefixedNameContext prefixedName() throws RecognitionException {
		PrefixedNameContext _localctx = new PrefixedNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_prefixedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(PNAME_LN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u00ef\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\4\3\4\3\4\3\4\3\4\7\4A\n\4"+
		"\f\4\16\4D\13\4\3\4\3\4\3\4\7\4I\n\4\f\4\16\4L\13\4\5\4N\n\4\3\5\5\5Q"+
		"\n\5\3\5\3\5\3\6\5\6V\n\6\3\6\3\6\5\6Z\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7o\n\7\3\7\3\7\3\7"+
		"\3\7\5\7u\n\7\3\7\3\7\3\7\3\7\5\7{\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008d\n\7\3\7\3\7\3\7\3\7\5\7\u0093"+
		"\n\7\3\7\3\7\3\7\3\7\5\7\u0099\n\7\5\7\u009b\n\7\3\b\3\b\5\b\u009f\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00aa\n\t\3\n\5\n\u00ad\n\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00b6\n\13\3\f\3\f\3\f\3\f\5\f\u00bc"+
		"\n\f\3\r\3\r\3\16\3\16\5\16\u00c2\n\16\3\17\3\17\5\17\u00c6\n\17\3\20"+
		"\3\20\3\20\7\20\u00cb\n\20\f\20\16\20\u00ce\13\20\3\21\3\21\3\22\3\22"+
		"\3\22\7\22\u00d5\n\22\f\22\16\22\u00d8\13\22\3\23\3\23\5\23\u00dc\n\23"+
		"\3\24\3\24\5\24\u00e0\n\24\3\25\3\25\5\25\u00e4\n\25\3\26\3\26\3\26\3"+
		"\27\3\27\5\27\u00eb\n\27\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\2\4\3\2\"#\3\2\b\13\2\u00ff\2\60\3\2\2\2\4\63"+
		"\3\2\2\2\6M\3\2\2\2\bP\3\2\2\2\nU\3\2\2\2\f\u009a\3\2\2\2\16\u009e\3\2"+
		"\2\2\20\u00a9\3\2\2\2\22\u00ac\3\2\2\2\24\u00b5\3\2\2\2\26\u00b7\3\2\2"+
		"\2\30\u00bd\3\2\2\2\32\u00c1\3\2\2\2\34\u00c5\3\2\2\2\36\u00c7\3\2\2\2"+
		" \u00cf\3\2\2\2\"\u00d1\3\2\2\2$\u00db\3\2\2\2&\u00df\3\2\2\2(\u00e3\3"+
		"\2\2\2*\u00e5\3\2\2\2,\u00ea\3\2\2\2.\u00ec\3\2\2\2\60\61\5\4\3\2\61\62"+
		"\7\2\2\3\62\3\3\2\2\2\638\5\6\4\2\64\65\7\22\2\2\65\67\5\6\4\2\66\64\3"+
		"\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\5\3\2\2\2:8\3\2\2\2;<\5,\27"+
		"\2<=\7\34\2\2=B\5\b\5\2>?\7\23\2\2?A\5\b\5\2@>\3\2\2\2AD\3\2\2\2B@\3\2"+
		"\2\2BC\3\2\2\2CN\3\2\2\2DB\3\2\2\2EJ\5\n\6\2FG\7\23\2\2GI\5\n\6\2HF\3"+
		"\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2M;\3\2\2\2ME\3"+
		"\2\2\2N\7\3\2\2\2OQ\7\24\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\5\f\7\2S"+
		"\t\3\2\2\2TV\7\24\2\2UT\3\2\2\2UV\3\2\2\2VY\3\2\2\2WZ\5\f\7\2XZ\5\20\t"+
		"\2YW\3\2\2\2YX\3\2\2\2Z\13\3\2\2\2[\\\5\16\b\2\\]\7\25\2\2]^\5\n\6\2^"+
		"\u009b\3\2\2\2_`\5\16\b\2`a\7\26\2\2ab\5\n\6\2b\u009b\3\2\2\2cd\5\16\b"+
		"\2de\7\32\2\2ef\5$\23\2f\u009b\3\2\2\2gh\5\16\b\2hi\7\33\2\2i\u009b\3"+
		"\2\2\2jk\5\16\b\2kl\7\27\2\2ln\5 \21\2mo\5\n\6\2nm\3\2\2\2no\3\2\2\2o"+
		"\u009b\3\2\2\2pq\5\16\b\2qr\7\30\2\2rt\5 \21\2su\5\n\6\2ts\3\2\2\2tu\3"+
		"\2\2\2u\u009b\3\2\2\2vw\5\16\b\2wx\7\31\2\2xz\5 \21\2y{\5\n\6\2zy\3\2"+
		"\2\2z{\3\2\2\2{\u009b\3\2\2\2|}\5&\24\2}~\7\25\2\2~\177\5\22\n\2\177\u009b"+
		"\3\2\2\2\u0080\u0081\5&\24\2\u0081\u0082\7\26\2\2\u0082\u0083\5\22\n\2"+
		"\u0083\u009b\3\2\2\2\u0084\u0085\5&\24\2\u0085\u0086\7\32\2\2\u0086\u0087"+
		"\5\26\f\2\u0087\u009b\3\2\2\2\u0088\u0089\5&\24\2\u0089\u008a\7\27\2\2"+
		"\u008a\u008c\5 \21\2\u008b\u008d\5\22\n\2\u008c\u008b\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u009b\3\2\2\2\u008e\u008f\5&\24\2\u008f\u0090\7\30\2\2"+
		"\u0090\u0092\5 \21\2\u0091\u0093\5\22\n\2\u0092\u0091\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u009b\3\2\2\2\u0094\u0095\5&\24\2\u0095\u0096\7\31\2\2"+
		"\u0096\u0098\5 \21\2\u0097\u0099\5\22\n\2\u0098\u0097\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u009b\3\2\2\2\u009a[\3\2\2\2\u009a_\3\2\2\2\u009ac\3\2"+
		"\2\2\u009ag\3\2\2\2\u009aj\3\2\2\2\u009ap\3\2\2\2\u009av\3\2\2\2\u009a"+
		"|\3\2\2\2\u009a\u0080\3\2\2\2\u009a\u0084\3\2\2\2\u009a\u0088\3\2\2\2"+
		"\u009a\u008e\3\2\2\2\u009a\u0094\3\2\2\2\u009b\r\3\2\2\2\u009c\u009f\5"+
		"(\25\2\u009d\u009f\5*\26\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\17\3\2\2\2\u00a0\u00aa\5,\27\2\u00a1\u00a2\7\3\2\2\u00a2\u00a3\5\"\22"+
		"\2\u00a3\u00a4\7\4\2\2\u00a4\u00aa\3\2\2\2\u00a5\u00a6\7\5\2\2\u00a6\u00a7"+
		"\5\4\3\2\u00a7\u00a8\7\6\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a0\3\2\2\2\u00a9"+
		"\u00a1\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa\21\3\2\2\2\u00ab\u00ad\7\24\2"+
		"\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af"+
		"\5\24\13\2\u00af\23\3\2\2\2\u00b0\u00b6\5\32\16\2\u00b1\u00b2\7\3\2\2"+
		"\u00b2\u00b3\5\36\20\2\u00b3\u00b4\7\4\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b0"+
		"\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b6\25\3\2\2\2\u00b7\u00bb\5\30\r\2\u00b8"+
		"\u00bc\7!\2\2\u00b9\u00ba\7\7\2\2\u00ba\u00bc\5,\27\2\u00bb\u00b8\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\27\3\2\2\2\u00bd\u00be"+
		"\t\2\2\2\u00be\31\3\2\2\2\u00bf\u00c2\5\34\17\2\u00c0\u00c2\t\3\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\33\3\2\2\2\u00c3\u00c6\7\21\2"+
		"\2\u00c4\u00c6\5.\30\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\35"+
		"\3\2\2\2\u00c7\u00cc\5\26\f\2\u00c8\u00c9\7\f\2\2\u00c9\u00cb\5\26\f\2"+
		"\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\37\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\36\2\2\u00d0"+
		"!\3\2\2\2\u00d1\u00d6\5$\23\2\u00d2\u00d3\7\f\2\2\u00d3\u00d5\5$\23\2"+
		"\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7#\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\7\21\2\2\u00da"+
		"\u00dc\5.\30\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc%\3\2\2\2"+
		"\u00dd\u00e0\7\21\2\2\u00de\u00e0\5.\30\2\u00df\u00dd\3\2\2\2\u00df\u00de"+
		"\3\2\2\2\u00e0\'\3\2\2\2\u00e1\u00e4\7\21\2\2\u00e2\u00e4\5.\30\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4)\3\2\2\2\u00e5\u00e6\7\35\2\2"+
		"\u00e6\u00e7\5(\25\2\u00e7+\3\2\2\2\u00e8\u00eb\7\21\2\2\u00e9\u00eb\5"+
		".\30\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb-\3\2\2\2\u00ec\u00ed"+
		"\7 \2\2\u00ed/\3\2\2\2\358BJMPUYntz\u008c\u0092\u0098\u009a\u009e\u00a9"+
		"\u00ac\u00b5\u00bb\u00c1\u00c5\u00cc\u00d6\u00db\u00df\u00e3\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}