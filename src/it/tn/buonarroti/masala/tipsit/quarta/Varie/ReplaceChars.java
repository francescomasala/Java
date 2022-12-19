package it.tn.buonarroti.masala.tipsit.quarta.Varie;

import java.util.ArrayList;

public class ReplaceChars {
	public static void main(String[] args) {
		ReplaceLogic rl = new ReplaceLogic("C:\\Users\\francesco.masala\\Desktop\\generic.txt",
				"C:\\Users\\francesco.masala\\Desktop\\bad.txt");
		ArrayList<String> Phrase = rl.doStuff();

		for (int i = 0; i < Phrase.size(); i++) {
			System.out.println(Phrase.get(i));
		}
	}
}
