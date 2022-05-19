package it.tn.buonarroti.masala.terza.elenco;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Elenco {

	//Attributi
	private final String[] nominativi;
	private Integer numElementi;
	private Integer maxElementi;

	//Costruttore
	public Elenco(Integer maxElementi) {
		this.nominativi = new String[maxElementi];
		numElementi = 0;
	}

	public Integer getNumElementi() {
		return numElementi;
	}

	public void aggiungiNominativo(String Nominativo) {
		this.nominativi[this.numElementi] = Nominativo;
		this.numElementi++;
	}

	public String trovaDaIntex(Integer Indice) {
		String localNominativo;
		if (Indice >= 0 && Indice < numElementi) {
			localNominativo = this.nominativi[Indice];
		} else {
			localNominativo = "Errore: spazio nullo";
		}
		return localNominativo;
	}

	public String[] trovaDaIniziale(char c) {
		String[] risultato = new String[numElementi];
		int elementiTrovati = 0;

		for (int i = 0; i < numElementi; i++) {
			if (nominativi[i].charAt(0) == c) {
				risultato[elementiTrovati] = nominativi[1];
				elementiTrovati++;
			}
		}
		return risultato;
	}
}