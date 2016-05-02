package org.redhelix.core.manager;

import org.redhelix.core.service.root.RedHxServiceRootIdEum;
import org.redhelix.core.util.RedHxAbstractJsonParseException;

public class RedHxManagerParseException extends RedHxAbstractJsonParseException {

	public RedHxManagerParseException(String message) {
		super(RedHxServiceRootIdEum.MANAGERS, message);
	}
}
