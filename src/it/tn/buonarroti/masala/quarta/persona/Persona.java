package it.tn.buonarroti.masala.quarta.persona;

import lombok.Getter;
import lombok.Setter;

/**
 * La classe persona definisce le caratteristiche e comportamenti di una persona
 *
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 * @version 2021.10.21
 */
public class Persona {
	@Getter
	@Setter
	public Double altezza;
	@Getter
	@Setter
	public String cognome;
	@Getter
	@Setter
	public String nome;
	@Getter
	@Setter
	public Float peso;
	@Getter
	@Setter
	public String dataDiNascita;

	/**
	 * Primo costruttore del metodo
	 */
	public Persona() {

	}

	/**
	 * Secondo costruttore del metodo
	 *
	 * @param altezza       Inserire l'altezza come un double - Es. 1.75
	 * @param cognome       Inserire il cognome come una stringa - Es. Masala
	 * @param nome          Inserire il nome come una stringa - Es. Francesco
	 * @param peso          Inserire il peso come un float - Es. 72.450
	 * @param dataDiNascita Inserire la data di nascita come una stringa - Es. 27/02/2002
	 */
	public Persona(Double altezza, String cognome,
	               String nome, Float peso,
	               String dataDiNascita) {
		this.altezza = altezza;
		this.cognome = cognome;
		this.nome = nome;
		this.peso = peso;

		this.setDataDiNascita(dataDiNascita);
	}

	/**
	 * Metodo Info
	 *
	 * @return null
	 */
	public String info() {
		return "Cognome         :" + this.cognome + "\n"
				+ "Nome            :" + this.nome + "\n"
				+ "Altezza         :" + this.altezza + "\n"
				+ "Peso            :" + this.peso + "\n"
				+ "Data Di Nascita :" + this.dataDiNascita + "\n";
	}
}

