package it.tn.buonarroti.masala.terza.esercizi;

import java.util.Scanner;

public class Esercizio1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a, b, c;
        double delta, ris_1, ris_2;

        Scanner usr_input = new Scanner(System.in);

        do {
            System.out.println("Inserisci la variabile A:");
            a = usr_input.nextInt();
        } while (a == 0);

        System.out.println("Inserisci la variabile B:");
        b = usr_input.nextInt();
        System.out.println("Inserisci la variabile C:");
        c = usr_input.nextInt();
        System.out.println("\n");

        delta = Math.pow(b, 2) - (4 * a) * c;

        if (delta < 0) {
            System.out.println("\n");
            System.out.println("Valore del delta minore di 0");
        } else {
            System.out.println("\n");
            ris_1 = ((b * (-1)) + Math.sqrt(delta) / (2 * a));
            ris_2 = ((b * (-1)) - Math.sqrt(delta) / (2 * a));

            System.out.println("Risultato 1:" + ris_1);
            System.out.println("Risultato 2:" + ris_2);
        }

        usr_input.close();
    }
}
