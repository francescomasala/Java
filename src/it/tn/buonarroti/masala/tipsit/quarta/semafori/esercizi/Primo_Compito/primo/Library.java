package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.primo;

import java.util.concurrent.Semaphore;

public class Library implements Runnable {
	protected Semaphore BookSearch;
	protected Semaphore BookBorrow;

	public Library(Semaphore BookSearch, Semaphore BookBorrow) {
		this.BookSearch = BookSearch;
		this.BookBorrow = BookBorrow;
	}


	@Override
	public synchronized void run() {
		while (true) {
			try {
				System.out.println("[INFO] - There are: " + BookBorrow.getQueueLength() + " students waiting");
				System.out.println("[INFO] - There are: " + BookSearch.getQueueLength() + " students searching");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		}
	}
}
