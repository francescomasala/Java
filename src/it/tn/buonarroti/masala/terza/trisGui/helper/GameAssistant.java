package it.tn.buonarroti.masala.terza.trisGui.helper;

import lombok.NonNull;

import javax.swing.*;


public class GameAssistant {
	public static void dialogPopupWinnerGUI(@NonNull Character vincitore) throws InterruptedException {
		switch (vincitore) {
			case '1':
				JOptionPane.showMessageDialog(null, GameLogic.getGiocatoreUno() + " ha vinto il gioco!");
				Thread.sleep(1000);
				System.exit(1);
				break;
			case '2':
				JOptionPane.showMessageDialog(null, GameLogic.getGiocatoreDue() + " ha vinto il gioco!");
				Thread.sleep(1000);
				System.exit(1);
				break;
			case 'p':
				JOptionPane.showMessageDialog(null, "Pareggio!");
				Thread.sleep(1000);
				System.exit(1);
				break;
			case 'd':
				break;
		}
	}

	public void askPlayersNames() {
		GameLogic.setGiocatoreUno(JOptionPane.showInputDialog("Nome del primo giocatore: "));
		while (GameLogic.getGiocatoreUno() == null) {
			GameLogic.setGiocatoreUno(JOptionPane.showInputDialog("Nome del primo giocatore non valido, reinserire: "));
		}
		GameLogic.setGiocatoreDue(JOptionPane.showInputDialog("Nome del secondo giocatore: "));
		while (GameLogic.getGiocatoreDue() == null) {
			GameLogic.setGiocatoreDue(JOptionPane.showInputDialog("Nome del secondo giocatore non valido, reinserire: "));
		}
	}
}
