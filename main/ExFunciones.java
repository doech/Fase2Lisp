
import java.util.ArrayList;
import java.util.List;

public class ExFunciones {
    private Funciones funcion;
    private List<Expresion> argumentos;

    public ExFunciones(Funciones funcion) {
        this.funcion = funcion;
        this.argumentos = new ArrayList<>();
    }

    public void agregarArgumento(Expresion expr) {
        argumentos.add(expr);
    }

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

    // Evalúa la función con los argumentos almacenados
    public double evaluar() {
        if (!verificar()) {
            throw new IllegalArgumentException("No se puede evaluar la función debido a argumentos inválidos.");
        }
        return funcion.invocar(argumentos);
    }
}
