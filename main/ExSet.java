import java.util.Map;

/**
 * Clase que representa la expresión 'set' en el lenguaje interpretado.
 * Permite asignar un nuevo valor a una variable en el entorno de ejecución.
 */
public class ExSet extends Expresion {
    private String nombreVariable;
    private String nuevoValor;
    private Map<String, String> entornoVariables;

    /**
     * Constructor que inicializa la asignación de una variable con su nuevo valor.
     */
    public ExSet(String nombreVariable, String nuevoValor, Map<String, String> entornoVariables) {
        this.nombreVariable = nombreVariable;
        this.nuevoValor = nuevoValor;
        this.entornoVariables = entornoVariables;
    }

    /**
     * Evalúa la expresión 'set', asignando el nuevo valor a la variable especificada.
     * @return El valor asignado si es válido, o un mensaje de error si no lo es.
     */
    @Override
    public String evaluar() {
        if (nuevoValor == null || nuevoValor.isEmpty()) {
            return "Error: Valor no válido";
        }
        entornoVariables.put(nombreVariable, nuevoValor);
        return nuevoValor;
    }

    /**
     * Verifica si la asignación de la variable es válida.
     * @return true si la variable y el valor son válidos, false en caso contrario.
     */
    @Override
    public boolean verificar() {
        return nombreVariable != null && !nombreVariable.isEmpty() && nuevoValor != null;
    }
}


