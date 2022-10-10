package it.tn.buonarroti.masala.tipsit.quarta.semafori.risoluzione.primo;


import java.util.concurrent.Semaphore;

public class Bibliotecario {
	protected int waitTime;

	Semaphore sem = new Semaphore(1);

	public Bibliotecario(int waitTime) {
		this.waitTime = waitTime;
	}

	public synchronized void ricerca(String tname) {
		System.out.println(tname + " sta cercando un libro");
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			System.out.println("Thread Interrotto");
		}
		System.out.println(tname + " ha trovato un libro");
	}

	public void ricercaSem(String tName) {
		try {
			System.out.println(tName + "Sta cercando un libro");
			sem.acquire();
			Thread.sleep(waitTime);
			System.out.println(tName + "Ha trovato il libro");
		} catch (InterruptedException e) {
			System.out.println(tName + "Thread Interrotto");
		} finally {
			sem.release();
		}

	}
}
