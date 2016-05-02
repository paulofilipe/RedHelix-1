package org.redhelix.core.manager;

import org.redhelix.core.util.RedHxUriPath;

/**
 *
 *
 *
 * @since RedHelix Version 0.1
 * @author Hank Bruning
 */
public interface RedHxManagerCollection extends Iterable<RedHxManager>{
	
	  boolean isEmpty();

	  int size();
	  
	  /**
	   * get a single manager.
	   *
	   * @param managerPath the path on the server implementing Redfish to a computer system.
	   * @return null if the path is not found in this class otherwise a manager.
	   */
	  RedHxManager getComputerSystem(RedHxUriPath managerPath);
}
