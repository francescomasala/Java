package it.tn.buonarroti.masala.quarta.caesarCypher;

import lombok.Getter;

public class CaesarCypher {
    @Getter
    private final Character[] alphabet_ita;
    @Getter
    private Integer key = 0;

    public CaesarCypher(Integer key) {
        this.alphabet_ita = alphabet_ita;
        this.key = key;
    }
}
