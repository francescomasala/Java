package it.tn.buonarroti.masala.tipsit.semafori;

public class Cesto {
	Integer frutta_disponibile = 0;
	Integer state = 1; // 1 --> Oggetto libero; 0 --> Oggetto occupato

	// Blocca la risorsa
	public boolean p(){
		while (state.equals(0))
			this.state=1;
			return Boolean.TRUE;
	}

	// Libera la risorsa
	public boolean v() throws Exception{
		if(state.equals(0)){
			this.state=1;
			return Boolean.TRUE;
		}else{
			throw new Exception("Risorsa già occupata");
		}
	}

	public void aggiungiFrutta(){
		this.frutta_disponibile++;
	}

	public void togliFrutta(){
		this.frutta_disponibile--;
	}

	public int getFruttaCount() throws Exception {
		Integer ris;
		p();
		ris = frutta_disponibile;
		v();
		return ris;
	}
}
