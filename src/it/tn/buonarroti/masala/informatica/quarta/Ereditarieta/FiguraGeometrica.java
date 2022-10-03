package it.tn.buonarroti.masala.informatica.quarta.Ereditarieta;

import lombok.Getter;
import lombok.Setter;

public abstract class FiguraGeometrica {
	@Getter
	@Setter
	protected String colore;

	public abstract Integer numeroLati();
}
