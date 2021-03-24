package it.tn.buonarroti.masala.lanci;

import java.util.Random;

/**
 * @author francesco.masala
 *
 * @lastupdate 24/03/2021
 */

public class Lanci {
    private Integer numLanci;
    private Integer numFacce;
    private Integer arrLanci[];
    private Integer indexLanci;

    public Lanci (){
    }

    /**
     * @author Francesco Masala (mail@francescomasala.me)
     *
     * @version 0.1
     *
     * Serve per inizializzare la classe Lanci
     *
     * @param Lanci Indica il numero di lanci da effettuare
     *
     * @param Facce Indica il numero di Facce del dado
     *
     */
    public void InitThrow(Integer Facce, Integer Lanci){
        this.numFacce = Facce;
        this.numLanci = Lanci;
    }

    /**
     * @author Francesco Masala (mail@francescomasala.me)
     *
     * @version 0.1
     *
     * Effettua il lancio del dato
     */
    public void DoThrow(){

        Random random = new Random();
        int randomInteger = random.nextInt(this.numFacce);
        this.arrLanci[this.indexLanci] = randomInteger;
        this.IncThrowIndex();

    }

    /**
     * @author Francesco Masala (mail@francescomasala.me)
     *
     * @version 0.1
     *
     * @param value0 Indica il valore minimo del filtro
     *
     * @param value1 Indica il valore massimo del filtro
     *
     * @return Quanti valori corrispondono al Filtro
     *
     */
    public Integer FilterThrow (Integer value0, Integer value1){
        Integer localI=0;
        while (localI <= this.indexLanci) {
            if (this.arrLanci[this.indexLanci] <= value0 && this.arrLanci[this.indexLanci] >= value1){
                localI ++;
            }
        }
        return localI;
    }

    /**
     * @author Francesco Masala (mail@francescomasala.me)
     *
     * @version 0.1
     *
     * @return Idk really
     *
     */
    public String StringThrow(){
        return null;
    }

    /**
     * @author Francesco Masala (mail@francescomasala.me)
     *
     * @version 0.1
     *
     * Serve per incrementare il valore dell'indice della classe
     *
     */
    public void IncThrowIndex(){

        this.indexLanci++;

    }
}
