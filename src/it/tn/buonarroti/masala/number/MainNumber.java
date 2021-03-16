package it.tn.buonarroti.masala.number;

/**
 * @author francesco.masala
 */
public class MainNumber {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        int ParametroAttuale = 12;
        Number n = new Number(ParametroAttuale);
        System.out.println(n.outputString());
        n.setNum(64);
        System.out.println(n.outputString());
        System.out.println(n.mcd(ParametroAttuale));
    }

}