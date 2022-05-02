package it.tn.buonarroti.masala.tipsit.semafori;

public class Mensa implements Runnable {
	private Cesto cestino;

	public Mensa(Cesto cestino){
		this.cestino = cestino;
	}

	public void run(){
		try{
			run1();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void run1() throws Exception {
		boolean run = true;

		while(run){
			cestino.p();
			if(cestino.getFruttaCount() >0){
				cestino.togliFrutta();
			} else {
				run = false;
			}
			cestino.v();
		}
	}

	public void run2() throws Exception {
		while (cestino.getFruttaCount() > 0) {
			cestino.p();
			cestino.togliFrutta();;
			cestino.v();
		}
	}
}
