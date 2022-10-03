package it.tn.buonarroti.masala.informatica.terza.esercizi;

import java.util.Random;

public class Esercizio7 {
	public static void main(String[] args) {
		// Random object declaration
		Random rand = new Random();
		// Array declaration
		int[] Main_Arr = new int[100];
		int[] Inv_Arr = new int[100];
		boolean[] Max_Min_Arr = new boolean[100];
		// Fill the array with random values
		for (int i = 0; i < 100; i++) {
			Main_Arr[i] = rand.nextInt();
			System.out.println("Val: " + i + " Primo Array: " + Main_Arr[i]);
		}
		// Print a separator
		System.out.println("!--------------------------------!");
		// Fill the array with random values
		for (int i = 0; i < 100; i++) {
			if (Main_Arr[i] <= 50)
				Max_Min_Arr[i] = Boolean.FALSE;
			if (Main_Arr[i] <= 100)
				Max_Min_Arr[i] = Boolean.TRUE;
			System.out.println("Val: " + i + " Secondo Array: " + Max_Min_Arr[i]);
		}
		// Fill the array with random values
		for (int i = 0; i < 100; i++) {
			Inv_Arr[99 - i] = Main_Arr[i];
		}
		// Print a separator
		System.out.println("!--------------------------------!");

		// Print the array with random values
		for (int i = 0; i < 100; i++) {
			System.out.println("Val: " + i + " Terzo Array: " + Inv_Arr[i]);
		}
		// Print a separator
		System.out.println("!--------------------------------!");
	}
}
