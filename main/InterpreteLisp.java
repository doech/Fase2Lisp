import java.util.HashMap;
import java.util.Stack;

public class InterpreteLisp {
    public HashMap<String, String> variables = new HashMap<>();
    public Stack<String> pilaOperaciones = new Stack<>();
    public HashMap<String, ExFunciones> funciones = new HashMap<>();

    public void definirVariable(String nombre, String valor) {
        variables.put(nombre, valor);
    }

    public String obtenerVariable(String nombre) {
        return variables.get(nombre);
    }

    public void pushOperacion(String valor) {
        pilaOperaciones.push(valor);
    }

    public String popOperacion() {
        return pilaOperaciones.pop();
    }

    public static void main(String[] args) {
        CargadorArchivo cargador = new CargadorArchivo();
        cargador.cargarArchivo("C://Users/males/OneDrive/Escritorio/programas 2/Fase2Lisp/main/prueba.txt");
    }
}