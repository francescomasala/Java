package it.tn.buonarroti.masala.quarta.studente;

import it.tn.buonarroti.masala.quarta.persona.Persona7a;

import java.util.ArrayList;

public class Studente2 extends Persona7a {

	//Parametri
	public final String SCUOLA = "I.T.T. BUONARROTI";
	private Integer classe;
	private Boolean isRipetente;
	private ArrayList<Float> voti = new ArrayList<>();

	//Costruttore
	public Studente2(Integer classe, Boolean ripetente, Float[] voti, Double altezza, String cognome, String nome, Float peso, String dataDiNascita, String password, String email) throws Exception {
		super(altezza, cognome, nome, peso, dataDiNascita, password, email);
		this.classe = classe;
		this.isRipetente = ripetente;
	}

	//Get e Set

	public String getSCUOLA() {
		return SCUOLA;
	}

	public Integer getClasse() {
		return classe;
	}

	public void setClasse(Integer classe) {
		this.classe = classe;
	}

	public Boolean getIsRipetente() {
		return isRipetente;
	}

	public void setIsRipetente(Boolean isRipetente) {
		this.isRipetente = isRipetente;
	}

	public ArrayList getVoti() {
		return (ArrayList) voti.clone();
	}

	public void setVoti(ArrayList<Float> voti) {
		this.voti = voti;
	}

	//Metodi della madre
	@Override
	public String info() {
		return "== Informazioni sullo studente: " + nome + " " + cognome + " =="
				+ "\nClasse: " + classe
				+ "\nE' ripetente: " + (isRipetente ? "Si" : "No")
				+ "\nStatistiche voti:"
				+ "\n   - Media globale: " + (mediaVoti() == 0 ? "Nessun voto inserito" : mediaVoti())
				+ "\n   - Voto più alto: " + (votoMaggiore() == 0 ? "Nessun voto inserito" : votoMaggiore())
				+ "\n   - Voto pù basso: " + (votoMinore() == 0 ? "Nessun voto inserito" : votoMinore())
				+ "\nAltezza:  " + altezza
				+ "\nPeso: " + peso
				+ "\nData di Nascita: " + dataDiNascita
				+ "\nEta: " + eta
				+ "\nEmail: " + email
				+ "\nPassword: **********";

	}

	//Metodi della classe
	public Boolean promuovi() {
		classe += 1;
		return true;
	}

	public Boolean promuovi(Integer numeroClassi) {
		classe += numeroClassi;
		return true;
	}

	private Float votoMinore() {
		Float minore = 0f;
		for (int i = 0; i < voti.size(); i++) if (voti.get(i) < minore || i == 0) minore = voti.get(i);
		return minore;
	}

	private Float votoMaggiore() {
		Float maggiore = 0f;
		for (int i = 0; i < voti.size(); i++) if (voti.get(i) > maggiore || i == 0) maggiore = voti.get(i);
		return maggiore;
	}

	private Float mediaVoti() {
		Float somma = 0f;
		int divisore = 0;
		for (int i = 0; i < voti.size() && voti.get(i) != null; i++) {
			somma += voti.get(i);
			divisore = i + 1;
		}
		return somma / divisore;
	}


}