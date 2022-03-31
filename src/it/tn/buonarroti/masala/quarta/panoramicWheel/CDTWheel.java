package it.tn.buonarroti.masala.quarta.panoramicWheel;

public class CDTWheel<T> implements ADTWheel<T> {

	private final T[] wheel;
	private Integer bottom;

	public CDTWheel(int nCarrozze) {
		wheel = (T[]) new Object[nCarrozze];
		bottom = 0;
		for (int i = 0; i < nCarrozze; i++)
			wheel[i] = null;
	}

	@Override
	public void add(T obj) throws Exception {
		if (wheel[bottom].equals(null)) {
			if (!obj.equals(null)) {
				wheel[bottom] = obj;
			} else {
				throw new Exception("l'oggetto non può essere nullo!");
			}
		} else {
			throw new Exception("la cabina è già occupata!");
		}
	}

	@Override
	public T remove() throws Exception {
		T val;
		if (!wheel[bottom].equals(null)) {
			val = wheel[bottom];
			wheel[bottom] = null;
		} else {
			throw new Exception("la cabina è già vuota");
		}
		return val;
	}

	@Override
	public T peek() throws Exception {
		if (wheel[bottom].equals(null)) {
			throw new Exception("la cabina è vuota");
		}
		return wheel[bottom];
	}

	@Override
	public void next() {
		if (bottom < wheel.length - 1) {
			bottom++;
		} else {
			bottom = 0;
		}
	}

}
