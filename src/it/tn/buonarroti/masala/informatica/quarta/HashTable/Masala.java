package it.tn.buonarroti.masala.informatica.quarta.HashTable;

/**
 * @author 75VERIFICA05
 */
public class Masala {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception {
		PersonaHT personaHT = new PersonaHT("Francesco", "27/02/2002");
		PersonaHT personaHT1 = new PersonaHT("Francesco", "27/02/2003");
		HashTable2 ht1 = new HashTable2();

		ht1.addElement(personaHT);
		ht1.addElement(personaHT1);
		System.out.println(ht1.findElement(personaHT));
		System.out.println(ht1.findElement(personaHT1));
	}

}
