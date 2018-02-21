package org.springframework.tooling.boot.java.ls.jdt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
import org.eclipse.jdt.internal.core.search.JavaSearchScope;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.springframework.tooling.boot.java.ls.BootJavaLanguageServerPlugin;

public class OpenFullyQualifiedNameInEditor extends AbstractHandler {
	
	private static final String FQ_NAME = "fqName";
	private static final String PROJECT_NAME = "projectName";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String fqName = event.getParameter(FQ_NAME);
		String projectName = event.getParameter(PROJECT_NAME);
		
		String packageName = "";
		String typeName = fqName;
		int idx = fqName.lastIndexOf('.');
		if (idx >= 0) {
			packageName = fqName.substring(0, idx);
			typeName = idx < fqName.length() - 1 ? fqName.substring(idx + 1) : ""; 
		}
		
		if (!typeName.isEmpty()) {
			SearchEngine engine= new SearchEngine((WorkingCopyOwner) null);
			List<TypeNameMatch> matches = new ArrayList<>();
			String searchedTypeName = getSearchedTypeName(typeName);
			final boolean isInnerType = searchedTypeName != typeName; 
			TypeNameMatchRequestor requestor = new TypeNameMatchRequestor() {
				@Override
				public void acceptTypeNameMatch(TypeNameMatch match) {
					if (isInnerType) {
						if (match.getFullyQualifiedName().equals(fqName.replace("$", "."))) {
							matches.add(match);
						}
					} else {
						matches.add(match);
					}
				}
			};
			try {
				IJavaSearchScope searchScope = createSearchScope(projectName);
				engine.searchAllTypeNames(packageName.toCharArray(), SearchPattern.R_EXACT_MATCH,
						searchedTypeName.toCharArray(), SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE, searchScope,
						requestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
				if (matches.isEmpty()) {
					BootJavaLanguageServerPlugin.getDefault().getLog().log(new Status(IStatus.WARNING, BootJavaLanguageServerPlugin.ID, "Cannot find type: " + fqName));
				} else {
					if (matches.size() > 1) {
						BootJavaLanguageServerPlugin.getDefault().getLog().log(new Status(IStatus.WARNING, BootJavaLanguageServerPlugin.ID, "More than one type is defined for: " + fqName));
					}
					try {
						IType type = matches.get(0).getType();
						IEditorPart editorPart= JavaUI.openInEditor(type);
						JavaUI.revealInEditor(editorPart, (IJavaElement)type);
					} catch (JavaModelException ex) {
						throw new ExecutionException("Error opening java element in editor", ex); //$NON-NLS-1$
					} catch (PartInitException ex) {
						throw new ExecutionException("Error opening java element in editor", ex); //$NON-NLS-1$
					}
				}
			} catch (JavaModelException e) {
				BootJavaLanguageServerPlugin.getDefault().getLog().log(e.getStatus());
			}
			
			
		}
		return null;
	}
	
	private String getSearchedTypeName(String typeName) {
		int idx = typeName.lastIndexOf('$');
		if (idx >= 0 && idx < typeName.length()) {
			return typeName.substring(idx + 1);
		}
		return typeName;
	}
	
	private IJavaSearchScope createSearchScope(String projectName) {
		try {
			if (projectName != null) {
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				if (project != null) {
					IJavaProject javaProject =  JavaCore.create(project);
					if (javaProject != null) {
						JavaSearchScope scope = new JavaSearchScope(false);
						scope.add(javaProject);
						return scope;
						
					}
				}
			}
		} catch (Throwable t) {
			BootJavaLanguageServerPlugin.getDefault().getLog().log(new Status(IStatus.WARNING, BootJavaLanguageServerPlugin.ID, "Failed creating Java search scope for project: " + projectName));
		}
		return SearchEngine.createWorkspaceScope();
	}
	
}
