package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.Secondo_Compito.Secondo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.Stack;

public class app {
	public static void main(String[] args) throws Exception {
		Semaphore semPosti = new Semaphore(2);
		Semaphore semBenzina = new Semaphore(0);
		Semaphore semSerbatoio = new Semaphore(60);

	}
}

class Produttore implements Runnable{
	Semaphore semSerbatoio;
	Semaphore semBenzina;
	int delay;
	private final int MAX = 40;
	private final int MIN = 20;

	public Produttore(Semaphore semSerbatoio, Semaphore semBenzina, int delay) {
		this.semSerbatoio = semSerbatoio;
		this.semBenzina = semBenzina;
		this.delay = delay;
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				int benzina = new Random().nextInt(MAX - MIN) + MIN;
				semSerbatoio.acquire(benzina);
				semBenzina.release(benzina);
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumatore implements Runnable {
	Semaphore semSerbatoio;
	Semaphore semBenzina;
	Semaphore semPosti;
	private final int MAX = 30;
	private final int MIN = 5;

	public Consumatore(Semaphore semSerbatoio, Semaphore semBenzina, Semaphore semPosti) {
		this.semSerbatoio = semSerbatoio;
		this.semBenzina = semBenzina;
		this.semPosti = semPosti;
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				Thread.sleep(4000);
				semPosti.acquire();
				
				int benzina = new Random().nextInt(MAX-MIN) + MIN;
				semBenzina.acquire(benzina);
				Thread.sleep(benzina*100);
				semSerbatoio.release(benzina);
				semPosti.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}