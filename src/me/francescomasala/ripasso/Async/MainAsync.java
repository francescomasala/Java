package me.francescomasala.ripasso.Async;

public class MainAsync {
	public static void main(String[] args) {
		DemoAsync d1 = new DemoAsync(Boolean.FALSE);
		DemoAsync d2 = new DemoAsync(Boolean.TRUE);

		Thread thread1 = new Thread(d1);
		Thread thread2 = new Thread(d2);

		thread2.start();

		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread1.start();
	}

}
