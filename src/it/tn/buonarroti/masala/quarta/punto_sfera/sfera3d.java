package it.tn.buonarroti.masala.quarta.punto_sfera;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class sfera3d extends sfera {
    @Getter
    @Setter
    private punto3d centro;
    @Getter
    @Setter
    private Float raggio;

    public sfera3d(@NotNull punto3d centro, Float raggio) {
        super(centro);
        this.raggio = raggio;
    }

    public void trasla(Float dx, Float dy, Float dz) {
        centro.trasla(dx, dy, dz);
    }

    public void sposta(Float x, Float y, Float z) {
        centro.sposta(x, y, z);
    }

    @Override
    public void toOrigin() {
        centro.sposta(0f, 0f, 0f);
    }

    public Float volume() {
        return (float) (4 * (Math.PI * Math.pow(this.getRaggio(), 3))/3);
    }

    public Float superficie() {
        return (float) (Math.PI * Math.pow(this.getRaggio(), 2) * 4);
    }

    @Override
    public String toString() {
        return this.centro.toString() + "\n" +
                "Raggio: " + this.raggio + "\n" +
                "Superficie: " + this.superficie() + "\n" +
                "Volume: " + this.volume() + "\n";
    }
}
