package it.tn.buonarroti.masala.trisGui.helper;

import it.tn.buonarroti.masala.trisGui.TrisGUI;

import javax.swing.*;

public class GameAssistant {
    public void askPlayersNames() {
        TrisGUI tris = new TrisGUI();
        tris.setGiocatoreUno(JOptionPane.showInputDialog("Nome del primo giocatore: "));
        while (tris.getGiocatoreUno() == null) {
            tris.setGiocatoreUno(JOptionPane.showInputDialog("Nome del primo giocatore non valido, reinserire: "));
        }
        tris.setGiocatoreDue(JOptionPane.showInputDialog("Nome del secondo giocatore: "));
        while (tris.getGiocatoreDue() == null) {
            tris.setGiocatoreDue(JOptionPane.showInputDialog("Nome del secondo giocatore non valido, reinserire: "));
        }
    }
}
