package it.tn.buonarroti.masala.quarta.ScontrinoFiscale2;

public class ScontrinoFiscale2 {
    private static final Integer DIM_MAX = 10;
    private String[] articoloNome;
    private Integer[] articoloNumero;
    private Double[] articoloCosto;
    private Integer ultimoArticolo;

    public ScontrinoFiscale2() {
        articoloNome = new String[DIM_MAX];
        articoloNumero = new Integer[DIM_MAX];
        articoloCosto = new Double[DIM_MAX];
    }
}
