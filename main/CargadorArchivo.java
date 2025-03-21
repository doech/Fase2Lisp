import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CargadorArchivo {
    private HashMap<String, String> entornoVariables = new HashMap<>(); //creación de hashmap para almacenar variables locales
    private HashMap<String, Funciones> funciones = new HashMap<>(); //creación de hashmap para almacenar funciones definidas}
   
    public HashMap<String, Funciones> getFunciones() {
        return funciones;
    }

    public HashMap<String, String> getEntornoVariables() {
        return entornoVariables;
    }

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
        
        if (!entrada.startsWith("(")) {
            System.out.println("Error: Expression must start with '('");
            return;
        }
            StringBuilder expressionBuilder = new StringBuilder();
            for (int i = 1; i < entrada.length() - 1; i++) {
                expressionBuilder.append(entrada.charAt(i));
            }
            String expression = expressionBuilder.toString().trim();
            
            String[] tokens = expression.split("\\s+");
            if (tokens.length == 0) {
                System.out.println("Entrada vacía");
                return;
            }
            
            String operador = tokens[0];
            switch (operador) {
                case "setq":
                    if (tokens.length < 3) {
                        System.out.println("Error de sintaxis en setq");
                    } else {
                        String nombre = tokens[1];
                        String valor = tokens[2];
                        ExSet set = new ExSet(nombre, valor, entornoVariables);
                        String resultadoSetq = set.evaluar();
                        System.out.println("Variable definida: " + nombre + " = " + resultadoSetq);
                    }
                    break;
                case "cond":
                    ExCondicion condicion = new ExCondicion(expression, entornoVariables);
                    String resultadoCondicion = condicion.evaluar();
                    System.out.println("Resultado: " + resultadoCondicion);
                    break;

                case "<":
                case ">":
                case "equal":
                    if (tokens.length < 3) {
                        System.out.println("Error de sintaxis en " + operador);
                    } else {
                        String valorIzq;
                        if (entornoVariables.containsKey(tokens[1])) {
                            valorIzq = entornoVariables.get(tokens[1]);
                        } else {
                            valorIzq = tokens[1];
                        }

                        String valorDer;
                        if (entornoVariables.containsKey(tokens[2])) {
                            valorDer = entornoVariables.get(tokens[2]);
                        } else {
                            valorDer = tokens[2];
                        }

                        ExPredicado predicado = new ExPredicado(operador, valorIzq, valorDer, entornoVariables);
                        String resultadoPredicado = predicado.evaluar();
                        System.out.println("Resultado: " + resultadoPredicado);
                    }
                    break;

                case "quote":
                    if (tokens.length < 2) {
                        System.out.println("Error: Sintaxis incorrecta en quote.");
                        return;
                    }
                    String resultadoQuote = expression.substring(6).trim();
                    System.out.println("Resultado: " + resultadoQuote);
                    break;

                case "+": 
                case "-": 
                case "*": 
                case "/":
                    if (tokens.length != 3) {
                        System.out.println("Error: Operación aritmética inválida");
                        return;
                    }

                    String operandoIz;
                    if (entornoVariables.containsKey(tokens[1])) {
                        operandoIz = entornoVariables.get(tokens[1]);
                    } else {
                        operandoIz = tokens[1];
                    }

                    String operandoDer;
                    if (entornoVariables.containsKey(tokens[2])) {
                        operandoDer = entornoVariables.get(tokens[2]);
                    } else {
                        operandoDer = tokens[2];
                    }

                    ExAritmeticas aritmetica = new ExAritmeticas(operador, operandoIz, operandoDer, entornoVariables);
                    String resultadoAritmetica = aritmetica.evaluar();
                    System.out.println("Resultado: " + resultadoAritmetica);
                    break;

                case "defun":
                    if (tokens.length < 4) {
                        System.out.println("Error de sintaxis en defun");
                    } else {
                        String nombreFuncion = tokens[1];
                        String parametros = tokens[2]; 
                        String cuerpo = tokens[3];     

                        Funciones nuevaFuncion = ExFunciones.definirFuncion(nombreFuncion, parametros, cuerpo);
                        funciones.put(nombreFuncion, nuevaFuncion);

                        System.out.println("Función " + nombreFuncion + " definida correctamente");
                    }
                    break;

                default:
                 System.out.println("Error: Operador no reconocido - " + operador);
            }
    }
}