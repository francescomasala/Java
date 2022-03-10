package it.tn.buonarroti.masala.quarta.stack.linkedList;

public class StackLinkedList<T> implements Stack<T> {

	//Attributi
	LinkedList<T> stack;

	//Metodi implementati da Stack
	public void push(T element) {
		if (element != null) {
			stack.prepend(element);
		}
	}

	public T pop() {

		T data = stack.getHead();
		stack.deleteWithValue(data); //Ottengo la testa ed elimino

		return data;
	}

	public T peek() {

		T data = stack.getHead();

		return data;
	}

	public int count() {
		return stack.count();
	}


}