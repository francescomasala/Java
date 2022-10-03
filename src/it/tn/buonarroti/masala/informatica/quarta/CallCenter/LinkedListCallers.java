package it.tn.buonarroti.masala.informatica.quarta.CallCenter;

import it.tn.buonarroti.masala.informatica.quarta.stack.linkedList.LinkedList;


public class LinkedListCallers<T extends CallCenterCaller> {
	LinkedList<T> List;

	public LinkedListCallers(LinkedList set) {
		this.List = new LinkedList<>();
	}

	public void insert(T data) throws Exception {
		Integer isIn = isIn(data);
		if (isIn.equals(0)) {
			this.List.append(data);
		} else {
			throw new Exception("The element is already in the set.");
		}
	}

	public void delete(T data) throws Exception {
		Integer isIn = isIn(data);
		if (isIn == 0) {
			List.deleteWithValue(data);
		} else {
			throw new Exception("The element is not in the set.");
		}

	}

	public Integer isIn(T data) {
		Boolean isIn = List.search(data);
		return (isIn ? 0 : -1);
	}

	public Integer cardinality() {
		return List.count();
	}
}
