package it.tn.buonarroti.masala.elenco;

public class Elenco {

    //Attributi
    private final String[] nominativi;
    private Integer numeroElementi;
    private Integer maxElementi;

    //Costruttore
    public Elenco(Integer maxElementi) {
        this.nominativi = new String[maxElementi];
        numeroElementi = 0;
    }

    public Integer getNumeroElementi() {
        return numeroElementi;
    }

    public void aggiungiNominativo(String Nominativo) {
        this.nominativi[this.numeroElementi] = Nominativo;
        this.numeroElementi++;
    }

    public String trovaDaIntex(Integer Indice) {
        String localNominativo;
        if (Indice >= 0 && Indice < numeroElementi) {
            localNominativo = this.nominativi[Indice];
        } else {
            localNominativo = "Errore: spazio nullo";
        }
        return localNominativo;
    }
}