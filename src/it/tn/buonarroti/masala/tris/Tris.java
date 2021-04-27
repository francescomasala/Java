package it.tn.buonarroti.masala.tris;

import java.util.Objects;

public class Tris {
    private boolean[][] gioco;
    private int nMossa;

    public Tris() {

    }

    public Boolean mossaG(int row, int col) {
        Boolean result = Boolean.FALSE;
        if (this.giocoValido() == Boolean.TRUE) {
            if ((row >= 0 && row < 3) && (col >= 0 && col < 3)) {
                if (Objects.equals(this.gioco[row][col], null)) {
                    this.gioco[row][col] = Boolean.TRUE;
                    result = Boolean.TRUE;
                }
            }
        }
        if ((Objects.equals(this.giocoValido(), Boolean.TRUE) && (Objects.equals(result, Boolean.TRUE)))){
            this.mossaC();
        }
        return true;
    }

    private void mossaC() {

    }

    public boolean giocoValido() {
        return true;
    }

    public Integer vincitore() {

        return 0;
    }

    public String toString(){
        return "";
    }

}
