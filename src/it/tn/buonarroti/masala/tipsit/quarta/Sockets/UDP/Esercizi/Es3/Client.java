package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.Es3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private final ListaProdotti prodInVendita;
    private final Scanner input;

    private final DatagramSocket socket;
     final InetAddress address;
     final int port;

    public Client(int port) throws SocketException, UnknownHostException {
        this.prodInVendita = new ListaProdotti(true);
        this.input = new Scanner(System.in);

        this.socket = new DatagramSocket();
        this.address = InetAddress.getByName("localhost");
        this.port = port;
    }

    public void connettiAlServer() throws IOException, Exception {
        // Stabilisco prima la connessione col server
        inviaPrimoMessaggio();

        // Invio poi il nome del client al server
        System.out.print("> Inserisci il tuo nome: ");
        String nomeCliente = input.nextLine();
        nomeCliente = nomeCliente.substring(0, 1).toUpperCase() + nomeCliente.substring(1);

        // Invio il nome al server e ricevo la risposta
        inviaMessaggio(nomeCliente);
        System.out.println(riceviMessaggio());

        // Eseguo la spesa
        effettuaSpesa();

        System.out.println("\n" + "- Spesa terminata!" + "\n");
    }

    private void effettuaSpesa() throws Exception {
        // Ho due variabili per scegliere l'operazione e/o il prodotto + una variabile per il numero di prodotto che ho nel carrello
        int sceltaMenu, sceltaProd, nProdotti;

        // Eseguo la spesa fino a quando non la confermo con la terza scelta
        do {
            System.out.println("\n" + "> Scegliere un'opzione tra le seguenti:");
            System.out.println("1: Aggiungi un prodotto al carrello");
            System.out.println("2: Rimuovi un prodotto dal carrello");
            System.out.println("3: Paga la spesa con uno sconto bonus");
            sceltaMenu = input.nextInt();

            // Invio al server la scelta che ho fatto
            inviaMessaggio(String.valueOf(sceltaMenu));

            // Eseguo in base alla scelta fatta l'operazione richiesta
            switch (sceltaMenu) {
                // CASO 1: AGGIUNGO UN PRODOTTO AL CARRELLO
                case 1:
                    System.out.println("\n> " + prodInVendita.grandezzaLista() + " PRODOTTI IN VENDITA:" + prodInVendita.stampaLista());
                    System.out.print("\n" + "> Scegliere quale prodotto acquistare: ");
                    sceltaProd = input.nextInt();

                    if (sceltaProd >= 1 && sceltaProd <= prodInVendita.grandezzaLista()) {
                        // Dico al server che prodotto voglio aggiungere al carrello
                        inviaMessaggio(String.valueOf(sceltaProd));

                        // Ricevo ad ogni inserimento lo stato attuale del carrello
                        System.out.println(riceviMessaggio());
                    } else {
                        stampaErrore("Scelta inserita non inclusa nella lista!");
                    }

                    break;
                // CASO 2: RIMUOVO UN PRODOTTO DAL CARRELLO
                case 2:
                    // Prima di tutto mi faccio dire dal server quanti prodotti ho nel carrello
                    nProdotti = Integer.parseInt(riceviMessaggio());

                    if (nProdotti == 0) {
                        stampaErrore("Non ci sono prodotti da rimuovere dal carrello!");
                    }

                    System.out.println("\n" + "> IL TUO CARRELLO: \n" + riceviMessaggio());
                    System.out.print("\n" + "> Scegliere quale prodotto rimuovere: ");
                    sceltaProd = input.nextInt();

                    if (sceltaProd >= 1 && sceltaProd <= nProdotti) {
                        // Dico al server che prodotto voglio rimuovere dal carrello
                        inviaMessaggio(String.valueOf(sceltaProd));

                        // Ricevo ad ogni rimozione lo stato attuale del carrello
                        System.out.println(riceviMessaggio());
                    } else {
                        stampaErrore("Scelta inserita non inclusa nel carrello!");
                    }

                    break;
                // CASO 3: CONFERMO GLI ACQUISTI SCELTI E PASSO ALLO SCONTO
                case 3:
                    // Non posso procedere col pagamento se non ho acquistato un prodotto
                    nProdotti = Integer.parseInt(riceviMessaggio());

                    if (nProdotti == 0) {
                        stampaErrore("Non ci sono prodotti da pagare nel carrello!");
                    }

                    inviaMessaggio("0");
                    break;
                default:
                    stampaErrore("Scelta inserita non valida!");
            }
        } while (sceltaMenu != 3);

        // Ricevo lo scontrino attuale e il totale dei prodotti in carrello
        System.out.println("\n" + riceviMessaggio());
        nProdotti = Integer.parseInt(riceviMessaggio());

        // Scelgo il prodotto su cui voglio effettuare lo sconto
        System.out.print("\n" + "> Scegliere quale prodotto scontare: ");
        int sceltaSconto = input.nextInt();

        // Comunico al server il prodotto su cui effettuerò lo sconto
        if (sceltaSconto >= 1 && sceltaSconto <= nProdotti) {
            inviaMessaggio(String.valueOf(sceltaSconto));
        } else {
            stampaErrore("Scelta inserita non inclusa nella lista!");
        }

        // Stampo la fattura finale
        System.out.println("\n" + riceviMessaggio());
    }

    // Metodo che utilizzo per inviare un primo messaggio al server, in modo da stabilirci la connessione
    private void inviaPrimoMessaggio() throws IOException {
        // Messaggio da inviare al server
        DatagramPacket dataClient = new DatagramPacket("".getBytes(), "".getBytes().length, address, port);
        socket.send(dataClient);

        // LOG d'informazione
        // System.out.println("INVIATO: address = " + address + ", port = " + port);
    }

    // Metodo che utilizzo per inviare un messaggio al server
    private void inviaMessaggio(String msgOut) throws IOException, Exception {
        // Invio al server il messaggio "msgOut"
        DatagramPacket dataOut = new DatagramPacket(msgOut.getBytes(), msgOut.getBytes().length, address, port);
        socket.send(dataOut);
    }

    // Metodo che utilizzo per ricevere un messaggio dal server
    private String riceviMessaggio() throws IOException, Exception {
        byte[] buffer = new byte[1024];

        // Ricevo la risposta dal server
        DatagramPacket dataIn = new DatagramPacket(buffer, buffer.length);
        socket.receive(dataIn);

        return new String(dataIn.getData()).trim();
    }

    // Metodo della classe per gestire eccezioni varie
    private void stampaErrore(String msgErr) {
        String strErr = "!) Errore: " + msgErr.substring(0, 1).toLowerCase() + msgErr.substring(1);

        System.err.println("\n" + strErr + "\n\n");
        System.exit(1);
    }

}
