package it.tn.buonarroti.masala.quarta.Ereditarieta;

public interface PoligonoRegolare {
	public static final Double NF_TE=0.289; // Numero fisso triangolo equilatero
	public static final Double NF_Q=0.500;  // Numero fisso quadrato

	/**
	 * Calcola l'apotema del poligono
	 */
	public abstract Double calcolaApotema();
}
