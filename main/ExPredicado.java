import java.util.Map;

/**
 * Clase que representa una expresión de predicado en el lenguaje interpretado.
 * encargado de evaluar comparaciones entre dos operandos.
 */
public class ExPredicado extends Expresion {
    private String operador;
    private String operandoIz;
    private String operandoDe;
    private Map<String, String> entornoVariables;

    /**
     * Constructor de la clase ExPredicado.
     */
    public ExPredicado(String operador, String operandoIz, String operandoDe, Map<String, String> entornoVariables) {
        this.operador = operador;
        this.operandoIz = operandoIz;
        this.operandoDe = operandoDe;
        this.entornoVariables = entornoVariables;
    }

    /**
     * Verifica si los operandos no son nulos.
     */
    @Override
    public boolean verificar() {
        return operandoIz != null && operandoDe != null;
    }

    /**
     * Evalúa la expresión de predicado y devuelve el resultado.
     * @return "true" o "false" según la evaluación de la condición, o un mensaje de error si la condición no es válida.
     */
    @Override
    public String evaluar() {
        String valorIzq;
        if (entornoVariables.containsKey(operandoIz)) {
            valorIzq = entornoVariables.get(operandoIz);
        } else {
            valorIzq = operandoIz;
        }

        String valorDer;
        if (entornoVariables.containsKey(operandoDe)) {
            valorDer = entornoVariables.get(operandoDe);
        } else {
            valorDer = operandoDe;
        }

        double numIzq, numDer;
        try {
            numIzq = Double.parseDouble(valorIzq);
            numDer = Double.parseDouble(valorDer);
        } catch (NumberFormatException e) {
            return "Error: Condición no válida en " + operador;
        }

        // Evaluar la condición según el operador
        switch (operador) {
            case "<":
                return String.valueOf(numIzq < numDer);
            case ">":
                return String.valueOf(numIzq > numDer);
            case "equal":
                return String.valueOf(numIzq == numDer);
            default:
                return "Error: Operador no reconocido - " + operador;
        }
    }
}
