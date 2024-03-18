package src.br.mackenzie.fci.progsis.code.core;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class AssentoPrimeiraClasse extends Assento {
    private static double adicionalLuxo = 300.0;

    public AssentoPrimeiraClasse(int numero) throws AssertionError {
        super("Primeira Classe", numero);
    }

    @Override
    public double calcularPreco() {
        return precoBase + adicionalLuxo + ((1/numero) * 10);
    }
}
