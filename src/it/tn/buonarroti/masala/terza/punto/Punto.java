package it.tn.buonarroti.masala.terza.punto;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Punto {
	//Attributi
	private Double x;
	private Double y;

	//Costruttore
	public Punto(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	//Metodi getter e setter

	/**
	 * Serve per restituire il valore di X
	 *
	 * @return restituisce la coordinata orizzontale
	 */
	public Double getX() {
		return x;
	}

	/**
	 * Serve per impostare un valore ad X
	 *
	 * @param x Coordinata orizzontale desiderata
	 */
	public void setX(Double x) {
		this.x = x;
	}

	/**
	 * Serve per restituire il valore di Y
	 *
	 * @return restituisce la coordinata verticale
	 */
	public Double getY() {
		return y;
	}

	/**
	 * Serve per impostare un valore ad X
	 *
	 * @param y Coordinata verticale desiderata
	 */
	public void setY(Double y) {
		this.y = y;
	}

	//Metodi della classe

	/**
	 * Restituisce un valore formattato
	 *
	 * @return x, y
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * Trasla X di un determinato valore
	 *
	 * @param x Coordinata orizzontale da aggiungere a X
	 */
	public void traslaX(Double x) {
		this.x += x;
	}

	/**
	 * Trasla Y di un determinato valore
	 *
	 * @param y Coordinata orizzontale da aggiungere a Y
	 */
	public void traslaY(Double y) {
		this.y += y;
	}

	/**
	 * Calcola la distanza dall'origine
	 *
	 * @return La distanza dall'origine
	 */
	public Double distanzaDaOrigine() {
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}

	/**
	 * Calcola la distanza da dei punti inseriti
	 *
	 * @param punto Inserire i punti desiderati in questo formato: x,y
	 * @return La distanza da quei punti
	 */
	public Double distanzaDaPunto(Punto punto) {
		return Math.sqrt(Math.pow((this.x - punto.x), 2) + Math.pow((this.y - punto.y), 2));
	}
}
