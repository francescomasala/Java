package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Teoria.CalcolaSocket;

public class ServerMain {

	public static void main(String[] args) throws InterruptedException {
		ServerCalcolatrice s = new ServerCalcolatrice(6789, "localhost");

		s.listen();
	}

}
