package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.secondo;

import java.util.Random;

public class Utils {
	public int GenerateFuelRefill(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
