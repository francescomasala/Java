package it.tn.buonarroti.masala.tipsit.quarta.Datagram.Example;

import java.net.InetAddress;

public class mainUDP {
    public static void main(String[] args) throws Exception {
        System.out.println("Vuoi essere client o server? (C/S)");
        char c = (char) System.in.read();
        System.in.skip(2);
        if (c == 'c') {
            ClientUDP client = new ClientUDP(InetAddress.getByName("10.10.0.12"), 6789);
            do {
                client.send();
                System.out.println("Vuoi inviare un altro messaggio? (y/n)");
                c = (char) System.in.read();
                System.in.skip(2);
            } while (c == 'y');
        } else if (c == 's') {
            ServerUDP server = new ServerUDP(6789);
            server.listen(1024);
        }
    }
}