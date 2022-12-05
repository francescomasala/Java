package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Esercizi.Primo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClient extends JDialog {
	private JPanel contentPane;
	private JButton buttonOK;
	private JButton cancelButton;
	private JTextArea MessageSentArea;
	private JButton SendButton;
	private JTextPane ChatLogField;
	private JButton stopButton;
	private JButton connectButton;
	private JCheckBox broadcastCheckBox;
	private JButton serverStatusButton;
	private JTextField indirizzoIPTextField;
	private JTextPane ServerLogField;
	private JTextPane chatClientFrancescoMasala5INATextPane;
	private JTextField portaTextField;
	private JTextField nomeUtenteTextField;

	private ThreadClient client = null;

	public ChatClient() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(cancelButton);
		serverStatusButton.setBackground(Color.RED);
		serverStatusButton.setText("Client Status: OFF");
		ServerLogField.setText("Client Logs: \n");

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

	private void onStop() {
		// add your code here if necessary
		client.interrupt();
		serverStatusButton.setBackground(Color.RED);
		serverStatusButton.setText("Client Status: OFF");
		ServerLogField.setText(ServerLogField.getText() + "Client Logs: \n");

	}

	private void onStart() {
		try {
			this.client = new ThreadClient(indirizzoIPTextField.getText(), broadcastCheckBox.isSelected(),
					Integer.parseInt(portaTextField.getText()), nomeUtenteTextField.getText(),
					ServerLogField, ChatLogField);

			String IPAddr = indirizzoIPTextField.getText();
			String Port = portaTextField.getText();

			Boolean IsBroadcast = broadcastCheckBox.isSelected();
			if (IsBroadcast && IPAddr.isBlank()) {
				IPAddr = "255.255.255.255";
				ServerLogField.setText(ServerLogField.getText() + "[!] Client Started in Broadcast Mode on :" + IPAddr +"\n");
			} else if (IsBroadcast && !IPAddr.isEmpty()) {
				IPAddr = "255.255.255.255";
				ServerLogField.setText(ServerLogField.getText() + "[!] Client Started in Broadcast Mode and the inserted IP is ignored\n");
			} else {
				ServerLogField.setText(ServerLogField.getText() + "[!] Client Started listening to IP: " + IPAddr +"\n");
				ServerLogField.setText(ServerLogField.getText() + "[!] Client Started in Unicast Mode to port: " + Port + "\n");
			}

			client.run();

			serverStatusButton.setBackground(Color.GREEN);
			serverStatusButton.setText("Server Status: ON");

		} catch (Exception e) {
			ServerLogField.setText(ServerLogField.getText() + "[!] Ricontrolla meglio i tuoi dati\n");
			JOptionPane.showMessageDialog(getParent(), "[!] Error: \n" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		ChatClient dialog = new ChatClient();
		dialog.pack();
		dialog.setVisible(true);
		System.exit(0);
	}
}
