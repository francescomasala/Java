package it.tn.buonarroti.masala.quarta.punto_sfera;

import lombok.Getter;
import lombok.Setter;

public class punto {
    @Getter
    @Setter
    protected Float X;
    @Getter
    @Setter
    protected Float Y;

    public punto(Float X, Float Y) {
        this.X = X;
        this.Y = Y;
    }

    public void trasla(Float dx, Float dy) {
        this.X += dx;
        this.Y += dy;
    }

    public void sposta(Float x, Float y) {
        this.X = x;
        this.Y = y;
    }

    public void toOrigin() {
        this.sposta(0f, 0f);
    }

    @Override
    public String toString() {
        return "X: " + this.X + "\n" +
                "Y: " + this.Y;
    }
}
