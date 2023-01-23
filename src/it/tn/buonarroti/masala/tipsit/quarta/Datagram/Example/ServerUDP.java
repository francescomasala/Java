package it.tn.buonarroti.masala.tipsit.quarta.Datagram.Example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;

public class ServerUDP {
    DatagramSocket socket;
    HashMap<InetAddress, Integer> IPList = new HashMap<InetAddress, Integer>();

    public ServerUDP(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public boolean isIPLocked(InetAddress ipAddress) {
        System.out.println("Ricevuto messaggio da: " + ipAddress.getHostAddress() + " '" + ipAddress.getHostName() + "'");
        if (IPList.containsKey(ipAddress)) {
            Integer Data = IPList.get(ipAddress);
            if (Data == 10) {
                return true;
            } else {
                IPList.replace(ipAddress, Data++);
                return false;
            }
        } else {
            IPList.put(ipAddress, 1);
            return false;
        }
    }

    public void listen(int BufferLength) {
        byte[] buffer;
        while (true) {
            buffer = new byte[BufferLength];
            DatagramPacket p = new DatagramPacket(buffer, BufferLength);
            try {
                socket.receive(p);
                System.out.println("Received: " + new String(p.getData()));
                String date = new Date().toString();
                String lock = "Il tuo IP e' stato bloccato, aggiorna al piano a pagamento";
                if (isIPLocked(p.getAddress())) {
                    DatagramPacket response = new DatagramPacket(date.getBytes(),
                        date.getBytes().length, p.getAddress(), p.getPort());
                    socket.send(response);
                } else {
                    DatagramPacket response = new DatagramPacket(lock.getBytes(),
                        date.getBytes().length, p.getAddress(), p.getPort());
                    socket.send(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}