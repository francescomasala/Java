package it.tn.buonarroti.masala.informatica.quarta.CallCenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallCenterOperator {
	public String FamilyName;
	public String PersonName;
	private Integer CallCenterID;
	private String email;
	private Boolean isOperatorFree;

	public CallCenterOperator() {
	}

	public CallCenterOperator(String FamilyName, String PersonName, String email, Integer CallCenterID)
			throws Exception {
		this();
		this.setFamilyName(FamilyName);
		this.setPersonName(PersonName);
		this.setCallCenterID(CallCenterID);
		this.setEmail(email);
	}

	public Boolean getOperatorFree() {
		return isOperatorFree;
	}

	public void setOperatorFree(Boolean operatorFree) {
		isOperatorFree = operatorFree;
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

	public Integer getCallCenterID() {
		return CallCenterID;
	}

	//Nuovo in persona 7
	public void setCallCenterID(Integer callCenterID) throws Exception {
		this.CallCenterID = callCenterID;
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
				+ "\nCall Center ID: " + CallCenterID;
	}
}
