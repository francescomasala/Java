package it.tn.buonarroti.masala.valutazione;

import it.tn.buonarroti.masala.exceptions.DesiredIndexSmallerThanDeclared;

/**
 * @author Francesco Masala (mail@francescomasala.me)
 */

public class Valutazione {
    private Integer lunghezzaMax;
    private Integer indice = 0;
    private Float[] voti;
    private String[] alunni;

    public Valutazione(Integer lunghezzaMax) {
        lunghezzaMax = this.lunghezzaMax;
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
     *                             </pre></blockquote>
     */
    public Boolean aggiungiValutazione(String alunno, Float voto) {


        return null;
    }

    /**
     * Effettua un ordinamento crescente per alunno
     */
    public void ordinamentoCrescente() {

    }

    /**
     * Effettua un ordinamento decrescente per voto
     */
    public void ordinamentoDecrescente() {

    }

    /**
     * Effettua una query all'interno dell'array Alunni e restituisce una stringa con l'alunno ed il rispettivo voto
     *
     * @param Alunno Nome dell'alunno
     */
    public String ricercaPerAlunno(String Alunno) {

        return null;
    }

    /**
     * Effettua una query all'interno dell'array Voti e restituisce una stringa contenente tutti gli alunni con quel
     * voto
     *
     * @param Voto Nome dell'alunno
     */
    public String ricercaPerVoto(Float Voto) {
        Boolean queryExec = Boolean.FALSE;
        Integer index = 0; // Variabile locale per l'indice
        String output = null;

        for (index = 0; this.voti[index] == Voto; index++) {
            queryExec = Boolean.TRUE;
            output = output + "\n" + this.voti[index];
        }
        if (queryExec) {
            return output;
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

        media = media / index;

        return media;
    }

    public String nAlunniSufficientiEInsufficienti() {

        return null;
    }

    @Override
    public String toString() {

        return null;
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
