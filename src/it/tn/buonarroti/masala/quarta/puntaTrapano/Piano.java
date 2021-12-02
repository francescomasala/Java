package it.tn.buonarroti.masala.quarta.puntaTrapano;

public class Piano {

    //Attributi
    private Float[][] piano;

    //Costruttore
    public Piano() {
        this.piano = new Float[30][30];
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                piano[i][j] = 0f;
            }
        }
    }

    //Metodi
    public void aggiungiDato(Integer x, Integer y, Float z){
        piano[x][y] = z;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                s+= "[" + piano[i][j] + "] ";
            }
            s+="\n";
        }

        return s;
    }


}