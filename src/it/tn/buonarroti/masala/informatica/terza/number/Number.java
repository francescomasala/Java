package it.tn.buonarroti.masala.informatica.terza.number;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Number {

	// Attributes
	private Integer num;

	public Number() {

	}

	public Number(Integer num) {
		this.num = num;
	}

	// Num - Getter
	public Integer getNum() {
		return num;
	}

	// Num - Setter
	public void setNum(Integer num) {
		this.num = num;
	}

	public String outputString() {
		String valoreDiRitorno;
		valoreDiRitorno = "Num: " + num;
		return valoreDiRitorno;
	}

	public Integer mcd(int num2) {
		int result = 0;
		Integer one = num;
		Integer two = num2;
		Integer max;
		if (one < two) {
			max = one;
		} else {
			max = two;
		}
		// Controllo parità dei numeri
		if (one.equals(two)) {
			// Se sono uguali restituisci num
			result = num;
			// Se sono diversi effetta
		} else {
			for (int i = max; i > 0; i--) {
				if (one % i == 0 && two % i == 0) {
					result = i;
				}
			}
		}
		return result;
	}

}
