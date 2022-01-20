package it.tn.buonarroti.masala.quarta.GenericTypes;

public class MainCalc {
	public static void main(String[] args) {
		Calculator calculator = new Calculator<>(15, 12);

		System.out.println(calculator.Mul());
	}
}
