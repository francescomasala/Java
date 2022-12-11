package it.tn.buonarroti.masala.tipsit.quarta.Sockets.Esercizi.Primo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
	private ThreadServer server;

	public ChatServer() throws UnknownHostException {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(cancelButton);

		serverIPAddrTextField.setText(InetAddress.getLocalHost().getHostAddress());

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

		serverStatusButton.setText("Server offline");
		serverStatusButton.setBackground(Color.RED);

	}

	public static void main(String[] args) throws UnknownHostException {
		ChatServer dialog = new ChatServer();
		dialog.pack();
		dialog.setVisible(true);
		System.exit(0);
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
		server = new ThreadServer(serverIPAddrTextField.getText(),
				broadcastCheckBox.isSelected(),
				Integer.parseInt(portaTextField.getText()),
				ServerLogField,
				serverStatusButton);
		server.run();
	}

	private void onStop() {
		server.interrupt();
		ServerLogField.setText(ServerLogField.getText() + "Server Stopped\n");
		serverStatusButton.setBackground(Color.RED);
		serverStatusButton.setText("Server Status: OFF");
	}
}
