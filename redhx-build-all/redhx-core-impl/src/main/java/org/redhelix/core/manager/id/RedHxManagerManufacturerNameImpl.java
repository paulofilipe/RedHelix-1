package org.redhelix.core.manager.id;

import org.redhelix.core.util.RedHxAbstractStringProperty;

public class RedHxManagerManufacturerNameImpl extends RedHxAbstractStringProperty implements RedHxManagerManufacturerName {

	protected RedHxManagerManufacturerNameImpl(String propName) {
		super(MAX_CHAR_COUNT_RED_HELIX_DEFINED, propName);
	}

}
