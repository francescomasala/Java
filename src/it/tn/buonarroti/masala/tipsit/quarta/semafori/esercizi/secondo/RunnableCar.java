package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.secondo;

import java.util.UUID;

public class RunnableCar implements Runnable {
	int CarNumber;
	String CarID;

	public RunnableCar(int CarNumber) {
		this.CarNumber = CarNumber;
		this.CarID = UUID.randomUUID().toString();
	}


	@Override
	public void run() {

	}
}
