package it.tn.buonarroti.masala.informatica.quarta.segmento;

import lombok.Getter;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */

public class Punto {
	//@Setter
	@Getter
	private Double x;
	//@Setter
	@Getter
	private Double y;

	/**
	 * Costruttore della classe
	 *
	 * @param x Valore all'interno dell'asse delle ascisse
	 * @param y Valore all'interno dell'asse delle ordinate
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public Punto(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Costruttore della classe
	 *
	 * @param p Valore all'interno di un grafico seguendo l'ordine: (x;y)
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public Punto(Punto p) {
		this.x = p.x;
		this.y = p.y;
	}

	/**
	 * Trasla x
	 *
	 * @param dx Trasla il valore di X dato un valore double come parametro
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public void traslaX(Double dx) {
		this.x = x + dx;
	}

	/**
	 * Trasla y
	 *
	 * @param dy Trasla il valore di Y dato un valore double come parametro
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public void traslaY(Double dy) {
		this.y = y + dy;
	}

	/**
	 * ToString della classe
	 *
	 * @return Il valore del punto in questo formato: x;y
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	@Override
	public String toString() {
		return x + ";" + y;
	}

}
