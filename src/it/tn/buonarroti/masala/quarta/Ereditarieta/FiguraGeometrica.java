package it.tn.buonarroti.masala.quarta.Ereditarieta;

import lombok.Getter;
import lombok.Setter;
import it.tn.buonarroti.masala.utils.Data;

public abstract class FiguraGeometrica {
	@Getter
	@Setter
	protected String colore;
	public abstract Integer numeroLati();
}
