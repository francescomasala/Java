package it.tn.buonarroti.masala.quarta.persona;

import me.francescomasala.school.libs.utils.DataHard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona7a {

	static private int numeroIstanze;
	public Double altezza;
	public String cognome;
	public String nome;
	public Float peso;
	protected String dataDiNascita;
	protected Integer eta;
	protected String email;
	protected String password;

	public Persona7a() {
	}

	public Persona7a(Double altezza, String cognome, String nome, Float peso,
	                 String dataDiNascita, String password, String email) throws Exception {
		this();
		this.setAltezza(altezza);
		this.setCognome(cognome);
		this.setNome(nome);
		this.setPeso(peso);
		this.setDataDiNascita(dataDiNascita);
		this.setPassword(password);
		this.setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	//nuovo in persona 6
	public void setEmail(String email) throws Exception {
		//Dichiarazione pattern e matcher
		Pattern pattern = Pattern.compile("[a-z0-9._-]+@[a-z0-9._-]+.[a-z]");
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches()) {
			this.email = email;
		} else {
			throw new Exception("L'email non rispetta il formato richiesto");
		}
	}

	public String getPassword() {
		return password;
	}

	//Nuovo in persona 7
	public void setPassword(String password) throws Exception {

		//Dichiarazione pattern e matcher
		Pattern pattern = Pattern.compile("[a-zA-Z0-9!%&=?-_.><*]{8,64}");
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches()) {
			this.password = password;
		} else {
			throw new Exception("La password non rispetta il formato richiesto");
		}

	}

	public Double getAltezza() {
		return altezza;
	}

	public void setAltezza(Double altezza) throws Exception {
		if (altezza != null && (altezza < 230 && altezza > 30)) this.altezza = altezza;
		else throw new Exception("Altezza fuori dal range oppure valore nullo.");
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) throws Exception {

		if (cognome == null & cognome.length() < 1)
			throw new Exception("Cognome assegnato via stringa vuota o valore nullo.");
		else {
			Pattern pattern = Pattern.compile("[a-zA-Zèòàù]+");
			Matcher matcher = pattern.matcher(cognome);

			if (matcher.matches()) {
				this.cognome = cognome;
			} else {
				throw new Exception("Il cognome non rispetta il formato.");
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (cognome == null & cognome.length() < 1)
			throw new Exception("Nome assegnato via stringa vuota o valore nullo.");
		else {
			Pattern pattern = Pattern.compile("[a-zA-Zèòàù]+");
			Matcher matcher = pattern.matcher(nome);

			if (matcher.matches()) {
				this.nome = nome;
			} else {
				throw new Exception("Il nome non rispetta il formato.");
			}
		}
	}

	public Float getPeso() {
		return peso;
	}


	public void setPeso(Float peso) {
		if (peso > 1 && peso < 636) this.peso = peso;
	}

	//aggiornato per persona 6
	public String getDataDiNascita() {
		return dataDiNascita;
	}

	//aggiornato per persona 7 NEW
	public void setDataDiNascita(String dataDiNascita) throws Exception {

		DataHard data = new DataHard(dataDiNascita);
		DataHard current = new DataHard();

		if (data.differenzaInGiorni(data, current) < 0) {
			throw new Exception("La data non può essere successiva a quella odierna.");
		} else {
			this.dataDiNascita = data.toString();
		}

	}

	//aggiornato per persona 7
	public Boolean verificaOmonimia(Persona7a persona) {
		return persona.equals(this);
	}

	//Aggiornato per persona 7
	public Integer getEta() {
		return eta;
	}

	//Aggiornato per persona 7
	private void calcolaEta() throws Exception {

		DataHard current = new DataHard();

		//Calcola età
		DataHard data = new DataHard(dataDiNascita);
		this.eta = current.differenzaInAnni(data, current);

	}

	//Aggiornato per persona 6
	public String info() {
		return "== Informazioni su: " + nome + " " + cognome + " =="
				+ "\nAltezza:  " + altezza
				+ "\nPeso: " + peso
				+ "\nData di Nascita: " + dataDiNascita
				+ "\nEta: " + eta
				+ "\nEmail: " + email
				+ "\nPassword: **********";
	}
}