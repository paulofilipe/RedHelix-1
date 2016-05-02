package org.redhelix.core.manager.id;

import org.redhelix.core.util.RedHxAbstractStringProperty;

public class RedHxManagerNameImpl extends RedHxAbstractStringProperty implements RedHxManagerName {

	public RedHxManagerNameImpl(String propName) {
		super(MAX_CHAR_COUNT_RED_HELIX_DEFINED, propName);
	}

}
