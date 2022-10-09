package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.primo;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		Object monitor = new Object();
		Semaphore BookSearch = new Semaphore(1, true);
		Semaphore BookBorrow = new Semaphore(2, true);
		Librarian librarian = new Librarian(BookSearch, BookBorrow);
		Students student1 = new Students(BookBorrow, BookSearch, 2);
		Students student2 = new Students(BookBorrow, BookSearch, 3);
		Library library = new Library(BookSearch, BookBorrow);

		Thread t1 = new Thread(librarian);
		Thread t2 = new Thread(student1);
		Thread t3 = new Thread(student2);
		Thread t4 = new Thread(library);

		t4.start();
		t1.start();
		t2.start();
		t3.start();


	}
}
