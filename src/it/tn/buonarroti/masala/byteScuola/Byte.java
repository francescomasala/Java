package it.tn.buonarroti.masala.byteScuola;

/**
 * @author francesco.masala
 */
public class Byte {
    private Boolean[] b = new Boolean[8];

    // Costruttore senza parametri
    // Inizializza con valore di default

    /**
     *
     */
    public Byte() {
        // this.b (Att) viene inizializzato a 0
        int i;
        for (i = 0; i < 8; i++) {
            b[i] = false;
        }
    }

    // Costruttore con parametri

    /**
     * @param b
     */
    public Byte(final Boolean[] b) {
        int i;
        for (i = 0; i < 8; i++) {
            this.b[i] = b[i];
        }
    }

    /**
     * @return
     */
    public Boolean[] getB() {
        return b;
    }

    /**
     * Causa condivisione di memoria tra parametro ed attributo\n DA EVITARE
     *
     * @param b
     */
    public void setB(final Boolean[] b) {
        this.b = b;
    }

    /**
     * @return
     */
    public String outputString() {
        int i;
        String s = "";
        for (i = 0; i < 8; i++) {
            s = s + "[" + this.b[i] + "]";
        }
        return s;
    }

    /**
     * @return
     */
    public String outputStringInt() {
        int i;
        String s = "";
        for (i = 0; i < 8; i++) {
            s = s + "[" + (this.b[i] ? "1" : "0") + "]";
        }
        return s;
    }

    /**
     * @param b
     */
    public void setArray(final Boolean[] b) {
        // this.b (Att) viene inizializzato a 0
        int i;
        for (i = 0; i < 8; i++) {
            this.b[i] = b[i];
        }
    }

    /**
     * Modify a determined value of the array "b"
     *
     * @param num   Position in the inxex of the array
     * @param value Value (in bool) of the segment of the array modArray("IndexPos",
     *              Boolean.VALUE);
     *              <p>
     *              First: [false][false][true][false][true][false][true][false]
     *              <p>
     *              After: [false][false][false][false][true][false][true][false]
     */
    public void modArray(final int num, final Boolean value) {
        this.b[num - 1] = value;
    }

    /**
     * @return
     */
    public int toDecimal() {
        int i;
        int output = 0;
        for (i = 0; i < 8; i++) {
            if (b[i] == true) {
                output += Math.pow(2, 7 - i);
            }
        }
        return output;
    }
}