package it.tn.buonarroti.masala.dado;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class DadoUno {
    private Integer nFacce;
    private String materiale;
    private String colore;
    private Float peso;
    private Double lato;
    private Integer risultato;

    public DadoUno() {

    }

    public DadoUno(Integer nFacce, String materiale, String colore, Float peso, Double lato) {
        this.nFacce = nFacce;
        this.materiale = materiale;
        this.colore = colore;
        this.peso = peso;
        this.lato = lato;
    }

    public Double getLato() {
        return lato;
    }

    public void setLato(Double lato) {
        this.lato = lato;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public Integer getnFacce() {
        return nFacce;
    }

    public void setnFacce(Integer nFacce) {
        this.nFacce = nFacce;
    }

    public String lanciaDado(Integer nLanci) {
        // Dichiarazione array
        int[] ctr = new int[nFacce];       // Array contatore

        // Dichiarazione variabili
        int i;      // Variabile contatore
        int numbers;    // Numero in uscita dal dado
        int val = 1;
        int i_2 = 1;
        StringBuilder risposta;

        // Ciclo for per inizializzare l'array
        for (i = 0; i < nFacce; i++) {
            ctr[i] = 0;
        }

        // Inizializzazione della variabile per il ciclo while
        i = 0;

        // Assegno un valore compreso in nFacce per simulare l'estrazione del dado
        while (i < nLanci) {
            numbers = (int) (Math.random() * (nFacce) + 1);
            ctr[numbers - 1] = ctr[numbers - 1] + 1;
            i++;
        }

        // Assegno max al primo valore dell'array di controllo
        int max = ctr[0];

        // Trovo la moda riguardante l'estrazione delle facce
        for (i = 1; i < nFacce; i++) {
            if (max < ctr[i]) {
                max = ctr[i];
                val = i + 1;
            }
        }

        // Assegno una stringa contenente il valore piu' frequente e le sue uscite
        risposta = new StringBuilder(("Il valore più frequente " + val
                + " numero uscite " + max + "\n" + "\n"));

        // Concateno a ** risposta ** il numero di volte in cui una faccia del dado e' uscita
        while (i_2 <= nFacce) {
            String list = ("La faccia del dado: " + i_2 + " e' uscita : " + ctr[i_2 - 1] + " volte" + "\n");
            risposta.append(list);
            i_2++;
        }
        return risposta.toString();
    }

}
