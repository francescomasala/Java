package it.tn.buonarroti.masala.informatica.terza.frazione;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Frazione {
	//Attributi
	private Integer numeratore;
	private Integer denominatore;

	//Costruttore
	public Frazione(Integer numeratore, Integer denominatore) {
		this.numeratore = numeratore;
		this.denominatore = denominatore;
	}

	//Metodi
	private Integer MCD(Integer a, Integer b) {

		Integer val1 = a;
		Integer val2 = b;

		while (!val1.equals(val2)) {
			if (val1 < val2) {
				val1 += a;
			} else {
				val2 += b;
			}
		}
		return val1;
	}

	@Override
	public String toString() {
		String s;
		s = numeratore.toString() + "/" + denominatore.toString();
		return s;
	}

	//da rivedere
	private void semplifica() {
		for (int i = 0; i < numeratore; i++) {
			if (denominatore % i == 0 && numeratore % i == 0) {
				numeratore = numeratore / i;
				denominatore = denominatore / i;
			}
		}

	}

	public Frazione Somma(Frazione frazione) {
		Integer mcd = MCD(frazione.denominatore, denominatore);
		Integer somma = ((mcd / denominatore) * numeratore) + (mcd / frazione.denominatore) * numeratore;

		return new Frazione(somma, mcd);
	}

	public Frazione Differenza(Frazione frazione) {

		Integer mcd = MCD(frazione.denominatore, denominatore);
		Integer differenza = Math.abs(((mcd / denominatore) * numeratore) - (mcd / frazione.denominatore) * numeratore);

		return new Frazione(differenza, mcd);
	}

	public Frazione Prodotto(Frazione frazione) {

		Integer num = numeratore * frazione.numeratore;
		Integer den = denominatore * frazione.denominatore;
		return new Frazione(num, den);
	}

	public Frazione Divisione(Frazione frazione) {

		Integer num = numeratore * frazione.denominatore;
		Integer den = denominatore * frazione.numeratore;
		return new Frazione(num, den);

	}

}
