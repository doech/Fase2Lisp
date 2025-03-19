import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
public class CargadorArchivo {
    /**
     * cargar archivo txt
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

    HashMap<String, Funciones> funciones = new HashMap<>();

    public void cargar(String entrada) {
        entrada = entrada.trim();
        
        if (entrada.isEmpty()) {
            return;
        }
        if (!entrada.startsWith("'") && !entrada.startsWith("quote")) {
            entrada = entrada.replace("(", "").replace(")", "");
        }

        String[] tokens = entrada.split("\\s+");
        if (tokens.length == 0) {
            System.out.println("Entrada vacía");
            return;
        }
        
    
        String operador = tokens[0]; // El primer token será el operador
         if (funciones.containsKey(operador)) {
        Funciones funcion = funciones.get(operador);
        String[] args = Arrays.copyOfRange(tokens, 1, tokens.length); // Obtener los argumentos
        ExFunciones exFuncion = new ExFunciones(funcion, args);
        if (exFuncion.verificar()) {
            System.out.println(exFuncion.evaluar());
        } else {
            System.out.println("Error: Llamada a función inválida.");
        }
        return; // Terminar aquí para no seguir al default
    }
        switch (operador) {
            
            case "defun":
                if (tokens.length < 4) { // Se requieren al menos 4 tokens: "defun", nombre, parámetros, cuerpo
                    System.out.println("Error de sintaxis en defun: Se requieren al menos 3 argumentos.");
                } else {
                    String nombre = tokens[1];
                    String[] parametros = new String[tokens.length - 3];
                    for (int i = 0; i < parametros.length; i++) {
                        parametros[i] = tokens[i + 2];
                    }
                    String cuerpoFuncion = tokens[tokens.length - 1];
            
                    // Validar que el nombre, parámetros y cuerpo no estén vacíos
                    if (nombre.isEmpty() || cuerpoFuncion.isEmpty() || parametros.length == 0) {
                        System.out.println("Error: El nombre, los parámetros o el cuerpo de la función no pueden estar vacíos.");
                    } else {
                        System.out.println("Sintaxis de defun válida: defun " + nombre + " " + String.join(" ", parametros) + " " + cuerpoFuncion);
                    }
                }
                break;
                
            case "setq":
                if (tokens.length != 3) {
                    System.out.println("Error de sintaxis en set");
                } else {
                    String nombre = tokens[1];
                    String valor = tokens[2];
            
                    if (nombre.isEmpty() || valor.isEmpty()) {
                        System.out.println("Error: El nombre de la variable o el valor no pueden estar vacíos.");
                    } else {
                        System.out.println("Sintaxis de setq válida: setq " + nombre + " " + valor);
                    }
                }
                break;
    
            case "'": // quote
            case "quote":
                if (tokens.length < 2) {
                    System.out.println("Error de sintaxis en quote");
                } else {
                    Expresion quote = new ExQuote(entrada);
                    if (quote.verificar()) {
                        System.out.println("Expresión quote válida.");
                    } else {
                        System.out.println("Error: Expresión quote inválida.");
                    }
                }
                break;
    
            case "cond":
                if (tokens.length < 4) { // Se requieren al menos 4 tokens: "cond", condición, siTrue, siFalse
                    System.out.println("Error de sintaxis en cond: Se requieren al menos 3 argumentos.");
                } else {
                    String condicion = tokens[1];
                    String siTrue = tokens[2];
                    String siFalse = tokens[3];
            
                    if (condicion.isEmpty() && siTrue.isEmpty() && siFalse.isEmpty()) {
                        System.out.println("Error: Los argumentos de cond no pueden estar vacíos.");
                    } else {
                        System.out.println("Sintaxis de cond válida: cond " + condicion + " " + siTrue + " " + siFalse);
                    }
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
                    if (predicado.verificar()) {
                        System.out.println("Predicado válido.");
                    } else {
                        System.out.println("Error: Predicado inválido.");
                    }
                }
                break;
    
            case "+":
            case "-":
            case "*":
            case "/":
                if (tokens.length != 3) {
                    System.out.println("Error de sintaxis en " + operador + ": Se requieren exactamente 2 operandos.");
                } else {
                    // Validar que la operación tenga la estructura correcta
                    String operandoIz = tokens[1];
                    String operandoDe = tokens[2];
            
                    if (operandoIz.isEmpty() && operandoDe.isEmpty()) {
                        System.out.println("Error: Los operandos no pueden estar vacíos.");
                    } else {
                        System.out.println("Operación aritmética válida: " + operador + " " + operandoIz + " " + operandoDe);
                    }
                }
                break;
    
            default:
                System.out.println("Operador no reconocido: " + operador);
                break;
        }
    } 
}
    