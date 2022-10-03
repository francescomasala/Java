package it.tn.buonarroti.masala.informatica.terza.ora;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Ora1 {

	public Integer ore;
	public Integer minuti;
	public Integer secondi;

	/**
	 * @param ore     Inserire l'ora desiderata
	 * @param minuti  Inserire i minuti desiderati
	 * @param secondi Inserire i secondi
	 */
	public Ora1(Integer ore, Integer minuti, Integer secondi) {
		this.ore = ore;
		this.minuti = minuti;
		this.secondi = secondi;
	}

	public Integer getOre() {
		return ore;
	}

	/**
	 * @param ore Inserire l'ora desiderata
	 */
	public void setOre(Integer ore) {
		this.ore = ore;
	}

	public Integer getMinuti() {
		return minuti;
	}

	/**
	 * @param minuti Inserire i minuti desiderati
	 */
	public void setMinuti(Integer minuti) {
		this.minuti = minuti;
	}

	public Integer getSecondi() {
		return secondi;
	}

	/**
	 * @param secondi Inserire i secondi desiderati
	 */
	public void setSecondi(Integer secondi) {
		this.secondi = secondi;
	}


	/**
	 * Controlla se l'ora inserita è valida
	 *
	 * @return Se l'ora è valida dovrebbe restituire un valore boolean.TRUE
	 */
	private Boolean validaOra() {
		Boolean check = Boolean.TRUE;
		// Creo una variabile booleana ed imposto TRUE come default
		if (this.ore < 0 || this.ore >= 23) {
			check = Boolean.FALSE;
		}
		// SE ore è minore di 24 assegna a check un valore FALSE
		if (this.minuti < 0 || this.minuti >= 59) {
			check = Boolean.FALSE;
		}
		// SE minuti è minore di 60 assegna a check un valore FALSE
		if (this.secondi < 0 || this.secondi >= 59) {
			check = Boolean.FALSE;
		}
		// SE secondi è minore di 60 assegna a check un valore FALSE
		return check;
	}

	/**
	 * Calcola la differenza in ore tra l'ora inserita all'interno della classe e l'ora attuale
	 *
	 * @return La differenza in intero
	 */
	public Integer differenzaInOre() {
		// Creo l'oggetto oraAttuale da GregorianCalendar
		Integer oraAttuale
				= new GregorianCalendar().get(GregorianCalendar.HOUR_OF_DAY);
		// Creo la variabile differenza
		int differenza;
		// Se validaOra() è falso deve ritornare il valore "-1"
		if (Objects.equals(validaOra(), Boolean.FALSE)) {
			differenza = -1;
		} else {
			// Mentre se è positivo mi restituisce il valore assoluto
			// Del risultato tra le due
			differenza = this.ore - oraAttuale;
			differenza = Math.abs(differenza);
		}
		return differenza;
	}

	/**
	 * Calcola la differenza in minuti tra l'ora inserita all'interno della classe e l'ora attuale
	 *
	 * @return La differenza in intero
	 */
	public Integer differenzaInMinuti() {
		// Creo l'oggetto oraAttuale da GregorianCalendar
		int minutoAttuale
				= new GregorianCalendar().get(GregorianCalendar.MINUTE);
		Integer differenzaOre = differenzaInOre();
		// Creo la variabile differenza
		int differenza;
		// Se validaOra() è falso deve ritornare il valore "-1"
		if (Objects.equals(validaOra(), Boolean.FALSE)) {
			differenza = -1;
		} else {
			// Mentre se è positivo mi restituisce il valore assoluto
			// Del risultato tra le due
			differenza = ((differenzaOre * 60) + this.minuti - minutoAttuale);
			differenza = Math.abs(differenza);
		}
		return differenza;
	}

	/**
	 * Calcola la differenza in secondi tra l'ora inserita all'interno della classe e l'ora attuale
	 *
	 * @return La differenza in intero
	 */
	public Integer differenzaInSecondi() {
		// Creo l'oggetto oraAttuale da GregorianCalendar
		int secondoAttuale
				= new GregorianCalendar().get(GregorianCalendar.SECOND);
		Integer differenzaMinuti = differenzaInMinuti();
		// Creo la variabile differenza
		int differenza;
		// Se validaOra() è falso deve ritornare il valore "-1"
		if (Objects.equals(validaOra(), Boolean.FALSE)) {
			differenza = -1;
		} else {
			// Mentre se è positivo mi restituisce il valore assoluto
			// Del risultato tra le due
			differenza = ((differenzaMinuti * 60)
					+ this.secondi - secondoAttuale);
			differenza = Math.abs(differenza);
		}
		return differenza;
	}

	/**
	 * Calcola la differenza in ore, minuti e secondi tra l'ora inserita all'interno della classe e l'ora attuale
	 *
	 * @return La differenza in una stringa
	 */
	public String differenzaInOreMinutiSecondi() {
		String stringDifferenza;
		Integer ore = differenzaInOre(), minuti = differenzaInMinuti(), secondi = differenzaInSecondi();
		stringDifferenza = "Ore: " + ore.toString() + "\nMinuti: " + minuti.toString() +
				"\nSecondi: " + secondi.toString();
		return stringDifferenza;

	}
}
