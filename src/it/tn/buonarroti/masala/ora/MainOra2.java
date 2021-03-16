package it.tn.buonarroti.masala.ora;

public class MainOra2 {
    public static void main(String[] args) {


        //Istanzio nuova ora
        Ora2 UNO = new Ora2(26, 22, 53);
        Ora2 DUE = new Ora2(20, 52, 24);

        Ora2 differenza = UNO.differenzaInOreMinSec(DUE);

        System.out.println("DIFFERENZA: " + differenza.getOre() + ":" + differenza.getMinuti() + ":" + differenza.getSecondi());


        System.out.println();


    }

}