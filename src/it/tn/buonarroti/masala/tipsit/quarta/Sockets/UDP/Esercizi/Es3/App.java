package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.Es3;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        int porta = 6789;
        Scanner scan = new Scanner(System.in);

        System.out.println("Vuoi essere server o client? (S/C)");
        char c = scan.next().charAt(0);

        switch (c) {
            // Se inserisco 's' oppure 'S', istanzio un nuovo Server sulla porta 6789
            case 's':
            case 'S':
                Server server = new Server(porta);
                server.connettiClient();

                break;
            // Se inserisco 'c' oppure 'C', istanzio un nuovo Client
            case 'c':
            case 'C':
                Client client = new Client(porta);
                client.connettiAlServer();

                break;
            default:
                System.out.println("Scelta inserita non riconosciuta!");
                break;
        }

    }
}
