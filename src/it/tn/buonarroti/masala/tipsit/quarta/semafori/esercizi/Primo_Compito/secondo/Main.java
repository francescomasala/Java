package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.secondo;

public class Main {
	public static void main(String[] args) {
		Thread car1 = new Thread(new RunnableCar(1));
		Thread car2 = new Thread(new RunnableCar(2));
		Thread car3 = new Thread(new RunnableCar(3));
		Thread car4 = new Thread(new RunnableCar(4));

		Thread car5 = new Thread(new RunnableCar(5));

		car1.start();
		car2.start();
		car3.start();
		car4.start();
		car5.start();
	}
}
