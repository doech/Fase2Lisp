import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CargadorArchivo {
    private HashMap<String, String> entornoVariables = new HashMap<>(); //creación de hashmap para almacenar variables locales
    private HashMap<String, Funciones> funciones = new HashMap<>(); //creación de hashmap para almacenar funciones definidas

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
            case "defun":
                if (tokens.length < 4) {
                    System.out.println("Error de sintaxis en defun");
                    return;
                }
                String nombreFuncion = tokens[1];
                List<String> parametros = new ArrayList<>();
                int i = 2;
                while (i < tokens.length - 1) {
                    parametros.add(tokens[i]);
                    i++;
                }
                String cuerpo = tokens[i];
                funciones.put(nombreFuncion, new Funciones(nombreFuncion, parametros.toArray(new String[0]), cuerpo));
                System.out.println("Función " + nombreFuncion + " definida correctamente");
                break;
            
            case "+": 
            case "-": 
            case "*": 
            case "/":
                if (tokens.length != 3) {
                    System.out.println("Error: Operación aritmética inválida");
                    return;
                }

                String operandoIz = tokens[1];
                String operandoDer = tokens[2];

                Expresion aritmetica = new ExAritmeticas(operador, operandoIz, operandoDer, entornoVariables);

                if (aritmetica.verificar()) {
                    System.out.println("Resultado: " + aritmetica.evaluar());
                } else {
                    System.out.println("Error: Operación aritmética inválida");
                }
                break;
            
            default:
                System.out.println("Error: Operador no reconocido - " + operador);
                
                break;
            

        }
    }

}