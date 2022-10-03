package it.tn.buonarroti.masala.informatica.quarta.Ereditarieta;

public interface PoligonoRegolare {
	Double NF_TE = 0.289; // Numero fisso triangolo equilatero
	Double NF_Q = 0.500;  // Numero fisso quadrato

	/**
	 * Calcola l'apotema del poligono
	 */
	Double calcolaApotema();
}
