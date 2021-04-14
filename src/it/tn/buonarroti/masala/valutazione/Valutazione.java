package it.tn.buonarroti.masala.valutazione;

import it.tn.buonarroti.masala.exceptions.DesiredIndexSmallerThanDeclared;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Francesco Masala (mail@francescomasala.me)
 */

public class Valutazione {
    private Integer lunghezzaMax;
    private Integer indice = 0;
    private float[] voti;
    private String[] alunni;

    public Valutazione() {
        Integer lunghezzaMax = this.lunghezzaMax;
    }

    /**
     * Serve per inserire il nominativo ed il voto di uno studente nei due array privati voti, alunni
     *
     * @param alunno Nome dell'alunno da inserire nell'array
     * @param voto   Voto dell'alunno da inserire nell'array
     *
     *               <blockquote>
     *               <pre>
     *                             aggiungiValutazione(Mario Rossi, 7.75);
     *               </pre>
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
        Arrays.sort(alunni);
    }

    /**
     * Effettua un ordinamento decrescente per voto
     */
    public void ordinamentoDecrescente() {
        float[] cloneVoti = this.voti;

        Arrays.sort(cloneVoti);

        for (int index = 0; index < this.indice; index++) {
            this.voti[index] = cloneVoti[this.indice - index];
        }
    }

    /**
     * Effettua una query all'interno dell'array Alunni e restituisce una stringa con l'alunno ed il rispettivo voto
     *
     * @param Alunno Nome dell'alunno
     */
    public String ricercaPerAlunno(String Alunno) {
        String result = "";

        for (int index = 0; index < this.indice; index++) {
            if (this.alunni[index].equals(Alunno)) {
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
     * @param Voto Nome dell'alunno
     */
    public String ricercaPerVoto(Float Voto) {
        boolean queryExec = Boolean.FALSE;
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
    }

    /**
     * Effettua una media globale dei voti di tutti gli alunni
     */
    public Float mediaDeiVoti() {
        Integer index = 0; // Variabile locale per l'indice
        Float media = null;// Variabile per contenere la media

        while (index <= this.indice) {
            media = this.voti[index];
            index++;
        }

        media /= index;

        return media;
    }

    public String nAlunniSufficientiEInsufficienti() {

        return null;
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
