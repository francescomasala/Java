package it.tn.buonarroti.masala.quarta.panoramicWheel;

public class TestWheel {
	public static void main(String[] args) throws Exception {

		CDTWheel w = new CDTWheel(6);

		w.add(1);
		System.out.println(w.peek());
		w.next();
		w.add(2);
		System.out.println(w.peek());
		w.next();
		w.next();
		w.next();
		w.add(3);
		System.out.println(w.peek());
		w.next();
		w.next();
		System.out.println(w.remove());
		w.next();
		System.out.println(w.peek());
	}

}
