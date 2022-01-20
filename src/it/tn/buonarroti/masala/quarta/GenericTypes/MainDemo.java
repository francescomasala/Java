package it.tn.buonarroti.masala.quarta.GenericTypes;

public class MainDemo {
	public static void main(String[] args) {
		Integer arg1 = 10;
		Float   arg2 = 20.0f;
		String  arg3 = "OwO";

		Demo d = new Demo(arg1, arg2, arg3);

		System.out.println(d.info());
	}
}
