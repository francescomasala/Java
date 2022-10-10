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
			// if (BookBorrow.getQueueLength() >= 0) {
				try {
					System.out.println("[LIB - " + Thread.currentThread().getName() + "] - I'm working!");
					System.out.println("[LIB - " + Thread.currentThread().getName() + "] - There are: " + BookBorrow.getQueueLength() + " students waiting");
					BookSearch.acquire();
					Thread.sleep(2000);
					if (BookSearch.getQueueLength() != 0) {
						System.out.println("[LIB - " + Thread.currentThread().getName() + "] - I'm searching a book!");
						System.out.println("[LIB - " + Thread.currentThread().getName() + "] - I gave a book!");
						BookBorrow.release();
					}
					BookSearch.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			// } else {
			//	try {
			//		System.out.println("[LIB] - I'm free!");
			//		Thread.sleep(2000);
			// 	} catch (Exception e) {
			// 		e.printStackTrace();
			// 	}
			// }
		}
	}
}
