package it.tn.buonarroti.masala.quarta.GenericTypes.Example;

public class BoxMain {
	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.set(3);
		Box<String> charBox = new Box<String>();
		charBox.set("3");
	}
}
