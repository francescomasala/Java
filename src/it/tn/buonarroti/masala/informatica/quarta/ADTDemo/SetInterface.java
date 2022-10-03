package it.tn.buonarroti.masala.informatica.quarta.ADTDemo;

public interface SetInterface<T> {
	/**
	 * @param data
	 */
	void insert(T data) throws Exception;

	void delete(T data) throws Exception;

	/**
	 * @param data
	 * @return
	 */
	Integer isIn(T data);

	Integer cardinality() throws Exception;
}
