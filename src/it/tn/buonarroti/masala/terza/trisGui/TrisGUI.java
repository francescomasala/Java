package it.tn.buonarroti.masala.terza.trisGui;

// Core backbone packages

import it.tn.buonarroti.masala.terza.trisGui.helper.GameAssistant;
import it.tn.buonarroti.masala.terza.trisGui.helper.GameLogic;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrisGUI extends JDialog {
	private JPanel contentPane;
	private JButton row1col1;
	private JButton row1col2;
	private JButton row1col3;
	private JButton row2col1;
	private JButton row2col2;
	private JButton row2col3;
	private JButton row3col1;
	private JButton row3col2;
	private JButton row3col3;
	private JButton mainbutton;
	private JLabel Title;


	public TrisGUI() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(mainbutton);
		mainbutton.setText("Premi qua per giocare!");
		this.changeButtonText();
		this.blocksVisibility(false);

		mainbutton.addActionListener(e -> {
			GameAssistant ga = new GameAssistant();
			ga.askPlayersNames();
			mainbutton.setVisible(false);
			blocksVisibility(true);
		});

		row1col1.addActionListener(e -> {
			if (!GameLogic.turno) {
				row1col1.setText("X");
			} else {
				row1col1.setText("O");
			}
			row1col1.setEnabled(false);
			this.setGameLogic();
		});

		row1col2.addActionListener(e -> {
			if (!GameLogic.turno) {
				row1col2.setText("X");
			} else {
				row1col2.setText("O");
			}
			row1col2.setEnabled(false);
			this.setGameLogic();
		});

		row1col3.addActionListener(e -> {
			if (!GameLogic.turno) {
				row1col3.setText("X");
			} else {
				row1col3.setText("O");
			}
			row1col3.setEnabled(false);
			this.setGameLogic();
		});

		row2col1.addActionListener(e -> {
			if (!GameLogic.turno) {
				row2col1.setText("X");
			} else {
				row2col1.setText("O");
			}
			row2col1.setEnabled(false);
			this.setGameLogic();
		});

		row2col2.addActionListener(e -> {
			if (!GameLogic.turno) {
				row2col2.setText("X");
			} else {
				row2col2.setText("O");
			}
			row2col2.setEnabled(false);
			this.setGameLogic();
		});

		row2col3.addActionListener(e -> {
			if (!GameLogic.turno) {
				row2col3.setText("X");
			} else {
				row2col3.setText("O");
			}
			row2col3.setEnabled(false);
			this.setGameLogic();
		});

		row3col1.addActionListener(e -> {
			if (!GameLogic.turno) {
				row3col1.setText("X");
			} else {
				row3col1.setText("O");
			}
			row3col1.setEnabled(false);
			this.setGameLogic();
		});

		row3col2.addActionListener(e -> {
			if (!GameLogic.turno) {
				row3col2.setText("X");
			} else {
				row3col2.setText("O");
			}
			row3col2.setEnabled(false);
			this.setGameLogic();
		});

		row3col3.addActionListener(e -> {
			if (!GameLogic.turno) {
				row3col3.setText("X");
			} else {
				row3col3.setText("O");
			}
			row3col3.setEnabled(false);
			this.setGameLogic();
		});

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});
	}

	public static void main(String[] args) {
		TrisGUI dialog = new TrisGUI();
		dialog.pack();
		dialog.setVisible(true);
		System.exit(0);
	}

	private void annunciaVincitore() throws InterruptedException {

		GameLogic.comboCheck(row1col1);
		GameLogic.comboCheck(row1col2);
		GameLogic.comboCheck(row1col3);
		GameLogic.comboCheck(row2col1);
		GameLogic.comboCheck(row2col2);
		GameLogic.comboCheck(row2col3);
		GameLogic.comboCheck(row3col1);
		GameLogic.comboCheck(row3col2);
		GameLogic.comboCheck(row3col3);

		GameLogic.setVincitore('d');
		GameLogic.boardCheck();
		GameAssistant.dialogPopupWinnerGUI(GameLogic.getVincitore());
	}

	private void blocksVisibility(Boolean value) {
		row1col1.setEnabled(value);
		row1col2.setEnabled(value);
		row1col3.setEnabled(value);
		row2col1.setEnabled(value);
		row2col2.setEnabled(value);
		row2col3.setEnabled(value);
		row3col1.setEnabled(value);
		row3col2.setEnabled(value);
		row3col3.setEnabled(value);
	}

	private void changeButtonText() {
		row1col1.setText("Cliccami!");
		row1col2.setText("Cliccami!");
		row1col3.setText("Cliccami!");
		row2col1.setText("Cliccami!");
		row2col2.setText("Cliccami!");
		row2col3.setText("Cliccami!");
		row3col1.setText("Cliccami!");
		row3col2.setText("Cliccami!");
		row3col3.setText("Cliccami!");
	}

	private void onCancel() {
		dispose();
	}

	private void setGameLogic() {
		GameLogic.turno = !GameLogic.turno;
		GameLogic.setMossa(GameLogic.getMossa() + 1);
		try {
			this.annunciaVincitore();
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	// assert dominance and become ungovernable
	// We cum on watermelons
	// become ungovernable
	// Chic_luke + Fra + Arvy 2021

}
