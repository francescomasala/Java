package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Teoria.multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class App {
    public static void main(String[] args) {
        new Thread(new Server()).start();
        new Thread(new Client()).start();
        new Thread(new Client()).start();
        new Thread(new Client()).start();
    }
}

class Server implements Runnable {

    @Override
    public void run() {
        try{
            InetAddress multicastAddress = InetAddress.getByName("228.5.6.8");
            int port = 13245;
            InetSocketAddress group = new InetSocketAddress(multicastAddress, port);
            MulticastSocket socket = new MulticastSocket(port);

            socket.joinGroup(group, null);

            String msg = "Hello world!";

            while(true){
                System.out.println("[!] Server with thread ID: " + Thread.currentThread().getId() + " has started");
                DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, group);
                socket.send(packet);
                System.out.println("[ ! - SRV-" + Thread.currentThread().getId() + "] Packet Sent");
                Thread.sleep(1000);
            }
        }catch(Exception e){
            System.out.println("[ X - SRV-" + Thread.currentThread().getId() + "] Had an error");
            System.err.println(e.getMessage());
        }
    }
}

class Client implements Runnable{

    @Override
    public void run() {
        try {
            InetAddress addr = InetAddress.getByName("228.5.6.8");
            int port = 13245;
            InetSocketAddress group = new InetSocketAddress(addr, port);
            MulticastSocket socket = new MulticastSocket(port);

            socket.joinGroup(group, null);
            byte[] msg = new byte[16];
            while(true){
                Thread.sleep(200);
                System.out.println("[!] Client with thread ID: " + Thread.currentThread().getId() + " has started");
                DatagramPacket p = new DatagramPacket(msg, msg.length);
                socket.receive(p);
                System.out.println("[ ! - CLI-" + Thread.currentThread().getId() + "] Recived: " + new String(msg));
            }
        } catch (Exception e) {
            System.out.println("[ X - CLI-" + Thread.currentThread().getId() + "] Had an error");
            System.err.println(e.getMessage());
        }
    }
    
}
