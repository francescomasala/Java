package it.tn.buonarroti.masala.dado;

/**
 * @author GIACOMO.BERTI & Francesco.Masala
 * @lastupdate 20/01/2021
 */
public class DadoDue {


    //Attributi dado
    private Integer nFacce;
    private String materiale;
    private String colore;
    private Float peso;
    private Double lato;

    //Costruttore senza dati
    public DadoDue() {
    }

    //Costruttore completo
    public DadoDue(Integer nFacce, String materiale, String colore, Float peso, Double lato) {
        this.nFacce = nFacce;
        this.materiale = materiale;
        this.colore = colore;
        this.peso = peso;
        this.lato = lato;
    }

    //Metodi Get e Set
    public Integer getnFacce() {
        return nFacce;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public Float getPeso() {
        return peso;
    }

    public Double getLato() {
        return lato;
    }

    //Metodi
    private Integer[] lanciaDado(Integer nLanci) {

        //dichiaro array (di Integer)
        Integer[] ctr;
        ctr = new Integer[nFacce];

        //inizializzazione array
        for (int i = 0; i != nFacce; i++) {
            ctr[i] = 0;
        }

        //Lancia il dado N volte
        //Incrementa per ogni valore uscito il corrispondente dell'array
        int i = 0;
        int numbers;
        int valorePiuComune;
        int numeroUscitePiuComune;
        while (i < nLanci) {
            numbers = (int) (Math.random() * nFacce) + 1;
            ctr[numbers - 1] += 1;
            i++;
        }


        //Trova valore più comune e quante volte è uscito
        numeroUscitePiuComune = ctr[0];
        valorePiuComune = 1;
        for (i = 1; i < nFacce; i++) {
            if (numeroUscitePiuComune < ctr[i]) {
                numeroUscitePiuComune = ctr[i];
                valorePiuComune = i + 1;

            }
        }

        //Trova valore meno comune e quante volte è uscito
        int valoreMenoComune = 1;
        int numeroUsciteMenoComune = ctr[0];
        for (i = 1; i < nFacce; i++) {
            if (numeroUsciteMenoComune > ctr[i]) {
                numeroUsciteMenoComune = ctr[i];
                valoreMenoComune = i + 1;

            }
        }

        Integer[] dati = new Integer[4];
        dati[0] = valorePiuComune;
        dati[1] = numeroUscitePiuComune;
        dati[2] = valoreMenoComune;
        dati[3] = numeroUsciteMenoComune;
        return dati;

    }

    public Integer frequenzaMaggiore(Integer nLanci) {

        Integer[] dati = lanciaDado(nLanci);
        return dati[1];

    }

    public Integer modaFaccia(Integer nLanci) {

        Integer[] dati = lanciaDado(nLanci);
        return dati[0];

    }

    public Integer menoModaFaccia(Integer nLanci) {

        Integer[] dati = lanciaDado(nLanci);
        return dati[2];

    }

    public Integer frequenzaMinore(Integer nLanci) {

        Integer[] dati = lanciaDado(nLanci);
        return dati[3];

    }

    public Integer[] tiroCompleto(Integer nLanci) {

        return lanciaDado(nLanci);

    }

}
