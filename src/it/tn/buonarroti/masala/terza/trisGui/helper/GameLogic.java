package it.tn.buonarroti.masala.terza.trisGui.helper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

public class GameLogic {
	public static final Character[][] valoriTris = new Character[3][3];
	public static boolean turno;
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private static Character vincitore;
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private static int mossa = 0;
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private static String giocatoreUno;
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private static String giocatoreDue;

	public static void boardCheck() {
		if (GameLogic.getMossa() == 9) GameLogic.setVincitore('p');
		try {
			for (int i = 0; i < 3; i++) {
				// Tris verticale
				if (GameLogic.valoriTris[0][i].equals(GameLogic.valoriTris[1][i]) && GameLogic.valoriTris[1][i].equals(GameLogic.valoriTris[2][i])) {
					GameLogic.setVincitore(GameLogic.valoriTris[0][i]);
					// Tris orizzontale
				} else if (GameLogic.valoriTris[i][0].equals(GameLogic.valoriTris[i][1]) && GameLogic.valoriTris[i][1].equals(GameLogic.valoriTris[i][2])) {
					GameLogic.setVincitore(GameLogic.valoriTris[i][0]);
				}
			}
			// Tris diagonale
			if (GameLogic.valoriTris[1][1] != ' ')
				if (GameLogic.valoriTris[0][0].equals(GameLogic.valoriTris[1][1]) && GameLogic.valoriTris[1][1].equals(GameLogic.valoriTris[2][2])) {
					GameLogic.setVincitore(GameLogic.valoriTris[1][1]);
				} else if (GameLogic.valoriTris[0][2].equals(GameLogic.valoriTris[1][1]) && GameLogic.valoriTris[1][1].equals(GameLogic.valoriTris[2][0])) {
					GameLogic.setVincitore(GameLogic.valoriTris[1][1]);
				}
		} catch (NullPointerException NPE) {
			System.out.println();
		}

	}

	public static void comboCheck(JButton button) {
		if (!button.getText().equals("Cliccami!")) {
			GameLogic.valoriTris[0][0] =
					((button.getText().equals("X")) ? '1' : '2');
		}
	}
}
