package it.tn.buonarroti.masala.informatica.quarta.puntaTrapano;

public class Trapano extends Punta {

	//Attrb
	private final String marca;
	private final Piano piano;
	private Boolean isAcceso;
	private Integer x;
	private Integer y;

	//Costruttore
	public Trapano(String marca, Float diametroPunta, Integer durabilitaPunta) {
		super(diametroPunta, durabilitaPunta);
		this.marca = marca;
		this.piano = new Piano();
		this.isAcceso = false;
		x = 0;
		y = 0;
	}

	//Metodi
	public void accendi() {
		try {
			if (isAcceso = false) {
				isAcceso = true;
			} else {
				throw new Exception("Il trapano è già acceso");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spegni() throws Exception {
		try {
			if (isAcceso) {
				isAcceso = false;
			} else {
				throw new Exception("Il trapano è già spento");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eseguiBuco(Float profondita) {
		if (durabilitaPunta > 0) {
			piano.aggiungiDato(x, y, profondita);
			durabilitaPunta--;
		}
	}

	public void spostaY(Integer dy) {
		x += dy;
	}

	public void spostaX(Integer dx) {
		y += dx;
	}

	@Override
	public String toString() {
		return piano.toString();
	}

}
