package it.tn.buonarroti.masala.quarta.ProvaArrayList;

import java.util.ArrayList;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Demo");
		list.set(0, "Hola!");
		list.get(0);

		try {
			list.remove(10);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(list.contains("Hola!"));

		System.out.println(list.size());

		System.out.println(list.indexOf("Hola!"));

		for (int i = 0; i <= list.size(); i++) {
			try {
				System.out.println(list.get(i));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(list.isEmpty());

		/*
		if(list.remove("Hola!") == Boolean.FALSE){
			System.out.println("L'oggetto non è stato rimosso");
		} else {
			System.out.println("L'oggetto è stato rimosso");
		}
		 */

		list.set(0, "Hola!");

		System.out.println();

		list.clear();

		System.out.println(list.isEmpty());
	}
}
