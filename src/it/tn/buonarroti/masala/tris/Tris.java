package it.tn.buonarroti.masala.tris;

import java.util.Objects;

public class Tris {
    private Character[][] griglia;
    private Character charVincitore;
    private Boolean giocatore;
    private int turno;

    public Tris(Character cGiocatore) {

    }

    public String layout(){
        return null;
    }

    public Boolean getGiocatore() {
        return this.giocatore;
    }

    private void setGiocatore() {

    }

    public Boolean mossaG(int row, int col) {
        return true;
    }

    private void mossaC() {

    }

    public boolean giocoValido() {
        return true;
    }

    public Character trisVincitore() {
        return null;
    }

    public String messaggioVincitore() {
        return null;
    }

    public String toString(){
        return "";
    }

}
