package it.tn.buonarroti.masala.quarta.punto_sfera;

public class MainPuntoSfera {
	public static void main(String[] args) {
		punto p = new punto(2f, 5f);

		System.out.println("Punto P: \n" + p);

		sfera s = new sfera(p, 5f);

		System.out.println("Sfera s: \n" + s);

		p.trasla(4f, -6f);
		System.out.println("Punto P: \n" + p);

		s.trasla(4f, -6f);
		System.out.println("Sfera s: \n" + s);
	}
}
