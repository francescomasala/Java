package me.francescomasala.ripasso.Runnable;

public class DemoRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Ehi ciao sono un thread!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
