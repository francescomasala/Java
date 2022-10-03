package it.tn.buonarroti.masala.informatica.quarta.stack.linkedList;

public interface Stack<T> {

	//Metodi astratti pubblici
	void push(T element);

	T pop();

	T peek();

	int count();

}