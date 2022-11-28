package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.Secondo_Compito.Primo;

public class semaphore {
	private Integer value;

	public semaphore(Integer value) throws Exception {
		if (value.equals(0)) {
			throw new Exception("Il valore del semaforo non deve essere negativo");
		}
		this.value = value;
	}

	public synchronized void p() {
		while (value.equals(0)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;
	}

	public synchronized void p(Integer Cycles) throws Exception {
		Integer i = 0;
		CheckMaxValue(Cycles);
		while (!Cycles.equals(i)) {
			while (value.equals(0)) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			value--;
		}
	}

	public synchronized void v() {
		value++;
		notifyAll();
	}

	public synchronized void v(Integer Cycles) throws Exception {
		Integer i = 0;
		CheckMaxValue(Cycles);
		while (!Cycles.equals(i)) {
			value++;
			i++;
		}
		notifyAll();
	}

	private void CheckMaxValue(int Cycles) throws Exception {
		if (value <= Cycles) {
			throw new Exception("Il numero di risorse da allocare è maggiore a quello disponibile");
		}

	}

}