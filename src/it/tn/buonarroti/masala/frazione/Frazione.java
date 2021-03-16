package it.tn.buonarroti.masala.frazione;

public class Frazione {
    //Attributi
    private Integer numeratore;
    private Integer denominatore;

    //Costruttore
    public Frazione(Integer numeratore, Integer denominatore) {
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    //Metodi
    private Integer MCD(Integer a, Integer b) {

        Integer val1 = a;
        Integer val2 = b;

        while (val1 != val2) {
            if (val1 < val2) {
                val1 += a;
            } else {
                val2 += b;
            }
        }
        return val1;
    }

    @Override
    public String toString(){
        String s = "";
        s = numeratore.toString() + "/" + denominatore.toString();
        return s;
    }

    //da rivedere
    private void semplifica(){

        for (int i = 0; i < numeratore; i++){
            if(denominatore%i==0 && numeratore%i==0){
                numeratore = numeratore/i;
                denominatore = denominatore / i;
            }
        }

    }

    public Frazione Somma(Frazione frazione) {
        Integer mcd = MCD(frazione.denominatore, denominatore);
        Integer somma = ((mcd / denominatore) * numeratore) + (mcd / frazione.denominatore) * numeratore;

        Frazione returnFraz = new Frazione(somma, mcd);
        return returnFraz;
    }

    public Frazione Differenza(Frazione frazione) {

        Integer mcd = MCD(frazione.denominatore, denominatore);
        Integer differenza = Math.abs(((mcd / denominatore) * numeratore) - (mcd / frazione.denominatore) * numeratore);

        Frazione returnFraz = new Frazione(differenza, mcd);
        return returnFraz;
    }

    public Frazione Prodotto(Frazione frazione) {

        Integer num = numeratore * frazione.numeratore;
        Integer den = denominatore * frazione.denominatore;
        Frazione returnFraz = new Frazione(num, den);
        return returnFraz;
    }

    public Frazione Divisione(Frazione frazione) {

        Integer num = numeratore * frazione.denominatore;
        Integer den = denominatore * frazione.numeratore;
        Frazione returnFraz = new Frazione(num, den);
        return returnFraz;

    }

}
