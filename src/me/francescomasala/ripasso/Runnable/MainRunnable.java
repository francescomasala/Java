package me.francescomasala.ripasso.Runnable;

public class MainRunnable {
	public static void main(String[] args) {
		Thread t1 = new Thread(new DemoRunnable());

		t1.start();
	}
}
