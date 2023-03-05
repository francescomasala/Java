package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.Es1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	String init;
	DatagramSocket socket;
	InetAddress address;
	int port;

	public Client(InetAddress address, int port) {
		this.init = "It's hammertime!";
		this.address = address;
		this.port = port;
	}

	public void initServer() {
		byte[] b = init.getBytes();
		DatagramPacket p = new DatagramPacket(b, b.length, address, port);
		try {
			socket.send(p);
			SocketListen(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SocketListen(DatagramPacket p) {
		byte[] buffer;
		while (true) {
			buffer = new byte[1024];
			try {
				socket.receive(p);
				System.out.println("[!] Ricevuto pacchetto da " + p.getAddress() + ":" + p.getPort());
				System.out.println("[!] Contenente: " + new String(p.getData(), 0, p.getLength()));
				String s = new String(p.getData(), 0, p.getLength());
				if (s.equals("/n")) {
					System.out.println("[!] Ricevuto /n, chiudo");
					socket.close();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
