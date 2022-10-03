package it.tn.buonarroti.masala.informatica.quarta.GenericTypes;

import lombok.Getter;
import lombok.Setter;

public class Calculator<Calc extends Number> {
	@Getter
	@Setter
	Calc FirstVal;
	@Getter
	@Setter
	Calc SecondVal;

	public Calculator(Calc FirstVal, Calc SecondVal) {
		this.FirstVal = FirstVal;
		this.SecondVal = SecondVal;
	}

	public Calc Sum() {
		Double calc = FirstVal.doubleValue() + SecondVal.doubleValue();
		Calc calc2 = (Calc) calc;
		return calc2;
	}

	public Calc Sub() {
		Double calc = FirstVal.doubleValue() - SecondVal.doubleValue();
		Calc calc2 = (Calc) calc;
		return calc2;
	}

	public Calc Mul() {
		Double calc = FirstVal.doubleValue() * SecondVal.doubleValue();
		Calc calc2 = (Calc) calc;
		return calc2;
	}

	public Calc Div() {
		Double calc = FirstVal.doubleValue() / SecondVal.doubleValue();
		Calc calc2 = (Calc) calc;
		return calc2;
	}
}
