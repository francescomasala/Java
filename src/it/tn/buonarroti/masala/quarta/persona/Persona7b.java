package it.tn.buonarroti.masala.quarta.persona;

import static java.lang.Math.*;
import java.util.*;
import java.time.*;
import java.util.regex.*;
import org.apache.commons.validator.routines.EmailValidator;
import me.francescomasala.school.libs.utils.DataHard;

public final class Persona7b {

	public Double altezza;
	public String cognome;
	public String nome;
	public Float peso;
	private DataHard dataDiNascita;
	private Integer eta;
	private String email;
	private String password;
	static private int numeroIstanze;

	public Persona7b() {
	}

	public Persona7b(Double altezza, String cognome, String nome, Float peso,
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

	//nuovo in persona 6
	public void setEmail(String email) throws Exception {
		//Dichiarazione pattern e matcher
		Pattern pattern = Pattern.compile("[a-z0-9._-]+@[a-z0-9._-]+.[a-z]");
		Matcher matcher = pattern.matcher(email);

		if(matcher.matches()){
			this.email = email;
		}else{
			throw new Exception("L'email non rispetta il formato richiesto");
		}
	}

	//Nuovo in persona 7
	public void setPassword(String password) throws Exception {

		//Dichiarazione pattern e matcher
		Pattern pattern = Pattern.compile("[a-zA-Z0-9!%&=?-_.><*]{8,64}");
		Matcher matcher = pattern.matcher(password);

		if(matcher.matches()){
			this.password = password;
		}else{
			throw new Exception("La password non rispetta il formato richiesto");
		}

	}


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}


	public Double getAltezza() {
		return altezza;
	}

	public void setAltezza(Double altezza) throws Exception {
		if(altezza != null && (altezza < 230 && altezza > 30)) this.altezza = altezza;
		else throw new Exception("Altezza fuori dal range oppure valore nullo.");
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) throws Exception {

		if (cognome == null & cognome.length() < 1) throw new Exception("Cognome assegnato via stringa vuota o valore nullo.");
		else{
			Pattern pattern = Pattern.compile("[a-zA-Zèòàù]+");
			Matcher matcher = pattern.matcher(cognome);

			if(matcher.matches()){
				this.cognome = cognome;
			}else{
				throw new Exception("Il cognome non rispetta il formato.");
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception{
		if (nome == null & nome.length() < 1) throw new Exception("Nome assegnato via stringa vuota o valore nullo.");
		else{
			Pattern pattern = Pattern.compile("[a-zA-Zèòàù]+");
			Matcher matcher = pattern.matcher(nome);

			if(matcher.matches()){
				this.nome = nome;
			}else{
				throw new Exception("Il nome non rispetta il formato.");
			}
		}
	}

	public Float getPeso() {
		return peso;
	}


	public void setPeso(Float peso) {
		if(peso > 1 && peso < 636) this.peso = peso;
	}

	//aggiornato per persona 6
	public String getDataDiNascita() {
		return dataDiNascita.toString();
	}

	//aggiornato per persona 7 NEW
	public void setDataDiNascita(String dataDiNascita) throws Exception {

		DataHard data = new DataHard(dataDiNascita);
		DataHard current = new DataHard();

		if(data.differenzaInGiorni(data, current) < 0){
			throw new Exception("La data non può essere successiva a quella odierna.");
		}else{
			this.dataDiNascita = data;
		}

	}

	public void setDataDiNascita(DataHard data){
		this.dataDiNascita = data;
	}

	//aggiornato per persona 7
	public Boolean verificaOmonimia(Persona7b persona){
		if(persona.equals(this)) return true; else return false;
	}

	//Aggiornato per persona 7
	public Integer getEta() {
		return eta;
	}

	//Aggiornato per persona 7
	private void calcolaEta() throws Exception {

		DataHard current = new DataHard();

		//Calcola età
		this.eta = current.differenzaInAnni(dataDiNascita, current);

	}

	//Aggiornato per persona 6
	public String info() {
		return "== Informazioni su: " + nome + " " + cognome + " =="
				+ "\nAltezza:  " + altezza
				+ "\nPeso: " + peso
				+ "\nData di Nascita: " + dataDiNascita.toString()
				+ "\nEta: " + eta
				+ "\nEmail: " + email
				+ "\nPassword: **********";
	}
}