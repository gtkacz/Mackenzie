package src.br.mackenzie.fci.progsis.code.core;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class AssentoEconomica extends Assento {
    public AssentoEconomica(int numero) throws AssertionError {
        super("Econômica", numero);
    }

    @Override
    public double calcularPreco() {
        return precoBase + ((1/numero) * 10);
    }
}
