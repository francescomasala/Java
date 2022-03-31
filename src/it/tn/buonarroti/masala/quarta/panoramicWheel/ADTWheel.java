package it.tn.buonarroti.masala.quarta.panoramicWheel;


public interface ADTWheel<T> {
	void add(T obj) throws Exception;

	T remove() throws Exception;

	T peek() throws Exception;

	void next();
}
