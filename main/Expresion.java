abstract class Expresion {
    public abstract String evaluar();
    public abstract boolean verificar();
}

class ExPredicado extends Expresion {
    private String operador;
    private List<Expresion> argumentos = new ArrayList<>();

    public ExPredicado(String operador) {
        this.operador = operador;
    }

    public void agregarArgumento(Expresion expr) {
        argumentos.add(expr);
    }

    @Override
    public String evaluar() {
        return "";
    }

    @Override
    public boolean verificar() {
        return !argumentos.isEmpty();
    }
}
