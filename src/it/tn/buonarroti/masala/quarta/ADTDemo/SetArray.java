package it.tn.buonarroti.masala.quarta.ADTDemo;

public class SetArray <T> implements SetInterface<T> {

	private T[] set;
	private Integer cardinality;

	public SetArray(){
		this.set = (T[]) new Object[10];
		this.cardinality = 0;
	}

	/**
	 * @param data
	 */
	@Override
	public void insert(T data) throws Exception {
		if (isIn(data) < 0){
			if(this.cardinality >= set.length)
				resize();
			this.set[this.cardinality] = data;
			cardinality++;
		} else {
			throw new Exception("The element is already in the list");
		}
	}

	/**
	 *
	 */
	@Override
	public void delete(T data) throws Exception {
		Integer pos = isIn(data);
		if (pos >= 0){
			shiftSX(pos);
			cardinality--;
		} else {
			throw new Exception("The element is not in the set");
		}
	}

	/**
	 * @param data
	 * @return
	 */
	@Override
	public Integer isIn(T data) throws Exception {
		for(int i=0;i<cardinality;i++){
			if(set[i] == data)
		}

	}

	/**
	 * @return
	 */
	@Override
	public Integer cardinality() throws Exception {

	}

	private void resize() throws Exception {}

	private void shiftSX(Integer pos) throws Exception{}
}
