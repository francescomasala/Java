package it.tn.buonarroti.masala.quarta.studente;

import java.util.Arrays;
import java.util.Random;

public class ProvaClone {
	public static void main(String[] args) {
		Random r  = new Random();
		Integer[] vett1 = new Integer[10];
		Integer[] vett2 = new Integer[20];

		for(int i=0; i < vett1.length; i++){
			vett1[i] = r.nextInt(10);
		}

		for(Integer num: vett2) {
			num = r.nextInt(10);
		}

		System.out.println(Arrays.toString(vett1));

		System.out.println(Arrays.toString(vett2));
	}
}
