package src.br.mackenzie.fci.progsis.code;

import src.br.mackenzie.fci.progsis.code.core.*;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class Main {
    public static void main(String[] args) {
        AssentoEconomica economica = new AssentoEconomica(1);
        AssentoExecutiva executiva = new AssentoExecutiva(2);
        AssentoPrimeiraClasse primeiraClasse = new AssentoPrimeiraClasse(3);

        System.out.println("Preço do assento econômico: $" + economica.calcularPreco());
        System.out.println("Preço do assento executivo: $" + executiva.calcularPreco());
        System.out.println("Preço do assento primeira classe: $" + primeiraClasse.calcularPreco());
    }
}
