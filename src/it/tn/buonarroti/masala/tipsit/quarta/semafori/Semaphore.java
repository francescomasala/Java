package it.tn.buonarroti.masala.tipsit.quarta.semafori;

public class Semaphore {
	private int value;

	public Semaphore(int value) throws IllegalArgumentException {
		if (value < 0) {
			throw new IllegalArgumentException("Il valore del semaforo non può essere negativo");
		}
		this.value = value;

	}

	public synchronized void P() {
		while (value == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;
	}

	public synchronized void V() {
		value++;
		notify();
	}

	public class Mutex {
		private boolean mutex = true;

		public synchronized void p() {
			while (!mutex) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			mutex = false;
		}

		public synchronized void v() {
			mutex = true;
			notify();
		}
	}
}
