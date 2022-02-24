package it.tn.buonarroti.masala.quarta.stack.linkedList;

public class linkedList<T> {
	public Node head;

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
}
