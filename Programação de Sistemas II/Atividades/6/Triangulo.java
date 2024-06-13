/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class Triangulo {
    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo(int lado1, int lado2, int lado3) {
        if (lado1 < 0 || lado2 < 0 || lado3 < 0) {
            throw new IllegalArgumentException("Lado não pode ser negativo");
        }
        if (lado1 + lado2 < lado3 || lado1 + lado3 < lado2 || lado2 + lado3 < lado1) {
            throw new IllegalArgumentException("Soma de dois lados deve ser maior que o terceiro");
        }
        if (Math.abs(lado1 - lado2) > lado3 || Math.abs(lado1 - lado3) > lado2 || Math.abs(lado2 - lado3) > lado1) {
            throw new IllegalArgumentException("Diferença de dois lados deve ser menor que o terceiro");
        }
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public boolean existe() {
        return (lado1 < lado2 + lado3) && (lado2 < lado1 + lado3) && (lado3 < lado1 + lado2);
    }

    public boolean ehEquilatero() {
        return lado1 == lado2 && lado2 == lado3;
    }

    public boolean ehIsosceles() {
        return lado1 == lado2 || lado1 == lado3 || lado2 == lado3;
    }

    public boolean ehEscaleno() {
        return !ehEquilatero() && !ehIsosceles();
    }

    public int getLado1() {
        return lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }
}
