package it.tn.buonarroti.masala.informatica.quarta.studente;

public class Studente3 extends Studente2 implements Cloneable {

	public Studente3() {
		super();
	}

	public Studente3(Integer classe, Boolean isRipetente, Double altezza, String cognome, String nome, Float peso, String dataDiNascita, String password, String email) throws Exception {
		super(classe, isRipetente, altezza, cognome, nome, peso, dataDiNascita, password, email);
	}

	//Metodi
	public Studente3 clone() {

		Studente3 voidClone = new Studente3();
		Studente3 returnObject;

		try {
			returnObject = (Studente3) super.clone();
		} catch (Exception e) {
			returnObject = voidClone;
		}

		return returnObject;

	}

	public boolean equals(Object oggetto) {

		Boolean result;

		result = oggetto.equals(this);

		return result;
	}

	public String toString() {
		try {
			return super.toString();
		} catch (Exception e) {
			return null;
		}

	}

	public int hashCode() {
		return super.hashCode();
	}

	protected void finalize() throws Throwable {
		super.finalize();
	}


}