package it.tn.buonarroti.masala.informatica.terza.lanci;

import java.util.Random;

/**
 * @author francesco.masala
 * @lastupdate 24/03/2021
 */

public class Lanci {
	private Integer numFacce;
	private Integer[] arrLanci;
	private Integer indexLanci;

	public Lanci() {
	}

	/**
	 * @param Lanci Indica il numero di lanci da effettuare
	 * @param Facce Indica il numero di Facce del dado
	 * @author Francesco Masala (mail@francescomasala.me)
	 * <p>
	 * Serve per inizializzare la classe Lanci
	 */
	public void InitThrow(Integer Facce, Integer Lanci) {
		this.numFacce = Facce;
	}

	/**
	 * @author Francesco Masala (mail@francescomasala.me)
	 * <p>
	 * Effettua il lancio del dato
	 */
	public void DoThrow() {

		Random random = new Random();
		int randomInteger = random.nextInt(this.numFacce);
		this.arrLanci[this.indexLanci] = randomInteger;
		this.IncThrowIndex();

	}

	/**
	 * @param value0 Indica il valore minimo del filtro
	 * @param value1 Indica il valore massimo del filtro
	 * @return Quanti valori corrispondono al Filtro
	 * @author Francesco Masala (mail@francescomasala.me)
	 */
	public Integer FilterThrow(Integer value0, Integer value1) {
		Integer localI = 0;
		while (localI <= this.indexLanci) {
			if (this.arrLanci[this.indexLanci] <= value0 && this.arrLanci[this.indexLanci] >= value1) {
				localI++;
			}
		}
		return localI;
	}

	/**
	 * @return Idk really
	 * @author Francesco Masala (mail@francescomasala.me)
	 */
	public String StringThrow() {
		return null;
	}

	/**
	 * @author Francesco Masala (mail@francescomasala.me)
	 * <p>
	 * Serve per incrementare il valore dell'indice della classe
	 */
	public void IncThrowIndex() {

		this.indexLanci++;

	}
}
