package me.francescomasala.ripasso.Threads;

public class ThreadDemo extends Thread {
	public Integer Demo;
	public String Demo2;

	public ThreadDemo(Integer Intero, String Demo2) {
		this.Demo = Intero;
		this.Demo2 = Demo2;
	}

	@Override
	public void run(){
		System.out.println("Ehi ciao sono un thread!\nNumero thread: " + this.Demo );
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
