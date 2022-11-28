package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Teoria;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerStr {
    // Inizializzo la porta
	public static final int PORT = 6789;

    // Creo un metodo listen che aspetta una connessione da un client
    public Socket listen(){
        Socket cli = null;
        // Creo un Try - Catch in caso se la porta è occupata
        try{
            // Seleziono la porta a cui assegnare il socket
            ServerSocket srv = new ServerSocket(PORT);
            // Comunico su quale porta ho avviato il server
            System.out.println("[✓] Server avviato sulla porta: " + PORT);
            // Assegno
            cli = srv.accept();
            // Comunico che si è connesso un client
            System.out.println("[!] Nuovo client connesso: " + cli.getInetAddress().toString());
        } catch (IOException e) {
            // Eccezione se la porta è occupata
			System.err.println("[!] La porta è occupata");
            e.printStackTrace();
            System.exit(1);
        }
		return cli;
    }
	public String receive(Socket cli) throws IOException{
        // Creo lo stream in ricezione dal client e creo un buffer da un KB tramite util.scanner
		Scanner scan = new Scanner(cli.getInputStream());
        System.out.println("[?] Il sistema sta aspettando una stringa");
        // Creo lo scanner e gli faccio "dumpare" i dati dentro la variabile str
        String str = scan.nextLine();
        System.out.println("[!] Il sistema ha ricevuto la stringa: " + str);
		return str;
    }
	public void send(Socket cli, String str) throws IOException{
        // Creo lo stream in uscita dal server
		DataOutputStream out = new DataOutputStream(cli.getOutputStream());
        System.out.println("[?] Il sistema sta inviando una stringa: " + str);
        // Invio i dati al client
        out.writeBytes(str +"\n");
    }

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