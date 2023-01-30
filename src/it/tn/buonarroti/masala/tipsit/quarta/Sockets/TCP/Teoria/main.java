package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Teoria;

import java.io.IOException;
import java.net.Socket;

public class main {
	public static void main(String[] args) throws IOException {
		// Creo il mio oggetto tramite la clase fatta prima
		ServerStr srv = new ServerStr();
		// Inizializzo il server e lo metto in ascolto
		Socket cli = srv.listen();
		// Ricevo la stringa dal mio client
		String s = srv.receive(cli);
		// Rendo la stringa maiuscola
		srv.send(cli, s.toUpperCase());
	}
}