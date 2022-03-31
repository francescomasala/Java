package it.tn.buonarroti.masala.quarta.ADTDemo;

public interface SetInterface <T>{
	/**
	 * @param data
	 */
	public void insert(T data) throws Exception;

	public void delete(T data) throws Exception;

	/**
	 * @param data
	 * @return
	 */
	public Integer isIn(T data) throws Exception;

	/**
	 * @return
	 */
	public Integer cardinality() throws Exception;
}
