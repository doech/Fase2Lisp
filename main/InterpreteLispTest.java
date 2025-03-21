import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterpreteLispTest {  
    private InterpreteLisp interprete;

    @BeforeEach
    void setUp() {
        interprete = new InterpreteLisp();
    }

    // Test de suma básica
    @Test
    void testSuma() {
        // Asegúrate de que la cadena sea evaluada correctamente
        assertEquals("5", interprete.evaluar("(+ 2 3)"), "La suma no es correcta");
    }

    // Test de multiplicación básica
    @Test
    void testMultiplicacion() {
        assertEquals("6", interprete.evaluar("(* 2 3)"), "La multiplicación no es correcta");
    }

    // Test de división
    @Test
    void testDivision() {
        assertEquals("2", interprete.evaluar("(/ 6 3)"), "La división no es correcta");
    }

    // Test de expresión compuesta
    @Test
    void testExpresionCompuesta() {
        assertEquals("14", interprete.evaluar("(+ (* 2 3) 8)"), "La evaluación de la expresión compuesta falló");
    }

    // Test para manejar división por cero
    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            interprete.evaluar("(/ 4 0)");
        });
        assertEquals("División por cero", exception.getMessage(), "No se detectó correctamente la división por cero");
    }
}
