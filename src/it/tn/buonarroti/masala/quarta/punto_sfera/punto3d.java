package it.tn.buonarroti.masala.quarta.punto_sfera;

import lombok.Getter;
import lombok.Setter;

public class punto3d extends punto {
	@Getter
	@Setter
	private Float Z;

	public punto3d(Float X, Float Y, Float Z) {
		super(X, Y);
		this.Z = Z;
	}

	public void trasla(Float dX, Float dY, Float dZ) {
		this.setX(this.getX() + dX);
		this.setY(this.getY() + dY);
		this.Z = dZ;
	}

	public void sposta(Float X, Float Y, Float Z) {
		this.sposta(X, Y);
		this.Z = Z;
	}

	@Override
	public void toOrigin() {
		sposta(0f, 0f, 0f);
	}

	@Override
	public String toString() {
		return "X: " + this.getX() + "\n" +
				"Y: " + this.getY() + "\n" +
				"Z: " + this.Z + "\n";
	}
}
