package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Teoria.CalcolaSocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientCalcolatrice {
	private final String ServerName;
	private final Integer port;
	private BufferedReader tastiera;
	private DataOutputStream outToServer;
	private BufferedReader inFromServer;

	public ClientCalcolatrice(String serverName, Integer port) {
		ServerName = serverName;
		this.port = port;
	}

	public Socket connect() {
		System.out.println("[!] - Client has started");
		tastiera = new BufferedReader(new InputStreamReader(System.in));
		Socket myServer;
		try {
			myServer = new Socket(ServerName, port);
			outToServer = new DataOutputStream(myServer.getOutputStream());
			inFromServer = new BufferedReader(new InputStreamReader(myServer.getInputStream()));
			sendData();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return myServer;
	}

	private void sendData() {
		try {
			System.out.println("[!] - Inserisci il primo operando");
			String operando1 = tastiera.readLine();

			System.out.println("[!] - Inserisci l'operazione");
			String operazione = tastiera.readLine();

			System.out.println("[!] - Inserisci il secondo operando");
			String operando2 = tastiera.readLine();

			outToServer.writeBytes(operando1 + "\n");
			outToServer.writeBytes(operazione + "\n");
			outToServer.writeBytes(operando2 + "\n");

			System.out.println("[!] Risultato: " + reciveData());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String reciveData() throws IOException {
		return inFromServer.readLine();
	}
}
