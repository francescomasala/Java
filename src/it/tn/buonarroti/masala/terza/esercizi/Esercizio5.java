package it.tn.buonarroti.masala.terza.esercizi;

import java.util.Scanner;

public class Esercizio5 {
	public static void main(String[] args) {

		//Inizializzo variabili
		int valoreX, valoreN, i;
		i = 0;

		//Creo oggetto scanner
		Scanner input = new Scanner(System.in);

		//Chiedo all'utente X e N
		System.out.print("Inserisci il valore che verra' moltiplicato (x): ");
		valoreX = input.nextInt();
		System.out.print("Inserisci il numero di valori dell'array (n): ");
		valoreN = input.nextInt();

		//Dichiaro array
		double[] array = new double[valoreN];

		//Primo ciclo
		while (valoreN > i) {

			array[i] = Math.pow(valoreX, i);
			i++;

		}

		//Secondo ciclo (ordine inverso)
		System.out.println("Stampa in ordine inverso:");
		while (i > 0) {

			System.out.println(array[i - 1]);
			i--;

		}
		input.close();
	}
}
