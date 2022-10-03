package it.tn.buonarroti.masala.informatica.terza.valutazione;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */

public class Valutazione {
	private final Integer lunghezzaMax;
	private final Float[] voti;
	private final String[] alunni;
	private Integer indice = 0;

	public Valutazione(Integer lunghezza) {
		this.lunghezzaMax = lunghezza + 1;
		this.alunni = new String[lunghezza + 1];
		this.voti = new Float[lunghezza + 1];
	}

	/**
	 * Serve per inserire il nominativo ed il voto di uno studente nei due array privati voti, alunni
	 *
	 * @param alunno Nome dell'alunno da inserire nell'array
	 * @param voto   Voto dell'alunno da inserire nell'array
	 *
	 *               <blockquote>
	 *               <pre>
	 *                                                                                                                 aggiungiValutazione(Mario Rossi, 7.75f);
	 *                                                                                                   </pre>
	 *               </blockquote>
	 */
	public Boolean aggiungiValutazione(String alunno, Float voto) {
		Boolean result;
		if (this.indice < lunghezzaMax) {
			alunni[indice] = alunno;
			voti[indice] = voto;
			this.incrementIndex();
			result = Boolean.TRUE;
		} else {
			result = Boolean.FALSE;
		}
		return result;
	}

	/**
	 * Effettua un ordinamento crescente per alunno
	 */
	public void ordinamentoCrescente() {
		Arrays.sort(this.alunni);
	}

	/**
	 * Effettua un ordinamento decrescente per voto
	 */
	public void ordinamentoDecrescente() {
		Float[] cloneVoti = this.voti;

		Arrays.sort(cloneVoti);

		for (int index = 0; index < this.indice; index++) {
			this.voti[index] = cloneVoti[this.indice - index];
		}
	}

	/**
	 * Effettua una query all'interno dell'array Alunni e restituisce una stringa con l'alunno ed il rispettivo voto
	 *
	 * @param alunno Nome dell'alunno
	 */
	public String ricercaPerAlunno(String alunno) {
		StringBuilder result = new StringBuilder();

		for (int index = 0; index < this.indice; index++) {
			if (this.alunni[index].equals(alunno)) {
				result.append("Alunno: ").append(this.alunni[index]).append("\n").append("Voto: ").append(this.voti[index]).append("\n");
			}
		}
		return result.toString();
	}

	/**
	 * Effettua una query all'interno dell'array Voti e restituisce una stringa contenente tutti gli alunni con quel
	 * voto
	 *
	 * @param voto Nome dell'alunno
	 */
	public String ricercaPerVoto(Float voto) {
		StringBuilder result = new StringBuilder();

		for (int index = 0; index < this.indice; index++) {
			if (Objects.equals(this.voti[index], voto)) {
				result.append("Alunno: ").append(this.alunni[index]).append("\n").append("Voto: ").append(this.voti[index]).append("\n");
			}
		}
		return result.toString();
	}

	/**
	 * Effettua una media globale dei voti di tutti gli alunni
	 */
	public float mediaDeiVoti() {
		int index = 0; // Variabile locale per l'indice
		float media = 0.0f;// Variabile per contenere la media

		while (index <= this.indice) {
			media = media + this.voti[index];
			index++;
		}

		media /= index;

		return media;
	}

	public String nAlunniSufficientiEInsufficienti() {
		String result = "";
		int sufficienti = 0, insufficienti = 0;

		for (int index = 0; index < this.indice; index++) {
			if (this.voti[index] < 6.0f) {
				insufficienti++;
			} else {
				sufficienti++;
			}
		}
		result += "Alunni sufficienti: " + sufficienti + "\n" +
				"Alunni insufficienti: " + insufficienti + "\n";
		return result;
	}

	public String AlunniSufficientiEInsufficienti() {
		StringBuilder result = new StringBuilder("Alunni sufficienti: \n");
		int indexOne = 0, indexTwo = 0;
		String[] sufficienti = new String[this.lunghezzaMax];
		String[] insufficienti = new String[this.lunghezzaMax];

		for (int index = 0; index < this.indice; index++) {
			if (this.voti[index] < 6.0f) {
				insufficienti[indexOne] = this.alunni[index];
				indexOne++;
			} else {
				sufficienti[indexTwo] = this.alunni[index];
				indexTwo++;
			}
		}

		for (int index = 0; index != indexOne; index++) {
			result.append(sufficienti[index]).append("\n");
		}
		result.append("Alunni insufficienti: \n");
		for (int index = 0; index != indexTwo; index++) {
			result.append(sufficienti[index]).append("\n");
		}
		return result.toString();
	}

	@Override
	public String toString() {

		StringBuilder ris = new StringBuilder();
		ris.append("ARR. VOT: ");

		for (int i = 0; i < indice; i++) {
			ris.append(voti[i]).append(" ");
		}

		ris.append("ARR. STD: ");

		for (int i = 0; i < indice; i++) {
			ris.append(alunni[i]).append(" ");
		}

		ris.append("LUN. MAX: ").append(lunghezzaMax);
		ris.append("IND. ARR: ").append(indice);

		return ris.toString();
	}

	private void incrementIndex() {
		this.indice++;
	}

}
