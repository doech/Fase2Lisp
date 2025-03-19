import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExPredicado extends Expresion {
    private String operador;
    private List<String> argumentos;
    private Map<String, String> entornoVariables; //agregado para poder guardar valores de variables

    public ExPredicado(String entrada, Map<String, String> entornoVariables) {
        this.argumentos = new ArrayList<>();
        this.entornoVariables = entornoVariables; 
        entrada = entrada.replace("(", "").replace(")", "");
        String[] tokens = entrada.split("\\s+");
        this.operador = tokens[0];

        for (int i = 1; i < tokens.length; i++) {
            argumentos.add(tokens[i]);
        }
        System.out.println("Operador: " + operador);
        System.out.println("Argumentos: " + argumentos);
    }

    @Override
    public boolean verificar() {
        return true; 
    }

    @Override
    public String evaluar() {
    if (argumentos.size() < 2) {
        return "Error: No hay suficientes argumentos";
    }
    String arg1 = obtenerValorSiEsVariable(argumentos.get(0));
    String arg2 = obtenerValorSiEsVariable(argumentos.get(1));

    if (!esNumerico(arg1) || !esNumerico(arg2)) {
        return "Error: Los argumentos no son numéricos.";
    }

    double num1 = Double.parseDouble(arg1);
    double num2 = Double.parseDouble(arg2);

        switch (operador) {
        case "<":
            if (num1 < num2) {
                return "menor";
            }
            break;
        case ">":
            if (num1 > num2) {
                return "mayor";
            }
            break;
        case "equal":
            if (num1 == num2) {
                return "igual";
            }
            break;
        default:
            return "Error: Operador no reconocido.";
    }
    
    return "Error: Condición no válida.";
}
    //metodo agregado para ver si las variables existen en el hashmap o sea que estan definidas ya
    private String obtenerValorSiEsVariable(String argumento) {
        if (entornoVariables.containsKey(argumento)) {
            return entornoVariables.get(argumento);
        } else {
            return argumento;
        }
    }

    //como toma la cadena como un string para dividirlo en tokens, se verifica si es numerico
    private boolean esNumerico(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}