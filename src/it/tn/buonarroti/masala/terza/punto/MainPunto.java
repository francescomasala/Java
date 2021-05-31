package it.tn.buonarroti.masala.terza.punto;

public class MainPunto {
    public static void main(String[] args) {

        Punto punto = new Punto(3.0, 5.0);
        System.out.println(punto);

        punto.traslaX(2.0);
        System.out.println(punto);

        System.out.println(punto.distanzaDaOrigine());

        Punto punto2 = new Punto(4.0, 5.0);
        System.out.println(punto.distanzaDaPunto(punto2));
    }
}
