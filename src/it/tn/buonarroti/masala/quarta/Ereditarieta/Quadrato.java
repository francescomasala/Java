package it.tn.buonarroti.masala.quarta.Ereditarieta;

import lombok.Getter;
import lombok.Setter;

public class Quadrato extends FiguraPiana implements PoligonoRegolare {
	@Getter
	@Setter
	private double lato;

	public Quadrato(String colore, Double lato) {
		this.lato = lato;
		this.colore = colore;
	}

	public Integer numeroLati() {
		return 4;
	}

	@Override
	public Double calcolaPerimetro() {
		return lato * 4;
	}

	@Override
	public Double calcolaArea() {
		return lato * lato;
	}

	public Double calcolaApotema() {
		return lato * NF_Q;
	}

	public Double calcolaDiagonale() {
		return lato * Math.sqrt(2);
	}
}
