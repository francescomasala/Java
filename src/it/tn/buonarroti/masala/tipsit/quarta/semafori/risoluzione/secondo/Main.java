package it.tn.buonarroti.masala.tipsit.quarta.semafori.risoluzione.secondo;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		Benzinaio b = new Benzinaio(2, 2000);
		Thread threads[] = {
				new Thread(new Auto(b, 50, 20, "a1")),
				new Thread(new Auto(b, 50, 20, "a2")),
				new Thread(new Auto(b, 50, 20, "a3")),
				new Thread(new Auto(b, 50, 20, "a4")),

		};
		for (Thread t : threads) {
			t.start();
		}
	}
}

class Benzinaio {
	Semaphore sem;
	String name;
	int litri;

	public Benzinaio(int Pompe, int litri) {
		this.litri = litri;
		sem = new Semaphore(Pompe);
	}

	public void rifornimento(String tname, int litri, Thread t) {
		try {
			sem.acquire();
			if (this.litri >= litri) {
				dimLitri(litri);
				System.out.println(tname + " ha rifornito " + litri + " litri");
				Thread.sleep(litri * 100);
				System.out.println(tname + " ha finito di rifornire");
			} else {
				t.interrupt();
			}
		} catch (InterruptedException e) {
			System.out.println("Thread Interrotto");
		} finally {
			sem.release();
		}
	}

	private synchronized int getValue() {
		return this.litri;
	}

	private synchronized void dimLitri(int litri) {
		this.litri -= litri;
	}
}

class Auto implements Runnable {
	int upperBound;
	int lowerBound;
	Benzinaio B;
	String nome;

	public Auto(Benzinaio B, int lowerBound, int upperBound, String name) {
		this.B = B;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.nome = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int litri = (int) (Math.random() * (upperBound - lowerBound) + lowerBound);
				B.rifornimento(this.nome, litri, Thread.currentThread());
				Thread.sleep(litri * 100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}