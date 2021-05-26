package it.tn.buonarroti.masala.trisGui;

import it.tn.buonarroti.masala.trisGui.helper.GameAssistant;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrisGUI extends JDialog {
    private static int mossa = 0;
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
    private String giocatoreUno;
    private String giocatoreDue;
    private boolean turno = false;


    public TrisGUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(mainbutton);
        mainbutton.setText("Premi qua per giocare!");
        this.changeButtonText("Cliccami!");
        //Short mossa = 0;

        this.blocksVisibility(false);

        mainbutton.addActionListener(e -> {
            it.tn.buonarroti.masala.trisGui.helper.GameAssistant ga = new GameAssistant();
            ga.askPlayersNames();

            mainbutton.setVisible(false);
            blocksVisibility(true);
        });

        row1col1.addActionListener(e -> {
            if (!turno) {
                row1col1.setText("X");
            } else {
                row1col1.setText("O");
            }

            turno = !turno;
            row1col1.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row1col2.addActionListener(e -> {
            if (!turno) {
                row1col2.setText("X");
            } else {
                row1col2.setText("O");
            }

            turno = !turno;
            row1col2.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row1col3.addActionListener(e -> {
            if (!turno) {
                row1col3.setText("X");
            } else {
                row1col3.setText("O");
            }

            turno = !turno;
            row1col3.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row2col1.addActionListener(e -> {
            if (!turno) {
                row2col1.setText("X");
            } else {
                row2col1.setText("O");
            }

            turno = !turno;
            row2col1.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row2col2.addActionListener(e -> {
            if (!turno) {
                row2col2.setText("X");
            } else {
                row2col2.setText("O");
            }

            turno = !turno;
            row2col2.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row2col3.addActionListener(e -> {
            if (!turno) {
                row2col3.setText("X");
            } else {
                row2col3.setText("O");
            }

            turno = !turno;
            row2col3.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row3col1.addActionListener(e -> {
            if (!turno) {
                row3col1.setText("X");
            } else {
                row3col1.setText("O");
            }

            turno = !turno;
            row3col1.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row3col2.addActionListener(e -> {
            if (!turno) {
                row3col2.setText("X");
            } else {
                row3col2.setText("O");
            }

            turno = !turno;
            row3col2.setEnabled(false);

            TrisGUI.mossa++;
            try {
                annunciaVincitore();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        row3col3.addActionListener(e -> {
            if (!turno) {
                row3col3.setText("X");
            } else {
                row3col3.setText("O");
            }

            turno = !turno;
            row3col3.setEnabled(false);

            TrisGUI.mossa++;
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
        // Caso di default se nessuna situazione accade
        Character vincitore;

        //Crea array
        Character[][] valoriTris = new Character[3][3];

        if (!row1col1.getText().equals("Cliccami!")) valoriTris[0][0] = ((row1col1.getText().equals("X")) ? '1' : '2');
        if (!row1col2.getText().equals("Cliccami!")) valoriTris[0][1] = ((row1col2.getText().equals("X")) ? '1' : '2');
        if (!row1col3.getText().equals("Cliccami!")) valoriTris[0][2] = ((row1col3.getText().equals("X")) ? '1' : '2');
        if (!row2col1.getText().equals("Cliccami!")) valoriTris[1][0] = ((row2col1.getText().equals("X")) ? '1' : '2');
        if (!row2col2.getText().equals("Cliccami!")) valoriTris[1][1] = ((row2col2.getText().equals("X")) ? '1' : '2');
        if (!row2col3.getText().equals("Cliccami!")) valoriTris[1][2] = ((row2col3.getText().equals("X")) ? '1' : '2');
        if (!row3col1.getText().equals("Cliccami!")) valoriTris[2][0] = ((row3col1.getText().equals("X")) ? '1' : '2');
        if (!row3col2.getText().equals("Cliccami!")) valoriTris[2][1] = ((row3col2.getText().equals("X")) ? '1' : '2');
        if (!row3col3.getText().equals("Cliccami!")) valoriTris[2][2] = ((row3col3.getText().equals("X")) ? '1' : '2');

        vincitore = 'd';
        if (mossa == 9) vincitore = 'p';
        for (int i = 0; i < 3; i++) {
            // Tris verticale
            if (valoriTris[0][i] == valoriTris[1][i] && valoriTris[1][i] == valoriTris[2][i] && valoriTris[0][i] != null) {
                vincitore = valoriTris[0][i];
                // Tris orizzontale
            } else if (valoriTris[i][0] == valoriTris[i][1] && valoriTris[i][1] == valoriTris[i][2] && valoriTris[i][0] != null) {
                vincitore = valoriTris[i][0];
            }
        }
        // Tris diagonale
        if (valoriTris[1][1] != ' ') {
            if (valoriTris[0][0] == valoriTris[1][1] && valoriTris[1][1] == valoriTris[2][2]) {
                vincitore = valoriTris[1][1];
            } else if (valoriTris[0][2] == valoriTris[1][1] && valoriTris[1][1] == valoriTris[2][0]) {
                vincitore = valoriTris[1][1];
            }
        }

        switch (vincitore) {
            case '1':
                JOptionPane.showMessageDialog(null, this.giocatoreUno + " ha vinto il gioco!");
                dispose();
                Thread.sleep(10000);
                break;
            case '2':
                JOptionPane.showMessageDialog(null, this.giocatoreDue + " ha vinto il gioco!");
                dispose();
                Thread.sleep(10000);
                break;
            case 'p':
                JOptionPane.showMessageDialog(null, "Pareggio!");
                dispose();
                Thread.sleep(10000);
                break;
            case 'd':
                break;
        }
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

    public String getGiocatoreUno() {
        return this.giocatoreUno;
    }

    public void setGiocatoreUno(String giocatoreUno) {
        this.giocatoreUno = giocatoreUno;
    }

    public String getGiocatoreDue() {
        return this.giocatoreDue;
    }

    public void setGiocatoreDue(String giocatoreDue) {
        this.giocatoreDue = giocatoreDue;
    }

    private void onCancel() {
        dispose();
    }
}
