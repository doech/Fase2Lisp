import java.util.HashMap;
import java.util.Stack;

public class InterpreteLisp {
    public HashMap<String, String> variables = new HashMap<String, String>();
    public Stack<String> pilaOperaciones = new Stack<String>();

    public void definirVariable(String nombre, String valor) {
        variables.put(nombre, valor);
    }

    public String obtenerVariable(String nombre) {
        return variables.get(nombre);
    }

    public void pushOperacion (String valor) {
        pilaOperaciones.push(valor);
    }

    public String popOperacion() {
        return pilaOperaciones.pop();
    }

    /**public String evaluar (Expresion expr) {
    *    return expr.evaluar();
    *}
    *
    *public void cargar (String) para ver a que clase pertenece la expresion
    */

}
