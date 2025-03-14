
import java.util.HashMap;
import java.util.Stack;

public class InterpreteLisp {
    public HashMap<String, String> variables = new HashMap<>();
    public Stack<String> pilaOperaciones = new Stack<>();
    public HashMap<String, ExFunciones> funciones = new HashMap<>(); // Almacena funciones

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
}