package it.tn.buonarroti.masala.punto;

public class Punto {
    //Attributi
    private Double x;
    private Double y;

    //Costruttore
    public Punto(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    //Metodi getter e setter
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    //Metodi della classe
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void traslaX(Double x) {
        this.x += x;
    }

    public void traslaY(Double y) {
        this.y += y;
    }

    public Double distanzaDaOrigine() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Double distanzaDaPunto(Punto punto) {
        return Math.sqrt(Math.pow((this.x - punto.x), 2) + Math.pow((this.y - punto.y), 2));
    }
}
