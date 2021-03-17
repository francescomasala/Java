package it.tn.buonarroti.masala.esercizi;

import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        //  Variables declaration
        int num_cache, min = 0, i = 1, count_values;
        // Initialize the scanner function
        Scanner usr_input = new Scanner(System.in);

        // Create the initial part of the algorithm
        System.out.print("Inserisci il numero di valori desiderato:");
        count_values = usr_input.nextInt();
        System.out.println();

        // Create zero values exception
        while (count_values <= 0) {
            System.out.println("Valore minore o uguale a 0");
            System.out.print("Re-inserire il numero di valori desiderato:");
            count_values = usr_input.nextInt();
            System.out.println();
        }

        // Middle part of the algorithm
        while (i <= count_values) {
            String number_phrase = "Inserire il numero " + i + " :";
            System.out.print(number_phrase);
            num_cache = usr_input.nextInt();

            // Check if the repetition is performed for the first time.
            // If the construct is positive it assigns the entered value to the **min** variable
            // If the construct is negative it does nothing, easy
            if (i == 1) {
                min = num_cache;
            }

            // If the construct is positive it assigns the entered value to the **min** variable
            // If the construct is negative it does nothing, easy
            if (num_cache < min) {
                min = num_cache;

            }
            // Prints a new line for a better CLI readability
            System.out.println();
            ++i;
        }

        // Final part of the algorithm
        String min_phrase = "Il numero minore di tutti è: " + min;
        System.out.println(min_phrase);
        usr_input.close();
    }
}
