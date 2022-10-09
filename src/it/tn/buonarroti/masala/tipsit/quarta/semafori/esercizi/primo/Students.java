package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.primo;

import java.util.concurrent.Semaphore;

public class Students implements Runnable{
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
		while (BooksToRead > 0) {
			if (BookSearch.getQueueLength() == 0) {
				try {
					System.out.println("[STU] - I'm asking for a book!");
					BookBorrow.acquire();
					Thread.sleep(2000);
					System.out.println("[STU] - I'm waiting!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (BookSearch.getQueueLength() > 0){
				try {
					System.out.println("[STU] - The queue is full!");
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
