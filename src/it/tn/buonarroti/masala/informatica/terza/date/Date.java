package it.tn.buonarroti.masala.informatica.terza.date;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Date {

	private Integer gg;
	private Integer mm;
	private Integer aa;

	public Date() {

	}

	public Date(Integer gg, Integer mm, Integer aa) {
		this.gg = gg;
		this.mm = mm;
		this.aa = aa;
	}

	public Integer getGg() {
		return gg;
	}

	public Integer getMm() {
		return mm;
	}

	public Integer getAa() {
		return aa;
	}

	//Metodi
	public void nextDay() { //subroutine (non ritorna nulla)
		gg += 1;
		switch (mm) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 9:
			case 11:
				if (gg == 32) {
					gg = 1;
					mm += 1;
				}
				break;
			case 2:
				if (gg == 29) {
					gg = 1;
					mm += 1;
				}
				break;
			case 4:
			case 6:
			case 8:
			case 10:
			case 12:
				if (gg == 31) {
					gg = 1;
					mm += 1;
				}
				break;
		}
		//Aggiungi anno
		if (mm == 13) { //Controlla mese
			aa += 1;
			mm = 1;
		}
	}

	public int lastDay(int mm, int aa) {
		switch (mm) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 9:
			case 11:
			case 4:
			case 6:
			case 8:
			case 10:
			case 12:
				return 30;
			case 2:
				return 28;
			default:
				return 0;
		}
	}
}