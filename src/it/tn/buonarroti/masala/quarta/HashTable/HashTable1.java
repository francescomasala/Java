package it.tn.buonarroti.masala.quarta.HashTable;

import org.jetbrains.annotations.NotNull;

public class HashTable1 {
	private final Object[] ELEMENTS = new Object[11];

	public HashTable1() {

	}

	public Object[] getELEMENTS() {
		return ELEMENTS;
	}

	public void addElement(PersonaHT element) {
		this.ELEMENTS[findPosition(element)] = element.getNome() + " " + element.getDataDiNascita();
		System.out.println(ELEMENTS[findPosition(element)]);
	}

	public Integer findElement(PersonaHT element) {
		if (this.ELEMENTS[findPosition(element)] == null) {
			return -1;
		} else {
			return findPosition(element);
		}
	}

	private Integer findPosition(@NotNull PersonaHT element) {
		int sommaAscii = 0, moduloAscii;
		for (int i = 0; i != element.getNome().length(); i++) {
			char carattere = element.getNome().charAt(i);
			sommaAscii = sommaAscii + Character.hashCode(carattere);
		}
		moduloAscii = sommaAscii % 11;
		return moduloAscii;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i <= 10; i++) {
			String temp;
			if (this.ELEMENTS[i] == null) {
				temp = "null";
			} else {
				temp = this.ELEMENTS[i].toString();
			}
			output.append(temp).append(",");
		}
		return ("[" + output + "]");
	}
}
