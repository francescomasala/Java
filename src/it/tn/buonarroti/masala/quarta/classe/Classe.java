package it.tn.buonarroti.masala.quarta.classe;

public class Classe {
    private Integer grandMax;
    private Alunno[] studenti;
    private String sezioneClasse;
    private Integer grandAttuale;

    public Classe(String sezione, Integer grandMax){
        this.sezioneClasse = sezione;
        this.grandMax = grandMax;
        this.studenti = new Alunno[grandMax];
    }

    public String getInfoStud(String Info, Integer num){
        return null;
    }

    public void compattaLista(){

    }

    public void aggStud(){

    }

    public void rmStud(String nome){

    }
}
