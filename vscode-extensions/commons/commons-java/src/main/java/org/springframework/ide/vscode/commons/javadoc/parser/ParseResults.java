/*******************************************************************************
 * Copyright (c) 2016 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.vscode.commons.javadoc.parser;

import java.util.List;

import org.springframework.ide.vscode.commons.javadoc.parser.AntlrParser.Problem;

/**
 * Results of parsing a text as Java Properties
 * 
 * @author Alex Boyko
 *
 */
public final class ParseResults {
	
	/**
	 * Resultant AST created based on parse tree
	 */
	final public JavadocAst ast;
	
	/**
	 * Any syntax errors discovered by the parser
	 */
	final public List<Problem> syntaxErrors;
	
	/**
	 * Any non-syntax problems discovered during parsing i.e. possible grammar problems such as ambiguity etc. 
	 */
	final public List<Problem> problems;
	
	public ParseResults(JavadocAst ast, List<Problem> syntaxErrors, List<Problem> problems) {
		this.ast = ast;
		this.syntaxErrors = syntaxErrors;
		this.problems = problems;
	}
	
}
