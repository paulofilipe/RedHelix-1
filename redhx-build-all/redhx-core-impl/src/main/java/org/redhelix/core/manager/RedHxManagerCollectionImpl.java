package org.redhelix.core.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.redhelix.core.util.RedHxUriPath;

public class RedHxManagerCollectionImpl implements RedHxManagerCollection {

	private final List<RedHxManager> list;

	public RedHxManagerCollectionImpl(final List<RedHxManager> list) {
		this.list = Collections.unmodifiableList(list);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedHxManagerCollectionImpl other = (RedHxManagerCollectionImpl) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public Iterator<RedHxManager> iterator() {
		ManagerIterator<RedHxManager> iter = new ManagerIterator<>(list);
		return iter;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public RedHxManager getComputerSystem(RedHxUriPath managerPath) {
		RedHxManager retVal = null;
		for (RedHxManager cs : list) {
			if (cs.getManagerPath().equals(managerPath)) {
				retVal = cs;
				break;
			}

		}
		return retVal;
	}

}
