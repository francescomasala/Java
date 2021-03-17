package it.tn.buonarroti.masala.byte;

/**
 * @author francesco.masala
 */
public class MainByte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Byte b = new Byte();

        //System.out.println(b.getB());
        //System.out.println(b.outputString());

        // Creazione di un array da passare come parametro al metodo getB
        Boolean[] a = new Boolean[8];
        int i;
        for (i = 0; i < 8; i++) {
            a[i] = i % 2 == 0;
            System.out.print("[" + a[i] + "]");
        }
        System.out.println();

        b.setB(a);

        System.out.println(b.outputStringInt());

        a[0] = false;

        for (i = 0; i < 8; i++) {
            System.out.print("[" + a[i] + "]");
        }

        System.out.println();

        b.modArray(1, Boolean.FALSE);
        b.modArray(2, Boolean.FALSE);
        b.modArray(3, Boolean.TRUE);
        b.modArray(4, Boolean.FALSE);
        b.modArray(5, Boolean.FALSE);
        b.modArray(6, Boolean.TRUE);
        b.modArray(7, Boolean.FALSE);
        b.modArray(8, Boolean.TRUE);

        System.out.println(b.outputStringInt());

        System.out.println(b.toDecimal());


    }
}