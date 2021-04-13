package it.tn.buonarroti.masala.ora;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * @author Francesco Masala
 */
public class Ora1 {

    public Integer ore;
    public Integer minuti;
    public Integer secondi;

    /**
     * @param ore     Inserire l'ora desiderata
     * @param minuti  Inserire i minuti desiderati
     * @param secondi Inserire i secondi
     */
    public Ora1(Integer ore, Integer minuti, Integer secondi) {
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    public Integer getOre() {
        return ore;
    }

    /**
     * @param ore Inserire l'ora desiderata
     */
    public void setOre(Integer ore) {
        this.ore = ore;
    }

    public Integer getMinuti() {
        return minuti;
    }

    /**
     * @param minuti Inserire i minuti desiderati
     */
    public void setMinuti(Integer minuti) {
        this.minuti = minuti;
    }

    public Integer getSecondi() {
        return secondi;
    }

    /**
     * @param secondi Inserire i secondi desiderati
     */
    public void setSecondi(Integer secondi) {
        this.secondi = secondi;
    }

    private Boolean validaOra() {
        Boolean check = Boolean.TRUE;
        // Creo una variabile booleana ed imposto TRUE come default
        if (this.ore < 0 || this.ore >= 23) {
            check = Boolean.FALSE;
        }
        // SE ore è minore di 24 assegna a check un valore FALSE
        if (this.minuti < 0 || this.minuti >= 59) {
            check = Boolean.FALSE;
        }
        // SE minuti è minore di 60 assegna a check un valore FALSE
        if (this.secondi < 0 || this.secondi >= 59) {
            check = Boolean.FALSE;
        }
        // SE secondi è minore di 60 assegna a check un valore FALSE
        return check;
    }

    public Integer differenzaInOre() {
        // Creo l'oggetto oraAttuale da GregorianCalendar
        Integer oraAttuale
                = new GregorianCalendar().get(GregorianCalendar.HOUR_OF_DAY);
        // Creo la variabile differenza
        int differenza;
        // Se validaOra() è falso deve ritornare il valore "-1"
        if (Objects.equals(validaOra(), Boolean.FALSE)) {
            differenza = -1;
        } else {
            // Mentre se è positivo mi restituisce il valore assoluto
            // Del risultato tra le due
            differenza = this.ore - oraAttuale;
            differenza = Math.abs(differenza);
        }
        return differenza;
    }

    public Integer differenzaInMinuti() {
        // Creo l'oggetto oraAttuale da GregorianCalendar
        int minutoAttuale
                = new GregorianCalendar().get(GregorianCalendar.MINUTE);
        Integer differenzaOre = differenzaInOre();
        // Creo la variabile differenza
        int differenza;
        // Se validaOra() è falso deve ritornare il valore "-1"
        if (Objects.equals(validaOra(), Boolean.FALSE)) {
            differenza = -1;
        } else {
            // Mentre se è positivo mi restituisce il valore assoluto
            // Del risultato tra le due
            differenza = ((differenzaOre * 60) + this.minuti - minutoAttuale);
            differenza = Math.abs(differenza);
        }
        return differenza;
    }

    public Integer differenzaInSecondi() {
        // Creo l'oggetto oraAttuale da GregorianCalendar
        int secondoAttuale
                = new GregorianCalendar().get(GregorianCalendar.SECOND);
        Integer differenzaMinuti = differenzaInMinuti();
        // Creo la variabile differenza
        int differenza;
        // Se validaOra() è falso deve ritornare il valore "-1"
        if (Objects.equals(validaOra(), Boolean.FALSE)) {
            differenza = -1;
        } else {
            // Mentre se è positivo mi restituisce il valore assoluto
            // Del risultato tra le due
            differenza = ((differenzaMinuti * 60)
                    + this.secondi - secondoAttuale);
            differenza = Math.abs(differenza);
        }
        return differenza;
    }

    public String differenzaInOreMinutiSecondi() {
        String stringDifferenza = null;
        Integer ore = differenzaInOre(), minuti = differenzaInMinuti(), secondi = differenzaInSecondi();
        stringDifferenza = "Ore: " + ore.toString() + "\nMinuti: " + minuti.toString() +
                "\nSecondi: " + secondi.toString();
        return stringDifferenza;

    }
}
