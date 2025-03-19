import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CargadorArchivo {
    private HashMap<String, String> entornoVariables = new HashMap<>(); //creación de hashmap para almacenar variables locales

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

        if (entrada.isEmpty()) {
            return;
        }
        if (entrada.contains("(") || entrada.contains(")")) {
            entrada = entrada.replace("(", "").replace(")", "");
        }

        String[] tokens = entrada.split("\\s+");
        if (tokens.length == 0) {
            System.out.println("Entrada vacía");
            return;
        }

        String operador = tokens[0]; 
        switch (operador) {
            case "setq":
                if (tokens.length != 3) {
                    System.out.println("Error de sintaxis en setq");
                } else {
                    String nombre = tokens[1];
                    String valor = tokens[2];

                    if (nombre.isEmpty() || valor.isEmpty()) {
                        System.out.println("Error: El nombre de la variable o el valor no pueden estar vacíos.");
                    } else {
                        entornoVariables.put(nombre, valor); 
                        System.out.println("Variable definida: " + nombre + " = " + valor);
                    }
                }
                break;

            case "<":
            case ">":
            case "equal":
                if (tokens.length < 3) {
                    System.out.println("Error de sintaxis en " + operador);
                } else {
                    Expresion predicado = new ExPredicado(entrada, entornoVariables); 
                    if (predicado.verificar()) {
                        System.out.println("Predicado válido: " + predicado.evaluar());
                    } else {
                        System.out.println("Error: Predicado inválido.");
                    }
                }
                break;

            default:
                System.out.println("Operador no reconocido: " + operador);
                break;
        }
    }
}