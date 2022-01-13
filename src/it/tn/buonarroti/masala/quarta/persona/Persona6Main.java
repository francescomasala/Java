package it.tn.buonarroti.masala.quarta.persona;

public class Persona6Main {
	public static void main(String[] args) throws Exception {
		Persona6 p = new Persona6();

		try {
			p.setAltezza(170.0);
			p.setNome("Francesco");
			p.setCognome("Masala");
			p.setPeso(75.5f);
			p.setDataDiNascita("27/02/2002");
			p.setEmail("mail@francescomasala.me");
			p.setPassword("4InA-Buonarroti");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(p.info());
	}
}
