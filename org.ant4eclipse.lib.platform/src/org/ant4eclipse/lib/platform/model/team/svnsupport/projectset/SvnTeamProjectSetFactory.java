/**********************************************************************
 * Copyright (c) 2005-2008 ant4eclipse project team.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nils Hartmann, Daniel Kasmeroglu, Gerd Wuetherich
 **********************************************************************/
package org.ant4eclipse.lib.platform.model.team.svnsupport.projectset;

import org.ant4eclipse.lib.core.Assure;
import org.ant4eclipse.lib.core.exception.Ant4EclipseException;
import org.ant4eclipse.lib.platform.PlatformExceptionCode;
import org.ant4eclipse.lib.platform.model.team.projectset.TeamProjectSet;
import org.ant4eclipse.lib.platform.model.team.projectset.TeamProjectSetFactory;

/**
 * Parses a Project Set-File provided by the Subversive Eclipse Plugin and the Subclipse Eclipse Plugin
 * 
 * <p>
 * For the format of the Project Set-File see org.polarion.team.svn.core.SVNTeamProjectSetCapability in
 * org.polarion.team.server.core plugin.
 * 
 * <p>
 * For the format of the PSF of the subclipse plugin see org.tigris.subversion.subclipse.core.SVNProjectSetCapability in
 * the org.tigris.subversion.subclipse.core plugin
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 */
public class SvnTeamProjectSetFactory implements TeamProjectSetFactory {

  /**
   * Position of the repository URL in the reference string
   */
  public static final int URL          = 1;

  /**
   * Position of the project name in the reference string
   */
  public static final int PROJECT_NAME = 2;

  /**
   * {@inheritDoc}
   */
  public TeamProjectSet createTeamProjectSet(String projectSetName) {
    Assure.notNull("projectSetName", projectSetName);
    SvnTeamProjectSet svnTeamProjectSet = new SvnTeamProjectSet(projectSetName);
    return svnTeamProjectSet;
  }

  /**
   * {@inheritDoc}
   * <p>
   * Parses a "reference" in a subversion-Project Set file.
   * </p>
   */
  public void addTeamProjectDescription(TeamProjectSet projectSet, String reference) {
    Assure.instanceOf("projectSet", projectSet, SvnTeamProjectSet.class);
    Assure.notNull("reference", reference);

    SvnTeamProjectSet svnTeamProjectSet = (SvnTeamProjectSet) projectSet;

    String[] parts = reference.split(",");

    if (parts.length < 3) {
      throw new Ant4EclipseException(PlatformExceptionCode.INVALID_PSF_REFERENCE, "three", Integer
          .valueOf(parts.length), reference);
    }

    String url = parts[URL];
    String projectName = parts[PROJECT_NAME];

    SvnTeamProjectDescription svnTeamProjectDescription = new SvnTeamProjectDescription(svnTeamProjectSet, projectName,
        url);
    svnTeamProjectSet.addTeamProjectDescription(svnTeamProjectDescription);
  }
}
