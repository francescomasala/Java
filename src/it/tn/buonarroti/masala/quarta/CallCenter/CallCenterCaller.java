package it.tn.buonarroti.masala.quarta.CallCenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallCenterCaller {
	public String FamilyName;
	public String PersonName;
	private Integer CallerID;
	private String email;

	public CallCenterCaller() {
	}

	public CallCenterCaller(String FamilyName, String PersonName, String email, Integer CallerID)
			throws Exception {
		this();
		this.setFamilyName(FamilyName);
		this.setPersonName(PersonName);
		this.setCallerID(CallerID);
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

	public Integer getCallerID() {
		return CallerID;
	}

	//Nuovo in persona 7
	public void setCallerID(Integer callCenterCaller) {
		this.CallerID = CallerID;
	}

	public String getFamilyName() {
		return FamilyName;
	}

	public void setFamilyName(String familyName) throws Exception {

		if (familyName == null & familyName.length() < 1) throw new Exception("Surname has empty or null value");
		else {
			Pattern pattern = Pattern.compile("[a-zA-Zèòàù]+");
			Matcher matcher = pattern.matcher(familyName);

			if (matcher.matches()) {
				this.FamilyName = familyName;
			} else {
				throw new Exception("This surname does not respect regex parameters: [a-zA-Zèòàù]");
			}
		}
	}

	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) throws Exception {
		if (FamilyName == null & FamilyName.length() < 1) throw new Exception("Name has empty or null value");
		else {
			Pattern pattern = Pattern.compile("[a-zA-Zèòàù]+");
			Matcher matcher = pattern.matcher(personName);

			if (matcher.matches()) {
				this.PersonName = personName;
			} else {
				throw new Exception("This surname does not respect regex parameters: [a-zA-Zèòàù]");
			}
		}
	}

	//Aggiornato per persona 6
	public String info() {
		return "== Informazioni su: " + PersonName + " " + FamilyName + " =="
				+ "\nEmail: " + email
				+ "\nCall Center ID: " + CallerID;
	}
}
