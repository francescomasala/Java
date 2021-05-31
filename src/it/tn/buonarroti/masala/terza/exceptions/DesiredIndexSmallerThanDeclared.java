package it.tn.buonarroti.masala.terza.exceptions;

/**
 * @author Francesco Masala (francesco.masala@buonarroti.tn.it)
 */
public class DesiredIndexSmallerThanDeclared extends Exception {
    public DesiredIndexSmallerThanDeclared(String errorMessage) {
        super(errorMessage);
    }
}
