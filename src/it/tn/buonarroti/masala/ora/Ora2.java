package it.tn.buonarroti.masala.ora;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ora2 {

    //ATTRIBUTI
    private Integer ore;
    private Integer minuti;
    private Integer secondi;

    //COSTRUTTORE CON PARAMETRI
    public Ora2(Integer ore, Integer minuti, Integer secondi) {
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    //METODI GET E SET
    public Integer getOre() {
        return ore;
    }

    public void setOre(Integer ore) {
        this.ore = ore;
    }

    public Integer getMinuti() {
        return minuti;
    }

    public void setMinuti(Integer minuti) {
        this.minuti = minuti;
    }

    public Integer getSecondi() {
        return secondi;
    }

    public void setSecondi(Integer secondi) {
        this.secondi = secondi;
    }


    public Integer differenzaMezzanotteSecondiPar(Integer ore, Integer minuti, Integer secondi) {

        if (validaOra(ore, minuti, secondi) && validaOra(this.ore, this.minuti, this.secondi)) {

            //Trasforma ora in secondi
            Integer secondiParametri = secondiDaMezzanotte(ore, minuti, secondi);
            Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

            //Calcola differenza
            Integer differenza = secondiParametri - secondiAttributi;

            //Ritorna differenza
            if (differenza > 0) return differenza;
            else return -differenza;

        } else return -1; //Ore fornite non valide
    }

    public Integer differenzaMezzanotteMinutiPar(Integer ore, Integer minuti, Integer secondi) {

        if (validaOra(ore, minuti, secondi) && validaOra(this.ore, this.minuti, this.secondi)) {

            //Trasforma ora in secondi
            Integer secondiParametri = secondiDaMezzanotte(ore, minuti, secondi);
            Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

            //Calcola differenza
            Integer differenza = secondiParametri - secondiAttributi;
            differenza = differenza / 60;

            //Ritorna differenza
            if (differenza > 0) return differenza;
            else return -differenza;

        } else return -1; //Ore fornite non valide
    }

    public Integer differenzaMezzanotteOrePar(Integer ore, Integer minuti, Integer secondi) {

        if (validaOra(ore, minuti, secondi) && validaOra(this.ore, this.minuti, this.secondi)) {

            //Trasforma ora in secondi
            Integer secondiParametri = secondiDaMezzanotte(ore, minuti, secondi);
            Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

            //Calcola differenza
            Integer differenza = secondiParametri - secondiAttributi;
            differenza = differenza / 3600;

            //Ritorna differenza
            if (differenza > 0) return differenza;
            else return -differenza;

        } else return -1; //Ore fornite non valide
    }

    private Integer secondiDaMezzanotte(Integer ore, Integer minuti, Integer secondi) {
        return (secondi + (minuti * 60) + (ore * 3600));

    }

    public void aggiungiSecondi(Integer secondi) { //NUOVA VERSIONE MIGLIORE

        //Aggiungi i secondi all'attributo onomino
        this.secondi += secondi;

        //Aggiusta gli attributi in base ai limiti temporali
        if (this.secondi > 59) {
            this.minuti += this.secondi / 60;
            this.secondi = this.secondi % 60;

            if (this.minuti > 59) {
                this.ore += this.minuti / 60;
                this.minuti = this.minuti % 60;

                while (this.ore > 23) {
                    this.ore -= 24;
                }
            }
        }
    }

    /*
    public Integer[] secondiToOraCompleta(Integer secondi) {
        Integer[] oraCompleta = new Integer[3];
        oraCompleta[0] = (secondi / 3600) % 24; //ORA CORRETTA IN AUTOMATICO
        oraCompleta[1] = (secondi % 3600) / 60;
        oraCompleta[2] = ((secondi % 3600) % 60);
        return oraCompleta;
    } */

    public void aggiungiSecondiV2(Integer secondi) {

        //ottieni secondi ora corrente
        Integer secCorrenti = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);
        secCorrenti += secondi;

        //Calcola per categoria
        ore = (secCorrenti / 3600) % 24; //ORA CORRETTA IN AUTOMATICO
        minuti = (secCorrenti % 3600) / 60;
        this.secondi = ((secCorrenti % 3600) % 60);

    }


    public Ora2 differenzaInOreMinSec(Ora2 ora) {

        //Valida ora
        if (validaOra(ora.getOre(), ora.getMinuti(), ora.getMinuti()) && validaOra(ore, minuti, secondi)) {

            //Trasforma tutto in secondi
            Integer secondiParametri = secondiDaMezzanotte(ora.getOre(), ora.getMinuti(), ora.getSecondi());
            Integer secondiAttributi = secondiDaMezzanotte(this.ore, this.minuti, this.secondi);

            Integer differenza = Math.abs(secondiParametri - secondiAttributi);

            //Ritrasforma in secondi
            Ora2 oraReturn = new Ora2(0, 0, 0);
            oraReturn.setOre((differenza / 3600) % 24);
            oraReturn.setMinuti((differenza % 3600) / 60);
            oraReturn.setSecondi((differenza % 3600) % 60);

            //Ritorna i valori di ora
            return oraReturn;

        } else {

            Ora2 oraNulla = new Ora2(0, 0, 0);
            return oraNulla;

        }
    }

    public Ora2 differenzaInOreMinSecAttuale() {

        //ottengo ora attuale
        GregorianCalendar calendario = new GregorianCalendar();
        Ora2 oraAttuale = new Ora2(0, 0, 0);

        oraAttuale.setOre(calendario.get(Calendar.HOUR_OF_DAY));
        oraAttuale.setMinuti(calendario.get(Calendar.MINUTE));
        oraAttuale.setSecondi(calendario.get(Calendar.SECOND));

        //chiamo metodo con parametri
        return differenzaInOreMinSec(oraAttuale);

    }


    public void aggiungiMinuti(Integer minuti) {
        aggiungiSecondiV2(minuti * 60);
    }

    public void aggiungiOre(Integer ore) {
        aggiungiSecondiV2(ore * 3600);
    }


    private Boolean validaOra(Integer ore, Integer minuti, Integer secondi) {

        //Controlla orario, le ore tra 0->23, i minuti tra 0->59, i secondi da 0->59
        return (ore <= 23 && ore >= 0) && (minuti <= 59 && minuti >= 0) && (secondi <= 59 && minuti >= 0);

    }


}
