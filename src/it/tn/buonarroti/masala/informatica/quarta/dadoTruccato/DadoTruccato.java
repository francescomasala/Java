package it.tn.buonarroti.masala.informatica.quarta.dadoTruccato;

import java.util.Random;

public class DadoTruccato extends Random {

	public DadoTruccato() {
		super();
	}

	@Override
	public int nextInt(int num) {
		int ran = super.nextInt(2);
		if (ran == 0) {
			return num - 1;
		} else {
			int i = super.nextInt(num - 1);
			return i;
		}
	}
}
