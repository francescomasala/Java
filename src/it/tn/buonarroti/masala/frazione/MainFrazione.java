package it.tn.buonarroti.masala.frazione;

public class MainFrazione {
    public static void main(String[] args) {

        //Frazione uno
        Frazione f1 = new Frazione(3, 2);
        Frazione f2 = new Frazione(4, 3);

        Frazione f3 = f1.Somma(f2);

        System.out.println("Frazione: " + f3.toString());

    }
}
