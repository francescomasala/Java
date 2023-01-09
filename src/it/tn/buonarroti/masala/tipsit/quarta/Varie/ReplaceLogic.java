package it.tn.buonarroti.masala.tipsit.quarta.Varie;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReplaceLogic {
	@Getter
	final private ArrayList<String> GenericWordsArray = new ArrayList<String>();
	@Getter
	final private ArrayList<String> BadWordsArray = new ArrayList<String>();

	private ArrayList<String> FinalWordsArray = new ArrayList<String>();

	public ReplaceLogic(String GenericWords, String BadWords) {
		this.setWords(GenericWords, this.GenericWordsArray);
		this.setWords(BadWords, this.BadWordsArray);
	}

	/*
	 * @Author Francesco Masala
	 * @Param String PathName - Pathname of the file to read
	 * @Param String[] GenericWordsArray - Array of the words to replace
	 */
	private void setWords(String PathName, ArrayList<String> ActiveArray) {
		int i = 0;
		try {
			File file = new File(PathName);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.next();
				line = line.toLowerCase();
				ActiveArray.add(line);
				i++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("[!] File non trovato!");
		} catch (NoSuchElementException e) {
			System.err.println("[!] Fine del file!");
		} catch (Exception e) {
			System.err.println("[!] Altro errore che per pigrizia non lo integro");
		}
	}

	private @NotNull void replaceWords(ArrayList<String> GenericWordsArray, ArrayList<String> BadWordsArray) {
		for (int i = 0; i < GenericWordsArray.size(); i++) {
			for (int j = 0; j < BadWordsArray.size(); j++) {
				StringBuilder generic = new StringBuilder(GenericWordsArray.get(i));
				StringBuilder bad = new StringBuilder(BadWordsArray.get(j));
				if (generic.toString().contains(bad.toString())) {
					FinalWordsArray.add(replaceChars(GenericWordsArray.get(i).length()));
				} else {
					FinalWordsArray.add(GenericWordsArray.get(i));
				}
			}
		}
	}

	private @NotNull String replaceChars(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append("*");
		}
		return sb.toString();
	}

	public ArrayList<String> doStuff() {
		replaceWords(GenericWordsArray, BadWordsArray);
		return FinalWordsArray;
	}
}

