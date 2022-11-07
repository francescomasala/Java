package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.Secondo_Compito.Primo;

public class main {
	public static void main(String[] args) throws Exception {
		semaphore semaforo = new semaphore(1);

		FraThread t1 = new FraThread(semaforo);
		FraThread t2 = new FraThread(semaforo);

		t1.start();
		t2.start();

	}
}