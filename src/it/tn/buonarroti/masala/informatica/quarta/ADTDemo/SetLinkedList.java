package it.tn.buonarroti.masala.informatica.quarta.ADTDemo;

import it.tn.buonarroti.masala.informatica.quarta.stack.linkedList.LinkedList;

public class SetLinkedList<T> implements SetInterface<T> {

	LinkedList<T> set;

	public SetLinkedList(LinkedList set) {
		this.set = new LinkedList<>();
	}

	public void insert(T data) throws Exception {
		Integer isIn = isIn(data);
		if (isIn.equals(0)) {
			this.set.append(data);
		} else {
			throw new Exception("The element is already in the set.");
		}
	}

	public void delete(T data) throws Exception {
		Integer isIn = isIn(data);
		if (isIn == 0) {
			set.deleteWithValue(data);
		} else {
			throw new Exception("The element is not in the set.");
		}

	}

	public Integer isIn(T data) {
		Boolean isIn = set.search(data);
		return (isIn ? 0 : -1);
	}

	@Override
	public Integer cardinality() throws Exception {
		return set.count();
	}
}
