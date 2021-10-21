package it.tn.buonarroti.masala.quarta.classe;

import lombok.Getter;
import lombok.Setter;

public class Alunno {
    @Getter
    @Setter
    private String cognome;
    @Getter
    @Setter
    private String nome;
    @Getter
    private String dataNascita;

    public Alunno (String cognome, String nome, String dataNascita){
        this.cognome = cognome;
        this.nome = nome;
        this.dataNascita = dataNascita;
    }
}
