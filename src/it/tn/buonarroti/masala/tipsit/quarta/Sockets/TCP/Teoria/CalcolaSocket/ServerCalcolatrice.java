package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Teoria.CalcolaSocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCalcolatrice {
	private final Integer port;
	private final String ServerName;

	private DataOutputStream outToClient;
	private BufferedReader inFromClient;

	public ServerCalcolatrice(Integer port, String serverName) {
		this.port = port;
		ServerName = serverName;
	}

	public Socket listen() {
		Socket myClient = null;
		try {
			ServerSocket srv = new ServerSocket(port);
			System.out.println("[!] - Server is listening on port: " + port);
			myClient = srv.accept();
			System.out.println("[!] - Client connected: " + myClient.getRemoteSocketAddress().toString());
			inFromClient = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
			outToClient = new DataOutputStream(myClient.getOutputStream());
			sendData();
			myClient.close();
		} catch (IOException e) {
			System.err.println("[!] The server encountered a fatal error");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return myClient;
	}

	private void sendData() {
		try {
			String operando1 = inFromClient.readLine();
			String operazione = inFromClient.readLine();
			String operando2 = inFromClient.readLine();

			Integer opereando1 = Integer.parseInt(operando1);
			Integer opereando2 = Integer.parseInt(operando2);

			Integer risultato = 0;

			switch (operazione) {
				case "+":
					risultato = opereando1 + opereando2;
					break;
				case "-":
					risultato = opereando1 - opereando2;
					break;
				case "*":
					risultato = opereando1 * opereando2;
					break;
				case "/":
					risultato = opereando1 / opereando2;
					break;
			}

			outToClient.writeBytes(risultato.toString() + "\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
