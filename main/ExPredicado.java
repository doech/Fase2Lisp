import java.util.ArrayList;
import java.util.List;

public class ExPredicado extends Expresion {
    private String operador;
    private List<String> argumentos;

    public ExPredicado(String entrada) {
        this.argumentos = new ArrayList<>();
        String[] tokens = entrada.split("\\s+");
        this.operador = tokens[0];

        for (int i = 1; i < tokens.length; i++) {
            argumentos.add(tokens[i]); 
        }
    }

    @Override
    public String evaluar() {
        if (argumentos.size() != 2) {
            return "Error: El predicado necesita exactamente 2 argumentos";
        }
    
        String arg1 = argumentos.get(0);
        String arg2 = argumentos.get(1);
    
        // Intentamos obtener el valor de las variables si no son números directos
        arg1 = obtenerValorSiEsVariable(arg1);
        arg2 = obtenerValorSiEsVariable(arg2);
    
        if (esNumerico(arg1) && esNumerico(arg2)) {
            double num1 = Double.parseDouble(arg1);
            double num2 = Double.parseDouble(arg2);
    
            switch (operador) {
                case ">":
                    return num1 > num2 ? "Mayor" : "No mayor";
                case "<":
                    return num1 < num2 ? "Menor" : "No menor";
                case "equal":
                    return num1 == num2 ? "Iguales" : "Diferentes";
                default:
                    return "Error: Operador no reconocido " + operador;
            }
        } else {
            return "Error: Los argumentos deben ser numéricos";
        }
    }
    

    // Verifica si una cadena es numérica (permite números negativos y decimales)
    private boolean esNumerico(String str) {
        try {
            Double.parseDouble(str);  // Intentamos parsear el número a Double
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean verificar() {
        // Verificar que haya exactamente 2 argumentos y que ambos sean numéricos
        if (argumentos.size() != 2) {
            return false;
        }

        String arg1 = argumentos.get(0);
        String arg2 = argumentos.get(1);

        return esNumerico(arg1) && esNumerico(arg2);
    }
}
