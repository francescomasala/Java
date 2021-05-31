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
        this.changeButtonText("Cliccami!");
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

            GameLogic.turno = !GameLogic.turno;
            row1col1.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row1col2.addActionListener(e -> {
            if (!GameLogic.turno) {
                row1col2.setText("X");
            } else {
                row1col2.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row1col2.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row1col3.addActionListener(e -> {
            if (!GameLogic.turno) {
                row1col3.setText("X");
            } else {
                row1col3.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row1col3.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row2col1.addActionListener(e -> {
            if (!GameLogic.turno) {
                row2col1.setText("X");
            } else {
                row2col1.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row2col1.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row2col2.addActionListener(e -> {
            if (!GameLogic.turno) {
                row2col2.setText("X");
            } else {
                row2col2.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row2col2.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row2col3.addActionListener(e -> {
            if (!GameLogic.turno) {
                row2col3.setText("X");
            } else {
                row2col3.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row2col3.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row3col1.addActionListener(e -> {
            if (!GameLogic.turno) {
                row3col1.setText("X");
            } else {
                row3col1.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row3col1.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row3col2.addActionListener(e -> {
            if (!GameLogic.turno) {
                row3col2.setText("X");
            } else {
                row3col2.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row3col2.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row3col3.addActionListener(e -> {
            if (!GameLogic.turno) {
                row3col3.setText("X");
            } else {
                row3col3.setText("O");
            }

            GameLogic.turno = !GameLogic.turno;
            row3col3.setEnabled(false);

            GameLogic.setMossa(GameLogic.getMossa()+1);
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
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

        if (!row1col1.getText().equals("Cliccami!")) GameLogic.valoriTris[0][0] =
                ((row1col1.getText().equals("X")) ? '1' : '2');
        if (!row1col2.getText().equals("Cliccami!")) GameLogic.valoriTris[0][1] =
                ((row1col2.getText().equals("X")) ? '1' : '2');
        if (!row1col3.getText().equals("Cliccami!")) GameLogic.valoriTris[0][2] =
                ((row1col3.getText().equals("X")) ? '1' : '2');
        if (!row2col1.getText().equals("Cliccami!")) GameLogic.valoriTris[1][0] =
                ((row2col1.getText().equals("X")) ? '1' : '2');
        if (!row2col2.getText().equals("Cliccami!")) GameLogic.valoriTris[1][1] =
                ((row2col2.getText().equals("X")) ? '1' : '2');
        if (!row2col3.getText().equals("Cliccami!")) GameLogic.valoriTris[1][2] =
                ((row2col3.getText().equals("X")) ? '1' : '2');
        if (!row3col1.getText().equals("Cliccami!")) GameLogic.valoriTris[2][0] =
                ((row3col1.getText().equals("X")) ? '1' : '2');
        if (!row3col2.getText().equals("Cliccami!")) GameLogic.valoriTris[2][1] =
                ((row3col2.getText().equals("X")) ? '1' : '2');
        if (!row3col3.getText().equals("Cliccami!")) GameLogic.valoriTris[2][2] =
                ((row3col3.getText().equals("X")) ? '1' : '2');

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

    private void changeButtonText(String value) {
        row1col1.setText(value);
        row1col2.setText(value);
        row1col3.setText(value);
        row2col1.setText(value);
        row2col2.setText(value);
        row2col3.setText(value);
        row3col1.setText(value);
        row3col2.setText(value);
        row3col3.setText(value);
    }

    private void onCancel() {
        dispose();
    }
}
