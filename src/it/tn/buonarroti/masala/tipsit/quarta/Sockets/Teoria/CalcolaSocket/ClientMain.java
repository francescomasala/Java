package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Teoria.CalcolaSocket;

public class ClientMain {

	public static void main(String[] args) throws InterruptedException {
		ClientCalcolatrice c = new ClientCalcolatrice("localhost", 6789);

		c.connect();
	}

}
