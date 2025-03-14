import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

/**
 * implementa hashmap para variables y stack para operaciones
 * tienen string como key y value para que lea cualquier tipo de dato
 */
public class InterpreteLisp {
    public HashMap<String, String> variables = new HashMap<String, String>();
    public Stack<String> pilaOperaciones = new Stack<String>();

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

    /**
     * cargar archivo txt?
     * lectura por linea
     * @param archivo
     */
    public void cargarArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                cargar(linea); 
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void cargar(String entrada) {
        entrada = entrada.trim();
        String[] tokens = entrada.split("\\s+"); // separa por espacios
        if (tokens.length == 0) {
            System.out.println("Entrada vacía");
        }

        String operador = tokens[0];
        switch (operador) {
            case "set":
            case "setq":
                if (tokens.length != 3) {
                    System.out.println("Error de sintaxis en set");
                } else {
                    definirVariable(tokens[1], tokens[2]);
                    System.out.println("Variable definida: " + tokens[1]);
                }
                break;
            case "'": //quote
                if (tokens.length != 2) {
                    System.out.println("Error de sintaxis en quote");
                } else {
                    System.out.println("Resultado quote: " + tokens[1]);
                }
                break;
            case "defun":
                if (tokens.length < 4) {
                    System.out.println("Error de sintaxis en defun");
                } else {
                    String nombre = tokens[1];
                    String[] parametros = new String[tokens.length - 3];
                    for (int i = 0; i < parametros.length; i++) {
                        parametros[i] = tokens[i + 2];
                    }
                    String valor = tokens[tokens.length - 1];
                    System.out.println("Función definida: " + nombre);
                }
                break;
            case "cond":
                if (tokens.length < 3) {
                    System.out.println("Error de sintaxis en cond");
                } else {
                    Expresion condicional = new ExCond(entrada);
                    System.out.println("Resultado:" + condicional.evaluar());
                }
                break;
            case "atom":
            case "list":
            case "equal":
            case "<":
            case ">":
                if (tokens.length < 2) {
                    System.out.println("Error de sintaxis en " + operador);
                } else {
                    Expresion predicado = new ExPredicado(entrada);
                    System.out.println("Resultado: " + predicado.evaluar());
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (tokens.length != 3) {
                    System.out.println("Error de sintaxis en " + operador);
                } else {
                    Expresion operacion = new ExOperacion(entrada);
                    System.out.println("Resultado: " + operacion.evaluar());
                }
                break;
            default:
                System.out.println("Operador no reconocido: " + operador);
                break;
        }
    }

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {
        InterpreteLisp interprete = new InterpreteLisp();
        interprete.cargarArchivo("prueba.txt"); 
    }
}
