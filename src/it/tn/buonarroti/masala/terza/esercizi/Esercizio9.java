package it.tn.buonarroti.masala.terza.esercizi;

import java.util.Random;

/**
 * @author francesco.masala
 */

public class Esercizio9 {
    public static void main(String[] args) {
        // Random object declaration
        Random rand = new Random();
        // Array declaration
        int[] Main_Arr = new int[10];
        int[] Inv_Arr = new int[10];
        boolean[] Max_Min_Arr = new boolean[10];
        // Fill the array with random values
        for (int i = 0; i < 10; i++) {
            Main_Arr[i] = rand.nextInt();
        }
        // Fill the array with random values
        for (int i = 0; i < 10; i++) {
            if (Main_Arr[i] <= 50) {
                Max_Min_Arr[i] = Boolean.FALSE;
            }
            if (Main_Arr[i] <= 100) {
                Max_Min_Arr[i] = Boolean.TRUE;
            }

        }
        // Print the array
        System.out.println("Secondo Array: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(Max_Min_Arr[i] + " ");
        }
        // Fill the array with random values
        for (int i = 0; i < 10; i++) {
            Inv_Arr[9 - i] = Main_Arr[i];
        }
    }
}
