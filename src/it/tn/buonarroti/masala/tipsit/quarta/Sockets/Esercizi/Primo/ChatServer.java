package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Esercizi.Primo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatServer extends JDialog {
	private JPanel contentPane;
	private JButton cancelButton;
	private JButton connectButton;
	private JCheckBox broadcastCheckBox;
	private JButton stopButton;
	private JTextField serverIPAddrTextField;
	private JButton serverStatusButton;
	private JTextPane ServerLogField;
	private JTextPane chatServerFrancescoMasala5INATextPane;
	private JTextField portaTextField;

	public ChatServer() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(cancelButton);

		cancelButton.addActionListener(e -> onCancel());

		connectButton.addActionListener(e -> onStart());

		stopButton.addActionListener(e -> onStop());

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});

		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}

	private void onOK() {
		// add your code here
		dispose();
	}

	private void onCancel() {
		// add your code here if necessary
		dispose();
	}

	private void onStart() {
		// add your code here if necessary
		String IPAddr = serverIPAddrTextField.getText();
		Boolean IsBroadcast = broadcastCheckBox.isSelected();
		if (IsBroadcast && IPAddr.isBlank()) {
			IPAddr = "255.255.255.255";
			ServerLogField.setText(ServerLogField.getText() + "[!] Server Started in Broadcast Mode on :" + IPAddr +"\n");
		} else if (IsBroadcast && !IPAddr.isEmpty()) {
			IPAddr = "255.255.255.255";
			ServerLogField.setText(ServerLogField.getText() + "[!] Server Started in Broadcast Mode and the inserted IP is ignored\n");
		} else {
			ServerLogField.setText(ServerLogField.getText() + "[!] Server Started with IP: " + IPAddr +"\n");
			ServerLogField.setText(ServerLogField.getText() + "[!] Server Started in Unicast Mode\n");
		}
		serverStatusButton.setBackground(Color.GREEN);
		serverStatusButton.setText("Server Status: ON");
	}

	private void onStop(){
		// add your code here if necessary
		ServerLogField.setText(ServerLogField.getText() + "Server Stopped\n");
		serverStatusButton.setBackground(Color.RED);
		serverStatusButton.setText("Server Status: OFF");
	}
	public static void main(String[] args) {
		ChatServer dialog = new ChatServer();
		dialog.pack();
		dialog.setVisible(true);
		System.exit(0);
	}
}
