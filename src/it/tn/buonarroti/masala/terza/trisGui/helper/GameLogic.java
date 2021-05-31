package it.tn.buonarroti.masala.terza.trisGui.helper;

import lombok.*;

public class GameLogic {
    public static Character[][] valoriTris = new Character[3][3];
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) private static Character vincitore;
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) private static int mossa = 0;
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) private static String giocatoreUno;
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) private static String giocatoreDue;
    public static boolean turno;
}
