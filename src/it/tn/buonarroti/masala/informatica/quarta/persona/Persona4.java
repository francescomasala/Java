package it.tn.buonarroti.masala.informatica.quarta.persona;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Math.toIntExact;

public class Persona4 {
	private static Integer numeroIstanze;
	@Getter
	public Double altezza;
	@Getter
	public String cognome;
	@Getter
	@Setter
	public String nome;
	@Getter
	public Float peso;
	@Getter
	private String dataDiNascita;
	@Getter
	private Integer eta;

	public Persona4() {
	}

	public Persona4(Double altezza, String cognome, String nome, Float peso,
	                String dataDiNascita) throws Exception {
		this.altezza = altezza;
		this.cognome = cognome;
		this.nome = nome;
		this.peso = peso;
		this.setDataDiNascita(dataDiNascita);
		numeroIstanze++;
	}

	private void calcolaEta() {
		GregorianCalendar data = new GregorianCalendar();

		String s1 = dataDiNascita.substring(0, 2);
		String s2 = dataDiNascita.substring(3, 5);
		String s3 = dataDiNascita.substring(6, 10);

		int g = Integer.parseInt(s1);
		int m = Integer.parseInt(s2);
		int a = Integer.parseInt(s3);

		int anno = data.get(Calendar.YEAR);
		int mese = data.get(Calendar.MONTH) + 1;
		int giorno = data.get(Calendar.DAY_OF_MONTH);

		LocalDate start = LocalDate.of(a, m, g);
		LocalDate end = LocalDate.of(anno, mese, giorno);
		long years = ChronoUnit.YEARS.between(start, end);
		eta = toIntExact(years);
	}

	public void setDataDiNascita(String dataDiNascita) {

		try {
			String s1 = dataDiNascita.substring(0, 2);
			String s2 = dataDiNascita.substring(3, 5);
			String s3 = dataDiNascita.substring(6, 10);

			int g = Integer.parseInt(s1);
			int m = Integer.parseInt(s2);
			int a = Integer.parseInt(s3);

			Boolean valida = Boolean.FALSE;

			if (a >= 1000 && a <= 9999) {
				switch (m) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						if (g > -1 && g <= 31) {
							valida = true;
						}
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						if (g > -1 && g <= 30) {
							valida = true;
						}
						break;
					case 2:
						if (a % 4 == 0) {
							if (g > -1 && g <= 29) {
								valida = true;
							}
						} else {
							if (g > -1 && g <= 28) {
								valida = true;
							}
						}
				}
			}
			if (valida) {
				this.dataDiNascita = dataDiNascita;
				calcolaEta();
			} else
				throw new Exception("Data errata!");
		} catch (StringIndexOutOfBoundsException e) {

		} catch (NumberFormatException e) {

		} catch (NullPointerException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAltezza(Double altezza) throws Exception {
		if (altezza != null) {
			if (altezza < 230 && altezza > 30) {
				this.altezza = altezza;
			} else {
				throw new Exception("L'altezza deve essere maggiore di 30 e minore di 230");
			}
		} else {
			throw new NullPointerException("L'altezza deve essere maggiore di 30 e minore di 230");
		}
	}

	public Boolean verificaOmonimia(Persona4 persona) {
		Boolean valida2 = Boolean.FALSE;
		if (this.nome.equals(persona.getNome()) && this.cognome.equals(persona.getCognome())) {
			valida2 = Boolean.TRUE;
		}
		return valida2;
	}

	public String info() {
		return "altezza = " + altezza
				+ "\ncognome = " + cognome
				+ "\nnome = " + nome
				+ "\npeso = " + peso
				+ "\ndataDiNascita = " + dataDiNascita
				+ "\netà = " + eta;
	}

	public void setCognome(String cognome) throws Exception {
		try {
			if (cognome != null) {
				this.cognome = cognome;
			} else if (!cognome.equals("")) {
				throw new Exception("L'attributo non deve essere vuoto");
			} else {
				throw new Exception("L'attributo non deve essere una stringa");
			}
		} catch (NullPointerException e) {
			throw new Exception("L'attributo non deve essere nullo");
		}
	}

	public void setPeso(Float peso) throws Exception {
		try {
			if (peso > 0) {
				this.peso = peso;
			} else throw new Exception("Il peso è minore di 0");
		} catch (NullPointerException e) {
			throw new NullPointerException("Il valore di peso è nullo");
		}
	}
}


