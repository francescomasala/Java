package it.tn.buonarroti.masala.informatica.quarta.caesarCypher;

public class CaesarCypherMain {
	public static void main(String[] args) {
		CaesarCypher cypher = new CaesarCypher(2);
		System.out.println("bacca");
		System.out.println(cypher.crypt("bacca"));
		System.out.println(cypher.decrypt("dceec"));
	}
}
