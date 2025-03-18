public class ExCondicion extends Expresion {
    private Expresion condicion;
    private Expresion siTrue;
    private Expresion siFalse;

    public ExCondicion(Expresion condicion, Expresion siTrue, Expresion siFalse) {
        this.condicion = condicion;
        this.siTrue = siTrue;
        this.siFalse = siFalse;
    }

    @Override
    public String evaluar() {
        return condicion.evaluar().equals("true") ? siTrue.evaluar() : siFalse.evaluar();
    }

    @Override
    public boolean verificar() {
        return condicion != null && siTrue != null && siFalse != null;
    }
}


