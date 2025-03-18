
import java.util.ArrayList;
import java.util.List;

public class ExFunciones extends Expresion {
    private Funciones funcion;
    private List<Expresion> argumentos;

    public ExFunciones(Funciones funcion) {
        this.funcion = funcion;
        this.argumentos = new ArrayList<>();
    }

    public void agregarArgumento(Expresion expr) {
        argumentos.add(expr);
    }

    @Override
    public boolean verificar() {
        if (funcion == null) {
            System.out.println("Error: La función no está definida.");
            return false;
        }
        for (Expresion arg : argumentos) {
            if (arg == null) {
                System.out.println("Error: Uno de los argumentos es nulo.");
                return false;
            }
        }
        return true;
    }

    @Override
    public String evaluar() {
        if (!verificar()) {
            return "Error: No se puede evaluar la función debido a argumentos inválidos.";
        }
        return String.valueOf(funcion.invocar(argumentos));
    }
}
