package org.springframework.ide.vscode.commons.javadoc.parser;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.BlockTag;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.Description;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.InlineTag;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.Node;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.TextFragment;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.BlockTagContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.BlockTagTextContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.DescriptionContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.DescriptionLineStartContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.DescriptionLineTextContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.InlineTagContext;

import com.google.common.collect.ImmutableList;

public class AntlrParser {
	
	public interface Problem {
		
		String getMessage();
		
		int getStart();
		
		int getEnd();
		
	}
	
	public ParseResults parse(String text) {
		ArrayList<Problem> syntaxErrors = new ArrayList<>();
		ArrayList<Problem> problems = new ArrayList<>();
		JavadocAst ast = new JavadocAst();
		ast.tags = new ArrayList<>();

		JavadocLexer lexer = new JavadocLexer(new ANTLRInputStream(text.toCharArray(), text.length()));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    JavadocParser parser = new JavadocParser(tokens);
	    
	    // To avoid printing parse errors in the console
		parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
	    
	    // Add listener to collect various parser errors
	    parser.addErrorListener(new ANTLRErrorListener() {

			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				syntaxErrors.add(createProblem(msg, (Token) offendingSymbol));
			}

			@Override
			public void reportAmbiguity(org.antlr.v4.runtime.Parser recognizer, DFA dfa, int startIndex, int stopIndex,
					boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
				problems.add(createProblem("Ambiguity detected!", recognizer.getCurrentToken()));
			}

			@Override
			public void reportAttemptingFullContext(org.antlr.v4.runtime.Parser recognizer, DFA dfa, int startIndex,
					int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
				problems.add(createProblem("Full-Context attempt detected!", recognizer.getCurrentToken()));
			}

			@Override
			public void reportContextSensitivity(org.antlr.v4.runtime.Parser recognizer, DFA dfa, int startIndex,
					int stopIndex, int prediction, ATNConfigSet configs) {
				problems.add(createProblem("Context sensitivity detected!", recognizer.getCurrentToken()));
			}
	    	
	    });
	    
	    // Add listener to the parse tree to collect AST nodes
	    parser.addParseListener(new JavadocBaseListener() {
	    	
	    	private List<Node<?>> fragments = new ArrayList<>();
	    	private boolean enteredDescriptionLineStart = false;

			@Override
			public void exitDescription(DescriptionContext ctx) {
				ast.description = new Description(ctx, fragments);
				fragments = new ArrayList<>();
				super.exitDescription(ctx);
			}

			
			@Override
			public void enterDescriptionLineStart(DescriptionLineStartContext ctx) {
				enteredDescriptionLineStart = true;
				super.enterDescriptionLineStart(ctx);
			}

			@Override
			public void exitDescriptionLineStart(DescriptionLineStartContext ctx) {
				if (ctx.descriptionLineLeadingText() != null) {
					fragments.add(new TextFragment(ctx.descriptionLineLeadingText()));
				}
				if (ctx.descriptionLineText() != null) {
					fragments.addAll(
							ctx.descriptionLineText().stream().map(c -> new TextFragment(c)).collect(Collectors.toList()));
				}
				enteredDescriptionLineStart = false;
				super.exitDescriptionLineStart(ctx);
			}

			@Override
			public void exitInlineTag(InlineTagContext ctx) {
				fragments.add(new InlineTag(ctx));
				super.exitInlineTag(ctx);
			}

			@Override
			public void exitDescriptionLineText(DescriptionLineTextContext ctx) {
				if (!enteredDescriptionLineStart) {
					fragments.add(new TextFragment(ctx));
				}
				super.exitDescriptionLineText(ctx);
			}

			@Override
			public void exitBlockTag(BlockTagContext ctx) {
				ast.tags.add(new BlockTag(ctx, fragments));
				fragments = new ArrayList<>();
				super.exitBlockTag(ctx);
			}

			@Override
			public void exitBlockTagText(BlockTagTextContext ctx) {
				if (!ctx.getText().isEmpty()) {
					fragments.add(new TextFragment(ctx));
				}
				super.exitBlockTagText(ctx);
			}

		});

	    parser.parse();
	    
	    // Collect and return parse results
	    return new ParseResults(ast, ImmutableList.copyOf(syntaxErrors), ImmutableList.copyOf(problems));
	}
	
	private Problem createProblem(String message, Token token) {
		return new Problem() {

			@Override
			public String getMessage() {
				return message;
			}

			@Override
			public int getStart() {
				return token.getStartIndex();
			}

			@Override
			public int getEnd() {
				return token.getStopIndex();
			}
			
		};
	}


}
