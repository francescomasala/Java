package it.tn.buonarroti.masala.terza.classi;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Es01 {
    // Float var
    public Float a;
    public Float b;
    public Float c;

    // Private and Double var
    private Double d;
    private Double x1;
    private Double x2;

    // Bool var
    private boolean isPossible;

    public Es01(int i, int i1, int i2) {
    }

    public Es01(Float a, Float b, Float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Float getA() {
        return a;
    }

    public void setA(Float a) {
        this.a = a;
    }

    public Float getB() {
        return b;
    }

    public void setB(Float b) {
        this.b = b;
    }

    public Float getC() {
        return c;
    }

    public void setC(Float c) {
        this.c = c;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public void calcola() {
        d = (double) ((b * b) - (4 * a * c));

        if (d >= 0) {
            x1 = ((-1 * b) + (Math.sqrt(d))) / (2 * a);
            x2 = ((-1 * b) - (Math.sqrt(d))) / (2 * a);

            isPossible = true;
        } else {
            isPossible = false;
        }
    }

    public String stampa() {
        String risultato;

        risultato = "a:   " + a + "\n" +
                "b:   " + b + "\n" +
                "c:   " + c + "\n" +
                "d:   " + d + "\n" +
                "x1:  " + x1 + "\n" +
                "x2:  " + x2 + "\n" +
                "possibile?" + (isPossible ? " si" : " no");

        return risultato;
    }

    void ordina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

