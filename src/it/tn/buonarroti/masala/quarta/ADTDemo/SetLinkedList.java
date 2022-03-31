package it.tn.buonarroti.masala.quarta.ADTDemo;

import it.tn.buonarroti.masala.quarta.stack.linkedList.LinkedList;

public class SetLinkedList<T> implements SetInterface<T>{

	T[] set;

	public SetLinkedList(LinkedList set){
		this.set = new LinkedList<>();
	}

	@Override
	public void insert(T data) throws Exception {
		if (isIn(data)){
			this.set.append(data);
		} else {
			throw new Exception("The element is already in the set");
		}
	}

	@Override
	public void delete(T data) throws Exception {
		Boolean pos = isIn(data);
		if (pos) {
			set.deleteWithValue(data);
		} else{
			throw new Exception("The element is not in the set");
		}


	}

	@Override
	public Integer isIn(T data) throws Exception {
		Integer pos = -1, i = 0;
		Boolean found = false;

		while(i < set.length && !found){
			if(set[i] == data){
				found = true;
			} else {
				i++;
			}
		}

		if(found) pos = i; else pos = -1;
		return pos;
	}

	@Override
	public Integer cardinality() throws Exception {
		return this.cardinality;
	}

	private void resize() throws Exception {

		T[] supporto = (T[]) new Object[set.length^2];
		for(int i = 0; i < set.length; i++){
			supporto[i] = set[i];
		}

		set = supporto.clone();

	}

	private void shiftSX(Integer pos) throws Exception{
		for (int i = pos; i < set.length-1; i++){
			set[i] = set[i+1];
		}
	}
}
