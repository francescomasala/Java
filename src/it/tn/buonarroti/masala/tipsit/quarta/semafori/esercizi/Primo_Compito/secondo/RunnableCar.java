package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.secondo;

import lombok.Getter;

import java.util.Random;
import java.util.UUID;

public class RunnableCar implements Runnable {

	@Getter
	private int CarNumber;
	@Getter
	private String CarID;

	public RunnableCar(int CarNumber) {
		this.CarNumber = CarNumber;
		this.CarID = UUID.randomUUID().toString();
	}


	@Override
	public void run() {
		getInfo();
		Random rand = new Random();
		while (true) {
			try {
				Integer Fuel = getRandomFuel();
				System.out.println("[CAR] - Car " + CarNumber + " is refueling " + Fuel + " liters of fuel");
				Thread.sleep(Fuel * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private String getInfo() {
		return "Car: " + CarNumber + " with ID: " + CarID + " is started";
	}

	private Integer getRandomFuel() {
		while (true) {
			Random rand = new Random();
			rand.setSeed(System.currentTimeMillis() * rand.nextInt(54));
			Integer randomNum = rand.nextInt(50);
			if (randomNum >= 20 && randomNum <= 50) {
				return randomNum;
			}
		}
	}
}
