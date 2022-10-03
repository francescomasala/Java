package it.tn.buonarroti.masala.informatica.quarta.persona;

public class Persona6Main {
	public static void main(String[] args) throws Exception {
		Persona7 p = new Persona7();

		try {
			p.setAltezza(170.0);
			p.setNome("Francesco");
			p.setCognome("Masala");
			p.setPeso(75.5f);
			p.setDataDiNascita("27/02/2002");
			p.setEmail("mail@francescomasala.me");
			p.setPassword("ZjZ$Z$K@FE45NQ&YGD$EafwtTtm3S4MX");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(p.info());
	}
}
