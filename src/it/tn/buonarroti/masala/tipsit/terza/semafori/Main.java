package it.tn.buonarroti.masala.tipsit.terza.semafori;

public class Main {
	public static void main(String[] args) {
		Cesto cestino = new Cesto();

		Thread mensa1 = new Thread(new Mensa(cestino));
		Thread mensa2 = new Thread(new Mensa(cestino));
		Thread mensa3 = new Thread(new Mensa(cestino));

		mensa1.run();
		mensa2.run();
		mensa3.run();
	}
}
