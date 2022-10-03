package it.tn.buonarroti.masala.informatica.quarta.stack.linkedList;

public class queue<T> {
	public LinkedList<T> list;

	public queue() {
		list = new LinkedList<>();
	}

	public void enqueue(T element) {
		list.append(element);
	}

	public T dequeue() {
		T element = list.getHead();
		list.deleteWithValue(element);
		return element;
	}

	public Integer elementCount() {
		return list.count();
	}

}
