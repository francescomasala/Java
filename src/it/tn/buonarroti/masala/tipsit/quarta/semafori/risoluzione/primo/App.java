package it.tn.buonarroti.masala.tipsit.quarta.semafori.risoluzione.primo;

public class App {
	public static void main(String[] args) {
		Bibliotecario b = new Bibliotecario(1000);
		Thread a1 = new Thread(new Amico(b, 3, "piero"));
		Thread a2 = new Thread(new Amico(b, 5, "antonio"));
		Thread a3 = new Thread(new Amico(b, 2, "marco"));

		a1.run();
		a2.run();
		a3.run();
	}
}

class Amico implements Runnable {
	int nLibri;
	Bibliotecario B;
	String name;

	public Amico(Bibliotecario B, int nLibri, String name) {
		this.name = name;
		this.B = B;
		this.nLibri = nLibri;
	}

	@Override
	public void run() {
		for (int i = 0; i < nLibri; i++) {
			B.ricerca(name);
		}
	}
}
