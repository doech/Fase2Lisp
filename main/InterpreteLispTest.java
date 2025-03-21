import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterpreteLispTest {

    @Test
    public void testDefinirYObtenerVariable() {
        InterpreteLisp interprete = new InterpreteLisp();
        interprete.definirVariable("saludo", "hola");

        String valor = interprete.obtenerVariable("saludo");
        assertEquals("hola", valor, "Debería devolver 'hola' al obtener la variable saludo.");
    }

    @Test
    public void testVariableNoDefinida() {
        InterpreteLisp interprete = new InterpreteLisp();

        String valor = interprete.obtenerVariable("nada");
        assertEquals("Error: Variable no definida", valor);
    }
}
