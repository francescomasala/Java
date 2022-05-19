package it.tn.buonarroti.masala.tipsit.FisolofiACena;

public class threadFilosofi implements Runnable {

	private final Object ForchettaDX, ForchettaSX;

	public threadFilosofi(Object destra, Object sinistra) {
		ForchettaDX = destra;
		ForchettaSX = sinistra;
	}

	private void esegui(String azione) {
		System.out.println(Thread.currentThread().getName() + " " + azione);
	}

	@Override
	public void run() {
		try {
			{
				while (true) {
					esegui(": Pensa");
					synchronized (this.ForchettaSX) {
						esegui(": Preso la forchetta di sinistra");
						synchronized (this.ForchettaDX) {
							esegui(": Preso la forchetta di destra");
							esegui(": Mangio");
							esegui(": Rilascio la forchetta di destra");
						}
					}
					esegui(": Rilascio la forchetta di sinistra");
					esegui(": Penso");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
