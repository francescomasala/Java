package me.francescomasala.ripasso.Threads;

public class MainThread {
	public static void main(String[] args) {
		DemoThread t1 = new DemoThread(1, "Test"), t2 = new DemoThread(2, "Test2");
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
