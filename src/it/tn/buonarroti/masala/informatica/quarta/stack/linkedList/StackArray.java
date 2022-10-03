package it.tn.buonarroti.masala.informatica.quarta.stack.linkedList;

public class StackArray<T> implements Stack<T> {

	Integer top;
	private T[] stack;

	public StackArray() {
		stack = (T[]) new Object[8];
		top = -1;
	}

	public void push(T element) {
		if (stack.length == top + 1) {
			doubleSize();
		}
		stack[top + 1] = element;
	}

	public T pop() {
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
		T[] newArray = (T[]) new Object[stack.length * 2];
		System.arraycopy(stack, 0, newArray, 0, stack.length);
		stack = newArray.clone();

	}

	private void shrinkArray() {
		T[] newArray = (T[]) new Object[stack.length / 2];
		System.arraycopy(stack, 0, newArray, 0, newArray.length);
		stack = newArray.clone();
	}


}