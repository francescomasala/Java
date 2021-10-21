package it.tn.buonarroti.masala.quarta.persona;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * La classe persona definisce le caratteristiche e comportamenti di una persona
 *
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 * @version 2021.10.21
 */
public class Persona2 {
    @Getter
    @Setter
    public Double altezza;
    @Getter
    @Setter
    public String cognome;
    @Getter
    @Setter
    public String nome;
    @Getter
    @Setter
    public Float peso;
    @Getter
    private String dataDiNascita;
    @Getter
    private Integer eta;

    /**
     * Primo costruttore del metodo
     *
     */
    public Persona2() {

    }

    /**
     * Secondo costruttore del metodo
     *
     * @param altezza Inserire l'altezza come un double - Es. 1.75
     * @param cognome Inserire il cognome come una stringa - Es. Masala
     * @param nome Inserire il nome come una stringa - Es. Francesco
     * @param peso Inserire il peso come un float - Es. 72.450
     * @param dataDiNascita Inserire la data di nascita come una stringa - Es. 27/02/2002
     *
     */
    public Persona2(Double altezza, String cognome,
                    String nome, Float peso,
                    String dataDiNascita) {
        this.altezza = altezza;
        this.cognome = cognome;
        this.nome = nome;
        this.peso = peso;
        this.dataDiNascita = dataDiNascita;
    }

    public void setDataDiNascita(@NotNull String dataDiNascita) {
        String annoDiNascitaString, meseDiNascitaString, giornoDiNascitaString;
        Integer annoDiNascita, meseDiNascita, giornoDiNascita;
        Boolean valida = Boolean.FALSE;

        giornoDiNascitaString = dataDiNascita.substring(0, 2);
        meseDiNascitaString = dataDiNascita.substring(3, 5);
        annoDiNascitaString = dataDiNascita.substring(6, 10);

        giornoDiNascita = Integer.parseInt(giornoDiNascitaString);
        meseDiNascita = Integer.parseInt(meseDiNascitaString);
        annoDiNascita = Integer.parseInt(annoDiNascitaString);

        if (annoDiNascita > 1000 && annoDiNascita < 2025) {
            switch (meseDiNascita) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (giornoDiNascita <=1){
                        valida = Boolean.TRUE;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (giornoDiNascita <=30){
                        valida = Boolean.TRUE;
                    }
                case 2:
                    if (giornoDiNascita <=28){
                        valida = Boolean.TRUE;
                    }
            }
        }
        if (valida) {
            this.dataDiNascita = dataDiNascita;
        }
    }

    /**
     * Metodo Info
     *
     * @return null
     *
     */
    public String info(){
        return "Cognome         :" + this.cognome       + "\n"
                + "Nome            :" + this.nome          + "\n"
                + "Altezza         :" + this.altezza       + "\n"
                + "Peso            :" + this.peso          + "\n"
                + "Data Di Nascita :" + this.dataDiNascita + "\n";
    }

    private void CalcoloEta(){
        String annoDiNascitaString, meseDiNascitaString, giornoDiNascitaString;
        Integer annoDiNascita, meseDiNascita, giornoDiNascita;
        Integer annoAttuale, meseAttuale, giornoAttuale;
        Integer eta;

        giornoDiNascitaString = this.dataDiNascita.substring(0, 2);
        meseDiNascitaString = this.dataDiNascita.substring(3, 5);
        annoDiNascitaString = this.dataDiNascita.substring(6, 10);

        giornoDiNascita = Integer.parseInt(giornoDiNascitaString);
        meseDiNascita = Integer.parseInt(meseDiNascitaString);
        annoDiNascita = Integer.parseInt(annoDiNascitaString);

        GregorianCalendar dataOdierna = new GregorianCalendar();

        annoAttuale = dataOdierna.get(Calendar.YEAR);
        meseAttuale = dataOdierna.get(Calendar.MONTH) + 1;
        giornoAttuale = dataOdierna.get(Calendar.DAY_OF_MONTH);



    }
}