package it.tn.buonarroti.masala.quarta.punto_sfera;

import lombok.Getter;
import lombok.Setter;

public class sfera {
    @Getter
    @Setter
    private punto centro;
    @Getter
    @Setter
    private Float raggio;

    public sfera(punto centro, Float raggio) {
        this.centro = new punto(centro.getX(), centro.getY());
        this.raggio = raggio;
    }

    public void trasla(Float dx, Float dy){
        centro.trasla(dx, dy);
    }

    public void sposta(Float x, Float y){
        centro.sposta(x, y);
    }

    public void toOrigin(){
        centro.sposta(0f,0f);
    }

    public Float volume(){
        return (float) ((4/3)*Math.PI*Math.pow(this.raggio,3));
    }

    public Float superficie(){
        return (float) (Math.PI*Math.pow(this.getRaggio(), 2)*4);
    }

    public String toString(){
        return  "X: " + this.centro.getX() + "\n" +
                "Y: " + this.centro.getY() + "\n" +
                "Volume: " + this.volume() + "\n";
    }
}
