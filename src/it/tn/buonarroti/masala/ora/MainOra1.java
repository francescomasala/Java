package it.tn.buonarroti.masala.ora;

/**
 * @author Francesco Masala
 */
public class MainOra1 {
    public static void main(String[] args) {
        Ora1 ora = new Ora1(10, 25, 00);

        // Esecuzione di tutti i metodi get*
        System.out.println("[~] Esecuzione di getOre: " +
                ora.getOre());
        System.out.println("[~] Esecuzione di getMinuti: " +
                ora.getMinuti());
        System.out.println("[~] Esecuzione di getSecondi: " +
                ora.getSecondi());

        // Immette una linea per differenziare i get* dalla differenzaIn*
        System.out.println();

        // Esecuzione di tutti i metodi differenzaIn*
        System.out.println("[~] Esecuzione di differenzaInOre: " +
                ora.differenzaInOre());
        System.out.println("[~] Esecuzione di differenzaInMinuti: " +
                ora.differenzaInMinuti());
        System.out.println("[~] Esecuzione di differenzaInSecondi: " +
                ora.differenzaInSecondi());

        // Immette una linea per differenziare i get* dalla differenzaIn*
        System.out.println();

            // Esecuzione di tutti i metodi Set*
        //System.out.println("[~] Esecuzione di setOre");
        //ora.setOre(23);
        //System.out.println("[~] Esecuzione di getMinuti");
        //ora.setMinuti(59);
        //System.out.println("[~] Esecuzione di getSecondi");
        //ora.setSecondi(59);

        //System.out.println();

            // Esecuzione di tutti i metodi get*
        //System.out.println("[~] Esecuzione di getOre: " +
        //        ora.getOre());
        //System.out.println("[~] Esecuzione di getMinuti: " +
        //        ora.getMinuti());
        //System.out.println("[~] Esecuzione di getSecondi: " +
        //        ora.getSecondi());

        System.out.println(ora.differenzaInOreMinutiSecondi());
    }
}