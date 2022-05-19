package it.tn.buonarroti.masala.quarta.ADTDemo;

public class SetArray<T> implements SetInterface<T> {

	private T[] set;
	private Integer cardinality;

	public SetArray() {
		this.set = (T[]) new Object[10];
		this.cardinality = 0;
	}

	/**
	 * @param data
	 */
	public void insert(Object data) throws Exception {
		if (isIn(data) < 0) {
			if (this.cardinality >= set.length)
				resize();
			this.set[this.cardinality] = (T) data;
			cardinality++;
		} else {
			throw new Exception("The element is already in the list");
		}
	}

	/**
	 * @param data
	 */
	@Override
	public void delete(Object data) throws Exception {
		Integer pos = isIn(data);
		if (pos >= 0) {
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
	public Integer isIn(Object data) {
		Integer pos = -1, i = 0;
		Boolean found = false;

		while (i < set.length && !found) {
			if (set[i] == data) {
				found = true;
			} else {
				i++;
			}
		}

		if (found) pos = i;
		else pos = -1;
		return pos;
	}

	/**
	 * @return
	 */
	@Override
	public Integer cardinality() {
		return cardinality;
	}

	private void resize() {
		T[] support = (T[]) new Object[set.length ^ 2];
		for (int i = 0; i < set.length; i++) {
			support[i] = set[i];
		}
		set = support.clone();
	}

	private void shiftSX(Integer pos) {
		for (int i = pos; i < set.length - 1; i++) {
			set[i] = set[i + 1];
		}
	}
}
