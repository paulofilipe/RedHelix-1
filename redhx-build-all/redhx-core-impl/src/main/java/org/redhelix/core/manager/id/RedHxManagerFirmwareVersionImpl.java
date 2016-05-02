package org.redhelix.core.manager.id;

import org.redhelix.core.util.RedHxAbstractStringProperty;

public class RedHxManagerFirmwareVersionImpl extends RedHxAbstractStringProperty implements RedHxManagerFirmwareVersion {

	public RedHxManagerFirmwareVersionImpl(String propName) {
		super(MAX_CHAR_COUNT_RED_HELIX_DEFINED, propName);
	}


}
