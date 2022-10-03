package it.tn.buonarroti.masala.informatica.quarta.segmento;

public class main {
	public main(String[] args) {
		Punto p1 = new Punto(16.0, 12.0);
		Punto p2 = new Punto(8.0, 5.0);

		Segmento seg = new Segmento(p1, p2);

		System.out.println(seg.trovaLung());

		seg.traslaX(12.0);
		seg.traslaY(16.0);

		System.out.println(seg.trovaLung());
	}
}
