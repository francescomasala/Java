package me.francescomasala.school.libs.utils;

public class DataEasy {
	private String data;
	private Integer giorno;
	private Integer mese;
	private Integer anno;

	public DataEasy() {

	}

	public DataEasy(Data dataInput) {
		this.data = dataInput.getData();
		this.giorno = dataInput.getGiorno();
		this.mese = dataInput.getMese();
		this.anno = dataInput.getAnno();
	}

	public DataEasy(Integer giorno, Integer mese, Integer anno) {
		this.giorno=giorno;
		this.mese=mese;
		this.anno=anno;
	}

	public String giornoDellaSettimana() {
		return null;
	}

	public Integer differenzaInAnni(Data dataAntecedente, Data dataSuccessiva) {
		return null;
	}

	public Integer differenzaInMesi(Data dataAntecedente, Data dataSuccessiva) {
		return null;
	}

	public Integer differenzaInSettimane(Data dataAntecedente, Data dataSuccessiva) {
		return null;
	}

	public Integer differenzaInGiorni(Data dataAntecedente, Data dataSuccessiva) {
		return null;
	}

	public Integer differenzaInGiorniMesiAnni(Data dataAntecedente, Data dataSuccessiva) {
		return null;
	}

	public Boolean validaData(String data) {
		return null;
	}

	@Override
	public String toString() {
		return "Data{" +
				"data='" + data + '\'' +
				", giorno=" + giorno +
				", mese=" + mese +
				", anno=" + anno +
				'}';
	}

	/*
	 * Getters and setters
	 */
	public Integer getAnno() {
		return anno;
	}

	public Integer getMese() {
		return mese;
	}

	public Integer getGiorno() {
		return giorno;
	}

	public String getData() {
		return data;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public void setMese(Integer mese) {
		this.mese = mese;
	}

	public void setGiorno(Integer giorno) {
		this.giorno = giorno;
	}

	public void setData(String data) {
		this.data = data;
	}
}