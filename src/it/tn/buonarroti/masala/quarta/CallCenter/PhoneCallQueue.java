package it.tn.buonarroti.masala.quarta.CallCenter;

import it.tn.buonarroti.masala.quarta.stack.linkedList.LinkedList;

public class PhoneCallQueue<T> {
	LinkedList<T> set;

	public PhoneCallQueue(LinkedList set) {
		this.set = new LinkedList<>();
	}

	public void insert(T data) throws Exception {
		Integer isIn = isIn(data);
		if(isIn.equals(0)){
			this.set.append(data);
		} else {
			throw new Exception("The element is already in the set.");
		}
	}

	public void delete(T data) throws Exception {
		Integer isIn = isIn(data);
		if (isIn==0){
			set.deleteWithValue(data);
		} else {
			throw new Exception("The element is not in the set.");
		}

	}

	public Integer isIn(T data) {
		Boolean isIn = set.search(data);
		return (isIn ? 0 : -1);
	}

	public Integer cardinality() throws Exception {
		return set.count();
	}
}
