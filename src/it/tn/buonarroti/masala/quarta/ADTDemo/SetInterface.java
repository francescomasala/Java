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
	public Boolean isIn(T data) throws Exception;

	/**
	 * @return
	 */
	public Integer cardinality() throws Exception;
}
