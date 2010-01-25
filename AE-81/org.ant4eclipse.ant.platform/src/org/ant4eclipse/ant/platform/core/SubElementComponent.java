/**********************************************************************
 * Copyright (c) 2005-2009 ant4eclipse project team.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nils Hartmann, Daniel Kasmeroglu, Gerd Wuetherich
 **********************************************************************/
package org.ant4eclipse.ant.platform.core;

import org.apache.tools.ant.DynamicElement;

import java.util.List;

/**
 * <p>
 * Interface for all ant4eclipse tasks, conditions and types that have to deal with dynamic sub elements.
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface SubElementComponent extends DynamicElement {

  /**
   * <p>
   * Returns a list with all known sub elements.
   * </p>
   * 
   * @return a list with all known sub elements.
   */
  List<Object> getSubElements();
}
