package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.primo;

import java.util.concurrent.Semaphore;

public class Librarian implements Runnable {
	protected Semaphore BookSearch;
	protected Semaphore BookBorrow;

	public Librarian(Semaphore BookSearch, Semaphore BookBorrow) {
		this.BookSearch = BookSearch;
		this.BookBorrow = BookBorrow;
	}


	@Override
	public void run() {
		while (true) {
			if (BookBorrow.getQueueLength() >= 0) {
				try {
					System.out.println("[LIB] - I'm working!");
					BookSearch.acquire();
					System.out.println("[LIB] - I'm searching a book!");
					Thread.sleep(2000);
					System.out.println("[LIB] - I gave a book!");
					BookSearch.release();
					BookBorrow.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					System.out.println("[LIB] - I'm free!");
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
