public class ExSet extends Expresion {
    private String nombreVariable;
    private Expresion nuevoValor;
    private InterpreteLisp interprete;

    public ExSet(String nombreVariable, Expresion nuevoValor, InterpreteLisp interprete) {
        this.nombreVariable = nombreVariable;
        this.nuevoValor = nuevoValor;
        this.interprete = interprete;
    }

    @Override
    public String evaluar() {
        String valor = nuevoValor.evaluar();
        interprete.definirVariable(nombreVariable, valor);
        return valor;
    }

    @Override
    public boolean verificar() {
        return nombreVariable != null && nuevoValor != null;
    }
}


