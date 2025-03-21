import java.util.Map;

public class ExSet extends Expresion {
    private String nombreVariable;
    private String nuevoValor;
    private Map<String, String> entornoVariables;

    public ExSet(String nombreVariable, String nuevoValor, Map<String, String> entornoVariables) {
        this.nombreVariable = nombreVariable;
        this.nuevoValor = nuevoValor;
        this.entornoVariables = entornoVariables;
    }

    @Override
    public String evaluar() {
        if (nuevoValor == null || nuevoValor.isEmpty()) {
            return "Error: Valor no válido";
        }
        entornoVariables.put(nombreVariable, nuevoValor);
        return nuevoValor;
    }

    @Override
    public boolean verificar() {
        return nombreVariable != null && !nombreVariable.isEmpty() && nuevoValor != null;
    }
}


