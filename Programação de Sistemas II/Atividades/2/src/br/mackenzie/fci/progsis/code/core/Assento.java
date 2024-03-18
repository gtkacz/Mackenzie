package src.br.mackenzie.fci.progsis.code.core;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public abstract class Assento {
    protected String classe;
    protected double precoBase;
    protected int numero;

    public Assento(String classe, int numero) throws AssertionError {
        if (numero < 1) {
            throw new AssertionError("Número do assento tem que ser maior que 0.");
        }

        this.classe = classe;
        this.precoBase = 100.0;
        this.numero = numero;
    }

    public Assento(String classe, double precoBase, int numero) throws AssertionError {
        if (numero < 1) {
            throw new AssertionError("Número do assento tem que ser maior que 0.");
        }

        this.classe = classe;
        this.precoBase = precoBase;
        this.numero = numero;
    }

    public abstract double calcularPreco();

    public String getClasse() {
        return classe;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getNumero() {
        return numero;
    }

    public double getprecoBase() {
        return precoBase;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public void setNumero(int numero) throws AssertionError {
        if (numero < 1) {
            throw new AssertionError("Número do assento tem que ser maior que 0.");
        }
        this.numero = numero;
    }

    public void setprecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
