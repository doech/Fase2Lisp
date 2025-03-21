import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CargadorArchivoTest {

    @Test
    public void testSetqDefineVariable() {
        CargadorArchivo cargador = new CargadorArchivo();
        cargador.cargar("(setq x 10)");
        
        String valor = cargador.getEntornoVariables().get("x");
        assertEquals("10", valor, "La variable x debería contener el valor 10.");
    }
}
