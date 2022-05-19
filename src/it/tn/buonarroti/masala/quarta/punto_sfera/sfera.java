package it.tn.buonarroti.masala.quarta.punto_sfera;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * La classe "Sfera" è collegata alla classe "Punto" attraverso un aggregazione
 *
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 * @version 2021.11.18
 */
public class sfera {
	@Getter
	@Setter
	private punto centro;
	@Getter
	@Setter
	private Float raggio;

	public sfera(@NotNull punto centro, Float raggio) {
		this.centro = new punto(centro.getX(), centro.getY());
		this.raggio = raggio;
	}

	public sfera(punto3d centro) {
		this.centro = new punto3d(centro.getX(), centro.getY(), centro.getZ());
	}

	public void trasla(Float dx, Float dy) {
		centro.trasla(dx, dy);
	}

	public void sposta(Float x, Float y) {
		centro.sposta(x, y);
	}

	public void toOrigin() {
		centro.sposta(0f, 0f);
	}

	public Float volume() {
		return (float) (4 * (Math.PI * Math.pow(this.raggio, 3)) / 3);
	}

	public Float superficie() {
		return (float) (Math.PI * Math.pow(this.getRaggio(), 2) * 4);
	}

	@Override
	public String toString() {
		return this.centro + "\n" +
				"Raggio: " + this.raggio + "\n" +
				"Superficie: " + this.superficie() + "\n" +
				"Volume: " + this.volume() + "\n";
	}
}
