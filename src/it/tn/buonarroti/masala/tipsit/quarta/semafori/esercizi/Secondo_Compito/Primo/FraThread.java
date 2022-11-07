package it.tn.buonarroti.masala.tipsit.quarta.semafori.esercizi.Secondo_Compito.Primo;

public class FraThread extends Thread {
	semaphore Semaforo;

	public FraThread(semaphore semaforo) {
		this.Semaforo = semaforo;
	}

	@Override
	public void run() {
		while (true) {
            try {
			Semaforo.p();
			System.out.println("Ho preso un posto nel semaforo!, ora aspetto, il mio ID è: " + Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println("Ho lasciato un posto nel semaforo!, ora aspetto, il mio ID è: " + Thread.currentThread().getId());
            Semaforo.v();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

}