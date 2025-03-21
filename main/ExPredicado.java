import java.util.Map;

public class ExPredicado extends Expresion {
    private String operador;
    private String operandoIz;
    private String operandoDe;
    private Map<String, String> entornoVariables;

    public ExPredicado(String operador, String operandoIz, String operandoDe, Map<String, String> entornoVariables) {
        this.operador = operador;
        this.operandoIz = operandoIz;
        this.operandoDe = operandoDe;
        this.entornoVariables = entornoVariables;
    }

    @Override
    public boolean verificar() {
        return operandoIz != null && operandoDe != null;
    }

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