package it.tn.buonarroti.masala.quarta.stack.linkedList;

public class LinkedList<T> {
	public Node head;

	public LinkedList() {
		this.head = null;
	}

	public void append(T element) {
		if (this.head.equals(null)) {
			this.head = new Node<>(element);
		} else {
			Node slide = head;
			while (!slide.next.equals(null)) {
				slide = slide.next;
			}
			slide.next = new Node<>(element);
		}
	}

	public void prepend(T element) {
		Node headNew = new Node<>(element);
		headNew.next = this.head;
		this.head = headNew;
	}

	public void deleteWithValue(T element) {
		if (!this.head.equals(null)) {
			if (this.head.data.equals(element)) {
				this.head = this.head.next;
			} else {
				Node slide = this.head;
				while (!slide.next.equals(null)) {
					if (slide.next.data.equals(element)) {
						slide.next = slide.next.next;
					}
				}
			}
		}
	}

	public T getHead() {
		Node newHead = head.next;
		Node returnHead = head;
		head = newHead;
		return (T) returnHead.data;

	}

	public Integer count() {
		Node slide = head;
		Integer ctn = 0;
		while (!slide.next.equals(null)) { //Scorri tutto finche non trovo elemento
			slide = slide.next;
			ctn++;
		}
		return ctn;
	}
}
