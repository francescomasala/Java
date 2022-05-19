package it.tn.buonarroti.masala.quarta.ProvaArrayList;

import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		list.add(0, 52d);
		list.add(1, 69d);
		list.add(2, 32d);
		list.add(3, 87d);

		Double sum = 1d, div = 1d, sub = 1d, mul = 1d;

		for (Double listDouble : list) {
			sum = sum + listDouble;
		}

		for (Double listDouble : list) {
			div = div / listDouble;
		}

		for (Double listDouble : list) {
			sub = sub - listDouble;
		}

		for (Double listDouble : list) {
			mul = mul * listDouble;
		}

		System.out.println(sum);
	}
}
