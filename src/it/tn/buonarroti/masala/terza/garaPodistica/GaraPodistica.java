package it.tn.buonarroti.masala.terza.garaPodistica;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class GaraPodistica {

    private final String[] nome;
    private final Integer[] tempoImpiegato;
    private final Integer numeroMaxPartecipanti;
    private Integer numeroEffettivoPartecipanti;

    /**
     */
    public GaraPodistica(Integer numeroPartecipanti) {
        this.numeroMaxPartecipanti = numeroPartecipanti;
        this.numeroEffettivoPartecipanti = 0;
        this.nome = new String[numeroPartecipanti];
        this.tempoImpiegato = new Integer[numeroPartecipanti];
        inizializzaVettori();
    }

    /**
     * Metodo per iscrivere un atleta
     *
     * @param nomeAtleta Inserire il nome dell'atleta
     * @return Se l'operazione è andata a buon fine
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public boolean iscriviPartecipante(String nomeAtleta) {
        Boolean result = Boolean.FALSE;

        if (this.numeroEffettivoPartecipanti < this.numeroMaxPartecipanti) {
            this.nome[this.numeroEffettivoPartecipanti] = nomeAtleta;
            incNumeroEffettivoPartecipanti();
            result = Boolean.TRUE;
        }

        return result;
    }

    /**
     * Metodo per eliminare un atleta
     *
     * @param nomeAtleta Inserire il nome dell'atleta
     * @return Se l'operazione è andata a buon fine
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public boolean cancellaPartecipante(String nomeAtleta) {
        boolean result = Boolean.FALSE;

        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            if (this.nome[i].equals(nomeAtleta)) {
                this.nome[i] = "";
                this.tempoImpiegato[i] = 0;
                result = Boolean.TRUE;
            }
        }

        return result;
    }

    /**
     * Metodo per assegnare un tempo all'atleta
     *
     * @param nomeAtleta  Il nome dell'atleta
     * @param tempoAtleta Il tempo dell'atleta
     * @return Se l'assegnazione è andata a buon fine
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public boolean assegnaTempoImpiegato(String nomeAtleta, Integer tempoAtleta) {
        boolean result = Boolean.FALSE;

        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            if (this.nome[i].equals(nomeAtleta)) {
                this.tempoImpiegato[i] = tempoAtleta;
                result = Boolean.TRUE;
            }
        }

        return result;
    }

    /**
     * Metodo per effettuare una query all'interno dell'array attraverso il nome
     * dell'atleta
     *
     * @param nomeAtleta Nome dell'atleta
     * @return Il tempo da lui impiegato
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public String ricercaPerNome(String nomeAtleta) {
        StringBuilder output = new StringBuilder("Ricerca per atleta:\n");

        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            if (this.nome[i].equals(nomeAtleta)) {
                output.append("Atleta:\t").append(this.nome[i]).append("\nTempo:\t").append(this.tempoImpiegato[i]);
            }
        }
        return output.toString();
    }

    /**
     * Metodo per incrementare il valore numeroEffettivoPartecipanti
     *
     * @return L'intero elenco dei partecipanti
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public String elencoPartecipanti() {
        StringBuilder output = new StringBuilder("Elenco Atleti:\n");

        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            output.append("Atleta:\t").append(this.nome[i]).append("\tTempo:\t").append(this.tempoImpiegato[i]).append("\n");

        }

        return output.toString();
    }

    /**
     * Metodo per determinare il partecipante più lento
     *
     * @return Il nome del partecipante più lento
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public String partecipantePiuLento() {
        String result = "Il partecipante più lento è:\t";
        int athlete = 0;
        Integer max = this.tempoImpiegato[0];

        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            if (max <= this.tempoImpiegato[i]) {
                max = this.tempoImpiegato[i];
                athlete = i;
            }
        }
        result += this.nome[athlete];

        return result;
    }

    /**
     * Metodo per determinare quanti partecipanti sono sopra i secondi indicati
     *
     * @param secondi Soglia minima dei secondi
     * @return Quanti partecipanti superano i secondi indicati
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public Integer nPartecipantiAlDiSopraDiTotSecondi(Integer secondi) {
        Integer index = 0;

        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            if (this.tempoImpiegato[i] > secondi) {
                index++;
            }
        }

        return index;
    }

    /**
     * Metodo per determinare il tempo medio di tutti i partecipanti
     *
     * @return La media di tutti gli atleti
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public float tempoMedio() {
        float somma = (float) 0.0;
        float media;

        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            somma = somma + this.tempoImpiegato[i];
        }

        media = somma / this.numeroMaxPartecipanti;

        return media;
    }

    /**
     * Metodo per incrementare il valore numeroEffettivoPartecipanti
     *
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    private void incNumeroEffettivoPartecipanti() {
        this.numeroEffettivoPartecipanti++;
    }

    /**
     * Ciclo per inizializzare i due vettori: Nome, TempoImpiegato
     *
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    private void inizializzaVettori() {
        for (int i = 0; i < this.numeroMaxPartecipanti; i++) {
            this.nome[i] = "";
            this.tempoImpiegato[i] = 0;
        }
    }
}
