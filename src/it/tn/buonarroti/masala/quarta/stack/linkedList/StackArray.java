package it.tn.buonarroti.masala.quarta.stack.linkedList;

public class StackArray<T> implements Stack<T> {

	Integer top;
	//Attributi
	private T[] stack;

	//Costruttore
	public StackArray() {
		stack = (T[]) new Object[8];
		top = -1;
	}

	//Metodi implementati da Stack
	public void push(T element) {

		//Spazio finito
		if (stack.length == top + 1) {
			doubleSize();
		}

		//aggiungi elemento
		stack[top + 1] = element;


	}

	public T pop() {

		//riduci spazio se serve
		if (((stack.length / 2) == top + 1) && stack.length > 8) {
			shrinkArray();
		}

		T data = stack[top];
		top--;

		return data;
	}

	public T peek() {
		return stack[top];
	}

	public int count() {
		return top;
	}

	private void doubleSize() {

		//Double size
		T[] newArray = (T[]) new Object[stack.length * 2];
		for (int i = 0; i < stack.length; i++) newArray[i] = stack[i];
		stack = newArray.clone();

	}

	private void shrinkArray() {

		T[] newArray = (T[]) new Object[stack.length / 2];
		for (int i = 0; i < newArray.length; i++) newArray[i] = stack[i];
		stack = newArray.clone();

	}


}