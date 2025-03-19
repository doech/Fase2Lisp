import java.util.HashMap;

public class ExAritmeticas extends Expresion {
    private String operandoIz;
    private String operandoDe;
    private String operadorAritmetico;
    private HashMap<String, String> entornoVariables;

    public ExAritmeticas(String operadorAritmetico, String operandoIz, String operandoDe, HashMap<String, String> entornoVariables) {
        if (operandoIz == null && operandoDe == null) {
           System.out.println("los operandos no pueden estar vacíos");
        }
        this.operadorAritmetico = operadorAritmetico;
        this.operandoIz = operandoIz;
        this.operandoDe = operandoDe;
        this.entornoVariables = entornoVariables;
    }

    @Override
    public String evaluar() {
    if (!verificar()) {
        return "Error: Operación aritmética inválida";
    }

    String valorIzq;
    String valorDer;

    if (entornoVariables.containsKey(operandoIz)) {
        valorIzq = entornoVariables.get(operandoIz);
    } else {
        valorIzq = operandoIz;
    }

    if (entornoVariables.containsKey(operandoDe)) {
        valorDer = entornoVariables.get(operandoDe);
    } else {
        valorDer = operandoDe;
    }

    double izq = Double.parseDouble(valorIzq);
    double der = Double.parseDouble(valorDer);
    double resultado = 0;

    if (operadorAritmetico.equals("+")) {
        resultado = izq + der;
    } else if (operadorAritmetico.equals("-")) {
        resultado = izq - der;
    } else if (operadorAritmetico.equals("*")) {
        resultado = izq * der;
    } else if (operadorAritmetico.equals("/")) {
        if (der == 0) {
            return "Error: División por cero";
        }
        resultado = izq / der;
    } else {
        return "Error: Operador no válido";
    }

    return String.valueOf(resultado);
}


    @Override
    public boolean verificar() {
        String valorIzq;
        String valorDer;

        if (entornoVariables.containsKey(operandoIz)) {
            valorIzq = entornoVariables.get(operandoIz);
        } else {
            valorIzq = operandoIz;
        }

        if (entornoVariables.containsKey(operandoDe)) {
            valorDer = entornoVariables.get(operandoDe);
        } else {
            valorDer = operandoDe;
        }

        return esNumerico(valorIzq) && esNumerico(valorDer);
    }

    private boolean esNumerico(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    

}
