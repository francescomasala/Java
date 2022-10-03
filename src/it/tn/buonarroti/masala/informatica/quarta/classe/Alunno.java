package it.tn.buonarroti.masala.informatica.quarta.classe;

import lombok.Getter;
import lombok.Setter;

public class Alunno {
	@Getter
	private final String dataNascita;
	@Getter
	@Setter
	private String cognome;
	@Getter
	@Setter
	private String nome;

	public Alunno(String cognome, String nome, String dataNascita) {
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
	}
}
