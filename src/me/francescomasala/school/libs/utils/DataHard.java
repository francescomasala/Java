package me.francescomasala.school.libs.utils;

import java.time.LocalDate;

public class DataHard {

	//Attributi
	private String data;
	private Integer giorno;
	private Integer mese;
	private Integer anno;

	//Costruttori
	public DataHard() {
		LocalDate objDate = LocalDate.now();
		giorno = objDate.getDayOfMonth();
		mese = objDate.getMonthValue();
		anno = objDate.getYear();
		data = toString();
	}


	public DataHard(String data) throws Exception {

		if (validaData(data)) {

			String[] dataA = data.split("/");
			giorno = Integer.parseInt(dataA[0]);
			mese = Integer.parseInt(dataA[1]);
			anno = Integer.parseInt(dataA[2]);
			this.data = toString();

		} else throw new Exception("La data è in un formato incompatibile o non può esistere.");
	}

	public DataHard(Integer giorno, Integer mese, Integer anno) throws Exception {

		String dataS = giorno + "/" + mese + "/" + anno;

		if (validaData(dataS)) {
			this.giorno = giorno;
			this.mese = mese;
			this.anno = anno;
			this.data = toString();

		} else throw new Exception("La data è in un formato incompatibile o non può esistere.");
	}


	//Metodi get e set di Data
	public String getData() {
		return data;
	}

	public void setData(String data) throws Exception {
		if (validaData(data)) {

			String[] dataA = data.split("/");
			giorno = Integer.parseInt(dataA[0]);
			mese = Integer.parseInt(dataA[1]);
			anno = Integer.parseInt(dataA[2]);
			this.data = toString();

		} else throw new Exception("La data è in un formato incompatibile o non può esistere.");
	}

	//Metodi get e set degli attributi singoli
	public Integer getGiorno() {
		return giorno;
	}

	public void setGiorno(Integer giorno) throws Exception {
		if (validaData(toString(giorno, mese, anno))) {
			this.giorno = giorno;
		} else throw new Exception("Data non valida.");
	}

	public Integer getMese() {
		return mese;
	}

	public void setMese(Integer mese) throws Exception {
		if (validaData(toString(giorno, mese, anno))) {
			this.mese = mese;
		} else throw new Exception("Data non valida.");
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) throws Exception {
		if (validaData(toString(giorno, mese, anno))) {
			this.mese = mese;
		} else throw new Exception("Data non valida.");
	}

	//Metodi della classe
	public String giornoDellaSettimana() {

		Integer giornoS;
		String giornoReturn = "";

		giornoS = ((giorno + ((13 * (mese + 1)) / 5) + (anno % 100) + ((anno % 100) / 4) + ((anno / 100) / 4) - (2 * (anno / 100))) % 7);

		switch (giornoS) {
			case 0:
				giornoReturn = "Sabato";
				break;
			case 1:
				giornoReturn = "Domenica";
				break;
			case 2:
				giornoReturn = "Lunedì";
				break;
			case 3:
				giornoReturn = "Martedì";
				break;
			case 4:
				giornoReturn = "Mercoledì";
				break;
			case 5:
				giornoReturn = "Giovedì";
				break;
			case 6:
				giornoReturn = "Venerdì";
				break;
		}


		return giornoReturn;

	}

	public Integer ultimoGiornoMese(Integer mese) {

		Integer uG = 0;

		switch (mese) {
			case 1:
				uG = 31;
				break;
			case 2:
				uG = (this.isBisestile(this.anno) ? 29 : 28);
				break;
			case 3:
				uG = 31;
				break;
			case 4:
				uG = 30;
				break;
			case 5:
				uG = 31;
				break;
			case 6:
				uG = 30;
				break;
			case 7:
				uG = 31;
				break;
			case 8:
				uG = 31;
				break;
			case 9:
				uG = 30;
				break;
			case 10:
				uG = 31;
				break;
			case 11:
				uG = 30;
				break;
			case 12:
				uG = 31;
				break;

		}

		return uG;


	}

	public Boolean isBisestile(Integer anno) {

		Boolean bis = false;
		if (anno % 4 == 0) {
			if (anno % 100 == 0) {
				if (anno % 400 == 0) {
					bis = true;
				}
			} else {
				bis = true;
			}
		}

		return bis;
	}


	public String meseDellAnno() {

		String meseS = "";

		switch (mese) {
			case 1:
				meseS = "Gennaio";
				break;
			case 2:
				meseS = "Febbraio";
				break;
			case 3:
				meseS = "Marzo";
				break;
			case 4:
				meseS = "Aprile";
				break;
			case 5:
				meseS = "Maggio";
				break;
			case 6:
				meseS = "Giugno";
				break;
			case 7:
				meseS = "Luglio";
				break;
			case 8:
				meseS = "Agosto";
				break;
			case 9:
				meseS = "Settembre";
				break;
			case 10:
				meseS = "Ottobre";
				break;
			case 11:
				meseS = "Novembre";
				break;
			case 12:
				meseS = "Dicembre";
				break;

		}

		return meseS;

	}

	@Override
	public String toString() {

		String testo;

		testo = (giorno <= 9 ? "0" : "") + giorno + "/" + (mese <= 9 ? "0" : "") + mese + "/" + anno;

		return testo;
	}

	public String toString(Integer giorno, Integer mese, Integer anno) throws Exception {
		String testo;

		testo = (giorno <= 9 ? "0" : "") + giorno + "/" + (mese <= 9 ? "0" : "") + mese + "/" + anno;
		if (!validaData(testo)) {
			throw new Exception("Formato data non valido");
		}

		return testo;
	}


	public Integer differenzaInGiorni(DataHard dataAtecedente, DataHard dataSuccessiva) {

		Integer differenzaUno;
		Integer differenzaDue;

		differenzaUno = dataAtecedente.getGiorno();
		for (int i = dataAtecedente.getAnno(); i > 0; i--) {
			differenzaUno += (dataAtecedente.isBisestile(i) ? 366 : 365);
		}

		for (int i = dataAtecedente.getMese(); i > 0; i--) {
			differenzaUno += dataAtecedente.ultimoGiornoMese(i);
		}

		differenzaDue = dataSuccessiva.getGiorno();
		for (int i = dataSuccessiva.getAnno(); i > 0; i--) {
			differenzaDue += (dataSuccessiva.isBisestile(i) ? 366 : 365);
		}

		for (int i = dataSuccessiva.getMese(); i > 0; i--) {
			differenzaDue += dataSuccessiva.ultimoGiornoMese(i);
		}

		Integer differenza = differenzaDue - differenzaUno;
		if (differenza > 0) differenza = -differenza;

		return differenza;

	}

	public Integer differenzaInSettimane(DataHard dataAtecedente, DataHard dataSuccessiva) {

		Integer differenza = differenzaInGiorni(dataAtecedente, dataSuccessiva);
		differenza /= 7;

		return differenza;

	}

	public Integer differenzaInMesi(DataHard dataAtecedente, DataHard dataSuccessiva) {

		Integer differenzaUno = 0, differenzaDue = 0;
		for (int j = dataAtecedente.getAnno(); j > 0; j--) {
			for (int i = dataAtecedente.getMese(); i > 0; i--) {
				differenzaUno += 1;
			}
		}

		for (int j = dataSuccessiva.getAnno(); j > 0; j--) {
			for (int i = dataSuccessiva.getMese(); i > 0; i--) {
				differenzaDue += 1;
			}
		}

		Integer differenza = differenzaDue - differenzaUno;
		if (differenza > 0) differenza = -differenza;
		return differenza;

	}

	public Integer differenzaInAnni(DataHard dataAtecedente, DataHard dataSuccessiva) {

		Integer differenzaUno = 0, differenzaDue = 0;
		for (int j = dataAtecedente.getAnno(); j > 0; j--) {
			differenzaUno += 1;
		}

		for (int j = dataSuccessiva.getAnno(); j > 0; j--) {
			differenzaDue += 1;
		}

		Integer differenza = differenzaDue - differenzaUno;
		if (differenza > 0) differenza = -differenza;
		return differenza;

	}

	public String differenzaInGiorniMesiAnni(DataHard dataAntecedente, DataHard dataSuccessiva) {
		Integer anni = differenzaInAnni(dataAntecedente, dataSuccessiva);
		Integer mesi = differenzaInMesi(dataAntecedente, dataSuccessiva) % 12;
		Integer giorni = differenzaInGiorni(dataAntecedente, dataSuccessiva) % this.ultimoGiornoMese(mesi);

		String s = "Differenza: " + anni + " anni, " + mesi + " mesi e " + giorni + " giorni.";
		return s;

	}

	private Boolean validaData(String data) {

		Integer giorni, mesi, anni;
		String[] dataA = data.split("/");
		giorni = Integer.parseInt(dataA[0]);
		mesi = Integer.parseInt(dataA[1]);
		anni = Integer.parseInt(dataA[2]);

		Boolean valid = true;
		if (mesi < 0 && mesi > 12) {
			valid = false;
		} else {
			if (giorni < 0 || giorni + 1 > this.ultimoGiornoMese(mesi)) valid = false;
		}

		return valid;
	}
}
