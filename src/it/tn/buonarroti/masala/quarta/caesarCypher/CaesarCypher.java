package it.tn.buonarroti.masala.quarta.caesarCypher;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */

public class CaesarCypher {
    @Getter
    private final Character[] alphabet_ita = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'
            , 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    @Getter
    @Setter
    private Integer key;

    /**
     * Costrutture della classe
     *
     * @param key la chiave per il cifrario
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public CaesarCypher(Integer key) {
        this.key = key;
    }

    /**
     * Metodo per criptare un messaggio attraverso il cifrario di cesare
     *
     * @param messaggio Inserire il messaggio
     * @return Il messaggio cifrato utilizzando la chiave indicata nel costruttore
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public String crypt(String messaggio) {
        String mex = messaggio;

        for (int i = 0; i < 26; i++) {
            int key_2 = i + this.key;
            key_2 %= 26;
            mex = mex.replace(this.alphabet_ita[i],
                    Character.toUpperCase(this.alphabet_ita[key_2]));
        }

        return mex.toLowerCase(Locale.ROOT);
    }

    /**
     * Metodo per decriptare un messaggio criptato attraverso il cifrario di cesare
     *
     * @param messaggio Inserire il messaggio da decriptare
     * @return Il messaggio decifrato utilizzando la chiave indicata nel costruttore
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public String decrypt(String messaggio) {
        String mex = messaggio;

        for (int i = 0; i < 26; i++) {
            int key_2 = i + this.key;
            key_2 %= 26;
            mex = mex.replace(this.alphabet_ita[key_2],
                    Character.toUpperCase(this.alphabet_ita[i]));
        }
        return mex.toLowerCase(Locale.ROOT);
    }

    /**
     * Metodo per restitutire l'alfabero
     *
     * @return L'alfabeto utilizzato dal nostro cifrario
     * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
     */
    public Character[] stringAlfabeto() {

        return Arrays.copyOf(this.alphabet_ita, this.alphabet_ita.length);
    }
}
