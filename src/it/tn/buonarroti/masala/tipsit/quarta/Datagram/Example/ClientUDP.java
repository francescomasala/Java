package it.tn.buonarroti.masala.tipsit.quarta.Datagram.Example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientUDP {
    DatagramSocket socket;
    InetAddress address;
    int port;

    public ClientUDP(InetAddress address, int port) throws SocketException{
        this.socket = new DatagramSocket();
        this.address = address;
        this.port = port;
    }

    public void send(){
        byte[] b = new byte[0];
        DatagramPacket p = new DatagramPacket(b, b.length, address, port);
        try {
            socket.send(p);
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            String date = new String(response.getData());
            System.out.println("Received: " + date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}