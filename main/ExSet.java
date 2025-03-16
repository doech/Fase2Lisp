class ExSet implements Expresion {
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

class ExFunciones implements Expresion {
    private Funciones funcion;
    private List<Expresion> argumentos = new ArrayList<>();

    public ExFunciones(Funciones funcion) {
        this.funcion = funcion;
    }

    public void agregarArgumento(Expresion expr) {
        argumentos.add(expr);
    }

    @Override
    public String evaluar() {
        String[] args = argumentos.stream().map(Expresion::evaluar).toArray(String[]::new);
        return funcion.invocar(args);
    }

    @Override
    public boolean verificar() {
        return !argumentos.isEmpty();
    }
}

