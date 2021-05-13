package it.tn.buonarroti.masala.tris;

import java.util.Objects;

public class Tris {
    private boolean[][] gioco;
    private int nMossa;

    public Tris() {

    }

    public Boolean mossaGiocatore(int row, int col) {
        Boolean result = Boolean.FALSE;
        if (this.giocoValido() == Boolean.TRUE) {
            if ((row >= 0 && row < 3) && (col >= 0 && col < 3)) {
                if (Objects.equals(this.gioco[row][col], null)) {
                    this.gioco[row][col] = Boolean.TRUE;
                    result = Boolean.TRUE;
                }
            }
        }
        if ((Objects.equals(this.giocoValido(), Boolean.TRUE) && (Objects.equals(result, Boolean.TRUE)))) {
            this.mossaComputer();
        }
        return true;
    }

    private void mossaComputer() {

    }

    private Boolean controllaScacchiera() {

        return Boolean.FALSE;
    }

    public Boolean giocoValido() {
        return true;
    }

    public Integer stabilisciVincitore() {

        return 0;
    }

    public String toString() {
        return "";
    }

    public void turnoGioco() {

    }

}
