package src.br.mackenzie.fci.progsis.code.core;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class AssentoExecutiva extends Assento {
    private static double adicionalLuxo = 100.0;

    public AssentoExecutiva(int numero) throws AssertionError {
        super("Executiva", numero);
    }

    @Override
    public double calcularPreco() {
        return precoBase + adicionalLuxo + ((1/numero) * 10);
    }
}
