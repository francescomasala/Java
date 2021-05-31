package it.tn.buonarroti.masala.terza.classi;

/**
 * @author francesco.masala
 */
public class MainEs01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Es01 es01 = new Es01(4f, 2f, 30f);

        es01.calcola();

        System.out.println(es01.stampa());
    }

}
