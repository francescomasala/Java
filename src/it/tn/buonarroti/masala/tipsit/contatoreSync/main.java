package it.tn.buonarroti.masala.tipsit.contatoreSync;

import me.francescomasala.ripasso.Async.DemoAsync2;
import me.francescomasala.ripasso.Async.Ordine;

public class main {
	public static void main(String[] args) {
		it.tn.buonarroti.masala.tipsit.contatoreSync.Ordine ordine = new it.tn.buonarroti.masala.tipsit.contatoreSync.Ordine();

		ordine.setOrdine(Boolean.TRUE);

		code c1 = new code(1,Boolean.FALSE, ordine,0);
		code c2 = new code(2,Boolean.TRUE, ordine, 0);

		Thread thread1 = new Thread(c1);
		Thread thread2 = new Thread(c2);

		thread1.start();
		thread2.start();
	}
}
