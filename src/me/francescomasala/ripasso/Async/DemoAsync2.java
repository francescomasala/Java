package me.francescomasala.ripasso.Async;

public class DemoAsync2 implements Runnable {
	public Boolean pari;
	public Ordine ordine;

	public DemoAsync2(Boolean pari, Ordine ordine) {
		this.pari = pari;
		this.ordine = ordine;
	}

	public void run() {
		for (int i = pari ? 0 : 1; i < 100; ) {
			synchronized (ordine) {
				if (ordine.getOrdine() == pari) {
					System.out.println(i + " Il numero è pari: " + pari);
					ordine.setOrdine(!ordine.getOrdine());
					i += 2;
				}
			}
		}
	}
}
