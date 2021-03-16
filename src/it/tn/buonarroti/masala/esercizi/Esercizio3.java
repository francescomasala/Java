package it.tn.buonarroti.masala.esercizi;

import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {

        //Dichiara oggetto Scanner
        Scanner input = new Scanner(System.in);

        //Ottengo 3 valori dall'utente
        int numeroValori, numeroCorrente, numeroMinimo = 0, contatoreValore = 0;

        //Chiedi all'utente i valori da inserire
        System.out.print("Inserisci il numero di valori da confrontare: ");
        numeroValori = input.nextInt();

        //Controllo del valore
        while (numeroValori <= 0) {
            System.out.println("Il valore inserito non è valido.");
            System.out.print("Inserisci un nuovo valore: ");
            numeroValori = input.nextInt();
        }

        //Valore convalidato, inizia la raccolta dati
        while (contatoreValore != numeroValori) {

            //Inserisci un nuovo valore
            System.out.print("Inserisci valore " + (contatoreValore + 1) + ": ");
            numeroCorrente = input.nextInt();

            //Confronta con il minimo e controlla se il primo numero è stato immesso.
            if ((numeroMinimo > numeroCorrente) || contatoreValore == 0) {
                numeroMinimo = numeroCorrente;
            }

            //Aggiorna contatore
            contatoreValore++;
        }

        //Esecuzione terminata, stampa valore minimo all'utente
        System.out.println();
        System.out.println("Numero minimo: " + numeroMinimo);

    }
}
