package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Teoria;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientStr {
    // Definisco la porta a cui connettersi
	public static final int PORT = 6789;
    // Definisco la macchina a cui connettersi
	public static final String ADDRESS = "localhost";

    public Socket connect() throws IOException {
        // Mi connetto al server tramite indirizzo DNS e porta
		Socket srv = new Socket(InetAddress.getByName(ADDRESS), PORT);
        System.out.println("[✓] Client Connesso");
        return srv;
    }

	public void send(Socket srv) throws IOException {
        // Chiedo all'utente di inserire la stringa
		System.out.println("[!] Inserisci la stringa da convertire in minuscolo: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        // Invio i dati al server
		DataOutputStream out = new DataOutputStream(srv.getOutputStream());
        out.writeBytes(str + "\n");
        System.out.println("[✓] Stringa inviata");
    }

	public void receive(Socket srv) throws IOException {
        // Ricevo i dati dal server
		Scanner in = new Scanner(srv.getInputStream());
        System.out.println("[?] Client in attesa");
        String str = in.nextLine();
        System.out.println("[!] Stringa ricevuta: " + str);
        srv.close();
    }
	public static void main(String[] args) throws IOException{
        ClientStr cli = new ClientStr();
		Socket srv = cli.connect();
        cli.send(srv);
        cli.receive(srv);
    }
}
