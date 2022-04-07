package it.tn.buonarroti.masala.quarta.CallCenter;
import it.tn.buonarroti.masala.quarta.stack.linkedList.LinkedList;


public class LinkedListOperators<T extends CallCenterOperator>{
	LinkedList<T> List;

	public LinkedListOperators(LinkedList set) {
		this.List = new LinkedList<>();
	}

	public void insert(T data) throws Exception {
		Integer isIn = isIn(data);
		if(isIn.equals(0)){
			this.List.append(data);
		} else {
			throw new Exception("The element is already in the set.");
		}
	}

	public void delete(T data) throws Exception {
		Integer isIn = isIn(data);
		if (isIn==0){
			List.deleteWithValue((T) data);
		} else {
			throw new Exception("The element is not in the set.");
		}

	}

	public Integer isIn(T data) {
		Boolean isIn = List.search(data);
		return (isIn ? 0 : -1);
	}

	public Integer cardinality(){
		return List.count();
	}

}
