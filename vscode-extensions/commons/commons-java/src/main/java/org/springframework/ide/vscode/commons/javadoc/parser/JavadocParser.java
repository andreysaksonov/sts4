// Generated from Javadoc.g4 by ANTLR 4.5.3
package org.springframework.ide.vscode.commons.javadoc.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavadocParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAME=1, NEWLINE=2, SPACE=3, TEXT_CONTENT=4, AT=5, STAR=6, SLASH=7, JAVADOC_START=8, 
		JAVADOC_END=9, INLINE_TAG_START=10, BRACE_OPEN=11, BRACE_CLOSE=12;
	public static final int
		RULE_parse = 0, RULE_documentationContent = 1, RULE_skipWhitespace = 2, 
		RULE_description = 3, RULE_descriptionLine = 4, RULE_descriptionLineStart = 5, 
		RULE_descriptionLineLeadingText = 6, RULE_descriptionLineNoSpaceNoAt = 7, 
		RULE_descriptionLineElement = 8, RULE_descriptionLineText = 9, RULE_descriptionNewline = 10, 
		RULE_tagSection = 11, RULE_blockTag = 12, RULE_blockTagName = 13, RULE_blockTagContent = 14, 
		RULE_blockTagText = 15, RULE_blockTagTextElement = 16, RULE_inlineTag = 17, 
		RULE_inlineTagName = 18, RULE_inlineTagContent = 19, RULE_braceExpression = 20, 
		RULE_braceContent = 21, RULE_braceText = 22;
	public static final String[] ruleNames = {
		"parse", "documentationContent", "skipWhitespace", "description", "descriptionLine", 
		"descriptionLineStart", "descriptionLineLeadingText", "descriptionLineNoSpaceNoAt", 
		"descriptionLineElement", "descriptionLineText", "descriptionNewline", 
		"tagSection", "blockTag", "blockTagName", "blockTagContent", "blockTagText", 
		"blockTagTextElement", "inlineTag", "inlineTagName", "inlineTagContent", 
		"braceExpression", "braceContent", "braceText"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'@'", "'*'", "'/'", null, null, "'{@'", 
		"'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NAME", "NEWLINE", "SPACE", "TEXT_CONTENT", "AT", "STAR", "SLASH", 
		"JAVADOC_START", "JAVADOC_END", "INLINE_TAG_START", "BRACE_OPEN", "BRACE_CLOSE"
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
	public String getGrammarFileName() { return "Javadoc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavadocParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JavadocParser.EOF, 0); }
		public TerminalNode JAVADOC_START() { return getToken(JavadocParser.JAVADOC_START, 0); }
		public DocumentationContentContext documentationContent() {
			return getRuleContext(DocumentationContentContext.class,0);
		}
		public TerminalNode JAVADOC_END() { return getToken(JavadocParser.JAVADOC_END, 0); }
		public List<SkipWhitespaceContext> skipWhitespace() {
			return getRuleContexts(SkipWhitespaceContext.class);
		}
		public SkipWhitespaceContext skipWhitespace(int i) {
			return getRuleContext(SkipWhitespaceContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			int _alt;
			setState(67);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(EOF);
				}
				break;
			case JAVADOC_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(JAVADOC_START);
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(48);
						skipWhitespace();
						}
						} 
					}
					setState(53);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(54);
				documentationContent();
				setState(55);
				match(JAVADOC_END);
				setState(56);
				match(EOF);
				}
				break;
			case NAME:
			case NEWLINE:
			case SPACE:
			case TEXT_CONTENT:
			case AT:
			case STAR:
			case SLASH:
			case INLINE_TAG_START:
			case BRACE_OPEN:
			case BRACE_CLOSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(58);
						skipWhitespace();
						}
						} 
					}
					setState(63);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(64);
				documentationContent();
				setState(65);
				match(EOF);
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

	public static class DocumentationContentContext extends ParserRuleContext {
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public List<SkipWhitespaceContext> skipWhitespace() {
			return getRuleContexts(SkipWhitespaceContext.class);
		}
		public SkipWhitespaceContext skipWhitespace(int i) {
			return getRuleContext(SkipWhitespaceContext.class,i);
		}
		public TagSectionContext tagSection() {
			return getRuleContext(TagSectionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(JavadocParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JavadocParser.NEWLINE, i);
		}
		public DocumentationContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentationContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDocumentationContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDocumentationContent(this);
		}
	}

	public final DocumentationContentContext documentationContent() throws RecognitionException {
		DocumentationContentContext _localctx = new DocumentationContentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_documentationContent);
		int _la;
		try {
			int _alt;
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				description();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE || _la==SPACE) {
					{
					{
					setState(70);
					skipWhitespace();
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(76);
						skipWhitespace();
						}
						} 
					}
					setState(81);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(82);
				tagSection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				description();
				setState(85); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(84);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(87); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(89);
						skipWhitespace();
						}
						} 
					}
					setState(94);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(95);
				tagSection();
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

	public static class SkipWhitespaceContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(JavadocParser.SPACE, 0); }
		public TerminalNode NEWLINE() { return getToken(JavadocParser.NEWLINE, 0); }
		public SkipWhitespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipWhitespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterSkipWhitespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitSkipWhitespace(this);
		}
	}

	public final SkipWhitespaceContext skipWhitespace() throws RecognitionException {
		SkipWhitespaceContext _localctx = new SkipWhitespaceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_skipWhitespace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==NEWLINE || _la==SPACE) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class DescriptionContext extends ParserRuleContext {
		public List<DescriptionLineContext> descriptionLine() {
			return getRuleContexts(DescriptionLineContext.class);
		}
		public DescriptionLineContext descriptionLine(int i) {
			return getRuleContext(DescriptionLineContext.class,i);
		}
		public List<DescriptionNewlineContext> descriptionNewline() {
			return getRuleContexts(DescriptionNewlineContext.class);
		}
		public DescriptionNewlineContext descriptionNewline(int i) {
			return getRuleContext(DescriptionNewlineContext.class,i);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_description);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			descriptionLine();
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(102);
						descriptionNewline();
						}
						}
						setState(105); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(107);
					descriptionLine();
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class DescriptionLineContext extends ParserRuleContext {
		public DescriptionLineStartContext descriptionLineStart() {
			return getRuleContext(DescriptionLineStartContext.class,0);
		}
		public List<DescriptionLineElementContext> descriptionLineElement() {
			return getRuleContexts(DescriptionLineElementContext.class);
		}
		public DescriptionLineElementContext descriptionLineElement(int i) {
			return getRuleContext(DescriptionLineElementContext.class,i);
		}
		public InlineTagContext inlineTag() {
			return getRuleContext(InlineTagContext.class,0);
		}
		public DescriptionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescriptionLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescriptionLine(this);
		}
	}

	public final DescriptionLineContext descriptionLine() throws RecognitionException {
		DescriptionLineContext _localctx = new DescriptionLineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_descriptionLine);
		try {
			int _alt;
			setState(128);
			switch (_input.LA(1)) {
			case NAME:
			case SPACE:
			case TEXT_CONTENT:
			case STAR:
			case SLASH:
			case BRACE_OPEN:
			case BRACE_CLOSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				descriptionLineStart();
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(115);
						descriptionLineElement();
						}
						} 
					}
					setState(120);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				break;
			case INLINE_TAG_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				inlineTag();
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(122);
						descriptionLineElement();
						}
						} 
					}
					setState(127);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class DescriptionLineStartContext extends ParserRuleContext {
		public DescriptionLineLeadingTextContext descriptionLineLeadingText() {
			return getRuleContext(DescriptionLineLeadingTextContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(JavadocParser.SPACE, 0); }
		public List<DescriptionLineTextContext> descriptionLineText() {
			return getRuleContexts(DescriptionLineTextContext.class);
		}
		public DescriptionLineTextContext descriptionLineText(int i) {
			return getRuleContext(DescriptionLineTextContext.class,i);
		}
		public DescriptionLineStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescriptionLineStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescriptionLineStart(this);
		}
	}

	public final DescriptionLineStartContext descriptionLineStart() throws RecognitionException {
		DescriptionLineStartContext _localctx = new DescriptionLineStartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_descriptionLineStart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(130);
				match(SPACE);
				}
			}

			setState(133);
			descriptionLineLeadingText();
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(134);
					descriptionLineText();
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class DescriptionLineLeadingTextContext extends ParserRuleContext {
		public List<DescriptionLineNoSpaceNoAtContext> descriptionLineNoSpaceNoAt() {
			return getRuleContexts(DescriptionLineNoSpaceNoAtContext.class);
		}
		public DescriptionLineNoSpaceNoAtContext descriptionLineNoSpaceNoAt(int i) {
			return getRuleContext(DescriptionLineNoSpaceNoAtContext.class,i);
		}
		public DescriptionLineLeadingTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineLeadingText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescriptionLineLeadingText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescriptionLineLeadingText(this);
		}
	}

	public final DescriptionLineLeadingTextContext descriptionLineLeadingText() throws RecognitionException {
		DescriptionLineLeadingTextContext _localctx = new DescriptionLineLeadingTextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_descriptionLineLeadingText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(140);
					descriptionLineNoSpaceNoAt();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(143); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DescriptionLineNoSpaceNoAtContext extends ParserRuleContext {
		public TerminalNode TEXT_CONTENT() { return getToken(JavadocParser.TEXT_CONTENT, 0); }
		public TerminalNode NAME() { return getToken(JavadocParser.NAME, 0); }
		public TerminalNode STAR() { return getToken(JavadocParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(JavadocParser.SLASH, 0); }
		public TerminalNode BRACE_OPEN() { return getToken(JavadocParser.BRACE_OPEN, 0); }
		public TerminalNode BRACE_CLOSE() { return getToken(JavadocParser.BRACE_CLOSE, 0); }
		public DescriptionLineNoSpaceNoAtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineNoSpaceNoAt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescriptionLineNoSpaceNoAt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescriptionLineNoSpaceNoAt(this);
		}
	}

	public final DescriptionLineNoSpaceNoAtContext descriptionLineNoSpaceNoAt() throws RecognitionException {
		DescriptionLineNoSpaceNoAtContext _localctx = new DescriptionLineNoSpaceNoAtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_descriptionLineNoSpaceNoAt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << TEXT_CONTENT) | (1L << STAR) | (1L << SLASH) | (1L << BRACE_OPEN) | (1L << BRACE_CLOSE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class DescriptionLineElementContext extends ParserRuleContext {
		public InlineTagContext inlineTag() {
			return getRuleContext(InlineTagContext.class,0);
		}
		public DescriptionLineTextContext descriptionLineText() {
			return getRuleContext(DescriptionLineTextContext.class,0);
		}
		public DescriptionLineElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescriptionLineElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescriptionLineElement(this);
		}
	}

	public final DescriptionLineElementContext descriptionLineElement() throws RecognitionException {
		DescriptionLineElementContext _localctx = new DescriptionLineElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_descriptionLineElement);
		try {
			setState(149);
			switch (_input.LA(1)) {
			case INLINE_TAG_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				inlineTag();
				}
				break;
			case NAME:
			case SPACE:
			case TEXT_CONTENT:
			case AT:
			case STAR:
			case SLASH:
			case BRACE_OPEN:
			case BRACE_CLOSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				descriptionLineText();
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

	public static class DescriptionLineTextContext extends ParserRuleContext {
		public List<DescriptionLineNoSpaceNoAtContext> descriptionLineNoSpaceNoAt() {
			return getRuleContexts(DescriptionLineNoSpaceNoAtContext.class);
		}
		public DescriptionLineNoSpaceNoAtContext descriptionLineNoSpaceNoAt(int i) {
			return getRuleContext(DescriptionLineNoSpaceNoAtContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(JavadocParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(JavadocParser.SPACE, i);
		}
		public List<TerminalNode> AT() { return getTokens(JavadocParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(JavadocParser.AT, i);
		}
		public DescriptionLineTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionLineText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescriptionLineText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescriptionLineText(this);
		}
	}

	public final DescriptionLineTextContext descriptionLineText() throws RecognitionException {
		DescriptionLineTextContext _localctx = new DescriptionLineTextContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_descriptionLineText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(154);
					switch (_input.LA(1)) {
					case NAME:
					case TEXT_CONTENT:
					case STAR:
					case SLASH:
					case BRACE_OPEN:
					case BRACE_CLOSE:
						{
						setState(151);
						descriptionLineNoSpaceNoAt();
						}
						break;
					case SPACE:
						{
						setState(152);
						match(SPACE);
						}
						break;
					case AT:
						{
						setState(153);
						match(AT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(156); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DescriptionNewlineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(JavadocParser.NEWLINE, 0); }
		public DescriptionNewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionNewline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterDescriptionNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitDescriptionNewline(this);
		}
	}

	public final DescriptionNewlineContext descriptionNewline() throws RecognitionException {
		DescriptionNewlineContext _localctx = new DescriptionNewlineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_descriptionNewline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(NEWLINE);
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

	public static class TagSectionContext extends ParserRuleContext {
		public List<BlockTagContext> blockTag() {
			return getRuleContexts(BlockTagContext.class);
		}
		public BlockTagContext blockTag(int i) {
			return getRuleContext(BlockTagContext.class,i);
		}
		public TagSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterTagSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitTagSection(this);
		}
	}

	public final TagSectionContext tagSection() throws RecognitionException {
		TagSectionContext _localctx = new TagSectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tagSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				blockTag();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SPACE || _la==AT );
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

	public static class BlockTagContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(JavadocParser.AT, 0); }
		public BlockTagNameContext blockTagName() {
			return getRuleContext(BlockTagNameContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(JavadocParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(JavadocParser.SPACE, i);
		}
		public List<BlockTagContentContext> blockTagContent() {
			return getRuleContexts(BlockTagContentContext.class);
		}
		public BlockTagContentContext blockTagContent(int i) {
			return getRuleContext(BlockTagContentContext.class,i);
		}
		public BlockTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBlockTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBlockTag(this);
		}
	}

	public final BlockTagContext blockTag() throws RecognitionException {
		BlockTagContext _localctx = new BlockTagContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blockTag);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(165);
				match(SPACE);
				}
			}

			setState(168);
			match(AT);
			setState(169);
			blockTagName();
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(170);
				match(SPACE);
				}
				break;
			}
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173);
					blockTagContent();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class BlockTagNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(JavadocParser.NAME, 0); }
		public BlockTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBlockTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBlockTagName(this);
		}
	}

	public final BlockTagNameContext blockTagName() throws RecognitionException {
		BlockTagNameContext _localctx = new BlockTagNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blockTagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(NAME);
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

	public static class BlockTagContentContext extends ParserRuleContext {
		public BlockTagTextContext blockTagText() {
			return getRuleContext(BlockTagTextContext.class,0);
		}
		public InlineTagContext inlineTag() {
			return getRuleContext(InlineTagContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(JavadocParser.NEWLINE, 0); }
		public List<TerminalNode> SPACE() { return getTokens(JavadocParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(JavadocParser.SPACE, i);
		}
		public BlockTagContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBlockTagContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBlockTagContent(this);
		}
	}

	public final BlockTagContentContext blockTagContent() throws RecognitionException {
		BlockTagContentContext _localctx = new BlockTagContentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_blockTagContent);
		try {
			int _alt;
			setState(190);
			switch (_input.LA(1)) {
			case NAME:
			case SPACE:
			case TEXT_CONTENT:
			case STAR:
			case SLASH:
			case BRACE_OPEN:
			case BRACE_CLOSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				blockTagText();
				}
				break;
			case INLINE_TAG_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				inlineTag();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(NEWLINE);
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(184);
						match(SPACE);
						}
						} 
					}
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class BlockTagTextContext extends ParserRuleContext {
		public List<BlockTagTextElementContext> blockTagTextElement() {
			return getRuleContexts(BlockTagTextElementContext.class);
		}
		public BlockTagTextElementContext blockTagTextElement(int i) {
			return getRuleContext(BlockTagTextElementContext.class,i);
		}
		public BlockTagTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBlockTagText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBlockTagText(this);
		}
	}

	public final BlockTagTextContext blockTagText() throws RecognitionException {
		BlockTagTextContext _localctx = new BlockTagTextContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blockTagText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(192);
					blockTagTextElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(195); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class BlockTagTextElementContext extends ParserRuleContext {
		public TerminalNode TEXT_CONTENT() { return getToken(JavadocParser.TEXT_CONTENT, 0); }
		public TerminalNode NAME() { return getToken(JavadocParser.NAME, 0); }
		public TerminalNode SPACE() { return getToken(JavadocParser.SPACE, 0); }
		public TerminalNode STAR() { return getToken(JavadocParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(JavadocParser.SLASH, 0); }
		public TerminalNode BRACE_OPEN() { return getToken(JavadocParser.BRACE_OPEN, 0); }
		public TerminalNode BRACE_CLOSE() { return getToken(JavadocParser.BRACE_CLOSE, 0); }
		public BlockTagTextElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockTagTextElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBlockTagTextElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBlockTagTextElement(this);
		}
	}

	public final BlockTagTextElementContext blockTagTextElement() throws RecognitionException {
		BlockTagTextElementContext _localctx = new BlockTagTextElementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_blockTagTextElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << SPACE) | (1L << TEXT_CONTENT) | (1L << STAR) | (1L << SLASH) | (1L << BRACE_OPEN) | (1L << BRACE_CLOSE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class InlineTagContext extends ParserRuleContext {
		public TerminalNode INLINE_TAG_START() { return getToken(JavadocParser.INLINE_TAG_START, 0); }
		public InlineTagNameContext inlineTagName() {
			return getRuleContext(InlineTagNameContext.class,0);
		}
		public TerminalNode BRACE_CLOSE() { return getToken(JavadocParser.BRACE_CLOSE, 0); }
		public List<TerminalNode> SPACE() { return getTokens(JavadocParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(JavadocParser.SPACE, i);
		}
		public InlineTagContentContext inlineTagContent() {
			return getRuleContext(InlineTagContentContext.class,0);
		}
		public InlineTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterInlineTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitInlineTag(this);
		}
	}

	public final InlineTagContext inlineTag() throws RecognitionException {
		InlineTagContext _localctx = new InlineTagContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_inlineTag);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(INLINE_TAG_START);
			setState(200);
			inlineTagName();
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(201);
					match(SPACE);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(208);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << NEWLINE) | (1L << SPACE) | (1L << TEXT_CONTENT) | (1L << STAR) | (1L << SLASH) | (1L << BRACE_OPEN))) != 0)) {
				{
				setState(207);
				inlineTagContent();
				}
			}

			setState(210);
			match(BRACE_CLOSE);
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

	public static class InlineTagNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(JavadocParser.NAME, 0); }
		public InlineTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterInlineTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitInlineTagName(this);
		}
	}

	public final InlineTagNameContext inlineTagName() throws RecognitionException {
		InlineTagNameContext _localctx = new InlineTagNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_inlineTagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(NAME);
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

	public static class InlineTagContentContext extends ParserRuleContext {
		public List<BraceContentContext> braceContent() {
			return getRuleContexts(BraceContentContext.class);
		}
		public BraceContentContext braceContent(int i) {
			return getRuleContext(BraceContentContext.class,i);
		}
		public InlineTagContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTagContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterInlineTagContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitInlineTagContent(this);
		}
	}

	public final InlineTagContentContext inlineTagContent() throws RecognitionException {
		InlineTagContentContext _localctx = new InlineTagContentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_inlineTagContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(214);
				braceContent();
				}
				}
				setState(217); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << NEWLINE) | (1L << SPACE) | (1L << TEXT_CONTENT) | (1L << STAR) | (1L << SLASH) | (1L << BRACE_OPEN))) != 0) );
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

	public static class BraceExpressionContext extends ParserRuleContext {
		public TerminalNode BRACE_OPEN() { return getToken(JavadocParser.BRACE_OPEN, 0); }
		public TerminalNode BRACE_CLOSE() { return getToken(JavadocParser.BRACE_CLOSE, 0); }
		public List<BraceContentContext> braceContent() {
			return getRuleContexts(BraceContentContext.class);
		}
		public BraceContentContext braceContent(int i) {
			return getRuleContext(BraceContentContext.class,i);
		}
		public BraceExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBraceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBraceExpression(this);
		}
	}

	public final BraceExpressionContext braceExpression() throws RecognitionException {
		BraceExpressionContext _localctx = new BraceExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_braceExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(BRACE_OPEN);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << NEWLINE) | (1L << SPACE) | (1L << TEXT_CONTENT) | (1L << STAR) | (1L << SLASH) | (1L << BRACE_OPEN))) != 0)) {
				{
				{
				setState(220);
				braceContent();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			match(BRACE_CLOSE);
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

	public static class BraceContentContext extends ParserRuleContext {
		public BraceExpressionContext braceExpression() {
			return getRuleContext(BraceExpressionContext.class,0);
		}
		public List<BraceTextContext> braceText() {
			return getRuleContexts(BraceTextContext.class);
		}
		public BraceTextContext braceText(int i) {
			return getRuleContext(BraceTextContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(JavadocParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(JavadocParser.NEWLINE, i);
		}
		public BraceContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBraceContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBraceContent(this);
		}
	}

	public final BraceContentContext braceContent() throws RecognitionException {
		BraceContentContext _localctx = new BraceContentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_braceContent);
		try {
			int _alt;
			setState(242);
			switch (_input.LA(1)) {
			case BRACE_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				braceExpression();
				}
				break;
			case NAME:
			case NEWLINE:
			case SPACE:
			case TEXT_CONTENT:
			case STAR:
			case SLASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				braceText();
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(233);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(230);
								match(NEWLINE);
								}
								} 
							}
							setState(235);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
						}
						setState(236);
						braceText();
						}
						} 
					}
					setState(241);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class BraceTextContext extends ParserRuleContext {
		public TerminalNode TEXT_CONTENT() { return getToken(JavadocParser.TEXT_CONTENT, 0); }
		public TerminalNode NAME() { return getToken(JavadocParser.NAME, 0); }
		public TerminalNode SPACE() { return getToken(JavadocParser.SPACE, 0); }
		public TerminalNode STAR() { return getToken(JavadocParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(JavadocParser.SLASH, 0); }
		public TerminalNode NEWLINE() { return getToken(JavadocParser.NEWLINE, 0); }
		public BraceTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).enterBraceText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavadocListener ) ((JavadocListener)listener).exitBraceText(this);
		}
	}

	public final BraceTextContext braceText() throws RecognitionException {
		BraceTextContext _localctx = new BraceTextContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_braceText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << NEWLINE) | (1L << SPACE) | (1L << TEXT_CONTENT) | (1L << STAR) | (1L << SLASH))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16\u00f9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\2\3\2\3\2\7\2>\n\2\f\2\16\2A"+
		"\13\2\3\2\3\2\3\2\5\2F\n\2\3\3\3\3\7\3J\n\3\f\3\16\3M\13\3\3\3\7\3P\n"+
		"\3\f\3\16\3S\13\3\3\3\3\3\3\3\6\3X\n\3\r\3\16\3Y\3\3\7\3]\n\3\f\3\16\3"+
		"`\13\3\3\3\3\3\5\3d\n\3\3\4\3\4\3\5\3\5\6\5j\n\5\r\5\16\5k\3\5\3\5\7\5"+
		"p\n\5\f\5\16\5s\13\5\3\6\3\6\7\6w\n\6\f\6\16\6z\13\6\3\6\3\6\7\6~\n\6"+
		"\f\6\16\6\u0081\13\6\5\6\u0083\n\6\3\7\5\7\u0086\n\7\3\7\3\7\7\7\u008a"+
		"\n\7\f\7\16\7\u008d\13\7\3\b\6\b\u0090\n\b\r\b\16\b\u0091\3\t\3\t\3\n"+
		"\3\n\5\n\u0098\n\n\3\13\3\13\3\13\6\13\u009d\n\13\r\13\16\13\u009e\3\f"+
		"\3\f\3\r\6\r\u00a4\n\r\r\r\16\r\u00a5\3\16\5\16\u00a9\n\16\3\16\3\16\3"+
		"\16\5\16\u00ae\n\16\3\16\7\16\u00b1\n\16\f\16\16\16\u00b4\13\16\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\7\20\u00bc\n\20\f\20\16\20\u00bf\13\20\5\20\u00c1"+
		"\n\20\3\21\6\21\u00c4\n\21\r\21\16\21\u00c5\3\22\3\22\3\23\3\23\3\23\7"+
		"\23\u00cd\n\23\f\23\16\23\u00d0\13\23\3\23\5\23\u00d3\n\23\3\23\3\23\3"+
		"\24\3\24\3\25\6\25\u00da\n\25\r\25\16\25\u00db\3\26\3\26\7\26\u00e0\n"+
		"\26\f\26\16\26\u00e3\13\26\3\26\3\26\3\27\3\27\3\27\7\27\u00ea\n\27\f"+
		"\27\16\27\u00ed\13\27\3\27\7\27\u00f0\n\27\f\27\16\27\u00f3\13\27\5\27"+
		"\u00f5\n\27\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\2\6\3\2\4\5\6\2\3\3\6\6\b\t\r\16\6\2\3\3\5\6\b\t\r\16\4\2"+
		"\3\6\b\t\u0106\2E\3\2\2\2\4c\3\2\2\2\6e\3\2\2\2\bg\3\2\2\2\n\u0082\3\2"+
		"\2\2\f\u0085\3\2\2\2\16\u008f\3\2\2\2\20\u0093\3\2\2\2\22\u0097\3\2\2"+
		"\2\24\u009c\3\2\2\2\26\u00a0\3\2\2\2\30\u00a3\3\2\2\2\32\u00a8\3\2\2\2"+
		"\34\u00b5\3\2\2\2\36\u00c0\3\2\2\2 \u00c3\3\2\2\2\"\u00c7\3\2\2\2$\u00c9"+
		"\3\2\2\2&\u00d6\3\2\2\2(\u00d9\3\2\2\2*\u00dd\3\2\2\2,\u00f4\3\2\2\2."+
		"\u00f6\3\2\2\2\60F\7\2\2\3\61\65\7\n\2\2\62\64\5\6\4\2\63\62\3\2\2\2\64"+
		"\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\5"+
		"\4\3\29:\7\13\2\2:;\7\2\2\3;F\3\2\2\2<>\5\6\4\2=<\3\2\2\2>A\3\2\2\2?="+
		"\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\5\4\3\2CD\7\2\2\3DF\3\2\2\2E"+
		"\60\3\2\2\2E\61\3\2\2\2E?\3\2\2\2F\3\3\2\2\2GK\5\b\5\2HJ\5\6\4\2IH\3\2"+
		"\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2Ld\3\2\2\2MK\3\2\2\2NP\5\6\4\2ON\3\2"+
		"\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2Td\5\30\r\2UW\5"+
		"\b\5\2VX\7\4\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z^\3\2\2\2[]\5"+
		"\6\4\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2a"+
		"b\5\30\r\2bd\3\2\2\2cG\3\2\2\2cQ\3\2\2\2cU\3\2\2\2d\5\3\2\2\2ef\t\2\2"+
		"\2f\7\3\2\2\2gq\5\n\6\2hj\5\26\f\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2"+
		"\2\2lm\3\2\2\2mn\5\n\6\2np\3\2\2\2oi\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2"+
		"\2\2r\t\3\2\2\2sq\3\2\2\2tx\5\f\7\2uw\5\22\n\2vu\3\2\2\2wz\3\2\2\2xv\3"+
		"\2\2\2xy\3\2\2\2y\u0083\3\2\2\2zx\3\2\2\2{\177\5$\23\2|~\5\22\n\2}|\3"+
		"\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0083\3\2\2"+
		"\2\u0081\177\3\2\2\2\u0082t\3\2\2\2\u0082{\3\2\2\2\u0083\13\3\2\2\2\u0084"+
		"\u0086\7\5\2\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u008b\5\16\b\2\u0088\u008a\5\24\13\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\r\3\2\2\2"+
		"\u008d\u008b\3\2\2\2\u008e\u0090\5\20\t\2\u008f\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\17\3\2\2\2\u0093"+
		"\u0094\t\3\2\2\u0094\21\3\2\2\2\u0095\u0098\5$\23\2\u0096\u0098\5\24\13"+
		"\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\23\3\2\2\2\u0099\u009d"+
		"\5\20\t\2\u009a\u009d\7\5\2\2\u009b\u009d\7\7\2\2\u009c\u0099\3\2\2\2"+
		"\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\25\3\2\2\2\u00a0\u00a1\7\4\2\2\u00a1"+
		"\27\3\2\2\2\u00a2\u00a4\5\32\16\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00a9"+
		"\7\5\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\7\7\2\2\u00ab\u00ad\5\34\17\2\u00ac\u00ae\7\5\2\2\u00ad\u00ac\3"+
		"\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b2\3\2\2\2\u00af\u00b1\5\36\20\2\u00b0"+
		"\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\33\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\3\2\2\u00b6\35"+
		"\3\2\2\2\u00b7\u00c1\5 \21\2\u00b8\u00c1\5$\23\2\u00b9\u00bd\7\4\2\2\u00ba"+
		"\u00bc\7\5\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00b7\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00b9\3\2\2\2\u00c1\37\3\2\2"+
		"\2\u00c2\u00c4\5\"\22\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6!\3\2\2\2\u00c7\u00c8\t\4\2\2"+
		"\u00c8#\3\2\2\2\u00c9\u00ca\7\f\2\2\u00ca\u00ce\5&\24\2\u00cb\u00cd\7"+
		"\5\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\5("+
		"\25\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\7\16\2\2\u00d5%\3\2\2\2\u00d6\u00d7\7\3\2\2\u00d7\'\3\2\2\2\u00d8"+
		"\u00da\5,\27\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc)\3\2\2\2\u00dd\u00e1\7\r\2\2\u00de\u00e0"+
		"\5,\27\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7\16"+
		"\2\2\u00e5+\3\2\2\2\u00e6\u00f5\5*\26\2\u00e7\u00f1\5.\30\2\u00e8\u00ea"+
		"\7\4\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\5."+
		"\30\2\u00ef\u00eb\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00e6\3\2"+
		"\2\2\u00f4\u00e7\3\2\2\2\u00f5-\3\2\2\2\u00f6\u00f7\t\5\2\2\u00f7/\3\2"+
		"\2\2#\65?EKQY^ckqx\177\u0082\u0085\u008b\u0091\u0097\u009c\u009e\u00a5"+
		"\u00a8\u00ad\u00b2\u00bd\u00c0\u00c5\u00ce\u00d2\u00db\u00e1\u00eb\u00f1"+
		"\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}