package it.tn.buonarroti.masala.tipsit.FisolofiACena;

public class mainFilosofi {
	public static void main(String[] args) {
		threadFilosofi[] filosofi = new threadFilosofi[5];
		Object[] forchette = new Object[filosofi.length];

		for (int i=0; i < forchette.length; i++){
			forchette[i] = new Object();
		}

		for (int i=0; i < filosofi.length; i++){
			Object sinistra = forchette[i];
			Object destra = forchette[(i + 1) % forchette.length];

			if (i == filosofi.length - 1) {
				filosofi[i] = new threadFilosofi(destra, sinistra);
			} else {
				filosofi[i] = new threadFilosofi(sinistra, destra);
			}

			Thread thread = new Thread(filosofi[i], "Filosofo " + (i + 1));
			thread.run();
		}
	}
}
