package it.tn.buonarroti.masala.trisGui;

import javax.swing.*;
import java.awt.event.*;

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
        //Short mossa = 0;

        row1col1.setEnabled(false);
        row1col2.setEnabled(false);
        row1col3.setEnabled(false);
        row2col1.setEnabled(false);
        row2col2.setEnabled(false);
        row2col3.setEnabled(false);
        row3col1.setEnabled(false);
        row3col2.setEnabled(false);
        row3col3.setEnabled(false);

        mainbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                giocatoreUno = JOptionPane.showInputDialog("Nome del primo giocatore: ");
                giocatoreDue = JOptionPane.showInputDialog("Nome del secondo giocatore: ");

                mainbutton.setVisible(false);

                row1col1.setEnabled(true);
                row1col2.setEnabled(true);
                row1col3.setEnabled(true);
                row2col1.setEnabled(true);
                row2col2.setEnabled(true);
                row2col3.setEnabled(true);
                row3col1.setEnabled(true);
                row3col2.setEnabled(true);
                row3col3.setEnabled(true);
            }
        });

        row1col1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row1col1.setText("X");
                } else {
                    row1col1.setText("O");
                }

                turno = !turno;
                row1col1.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row1col2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row1col2.setText("X");
                } else {
                    row1col2.setText("O");
                }

                turno = !turno;
                row1col2.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row1col3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row1col3.setText("X");
                } else {
                    row1col3.setText("O");
                }

                turno = !turno;
                row1col3.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row2col1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row2col1.setText("X");
                } else {
                    row2col1.setText("O");
                }

                turno = !turno;
                row2col1.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row2col2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row2col2.setText("X");
                } else {
                    row2col2.setText("O");
                }

                turno = !turno;
                row2col2.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row2col3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row2col3.setText("X");
                } else {
                    row2col3.setText("O");
                }

                turno = !turno;
                row2col3.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row3col1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row3col1.setText("X");
                } else {
                    row3col1.setText("O");
                }

                turno = !turno;
                row3col1.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row3col2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row3col2.setText("X");
                } else {
                    row3col2.setText("O");
                }

                turno = !turno;
                row3col2.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

        row3col3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (turno == false) {
                    row3col3.setText("X");
                } else {
                    row3col3.setText("O");
                }

                turno = !turno;
                row3col3.setEnabled(false);

                TrisGUI.mossa++;
            }
        });

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



    public static void main(String[] args) {
        TrisGUI dialog = new TrisGUI();
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
