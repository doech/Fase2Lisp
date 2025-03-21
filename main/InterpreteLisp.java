import java.util.HashMap;

/**
 * La clase encargado de simular un intérprete básico para manejar variables en un entorno estilo Lisp.
 * Permite definir y obtener el valor de variables almacenadas
 */
public class InterpreteLisp {
    
    private HashMap<String, String> variables = new HashMap<>();

    /**
     * Define una nueva variable o actualiza el valor de una variable existente.
     */
    public void definirVariable(String nombre, String valor) {
        variables.put(nombre, valor);
    }

    /**
     * Obtiene el valor de una variable previamente definida.
     * Si la variable no está definida, se devuelve un mensaje de error.
     */
    public String obtenerVariable(String nombre) {
        return variables.getOrDefault(nombre, "Error: Variable no definida");
    }

    /**
     * Método principal que se utiliza para cargar un archivo de entrada con el intérprete.
     */
    public static void main(String[] args) {
        CargadorArchivo cargador = new CargadorArchivo();
        cargador.cargarArchivo("C://Users/males/OneDrive/Escritorio/programas 2/Fase2Lisp/main/prueba.txt");
    }
}
