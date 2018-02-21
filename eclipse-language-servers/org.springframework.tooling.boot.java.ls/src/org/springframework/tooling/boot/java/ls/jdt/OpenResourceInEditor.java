package org.springframework.tooling.boot.java.ls.jdt;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class OpenResourceInEditor extends AbstractHandler {
	
	private static final String PATH = "path";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath rootPath = root.getLocation();
		IPath resourcePath = new Path(event.getParameter(PATH));
		
		IResource resource = root.findMember(resourcePath.makeRelativeTo(rootPath));
		
		if (resource == null && !(resource instanceof IFile)) {
			throw new ExecutionException("cannot find file: " + event.getParameter(PATH)); //$NON-NLS-1$
		}
		
		final IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window == null) {
			throw new ExecutionException("no active workbench window"); //$NON-NLS-1$
		}

		final IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			throw new ExecutionException("no active workbench page"); //$NON-NLS-1$
		}

		try {
			IDE.openEditor(page, (IFile) resource, true);
		} catch (final PartInitException e) {
			throw new ExecutionException("error opening file in editor", e); //$NON-NLS-1$
		}

		return null;
	}


}
