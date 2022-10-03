package me.francescomasala.ripasso.Async;

public class DemoAsync implements Runnable{
	public Boolean pari;

	public DemoAsync(Boolean pari){
		this.pari = pari;
	}

	public void run(){
		for (int i = pari ? 0 : 1; i < 100; i += 2) {
			System.out.println(i);
		}
	}
}
