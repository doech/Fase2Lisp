import java.util.HashMap;

public class InterpreteLisp {
    private HashMap<String, String> variables = new HashMap<>();

    public void definirVariable(String nombre, String valor) {
        variables.put(nombre, valor);
    }

    public String obtenerVariable(String nombre) {
        return variables.getOrDefault(nombre, "Error: Variable no definida");
    }

    public static void main(String[] args) {
        CargadorArchivo cargador = new CargadorArchivo();
        cargador.cargarArchivo("C://Users/males/OneDrive/Escritorio/programas 2/Fase2Lisp/main/prueba.txt");
    }
}