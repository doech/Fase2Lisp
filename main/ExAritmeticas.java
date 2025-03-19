public class ExAritmeticas extends Expresion {
    private Expresion operandoIz;
    private Expresion operandoDe;
    private String operadorAritmetico;

    public ExAritmeticas(Expresion operandoIz, Expresion operandoDe, String operadorAritmetico) {
        this.operandoIz = operandoIz;
        this.operandoDe = operandoDe;
        this.operadorAritmetico = operadorAritmetico;
    }

    @Override
    public String evaluar() {
        int izq = Integer.parseInt(operandoIz.evaluar());
        int der = Integer.parseInt(operandoDe.evaluar());

        switch (operadorAritmetico) {
            case "/":
                if (der == 0) {
                    return "Error: División por cero";
                }
                return String.valueOf(izq / der);
            case "+":
                return String.valueOf(izq + der);
            case "-":
                return String.valueOf(izq - der);
            case "*":
                return String.valueOf(izq * der);
            default:
                return "Error: Operador no válido";
        }
    }

    @Override
    public boolean verificar() {
        return operandoIz != null && operandoDe != null;
    }
}

