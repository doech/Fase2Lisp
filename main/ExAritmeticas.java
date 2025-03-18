
public class ExAritmeticas extends Expresion {
    private Expresion operandoIz;
    private Expresion operandoDe;
    private String operador;

    public ExAritmeticas(Expresion operandoIz, Expresion operandoDe, String operador) {
        this.operandoIz = operandoIz;
        this.operandoDe = operandoDe;
        this.operador = operador;
    }

    @Override
    public String evaluar() {
        int izq = Integer.parseInt(operandoIz.evaluar());
        int der = Integer.parseInt(operandoDe.evaluar());
        switch (operador) {
            case "+": return String.valueOf(izq + der);
            case "-": return String.valueOf(izq - der);
            case "*": return String.valueOf(izq * der);
            case "/": return der != 0 ? String.valueOf(izq / der) : "Error";
            default: return "Error";
        }
    }

    @Override
    public boolean verificar() {
        return operandoIz != null && operandoDe != null;
    }
}

