package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.Es3;

import java.util.ArrayList;

public class ListaProdotti {

    private final ArrayList<Prodotto> listaProdotti;

    public ListaProdotti(boolean isListaPredefinita) {
        this.listaProdotti = new ArrayList<>();

        if (isListaPredefinita) {
            creaListaPredefinita();
        }
    }

    private void creaListaPredefinita() {
        aggiungiProdotto("Mela", 0.8f);
        aggiungiProdotto("Melograno", 1.5f);
        aggiungiProdotto("Manzo", 10f);
        aggiungiProdotto("Pesce", 8f);
        aggiungiProdotto("Mandarino", 1f);
        aggiungiProdotto("Pasta", 1.75f);
        aggiungiProdotto("Pane", 0.9f);
        aggiungiProdotto("Pipas", 50f);
    }

    public void aggiungiProdotto(String nome, Float prezzo) {
        Prodotto prod = new Prodotto(nome, prezzo);

        listaProdotti.add(prod);
    }

    public boolean rimuoviProdotto(String nome) {
        boolean isProdottoRimosso = false;
        int cont = grandezzaLista() - 1;

        while (!isProdottoRimosso && cont >= 0) {
            if (getNomeProdotto(cont).equals(nome)) {
                listaProdotti.remove(cont);
                isProdottoRimosso = true;
            }

            cont--;
        }

        return isProdottoRimosso;
    }

    public String getNomeProdotto(int nProd) {
        return listaProdotti.get(nProd).getNomeProdotto();
    }

    public float getPrezzoProdotto(int nProd) {
        return listaProdotti.get(nProd).getPrezzoProdotto();
    }

    public float getPrezzoProdottoScontato(int nProd) {
        return listaProdotti.get(nProd).getPrezzoProdottoScontato();
    }

    public void setScontoSuProdotto(int nProd) {
        // Recupero il prodotto originale
        Prodotto prodOriginale = listaProdotti.get(nProd);

        // Creo un nuovo prodotto con lo stesso nome + " scontato" e con un prezzo scontato
        Prodotto prodScontato = new Prodotto(prodOriginale.getNomeProdotto() + " in sconto", prodOriginale.getPrezzoProdottoScontato());

        // "Sovrascrivo" il prodotto originale con quello scontato
        listaProdotti.set(nProd, prodScontato);
    }

    public void eliminaLista() {
        listaProdotti.clear();
    }

    public int grandezzaLista() {
        return listaProdotti.size();
    }

    public float getTotaleLista() {
        float totaleLista = 0;

        for (int i = 0; i < grandezzaLista(); i++) {
            totaleLista += getPrezzoProdotto(i);
        }

        return totaleLista;
    }

    public String stampaLista() {
        String infoLista = "";

        for (int i = 0; i < listaProdotti.size(); i++) {
            infoLista += "\n" + (i + 1) + ": " + stampaProdotto(i);
        }

        return infoLista;
    }

    public String stampaProdotto(int nProd) {
        String infoProdotto = listaProdotti.get(nProd).stampaProdotto();

        return infoProdotto;
    }

}

class Prodotto {

    private final String nomeProdotto;
    private final float prezzoProdotto;
    private final int percentualeSconto;

    public Prodotto(String nomeProdotto, float costoProdotto) {
        this.nomeProdotto = nomeProdotto;
        this.prezzoProdotto = costoProdotto;

        this.percentualeSconto = 20;
    }

    protected String getNomeProdotto() {
        return nomeProdotto;
    }

    protected float getPrezzoProdotto() {
        return prezzoProdotto;
    }

    protected float getPrezzoProdottoScontato() {
        float prezzoScontato = (prezzoProdotto / 100) * percentualeSconto;

        return prezzoProdotto - prezzoScontato;
    }

    protected String stampaProdotto() {
        String stringProd = nomeProdotto + " con costo di " + prezzoProdotto + " euro";

        return stringProd;
    }

}
