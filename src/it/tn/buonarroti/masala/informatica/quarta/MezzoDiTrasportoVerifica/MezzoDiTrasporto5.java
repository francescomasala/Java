/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tn.buonarroti.masala.informatica.quarta.MezzoDiTrasportoVerifica;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 * @version 2021.12.09
 */
public class MezzoDiTrasporto5 {

	private static final Float COEFF_CONV_DA_CV_A_KW = 0.73f; // Coefficiente di conversione
	private Integer cavalli = 0; // Cavalli della macchina
	private Integer cilindrata = 0; // Cilindrata della macchina
	private String colore = ""; // Colore della macchina
	private String marca = ""; // Marca della macchina
	private String modello = ""; // Modello della macchina
	private Integer kw = 0; // Kilowatt della macchina
	private int numeroIstanze = 0;

	/**
	 * @param cavalli    Il numero in Integer dei cavalli della macchina
	 * @param cilindrata Il numero in Integer della cilindrata della macchina
	 * @param colore     La stringa del colore della macchina
	 * @param marca      Il numero in Integer della cilindrata della macchina
	 * @param modello    Il numero in Integer della cilindrata della macchina
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public MezzoDiTrasporto5(Integer cavalli, Integer cilindrata, String colore, String marca, String modello) throws Exception {
		setCavalli(cavalli);
		setCilindrata(cilindrata);
		setColore(colore);
		setMarca(marca);
		setModello(modello);
		this.numeroIstanze++;
	}

	public MezzoDiTrasporto5() {
		this.numeroIstanze++;
	}

	/**
	 * @return Il valore in integer di cavalli
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public Integer getCavalli() {
		return cavalli;
	}

	/**
	 * @param cavalli Il valore in integer di cavalli
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 * <p>
	 * Controlla il valore di cavalli e restituisce un eccezione se qualcosa non corrisponde ai valori
	 */
	public void setCavalli(Integer cavalli) throws Exception {
		Integer max = 500;
		Integer min = 6;
		if (cavalli < max && cavalli > min) {
			this.cavalli = cavalli;
		} else if (cavalli < 6) {
			throw new Exception("Cavalli: Il valore inserito è minore di 6");
		} else if (cavalli > 500) {
			throw new Exception("Cavalli: Il valore inserito è maggiore di 500");
		} else {
			throw new Exception("Cavalli: Valore non valido");
		}
	}

	/**
	 * @return Il valore in integer di cilindrata
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public Integer getCilindrata() {
		return cilindrata;
	}

	/**
	 * @param cilindrata Il valore in integer di cilindrata
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 * <p>
	 * Controlla il valore di cilindrata e restituisce un eccezione se qualcosa non corrisponde ai valori
	 */
	public void setCilindrata(Integer cilindrata) throws Exception {
		if (cilindrata == 1000 || cilindrata == 1500 || cilindrata == 2000) {
			this.cilindrata = cilindrata;
		} else if (cilindrata != 1000 || cilindrata != 1500 || cilindrata != 2000) {
			throw new Exception("Cilindrata: Inserire un valore valido");
		} else {
			throw new Exception("Cavalli: Inserire un valore valido");
		}

	}

	/**
	 * @return Il valore in String di colore
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public String getColore() {
		return this.colore;
	}

	/**
	 * @param colore Il valore in String di colore
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 * <p>
	 * Controlla il valore di colore e restituisce un eccezione se qualcosa non corrisponde ai valori
	 */
	public void setColore(String colore) throws Exception {
		if (cilindrata == 1000 || cilindrata == 1500) {
			if (colore.equalsIgnoreCase("bianco")) {
				this.colore = colore;
			} else if (colore.equalsIgnoreCase("nero")) {
				this.colore = colore;
			}
		} else if (cilindrata == 2000) {
			if (colore.equalsIgnoreCase("rosso")) {
				this.colore = colore;
			} else if (!colore.equalsIgnoreCase("rosso")) {
				throw new Exception("Colore: Inserire un valore valido per questa cilindrata.");
			}
		} else {
			throw new Exception("Colore: Inserire un valore valido");
		}
	}

	/**
	 * @return Il valore in String di marca
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca Il valore in String di marca
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 * <p>
	 * Controlla il valore di marca e restituisce un eccezione se qualcosa non corrisponde ai valori
	 */
	public void setMarca(String marca) throws Exception {
		if (marca.length() >= 3) {
			this.marca = marca;
		} else if (marca == null || marca == "") {
			throw new Exception("Marca: Inserire un valore");
		} else if (marca.contains("1,2,3,4,5,6,7,8,9,_")) {
			throw new Exception("Marca: Valore non valido");
		}

	}

	/**
	 * @return Il valore in String di modello
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public String getModello() {
		return modello;
	}

	/**
	 * @param modello Il valore in String di modello
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 * <p>
	 * Controlla il valore di marca e restituisce un eccezione se qualcosa non corrisponde ai valori
	 */
	public void setModello(String modello) throws Exception {
		if (modello == null || modello == "") {
			throw new Exception("Modello: Il valore immesso non può essere nullo");
		} else {
			this.modello = modello;
		}
	}

	/**
	 * @return Il valore in Int di Kilowatt
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public Integer getKw() {
		this.calcolaKw();
		return kw;
	}

	public int getNumeroIstanze() {
		return numeroIstanze;
	}

	/**
	 * @param mezzoDiTrasporto la macchina che si vuole comparare
	 * @return Il valore in String della comparazione tra due macchine
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public String confrontaCaratteristiche(MezzoDiTrasporto5 mezzoDiTrasporto) {
		return (
				"Informazioni sulle macchine: " + "\n" +
						"Macchina 1:\t" + "\t|" + "\t" + "Macchina 2:\t" + "\n" +
						"Cavalli:\t" + getCavalli() + "\t|" + "\t" + "Cavalli:\t" + mezzoDiTrasporto.getCavalli() + "\n" +
						"Cilindrata:\t" + getCilindrata() + "\t|" + "\t" + "Cilindrata:\t" + mezzoDiTrasporto.getCilindrata() + "\n" +
						"Colore:\t\t" + getColore() + "\t|" + "\t" + "Colore:\t\t" + mezzoDiTrasporto.getColore() + "\n" +
						"Marca:\t\t" + getMarca() + "\t|" + "\t" + "Marca:\t\t" + mezzoDiTrasporto.getMarca() + "\n" +
						"Modello:\t" + getModello() + "\t|" + "\t" + "Modello:\t" + mezzoDiTrasporto.getModello() + "\n" +
						"Kilowatt:\t" + getKw() + "\t|" + "\t" + "Kilowatt:\t" + mezzoDiTrasporto.getKw() + "\n"
		);
	}

	/**
	 * @return Il valore in String della macchina
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 */
	public String info() {
		return (
				"Informazioni sulla macchina: \n" +
						"Cavalli:\t" + getCavalli() + "\n" +
						"Cilindrata:\t" + getModello() + "\n" +
						"Colore:\t\t" + getColore() + "\n" +
						"Marca:\t\t" + getMarca() + "\n" +
						"Modello:\t" + getModello() + "\n" +
						"Kilowatt:\t" + getKw() + "\n"
		);
	}

	/**
	 * @version 2021.12.09
	 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
	 * <p>
	 * Calcola i Kilowatt della macchina
	 */
	private void calcolaKw() {
		this.kw = (int) (COEFF_CONV_DA_CV_A_KW * this.cavalli);
	}
}
