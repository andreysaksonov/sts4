package org.springframework.ide.vscode.commons.javadoc;

import java.nio.file.Paths;
import java.util.List;

import org.assertj.core.util.Files;
import org.junit.Test;
import org.springframework.ide.vscode.commons.javadoc.parser.AntlrParser;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.BlockTag;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.InlineTag;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.Node;
import org.springframework.ide.vscode.commons.javadoc.parser.JavadocAst.TextFragment;
import org.springframework.ide.vscode.commons.javadoc.parser.ParseResults;

public class JavadocParserTest {

	private AntlrParser parser = new AntlrParser();
	
	private void dumpAst(JavadocAst ast) {
		System.out.println("-------> DESCRIPTION <---------");
		dumpNodes(ast.description.fragments());
		System.out.println("-----------------------------");
		ast.tags.forEach(this::dumpTag);
	}
	
	private void dumpInlineTag(InlineTag t) {
		System.out.println("INLINE-TAG: name=" + t.getTagName());
		if (t.textFragment() != null) {
			System.out.println("\t`" + t.textFragment().getText() + "`");
		}
	}
	
	private void dumpTextFragment(Node<?> n) {
		System.out.println("`" + n.getText() + "`");
	}
	
	private void dumpNodes(List<Node<?>> nodes) {
		nodes.forEach(n -> {
			if (n instanceof InlineTag) {
				dumpInlineTag((InlineTag) n);
			} else if (n instanceof TextFragment) {
				dumpTextFragment(n);
			} else {
				System.out.println("!!! Unexpected fragment !!!" + n.getText());
			}
		});
	}
	
	private void dumpTag(BlockTag t) {
		System.out.println("TAG: name=" + t.getTagName());
		dumpNodes(t.fragments());
	}
	
	private void testJavadoc(String fileName) throws Exception {
		String content = Files.contentOf(Paths.get(getClass().getResource("/" + fileName).toURI()).toFile(), "utf-8");
		ParseResults results = parser.parse(content);
		dumpAst(results.ast);
	}
	
	@Test
	public void simpleJavadoc() throws Exception {
		testJavadoc("javadoc1.txt");
	}
}
