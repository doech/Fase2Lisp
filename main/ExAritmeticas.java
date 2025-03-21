import java.util.HashMap;

/**
 * Clase que representa una expresión aritmética.
 * Permite evaluar operaciones matemáticas entre dos operandos.
 */
public class ExAritmeticas extends Expresion {
    private String operandoIz;
    private String operandoDe;
    private String operadorAritmetico;
    private HashMap<String, String> entornoVariables;

        /**
     * Constructor de la clase ExAritmeticas.
     * 
     * @param operadorAritmetico Operador matemático (+, -, *, /)
     * @param operandoIz Operando Iz (variable o un número)
     * @param operandoDe Operando De (variable o un número)
     * @param entornoVariables Mapa con variables disponibles en el entorno
     */

    public ExAritmeticas(String operadorAritmetico, String operandoIz, String operandoDe, HashMap<String, String> entornoVariables) {
        this.operadorAritmetico = operadorAritmetico;
        this.operandoIz = operandoIz;
        this.operandoDe = operandoDe;
        this.entornoVariables = entornoVariables;
    }

       /**
     * Evalúa la expresión aritmética y retorna el resultado como una cadena.
     * 
     * @return Resultado de la operación o un mensaje de error en caso de fallo.
     */
    @Override
    public String evaluar() {
        // Obtiene el valor de los operandos desde el entorno de variables o los usa directamente
        String valorIzq = entornoVariables.get(operandoIz);
        if (valorIzq == null) {
            valorIzq = operandoIz;
        }

        String valorDer = entornoVariables.get(operandoDe);
        if (valorDer == null) {
            valorDer = operandoDe;
        }

        double izq, der;
        try {
            izq = Double.parseDouble(valorIzq);
            der = Double.parseDouble(valorDer);
        } catch (NumberFormatException e) {
            return "Error: Operandos no válidos";
        }

        switch (operadorAritmetico) {
            case "+":
                return izq + der + ""; 
            case "-":
                return izq - der + ""; 
            case "*":
                return izq * der + ""; 
            case "/":
                if (der == 0) {
                    return "Error: División por cero";
                }
                return izq / der + ""; 
            default:
                return "Error: Operador no válido";
        }
    }

        /**
     * Verifica si los operandos no son nulos antes de realizar la operación.
     * 
     * @return true si los operandos son válidos, false en caso contrario.
     */
    @Override
    public boolean verificar() {
        return operandoIz != null && operandoDe != null;
    }
}
