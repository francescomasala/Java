package it.tn.buonarroti.masala.informatica.quarta.punto_sfera;

public class MainPunto3d {
	public static void main(String[] args) {
		punto3d p3d = new punto3d(3f, 3f, 3f);

		System.out.println("Punto3D: \n" + p3d);

		sfera3d s3d = new sfera3d(p3d, 5f);

		System.out.println("Sfera s: \n" + s3d);

		p3d.trasla(4f, -6f, 5f);
		System.out.println("Punto P: \n" + p3d);

		s3d.trasla(4f, -6f, 5f);
		System.out.println("Sfera s: \n" + s3d);
	}
}
