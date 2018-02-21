/*******************************************************************************
 * Copyright (c) 2018 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.vscode.boot.java.links;

import java.nio.file.Path;
import java.util.Optional;

import org.springframework.ide.vscode.boot.java.BootJavaLanguageServerComponents;
import org.springframework.ide.vscode.commons.java.IJavaProject;
import org.springframework.ide.vscode.commons.languageserver.util.LspClient;

/**
 * Factory for creating {@link SourceLinks}
 * 
 * @author Alex Boyko
 *
 */
public final class SourceLinkFactory {
	
	private static final SourceLinks NO_SOURCE_LINKS = new SourceLinks() {
		
		@Override
		public Optional<String> sourceLinkUrlForFQName(IJavaProject project, String fqName) {
			return Optional.empty();
		}
		
		@Override
		public Optional<String> sourceLinkUrlForClasspathResource(IJavaProject project, String path) {
			return Optional.empty();
		}
		
		@Override
		public Optional<String> sourceLinkForResourcePath(Path path) {
			return Optional.empty();
		}
		
	};
	
	/**
	 * Creates {@link SourceLinks} for specific server based on client type
	 * @param server the boot LS
	 * @return appropriate source links object
	 */
	public static SourceLinks createSourceLinks(BootJavaLanguageServerComponents server) {
		switch (LspClient.currentClient()) {
		case VSCODE:
			return new VSCodeSourceLinks(server);
		case ECLIPSE:
			return new EclipseSourceLinks();
		default:
			return NO_SOURCE_LINKS;
		}

	}

}
