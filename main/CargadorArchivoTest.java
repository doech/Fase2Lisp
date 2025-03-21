import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CargadorArchivoTest {
    private CargadorArchivo cargador;

    @BeforeEach
    void setUp() {
        cargador = new CargadorArchivo();
    }

    // Test para cargar un archivo existente
    @Test
    void testCargarArchivoExistente() throws IOException {
        // Crear archivo de prueba temporal
        Path tempFile = Files.createTempFile("testLisp", ".lisp");
        try {
            Files.write(tempFile, "(+ 2 3)".getBytes(), StandardOpenOption.WRITE);

            // Leer el archivo
            String contenido = cargador.cargarArchivo(tempFile.toString());

            // Verificar contenido
            assertEquals("(+ 2 3)", contenido.trim(), "El contenido del archivo no se cargó correctamente");
        } finally {
            // Eliminar archivo temporal
            Files.deleteIfExists(tempFile);
        }
    }

    // Test para manejar archivo inexistente
    @Test
    void testCargarArchivoInexistente() {
        Exception exception = assertThrows(IOException.class, () -> {
            cargador.cargarArchivo("archivo_que_no_existe.lisp");
        });

        // Verificar el mensaje de la excepción
        assertTrue(exception.getMessage().contains("No such file"), "No se manejó correctamente el archivo inexistente");
    }

    // Test para cargar archivo vacío
    @Test
    void testCargarArchivoVacio() throws IOException {
        Path tempFile = Files.createTempFile("emptyTest", ".lisp");
        try {
            // Leer el archivo vacío
            String contenido = cargador.cargarArchivo(tempFile.toString());

            // Verificar que el contenido esté vacío
            assertTrue(contenido.isEmpty(), "El archivo vacío debería devolver una cadena vacía");
        } finally {
            // Eliminar archivo temporal
            Files.deleteIfExists(tempFile);
        }
    }
}
