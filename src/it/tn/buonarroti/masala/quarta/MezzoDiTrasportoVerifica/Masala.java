/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tn.buonarroti.masala.quarta.MezzoDiTrasportoVerifica;

/**
 * @author Francesco Masala
 */
public class Masala {
	public static void main(String[] args) throws Exception {
		try {
			MezzoDiTrasporto5 mezzoDiTrasporto52 = new MezzoDiTrasporto5(55, 1000, "nero", "Fiat", "Uno");
			MezzoDiTrasporto5 mezzoDiTrasporto53 = new MezzoDiTrasporto5(69, 2000, "rosso", "Ford", "Fiesta");
			System.out.println(mezzoDiTrasporto52.info());
			System.out.println(mezzoDiTrasporto53.info());
			System.out.println(mezzoDiTrasporto53.confrontaCaratteristiche(mezzoDiTrasporto52));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		try {
			Thread.sleep(100);
			MezzoDiTrasporto5 mezzoDiTrasporto51 = new MezzoDiTrasporto5(null, null, "", "", "");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
