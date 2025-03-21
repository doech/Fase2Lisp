import java.util.HashMap;
import java.util.List;

public class ExFunciones extends Expresion {
    private Funciones funcion;
    private List<Expresion> argumentos;
    private HashMap<String, Funciones> funciones;

    public ExFunciones(Funciones funcion, List<Expresion> argumentos, HashMap<String, Funciones> funciones) {
        this.funcion = funcion;
        this.argumentos = argumentos;
        this.funciones = funciones;
    }

    public static Funciones definirFuncion(String nombre, String parametros, String cuerpo) {
        return new Funciones(nombre, parametros.split("\\s+"), cuerpo);
    }

    @Override
    public String evaluar() {
        return "Error no se pueden ejecutar funcniones.";
    }
}
