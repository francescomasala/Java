package it.tn.buonarroti.masala.terza.esercizi;

import java.util.Random;
import java.util.Scanner;

public class Esercizio6 {
	public static void main(String[] args) {
		//Declare a random object
		Random random = new Random();
		// Variables Declaration
		int Array_Vec, Undef_Obj, Max_value;
		Scanner usr_input = new Scanner(System.in);
		// Array Declaration
		System.out.print("Specificare la dimensione dell'array: ");
		Array_Vec = usr_input.nextInt();
		System.out.println();
		int[] array = new int[Array_Vec];
		// For each array position enter a random integer value
		for (int i = 0; i < Array_Vec; i++) {
			array[i] = random.nextInt(100);
		}
		// Enter a value to look for
		System.out.print("Inserisci il valore desiderato: ");
		Undef_Obj = usr_input.nextInt();
		// Ask the array for that specific value
		Max_value = 0;
		for (int i = 0; i < Array_Vec; i++) {
			// Search the array for that specific value
			if (array[i] == Undef_Obj) {
				System.out.println("Il valore inserito è stato trovato. (" + Undef_Obj + ")");
			}
			//cerca massimo
			if (Max_value == 0 || Max_value < array[i]) {
				Max_value = array[i];
			}
		}
		usr_input.close();
		// Prints Max Value
		System.out.println("Valore massimo all'interno dell'array: " + Max_value);
	}
}
