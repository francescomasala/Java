package it.tn.buonarroti.masala.garaPodistica;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class MainGaraPodistica {
    public static void main(String[] args) {
        GaraPodistica gara = new GaraPodistica(9);

        System.out.println("Iscrizione dei partecipanti in corso:");
        System.out.println(gara.iscriviPartecipante("Piero"));
        System.out.println(gara.iscriviPartecipante("Marco"));
        System.out.println(gara.iscriviPartecipante("Antonio"));
        System.out.println(gara.iscriviPartecipante("Edoardo"));
        System.out.println(gara.iscriviPartecipante("Pierino"));
        System.out.println(gara.iscriviPartecipante("Giacomo"));
        System.out.println(gara.iscriviPartecipante("Alessio"));
        System.out.println(gara.iscriviPartecipante("Davide"));
        System.out.println(gara.iscriviPartecipante("Samuele"));
        System.out.println();

        System.out.println("Assegnamento dei secondi in corso:");
        System.out.println(gara.assegnaTempoImpiegato("Piero", 30));
        System.out.println(gara.assegnaTempoImpiegato("Marco", 28));
        System.out.println(gara.assegnaTempoImpiegato("Antonio", 35));
        System.out.println(gara.assegnaTempoImpiegato("Edoardo", 26));
        System.out.println(gara.assegnaTempoImpiegato("Pierino", 39));
        System.out.println(gara.assegnaTempoImpiegato("Giacomo", 41));
        System.out.println(gara.assegnaTempoImpiegato("Alessio", 22));
        System.out.println(gara.assegnaTempoImpiegato("Davide", 28));
        System.out.println(gara.assegnaTempoImpiegato("Samuele", 31));
        System.out.println();

        System.out.println(gara.elencoPartecipanti());
        System.out.println();

        System.out.println(gara.ricercaPerNome("Piero"));
        System.out.println();

        System.out.println(gara.partecipantePiuLento());
        System.out.println();

        System.out.print("Partecipanti sopra 30 secondi: ");
        System.out.println(gara.nPartecipantiAlDiSopraDiTotSecondi(30));
        System.out.println();

        System.out.print("Tempo medio di tutti i partecipanti: ");
        System.out.println(gara.tempoMedio());
        System.out.println();

        System.out.print("Eliminazione di un partecipante: ");
        System.out.println(gara.cancellaPartecipante("Davide"));
        System.out.println();

        System.out.println(gara.elencoPartecipanti());
        System.out.println();
    }

}
