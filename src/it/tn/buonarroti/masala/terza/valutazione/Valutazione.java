package it.tn.buonarroti.masala.terza.valutazione;

import it.tn.buonarroti.masala.terza.exceptions.DesiredIndexSmallerThanDeclared;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */

public class Valutazione {
    private final Integer lunghezzaMax;
    private Integer indice = 0;
    private final Float[] voti;
    private final String[] alunni;

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
     *                                           aggiungiValutazione(Mario Rossi, 7.75f);
     *                             </pre>
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
        String result = "";

        for (int index = 0; index < this.indice; index++) {
            if (this.alunni[index].equals(alunno)) {
                result += "Alunno: " + this.alunni[index] + "\n" +
                        "Voto: " + this.voti[index] + "\n";
            }
        }
        return result;
    }

    /**
     * Effettua una query all'interno dell'array Voti e restituisce una stringa contenente tutti gli alunni con quel
     * voto
     *
     * @param voto Nome dell'alunno
     */
    public String ricercaPerVoto(Float voto) {
        /*
        Boolean queryExec = Boolean.FALSE;
        String query = "Alunni con il seguente voto:" + "\n";
        int index; // Variabile locale per l'indice

        for (index = 0; Objects.equals(this.voti[index], Voto); index++) {
            queryExec = Boolean.TRUE;
            query += this.voti[index] + "\n";
        }
        if (queryExec) {
            return query;
        } else {
            return "La ricerca non ha portato alcun risultato.\n";
        }
        */
        String result = "";

        for (int index = 0; index < this.indice; index++) {
            if (Objects.equals(this.voti[index], voto)) {
                result += "Alunno: " + this.alunni[index] + "\n" +
                        "Voto: " + this.voti[index] + "\n";
            }
        }
        return result;
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
        String result = "Alunni sufficienti: \n";
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
            result += sufficienti[index] + "\n";
        }
        result += "Alunni insufficienti: \n";
        for (int index = 0; index != indexTwo; index++) {
            result += sufficienti[index] + "\n";
        }
        return result;
    }

    @Override
    public String toString() {

        String ris = "";
        ris += "ARR. VOT: ";

        for (int i = 0; i < indice; i++) {
            ris += voti[i] + " ";
        }

        ris += "ARR. STD: ";

        for (int i = 0; i < indice; i++) {
            ris += alunni[i] + " ";
        }

        ris += "LUN. MAX: " + lunghezzaMax;
        ris += "IND. ARR: " + indice;

        return ris;
    }

    private void incrementIndex() {
        this.indice++;
    }

    private void indexCheck(Integer index) throws DesiredIndexSmallerThanDeclared {
        if (index < this.indice) {
            throw new DesiredIndexSmallerThanDeclared("L'indice inserito è più piccolo di quello attuale:\n" +
                    "Indice desiderato: " + index + "\nIndice Attuale: " + this.indice);
        }
    }

}
