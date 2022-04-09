package me.francescomasala.ripasso.Async;

public class MainAsync2 {
	public static void main(String[] args) {
		Ordine ordine = new Ordine();

		ordine.setOrdine(Boolean.TRUE);

		DemoAsync2 d1 = new DemoAsync2(Boolean.FALSE, ordine);
		DemoAsync2 d2 = new DemoAsync2(Boolean.TRUE, ordine);

		Thread thread1 = new Thread(d1);
		Thread thread2 = new Thread(d2);

		thread1.start();
		thread2.start();
	}
}
