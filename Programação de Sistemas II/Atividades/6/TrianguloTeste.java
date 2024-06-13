import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
class TrianguloTeste {
    @Test
    void testaTrianguloEquilateroValido() {
        int lado1 = 5;
        int lado2 = 5;
        int lado3 = 5;

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);

        assertTrue(triangulo.existe());
        assertTrue(triangulo.ehEquilatero());
        assertFalse(triangulo.ehIsosceles());
        assertFalse(triangulo.ehEscaleno());
    }

    @Test
    void testaTrianguloIsoscelesValido() {
        int lado1 = 5;
        int lado2 = 5;
        int lado3 = 4;

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);

        assertTrue(triangulo.existe());
        assertFalse(triangulo.ehEquilatero());
        assertTrue(triangulo.ehIsosceles());
        assertFalse(triangulo.ehEscaleno());
    }

    @Test
    void testaTrianguloEscalenoValido() {
        int lado1 = 5;
        int lado2 = 4;
        int lado3 = 3;

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);

        assertTrue(triangulo.existe());
        assertFalse(triangulo.ehEquilatero());
        assertFalse(triangulo.ehIsosceles());
        assertTrue(triangulo.ehEscaleno());
    }

    @Test
    void testaTrianguloInvalidoLadoNegativo() {
        int lado1 = -5;
        int lado2 = 5;
        int lado3 = 5;

        assertThrows(IllegalArgumentException.class, () -> new Triangulo(lado1, lado2, lado3));
    }

    @Test
    void testaTrianguloInvalidoSomaLadosMenoresQueTerceiro() {
        int lado1 = 1;
        int lado2 = 1;
        int lado3 = 5;

        assertThrows(IllegalArgumentException.class, () -> new Triangulo(lado1, lado2, lado3));
    }

    @Test
    void testaTrianguloInvalidoDiferencaLadosMaioresQueTerceiro() {
        int lado1 = 5;
        int lado2 = 1;
        int lado3 = 3;

        assertThrows(IllegalArgumentException.class, () -> new Triangulo(lado1, lado2, lado3));
    }
}
