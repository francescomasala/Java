package it.tn.buonarroti.masala.informatica.quarta.puntaTrapano;

public class Punta {

	//Attrb.
	protected Float diametroPunta;
	protected Integer durabilitaPunta;

	//Costr
	public Punta(Float diametroPunta, Integer durabilitaPunta) {
		this.diametroPunta = diametroPunta;
		this.durabilitaPunta = durabilitaPunta;
	}

	//Get e Set
	public Float getDiametroPunta() {
		return diametroPunta;
	}

	public Integer getDurabilitaPunta() {
		return durabilitaPunta;
	}


}