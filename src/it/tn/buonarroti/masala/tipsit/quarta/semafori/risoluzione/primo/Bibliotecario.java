package it.tn.buonarroti.masala.tipsit.quarta.semafori.risoluzione.primo;

public class Bibliotecario {
	protected int waitTime;

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
}
