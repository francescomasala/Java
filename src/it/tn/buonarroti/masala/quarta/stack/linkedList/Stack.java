package it.tn.buonarroti.masala.quarta.stack.linkedList;

public interface Stack<T> {

	//Metodi astratti pubblici
	public void push(T element);
	public T pop();
	public T peek();
	public int count();

}