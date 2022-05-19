package it.tn.buonarroti.masala.terza.valutazione;

public class MainValutazione {
	public static void main(String[] args) {
		Valutazione Class = new Valutazione(6);

		Class.aggiungiValutazione("Piero", 8f);
		Class.aggiungiValutazione("Enrico", 6.5f);
		Class.aggiungiValutazione("Checco", 9.5f);
		Class.aggiungiValutazione("Giacomo", 4.5f);
		Class.aggiungiValutazione("Davide", 7.25f);
		Class.aggiungiValutazione("Francesco", 7.75f);

		System.out.println(Class.nAlunniSufficientiEInsufficienti());
		System.out.println("Media: " + Class.mediaDeiVoti() + "\n");
		System.out.println("Voto: " + Class.ricercaPerVoto(9.5f) + "\n");
		System.out.println("Nome: " + Class.ricercaPerAlunno("Davide") + "\n");

	}
}
