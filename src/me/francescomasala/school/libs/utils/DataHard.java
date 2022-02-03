package me.francescomasala.school.libs.utils;

import java.time.LocalDate;

public class DataHard {
	private String data;
	private Integer giorno;
	private Integer mese;
	private Integer anno;
	private String formatoTesto;

	public DataHard() {
		LocalDate DataObj = LocalDate.now();
		this.giorno = LocalDate.MAX.getDayOfMonth();
		this.mese = LocalDate.MAX.getMonthValue();
		this.anno = LocalDate.MAX.getYear();
		this.formatoTesto = this.toString();
	}

	public DataHard(Data dataInput) {
		this.data = dataInput.getData();
		this.giorno = dataInput.getGiorno();
		this.mese = dataInput.getMese();
		this.anno = dataInput.getAnno();
	}

	public DataHard(Integer giorno, Integer mese, Integer anno) {
		this.giorno=giorno;
		this.mese=mese;
		this.anno=anno;
	}

	public String giornoDellaSettimana() {
		return null;
	}

	public Integer differenzaInAnni(Data dataAntecedente, Data dataSuccessiva) {
		Integer diff = (int) dataSuccessiva.getAnno() - dataAntecedente.getAnno();
		return diff;
	}

	public Integer differenzaInMesi(Data dataAntecedente, Data dataSuccessiva) {
		 int diff = this.differenzaInAnni(dataAntecedente, dataSuccessiva);
		 diff = (diff * 12) + (int) dataSuccessiva.getMese() - dataAntecedente.getMese();
		 return diff;
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
		String testo = (giorno <= 9 ? "0" : "") + giorno + "/" +
				       (mese <= 9 ? "0" : "") + mese + "/" +
				        anno;
		return testo;
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
