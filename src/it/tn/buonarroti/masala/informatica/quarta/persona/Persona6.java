package it.tn.buonarroti.masala.informatica.quarta.persona;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Math.toIntExact;

public class Persona6 {
	private static Integer numeroIstanze;
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
	private String dataDiNascita;
	@Getter
	private Integer eta;
	@Getter
	private String email;
	@Getter
	private String password;

	public Persona6(Double altezza, String cognome, String nome, Float peso,
	                String dataDiNascita) throws Exception {
		this.altezza = altezza;
		this.cognome = cognome;
		this.nome = nome;
		this.peso = peso;
		this.setDataDiNascita(dataDiNascita);
		numeroIstanze++;
	}

	public Persona6() throws Exception {

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

	public void setDataDiNascita(String dataDiNascita) throws Exception {
		try {
			if (DateValidator.getInstance().isValid(dataDiNascita)) {
				this.dataDiNascita = dataDiNascita;
				calcolaEta();
			} else throw new Exception("Formato della data errato!");
		} catch (NullPointerException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verificaOmonimia(Persona5 persona) {
		Boolean valida2 = FALSE;
		if (this.nome.equals(persona.getNome()) && this.cognome.equals(persona.getCognome())) {
			valida2 = TRUE;
		}
		return valida2;
	}

	public void setEmail(String email) throws Exception {
		try {
			if (EmailValidator.getInstance().isValid(email)) {
				this.email = email;
			} else throw new Exception("Formato della mail errato!");
		} catch (NullPointerException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPassword(String password) throws Exception {
		Integer Min_Len = 10, Min_Num = 1, Min_Uppercase = 1, Min_Lowercase = 1;
		Integer Val_Len = 0, Val_Num = 0, Val_Uppercase = 0, Val_Lowercase = 0;
		try {
			if (password.length() >= Min_Len) {
				Val_Len = password.length();
				for (int i = 0; i < Val_Len; i++) {
					if (Character.isDigit(password.charAt(i))) Val_Num++;
					if (Character.isUpperCase(password.charAt(i))) Val_Uppercase++;
					if (Character.isLowerCase(password.charAt(i))) Val_Lowercase++;
				}
			}
			if (Val_Len >= Min_Len && Val_Num >= Min_Num && Val_Uppercase >= Min_Uppercase && Val_Lowercase >= Min_Lowercase) {
				this.password = password;
			} else throw new Exception("Requisiti della password insufficienti!");
		} catch (NullPointerException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String info() {
		return "altezza = " + altezza
				+ "\ncognome = " + cognome
				+ "\nnome = " + nome
				+ "\npeso = " + peso
				+ "\ndataDiNascita = " + dataDiNascita
				+ "\nEmail = " + email
				+ "\nPassword = " + password
				+ "\netà = " + eta;
	}
}
