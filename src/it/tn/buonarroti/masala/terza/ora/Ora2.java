package it.tn.buonarroti.masala.terza.ora;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Ora2 {

	//ATTRIBUTI
	private Integer ore;
	private Integer minuti;
	private Integer secondi;

	//COSTRUTTORE CON PARAMETRI

	/**
	 * Metodo costrutture
	 *
	 * @param ore     Il valore in Integer delle ore desiderate
	 * @param minuti  Il valore in Integer dei minuti desiderati
	 * @param secondi Il valore in Integer dei secondi desiderati
	 */
	public Ora2(Integer ore, Integer minuti, Integer secondi) {
		this.ore = ore;
		this.minuti = minuti;
		this.secondi = secondi;
	}

	//METODI GET E SET

	/**
	 * Metodo getter per la variabile ore
	 *
	 * @return Il contenuto della variabile ore
	 */
	public Integer getOre() {
		return ore;
	}

	/**
	 * Metodo setter per la variabile ore
	 *
	 * @param ore Il contenuto desiderato della variabile ore
	 */
	public void setOre(Integer ore) {
		this.ore = ore;
	}

	/**
	 * Metodo getter per la variabile minuti
	 *
	 * @return Il contenuto della variabile minuti
	 */
	public Integer getMinuti() {
		return minuti;
	}

	/**
	 * Metodo setter per la variabile minuti
	 *
	 * @param minuti Il contenuto desiderato della variabile minuti
	 */
	public void setMinuti(Integer minuti) {
		this.minuti = minuti;
	}

	/**
	 * Metodo getter per la variabile secondi
	 *
	 * @return Il contenuto della variabile secondi
	 */
	public Integer getSecondi() {
		return secondi;
	}

	/**
	 * Metodo setter per la variabile secondi
	 *
	 * @param secondi Il contenuto desiderato della variabile secondi
	 */
	public void setSecondi(Integer secondi) {
		this.secondi = secondi;
	}


	/**
	 * Metodo per calcolare la differenza tra le variabili inserite nel costruttore ed i parametri desiderati
	 *
	 * @param ore     L'ora da confrontare con le varibili inserite nel costrutture
	 * @param minuti  I minuti da confrontare con le varibili inserite nel costrutture
	 * @param secondi I secondi da confrontare con le varibili inserite nel costrutture
	 * @return La differenza in un valore Integer indicato in secondi
	 */
	public Integer differenzaMezzanotteSecondiPar(Integer ore, Integer minuti, Integer secondi) {

		if (validaOra(ore, minuti, secondi) && validaOra(this.ore, this.minuti, this.secondi)) {

			//Trasforma ora in secondi
			Integer secondiParametri = secondiDaMezzanotte(ore, minuti, secondi);
			Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

			//Calcola differenza
			int differenza = secondiParametri - secondiAttributi;

			//Ritorna differenza
			if (differenza > 0) return differenza;
			else return -differenza;

		} else return -1; //Ore fornite non valide
	}

	/**
	 * Metodo per calcolare la differenza tra le variabili inserite nel costruttore ed i parametri desiderati
	 *
	 * @param ore     L'ora da confrontare con le varibili inserite nel costrutture
	 * @param minuti  I minuti da confrontare con le varibili inserite nel costrutture
	 * @param secondi I secondi da confrontare con le varibili inserite nel costrutture
	 * @return La differenza in un valore Integer indicato in minuti
	 */
	public Integer differenzaMezzanotteMinutiPar(Integer ore, Integer minuti, Integer secondi) {

		if (validaOra(ore, minuti, secondi) && validaOra(this.ore, this.minuti, this.secondi)) {

			//Trasforma ora in secondi
			Integer secondiParametri = secondiDaMezzanotte(ore, minuti, secondi);
			Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

			//Calcola differenza
			int differenza = secondiParametri - secondiAttributi;
			differenza = differenza / 60;

			//Ritorna differenza
			if (differenza > 0) return differenza;
			else return -differenza;

		} else return -1; //Ore fornite non valide
	}

	/**
	 * Metodo per calcolare la differenza tra le variabili inserite nel costruttore ed i parametri desiderati
	 *
	 * @param ore     L'ora da confrontare con le varibili inserite nel costrutture
	 * @param minuti  I minuti da confrontare con le varibili inserite nel costrutture
	 * @param secondi I secondi da confrontare con le varibili inserite nel costrutture
	 * @return La differenza in un valore Integer indicato in ore
	 */
	public Integer differenzaMezzanotteOrePar(Integer ore, Integer minuti, Integer secondi) {

		if (validaOra(ore, minuti, secondi) && validaOra(this.ore, this.minuti, this.secondi)) {

			//Trasforma ora in secondi
			Integer secondiParametri = secondiDaMezzanotte(ore, minuti, secondi);
			Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

			//Calcola differenza
			int differenza = secondiParametri - secondiAttributi;
			differenza = differenza / 3600;

			//Ritorna differenza
			if (differenza > 0) return differenza;
			else return -differenza;

		} else return -1; //Ore fornite non valide
	}


	private Integer secondiDaMezzanotte(Integer ore, Integer minuti, Integer secondi) {
		return (secondi + (minuti * 60) + (ore * 3600));
	}

	/**
	 * Metodo per aggiungere secondi nell'attributo iniziale
	 *
	 * @param secondi I secondi da inserire nell'attributo iniziale
	 * @deprecated
	 */
	public void aggiungiSecondi(Integer secondi) { //NUOVA VERSIONE MIGLIORE

		//Aggiungi i secondi all'attributo onomino
		this.secondi += secondi;

		//Aggiusta gli attributi in base ai limiti temporali
		if (this.secondi > 59) {
			this.minuti += this.secondi / 60;
			this.secondi = this.secondi % 60;

			if (this.minuti > 59) {
				this.ore += this.minuti / 60;
				this.minuti = this.minuti % 60;

				while (this.ore > 23) {
					this.ore -= 24;
				}
			}
		}
	}

	/**
	 * Metodo migliorato per aggiungere secondi nell'attributo iniziale
	 *
	 * @param secondi I secondi da inserire nell'attributo iniziale
	 */
	public void aggiungiSecondiV2(Integer secondi) {

		//ottieni secondi ora corrente
		Integer secCorrenti = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);
		secCorrenti += secondi;

		//Calcola per categoria
		ore = (secCorrenti / 3600) % 24; //ORA CORRETTA IN AUTOMATICO
		minuti = (secCorrenti % 3600) / 60;
		this.secondi = ((secCorrenti % 3600) % 60);

	}


	/**
	 * Ritorna la differenza di tempo data dai parametri iniziali e da i parametri desiderati
	 *
	 * @param ora L'ora in questo format ore,minuti,secondi
	 * @return La differenza in questo format: ore,minuti,secondi
	 */
	public Ora2 differenzaInOreMinSec(Ora2 ora) {

		//Valida ora
		if (validaOra(ora.getOre(), ora.getMinuti(), ora.getMinuti()) && validaOra(ore, minuti, secondi)) {

			//Trasforma tutto in secondi
			Integer secondiParametri = secondiDaMezzanotte(ora.getOre(), ora.getMinuti(), ora.getSecondi());
			Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

			int differenza = Math.abs(secondiParametri - secondiAttributi);

			//Ritrasforma in secondi
			Ora2 oraReturn = new Ora2(0, 0, 0);
			oraReturn.setOre((differenza / 3600) % 24);
			oraReturn.setMinuti((differenza % 3600) / 60);
			oraReturn.setSecondi((differenza % 3600) % 60);

			//Ritorna i valori di ora
			return oraReturn;

		} else {

			return new Ora2(0, 0, 0);

		}
	}

	/**
	 * Ritorna la differenza di tempo data dai parametri desiderati e dall'ora attuale
	 *
	 * @return La differenza in questo format: ore,minuti,secondi
	 */
	public Ora2 differenzaInOreMinSecAttuale() {

		//ottengo ora attuale
		GregorianCalendar calendario = new GregorianCalendar();
		Ora2 oraAttuale = new Ora2(0, 0, 0);

		oraAttuale.setOre(calendario.get(Calendar.HOUR_OF_DAY));
		oraAttuale.setMinuti(calendario.get(Calendar.MINUTE));
		oraAttuale.setSecondi(calendario.get(Calendar.SECOND));

		//chiamo metodo con parametri
		return differenzaInOreMinSec(oraAttuale);

	}


	/**
	 * Metodo per aggiungere minuti nell'attributo iniziale
	 *
	 * @param minuti I minuti da inserire nell'attributo iniziale
	 */
	public void aggiungiMinuti(Integer minuti) {
		aggiungiSecondiV2(minuti * 60);
	}

	/**
	 * Metodo per aggiungere ore nell'attributo iniziale
	 *
	 * @param ore Le ore da inserire nell'attributo iniziale
	 */
	public void aggiungiOre(Integer ore) {
		aggiungiSecondiV2(ore * 3600);
	}


	/**
	 * Metodo per validare l'ora inserita
	 *
	 * @param ore     Le ore da convalidare
	 * @param minuti  I minuti da convalidare
	 * @param secondi I secondi da convalidare
	 * @return Un valore booleano per indicare se l'ora è valida o no
	 */
	private Boolean validaOra(Integer ore, Integer minuti, Integer secondi) {

		//Controlla orario, le ore tra 0->23, i minuti tra 0->59, i secondi da 0->59
		return (ore <= 23 && ore >= 0) && (minuti <= 59 && minuti >= 0) && (secondi <= 59 && secondi >= 0);

	}


}
