package org.redhelix.core.manager.id;

import org.redhelix.core.util.RedHxAbstractStringProperty;

public class RedHxManagerDescriptionImpl extends RedHxAbstractStringProperty implements RedHxManagerDescription  {

	public RedHxManagerDescriptionImpl(String propName) {
		super(MAX_CHAR_COUNT_RED_HELIX_DEFINED, propName);
	}

}
