package me.francescomasala.ripasso.Threads;

public class ThreadMain {
	public static void main(String[] args) {
		ThreadDemo t1 = new ThreadDemo(1, "Test"), t2 = new ThreadDemo(2, "Test2");
		/*
		 * Con t*.run i thread partiranno in maniera sincrona e non asincrona
		 */
		System.out.println("Thread sincroni");
		t1.run(); // NON FARE
		t2.run(); // NON FARE

		/*
		 * Con t*.start i thread partiranno in maniera asincrona e non sincrona
		 */
		System.out.println("Thread asincroni");
		t1.start();
		t2.start();
	}
}
