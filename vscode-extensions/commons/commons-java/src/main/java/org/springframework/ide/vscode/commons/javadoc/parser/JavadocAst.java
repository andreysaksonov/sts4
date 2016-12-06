package org.springframework.ide.vscode.commons.javadoc.parser;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.BlockTagContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.DescriptionContext;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocParser.InlineTagContext;

public  class JavadocAst {
	
	public static class Node<T extends ParserRuleContext> {
		
		protected T context;
		
		public Node(T context) {
			this.context = context;
		}
		
		public String getText() {
			return context.getText();
		}
		
		public int getStart() {
			return context.getStart().getStartIndex();
		}
		
		public int getEnd() {
			return context.getStop().getStartIndex();
		}
		
	}
	
	public static class TextFragment extends Node<ParserRuleContext> {
		
		public TextFragment(ParserRuleContext context) {
			super(context);
		}
		
	}
	
	public static class InlineTag extends Node<InlineTagContext>{
		
		public InlineTag(InlineTagContext context) {
			super(context);
		}
		
		public String getTagName() {
			return context.inlineTagName().getText();
		}
		
		public TextFragment textFragment() {
			if (context.inlineTagContent() == null) {
				return null;
			}
			return new TextFragment(context.inlineTagContent());
		}
		
	}
	
	public static class BlockTag extends Node<BlockTagContext> {
		
		private List<Node<?>> fragments;

		public BlockTag(BlockTagContext context, List<Node<?>> fragments) {
			super(context);
			this.fragments = fragments;
		}
		
		public List<Node<?>> fragments() {
			return fragments;
		}
		
		public String getTagName() {
			return context.blockTagName().getText();
		}
		
	}
	
	public static class Description extends Node<DescriptionContext> {

		private List<Node<?>> fragments;

		public Description(DescriptionContext context, List<Node<?>> fragments) {
			super(context);
			this.fragments = fragments;
		}
		
		public List<Node<?>> fragments() {
			return fragments;
		}
		
	}
	
	public Description description;
	public List<BlockTag> tags;
	
}
