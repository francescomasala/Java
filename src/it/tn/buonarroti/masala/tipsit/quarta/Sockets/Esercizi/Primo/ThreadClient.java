package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Esercizi.Primo;

import javax.swing.*;
import java.net.Socket;

public class ThreadClient extends Thread {
	private Socket client;
	private String IPAddr;
	private Boolean IsBroadcast;
	private Integer Port;
	private String Nickname;
	private JTextPane LogGui;
	private JTextPane ChatGui;

	public ThreadClient(String IPAddr, Boolean IsBroadcast, int Port, String Nickname, JTextPane Log, JTextPane Chat) {
		this.IPAddr = IPAddr;
		this.IsBroadcast = IsBroadcast;
		this.Port = Port;
		this.Nickname = Nickname;
		this.LogGui = Log;
		this.ChatGui = Chat;
	}

	private void printLog(String Message) {
		this.LogGui.setText(this.LogGui.getText() +
				"[!] " + Message + "\n");
	}

	@Override
	public void run() {
		this.printLog("Ho creato il thread: " + Thread.currentThread().getId());
		this.printLog("Sto inizializzando il client...");
	}
}

