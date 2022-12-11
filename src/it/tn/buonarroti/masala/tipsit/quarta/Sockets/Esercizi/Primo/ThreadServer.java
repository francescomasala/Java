package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Esercizi.Primo;

import javax.swing.*;
import java.awt.*;

public class ThreadServer extends Thread {
private String IPAddr;
	private Boolean IsBroadcast;
	private Integer Port;
	private JTextPane LogGui;

	private JButton statusButton;

	public ThreadServer(String IPAddr, Boolean IsBroadcast, int Port, JTextPane Log, JButton statusButton) {
		this.IPAddr = IPAddr;
		this.IsBroadcast = IsBroadcast;
		this.Port = Port;
		this.LogGui = Log;
		this.statusButton = statusButton;
	}

	private void printLog(String Message) {
		this.LogGui.setText(this.LogGui.getText() +
				"[!] " + Message + "\n");
	}

	private void checkBroadcast() {
		if (this.IsBroadcast) {
			IPAddr = "255.255.255.255";
			this.printLog("Il server è in modalità broadcast");
		} else {
			IPAddr = IPAddr;
			this.printLog("Il server è in modalità unicast");
		}
	}

	private void setStatus(Boolean status) {
		if (status) {
			statusButton.setBackground(Color.GREEN);
			statusButton.setText("Server Status: ON");
		} else {
			statusButton.setText("Server offline");
			statusButton.setBackground(Color.RED);
		}
	}

	@Override
	public void run() {
		this.printLog("Ho creato il thread: " + Thread.currentThread().getId());
		this.printLog("Sto inizializzando il server...");
		checkBroadcast();
		setStatus(true);
		this.printLog("Server started with IP: " + IPAddr + " and Port: " + Port);
	}

}
