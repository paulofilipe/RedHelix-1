package org.redhelix.core.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ManagerIterator<RedHxChassis> implements Iterator<RedHxChassis> {

	private final List<RedHxChassis> list;

	ManagerIterator(final List<RedHxChassis> list) {
		this.list = new ArrayList<>();
		this.list.addAll(list);
	}

	private ManagerIterator() {
		list = null;
	}

	@Override
	public boolean hasNext() {
		return !list.isEmpty();
	}

	@Override
	public RedHxChassis next() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			RedHxChassis chassis = list.remove(0);

			return chassis;
		}
	}
}