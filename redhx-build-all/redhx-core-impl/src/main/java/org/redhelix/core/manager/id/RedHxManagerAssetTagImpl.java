package org.redhelix.core.manager.id;

import org.redhelix.core.util.RedHxAbstractStringProperty;

public class RedHxManagerAssetTagImpl extends RedHxAbstractStringProperty implements RedHxManagerAssetTag {

	protected RedHxManagerAssetTagImpl(String propName) {
		super(MAX_CHAR_COUNT_RED_HELIX_DEFINED, propName);
	}
}
