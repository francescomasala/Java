package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.Es3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {

    private InetAddress indirizzoClient;
    private int portaClient;

    private final ListaProdotti prodInVendita;
    private final ListaProdotti prodInCarello;
    private String nomeUtente;

    private final DatagramSocket serverSocket;

    public Server(int port) throws SocketException {
        this.prodInVendita = new ListaProdotti(true);
        this.prodInCarello = new ListaProdotti(false);

        this.serverSocket = new DatagramSocket(port);
    }

    public void connettiClient() throws IOException, Exception {
        System.out.println("Server in attesa di un client..." + "\n");

        while (true) {
            // Imposto la connessione con il client
            riceviPrimoMessaggio();

            // Ricevo il nome dal client, e gli rispondo confermando la connessione
            nomeUtente = riceviMessaggio();
            System.out.println("Utente '" + nomeUtente + "' connesso all'indirizzo " + indirizzoClient + ":" + portaClient + "\n");
            inviaMessaggio("Ciao " + nomeUtente + ", sei connesso al server sull'indirizzo " + indirizzoClient + ":" + portaClient);

            // Effettuo la spesa del Client
            effettuaSpesa();

            // Terminata la spesa, resetto il carrello per il prossimo client...
            System.out.println("\n" + ">>> In attesa di un nuovo client...");
            prodInCarello.eliminaLista();
        }
    }

    private void effettuaSpesa() throws IOException {
        String scontrinoSpesa = "- CARRELLO:";
        int sceltaClient, sceltaProd;

        String nomeProd;
        float prezzoProd;

        // Continuo a prendere in input la spesa da acquistare
        do {
            // Mi faccio dire dal client che scelta ha eseguito
            sceltaClient = Integer.parseInt(riceviMessaggio());

            switch (sceltaClient) {
                case 1:
                    // Mi informo su quale prodotto vuole aggiungere al carrello
                    sceltaProd = Integer.parseInt(riceviMessaggio());
                    nomeProd = prodInVendita.getNomeProdotto(sceltaProd - 1);
                    prezzoProd = prodInVendita.getPrezzoProdotto(sceltaProd - 1);

                    // Aggiorno lo stato del carrello
                    prodInCarello.aggiungiProdotto(nomeProd, prezzoProd);
                    System.out.println(prefissoMessaggio() + nomeProd + " aggiunto al carrello");
                    inviaMessaggio("Prodotto '" + nomeProd + "' aggiunto al tuo carrello!");

                    break;
                case 2:
                    // Faccio prima sapere al client la sua spesa attuale
                    inviaMessaggio(String.valueOf(prodInCarello.grandezzaLista()));
                    inviaMessaggio(String.valueOf(prodInCarello.stampaLista()));

                    // Mi informo su quale prodotto vuole rimuovere dal carrello
                    sceltaProd = Integer.parseInt(riceviMessaggio());
                    nomeProd = prodInCarello.getNomeProdotto(sceltaProd - 1);
                    prodInCarello.rimuoviProdotto(nomeProd);

                    // Aggiorno lo stato del carrello
                    System.out.println(prefissoMessaggio() + nomeProd + " rimosso dal carrello");
                    inviaMessaggio("Prodotto '" + nomeProd + "' rimosso dal tuo carrello!");

                    break;
                default:
                    // Se procedo col pagamento, devo prima assicurarmi che il carrello non sia vuoto
                    inviaMessaggio(String.valueOf(prodInCarello.grandezzaLista()));
                    sceltaClient = Integer.parseInt(riceviMessaggio());

                    break;
            }
        } while (sceltaClient != 0);

        // Quando confermo la spesa, invio un pre-scontrino al client e il numero di prodotti per farli scegliere quale prodotto scontare
        scontrinoSpesa += prodInCarello.stampaLista() + "\n\n";
        inviaMessaggio(scontrinoSpesa);
        inviaMessaggio(String.valueOf(prodInCarello.grandezzaLista()));

        System.out.println(prefissoMessaggio() + "Scontrino senza prodotto scontato inviato");

        // Recupero dal client quale prodotto scontare da quelli acquistati
        sceltaClient = Integer.parseInt(riceviMessaggio()) - 1;
        prodInCarello.setScontoSuProdotto(sceltaClient);

        // Aggiorno lo scontrino
        scontrinoSpesa = "==============================================\n\n";
        scontrinoSpesa += "- SCONTRINO DI " + nomeUtente + ":";
        scontrinoSpesa += prodInCarello.stampaLista() + "\n\n";
        scontrinoSpesa += "- TOTALE = " + prodInCarello.getTotaleLista();
        scontrinoSpesa += "\n\n==============================================";

        System.out.println(prefissoMessaggio() + "Scontrino con prodotto scontato inviato, fine sessione");

        // Invio finalmente lo scontrino finale al client
        inviaMessaggio("\n" + scontrinoSpesa);
    }

    // Metodo che utilizzo per ricevere un primo messaggio dal client, in modo da stabilire la connessione
    private void riceviPrimoMessaggio() throws IOException {
        byte[] buffer = new byte[1024];

        // Messaggio da ricevere dal client
        DatagramPacket dataClient = new DatagramPacket(buffer, 1024);
        serverSocket.receive(dataClient);

        // Dal messaggio ricevuto recupero l'indirizzo e la porta del client
        this.indirizzoClient = dataClient.getAddress();
        this.portaClient = dataClient.getPort();

        // LOG d'informazione
        // System.out.println("RICEVUTO: address = " + indirizzoClient + ", port = " + portaClient);
    }

    // Metodo che utilizzo per ricevere un messaggio dal client
    private String riceviMessaggio() throws IOException {
        byte[] buffer = new byte[1024];

        // Messaggio da ricevere dal client
        DatagramPacket dataIn = new DatagramPacket(buffer, 1024);
        serverSocket.receive(dataIn);

        // LOG di riceviMessaggio()
        // System.out.println("RICEVUTO: dataIn = " + new String(dataIn.getData()).trim());

        return new String(dataIn.getData()).trim();
    }

    // Metodo che utilizzo per inviare un messaggio al client
    private void inviaMessaggio(String msgRisposta) throws IOException {
        // Messaggio da rispedire al client
        DatagramPacket dataOut = new DatagramPacket(msgRisposta.getBytes(), msgRisposta.getBytes().length, indirizzoClient, portaClient);
        serverSocket.send(dataOut);

        // LOG di inviaMessaggio()
        // System.out.println("INVIATO: dataOut = " + msgRisposta);
    }

    private String prefissoMessaggio() {
        String oraAttuale;

        LocalDateTime data = LocalDateTime.now();
        oraAttuale = data.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        return "[" + nomeUtente + " alle " + oraAttuale + "] ";
    }

}
