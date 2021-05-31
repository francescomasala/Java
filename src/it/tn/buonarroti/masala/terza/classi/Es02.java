package it.tn.buonarroti.masala.terza.classi;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class Es02 {
    // Private variables declaration
    private Integer a;
    private Integer b;
    private Integer c;

    // Constructs declaration
    public Es02() {
    }

    public Es02(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Get method - a
    public Integer getA() {
        return a;
    }

    // Set method - a
    public void setA(Integer a) {
        this.a = a;
    }

    // Get method - b
    public Integer getB() {
        return b;
    }

    // Set method - b
    public void setB(Integer b) {
        this.b = b;
    }

    // Get method - c
    public Integer getC() {
        return c;
    }

    // Set method - c
    public void setC(Integer c) {
        this.c = c;
    }

    public void ordina() {
        if (a > b)
            if (a > c)
                System.out.println(a);
            else
                System.out.println(c);
        else if (b > c)
            System.out.println(b);
        else
            System.out.println(c);
    }

    public void stampa() {
        System.out.println(a);
        System.out.println(b);

    }

}
