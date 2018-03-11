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
package org.springframework.ide.vscode.boot.java.requestmapping;

import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.SymbolKind;
import org.springframework.ide.vscode.boot.java.handlers.EnhancedSymbolInformation;

/**
 * @author Martin Lippert
 */
public class RouteUtils {
	
	public static EnhancedSymbolInformation createRouteSymbol(Location location, String path,
			String[] httpMethods, String[] contentTypes, String[] acceptTypes, Object enhancedInformation) {
		
		if (path != null && path.length() > 0) {
			String label = "@" + (path.startsWith("/") ? path : ("/" + path));
			label += (httpMethods == null || httpMethods.length == 0 ? "" : " -- " + WebfluxUtils.getStringRep(httpMethods, string -> string));

			return new EnhancedSymbolInformation(new SymbolInformation(label, SymbolKind.Interface, location), enhancedInformation);
		}
		else {
			return null;
		}
		
	}

}