package it.tn.buonarroti.masala.esercizi;

import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {
        // Variables Declaration
        int cnt_stud, cnt_grades, cnt_med = 0, cnt_min = 0, cnt_max = 0, grade;

        // Counters Declaration
        int i_0 = 1, i_1 = 1;

        // Init the scanner input
        Scanner usr_input = new Scanner(System.in);

        // Ask the user how many students he wants
        System.out.print("Inserisci il numero desiderato di studenti: ");
        cnt_stud = usr_input.nextInt();
        System.out.println();

        // Ask the user how many student grades he wants
        System.out.print("Inserisci il numero desiderato di voti per studente: ");
        cnt_grades = usr_input.nextInt();
        System.out.println();

        while (i_0 <= cnt_stud) {
            while (i_1 <= cnt_grades) {
                // Ask the user for the vote
                System.out.print("Inserisci il voto " + i_1 + " dello studente " + i_0 + ":");
                grade = usr_input.nextInt();
                System.out.println();

                // Check if the repetition is performed for the first time.
                // If the construct is positive it assigns the entered value to the **min** variable
                // If the construct is negative it does nothing, easy
                if (i_1 == 1) {
                    cnt_min = grade;
                    cnt_max = grade;
                }

                if (grade < cnt_min) {
                    cnt_min = grade;
                }

                if (grade > cnt_max) {
                    cnt_max = grade;
                }
                cnt_med = cnt_med + grade;
                i_1++;
            }

            // Final part of the algorithm
            String min_phrase = "Il voto minore dello studente" + i_0 + " è: " + cnt_min;
            System.out.println(min_phrase);
            System.out.println();

            // Final part of the algorithm
            String max_phrase = "Il voto massimo dello studente" + i_0 + " è: " + cnt_max;
            System.out.println(max_phrase);
            System.out.println();

            // Final part of the algorithm
            cnt_med = cnt_med / cnt_grades;
            String med_phrase = "La media dello studente" + i_0 + " è: " + cnt_med;
            System.out.println(med_phrase);
            System.out.println();

            // Final part of the algorithm
            cnt_med = 0;
            cnt_min = 0;
            cnt_max = 0;
            i_1 = 1;
            i_0++;
        }
        usr_input.close();
    }
}
