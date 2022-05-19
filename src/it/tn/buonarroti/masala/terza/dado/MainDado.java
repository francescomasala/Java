package it.tn.buonarroti.masala.terza.dado;

import java.util.Scanner;

/**
 * @author francesco.masala
 */
public class MainDado {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int scelta;
		System.out.println("Scrivere:\n1) Per dadoUno\n2) Per dado due");
		Scanner usr_input = new Scanner(System.in);
		scelta = usr_input.nextInt();
		if (scelta == 1) {
			DadoUno d1Uno = new DadoUno(6, "legno", "blu", 4.0f, 2.0d);
			System.out.print(d1Uno.lanciaDado(30));
		} else {
			DadoDue d2Due = new DadoDue(6, "legno", "blu", 4.0f, 2.0d);
			Integer[] tiro = d2Due.tiroCompleto(35);
		}
		usr_input.close();
	}
}