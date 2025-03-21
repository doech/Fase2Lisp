import java.util.Map;

/**
 * Clase que representa la evaluación de una expresión condicional.
 * Permite analizar una estructura "cond" y determinar el resultado
 * de la primera condición verdadera.
 */
public class ExCondicion extends Expresion {
    private String entrada;
    private Map<String, String> entornoVariables;

    
    /**
     * Constructor de la clase ExCondicion.
     * 
     * @param entrada Expresión condicional en formato de texto.
     * @param entornoVariables Mapa de variables y sus valores actuales.
     */
    public ExCondicion(String entrada, Map<String, String> entornoVariables) {
        this.entrada = entrada.trim();
        this.entornoVariables = entornoVariables;
    }

    /**
     * Evalúa la condición y devuelve el resultado de la primera condición verdadera.
     * 
     * @return Resultado de la condición cumplida o un mensaje de error si ninguna se cumple.
     */
    @Override
    public String evaluar() {
        String[] tokens = entrada.split("\\)\\s*\\("); //Divide la expresion en multiple condiciones
        for (String token : tokens) {
            token = token.replace("(", "").replace(")", "").trim();
            String[] partes = token.split("\\s+", 2);

            if (partes.length < 2) {
                return "Error: Sintaxis incorrecta en cond.";
            }

            String condicion = partes[0];
            String resultado = partes[1];

            if (esTrue(condicion)) {
                return resultado.replace("\"", ""); 
            }
        }
        return "Error: Ninguna condición en cond se cumplió. Verifique las condiciones y las variables.";
    }

    /**
     * Verifica si la condición dada es verdadera.
     * 
     * @param condicion Condición a evaluar.
     * @return true si la condición es verdadera, false en caso contrario.
     */
    private boolean esTrue(String condicion) {
        if (entornoVariables.containsKey(condicion)) {
            String valor = entornoVariables.get(condicion);
            return valor != null && valor.equals("true");
        }
        return condicion.equals("true");
    }

    /**
     * Verifica si la expresión es válida.
     * 
     * @return true si la entrada no es nula ni vacía.
     */
    @Override
    public boolean verificar() {
        return entrada != null && !entrada.isEmpty();
    }
}


