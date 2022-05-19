package it.tn.buonarroti.masala.tipsit.contatoreSync;

import java.util.Random;

public class code implements Runnable {

	public Integer NumThread;
	public counter counter = new counter();
	public Ordine ordine;
	public Boolean pari;

	public code(Integer numThread, Boolean pari, Ordine ordine, Integer counter) {
		this.NumThread = numThread;
		this.pari = pari;
		this.ordine = ordine;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (int i = pari ? 0 : 1; i < 10; )
			synchronized (ordine) {
				if (ordine.getOrdine() == pari) {
					System.out.println("Thread N:\t" + this.NumThread);
					this.counter.addCounter(random.nextInt(5) - 3);
					System.out.println("Valore:\t" + this.counter.getCounter());
					System.out.println("--------------------------------------");
					ordine.setOrdine(!ordine.getOrdine());
					i += 1;
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
	}
}
