package org.redhelix.core.manager.id;

import org.redhelix.core.util.RedHxAbstractStringProperty;

public class RedHxManagerSerialNumberImpl extends RedHxAbstractStringProperty implements RedHxManagerSerialNumber {

	protected RedHxManagerSerialNumberImpl(String propName) {
		super(MAX_CHAR_COUNT_RED_HELIX_DEFINED, propName);
	}

}
