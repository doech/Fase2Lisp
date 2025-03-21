import java.util.HashMap;

public class ExAritmeticas extends Expresion {
    private String operandoIz;
    private String operandoDe;
    private String operadorAritmetico;
    private HashMap<String, String> entornoVariables;

    public ExAritmeticas(String operadorAritmetico, String operandoIz, String operandoDe, HashMap<String, String> entornoVariables) {
        this.operadorAritmetico = operadorAritmetico;
        this.operandoIz = operandoIz;
        this.operandoDe = operandoDe;
        this.entornoVariables = entornoVariables;
    }

    @Override
    public String evaluar() {
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

    @Override
    public boolean verificar() {
        return operandoIz != null && operandoDe != null;
    }
}
