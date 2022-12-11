package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.primo;

import java.util.concurrent.Semaphore;

public class Students implements Runnable {
	protected Semaphore BookBorrow;
	protected Semaphore BookSearch;
	protected Integer BooksToRead;

	private Integer BooksRead = 0;

	public Students(Semaphore BookSearch, Semaphore BookBorrow, Integer BooksToRead) {
		this.BookBorrow = BookBorrow;
		this.BookSearch = BookSearch;
		this.BooksToRead = BooksToRead;
	}


	@Override
	public void run() {
		System.out.println("[STU - " + Thread.currentThread().getName() + "] - Need to read " + BooksToRead + " books");
		while (BooksRead <= BooksToRead) {
			//if (BookSearch.getQueueLength() == 0) {
			try {
				System.out.println("[STU - " + Thread.currentThread().getName() + "] - I'm asking for a book!");
				BookBorrow.acquire();
				System.out.println("[STU - " + Thread.currentThread().getName() + "] - I'm waiting!");
				BookSearch.acquire();
				Thread.sleep(2000);
				System.out.println("[STU - " + Thread.currentThread().getName() + "] - I took the book!");
				BookBorrow.release();
				BookSearch.release();
				System.out.println("[STU - " + Thread.currentThread().getName() + "] - I've read " + BooksRead + " books of" + BooksToRead);
				BooksRead++;
			} catch (Exception e) {
				e.printStackTrace();
			}
			//} else if (BookSearch.getQueueLength() > 0){
			//	try {
			//		System.out.println("[STU] - The queue is full!");
			//		Thread.sleep(2000);
			//	} catch (Exception e) {
			//		e.printStackTrace();
			//	}
			//}
		}
	}
}
