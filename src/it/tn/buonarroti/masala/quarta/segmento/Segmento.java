package it.tn.buonarroti.masala.quarta.segmento;

public class Segmento {
	private final Punto e1;
	private final Punto e2;


	/**
	 * Costruttore della classe
	 *
	 * @param e1 Primo valore del segmento con questo ordine: x;y
	 * @param e2 Secondo valore del segmento con questo ordine: x;y
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public Segmento(Punto e1, Punto e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	/**
	 * Trova la lunghezza tra i due punti
	 *
	 * @return Il valore in formato Double
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public Double trovaLung() {
		return Math.sqrt(Math.pow(e2.getX() - e1.getX(), 2) + Math.pow(e2.getY() - e1.getY(), 2));
	}

	/**
	 * Trasla x
	 *
	 * @param dx Trasla il valore X di entrambi i punti dato un valore double come parametro
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public void traslaX(Double dx) {
		e1.traslaX(dx);
		e2.traslaX(dx);
	}

	/**
	 * Trasla y
	 *
	 * @param dy Trasla il valore Y di entrambi i punti dato un valore double come parametro
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public void traslaY(Double dy) {
		e1.traslaY(dy);
		e2.traslaY(dy);
	}

	/**
	 * ToString della classe
	 *
	 * @return Il valore del punto in questo formato:
	 * Segmento1: x;y
	 * Segmento 2: x;y
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	@Override
	public String toString() {
		return "Segmento 1: " + this.e1 + "\n" +
				"Segmento 2: " + this.e2;
	}
}
