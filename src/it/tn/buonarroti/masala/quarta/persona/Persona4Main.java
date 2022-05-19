package it.tn.buonarroti.masala.quarta.persona;

public class Persona4Main {
	public static void main(String[] args) {
		Persona4 p = new Persona4();

		try {
			p.setAltezza(170.0);
			p.setCognome(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(p.info());
	}
}
