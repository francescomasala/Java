package it.tn.buonarroti.masala.quarta.dadoTruccato;

import java.util.Random;

public class MainDadoTruccato {
	public static void main(String[] args) {
		DadoTruccato dado = new DadoTruccato();
		MainDadoTruccato mainDado = new MainDadoTruccato();
		System.out.println(dado.nextInt(7));
		System.out.println(mainDado.CheckDadoTruccato(9, 250000));
	}

	private String CheckDadoTruccato(int facceDado, int tiriPerControllo) {
		int iTrucc = 0, iNorm = 0, i = 0, checkTruccato = 0;
		int[] datiTrucc = new int[tiriPerControllo + 1];
		int[] datiNorm = new int[tiriPerControllo + 1];
		DadoTruccato dado = new DadoTruccato();
		Random random = new Random();

		while (iTrucc < tiriPerControllo) {
			datiTrucc[iTrucc] = dado.nextInt(facceDado);
			iTrucc++;
		}

		while (iNorm < tiriPerControllo) {
			datiNorm[iNorm] = random.nextInt(facceDado);
			iNorm++;
		}

		iTrucc = 0;
		iNorm = 0;

		while (i < tiriPerControllo) {
			if (datiTrucc[iTrucc] == (facceDado - 1)) {
				checkTruccato++;
			}

			if (datiNorm[iNorm] == (facceDado - 1)) {
				checkTruccato--;
			}
			iTrucc++;
			iNorm++;
			i++;
		}
		return "La possibilità che il dado sia truccato è dell': " + checkTruccato + "0%";
	}


}
