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

    public void ordinamentoCrescente() {

    }

    public void ordinamentoDecrescente() {

    }

    public String ricercaPerAlunno(String Alunno) {

        return null;
    }

    public String ricercaPerVoto(Float Voto) {

        return null;
    }

    public Float mediaDeiVoti() {

        return null;
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
