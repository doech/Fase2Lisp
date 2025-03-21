import java.util.HashMap;
import java.util.List;

/**
 * Clase que representa la evaluación de una función en el sistema de expresiones.
 */
public class ExFunciones extends Expresion {
    private Funciones funcion;
    private List<Expresion> argumentos;
    private HashMap<String, Funciones> funciones;

    /**
     * Constructor para inicializar una expresión de función.
     * 
     * @param funcion; La función que se ejecutará.
     * @param argumentos Lista de expresiones que representan los argumentos de la función.
     * @param funciones; Mapa de funciones definidas en el entorno.
     */
    public ExFunciones(Funciones funcion, List<Expresion> argumentos, HashMap<String, Funciones> funciones) {
        this.funcion = funcion;
        this.argumentos = argumentos;
        this.funciones = funciones;
    }

        /**
     * Método estático para definir una nueva función.
     * 
     * @param nombre; Nombre de la función.
     * @param parametros Parámetros de la función como una cadena.
     * @param cuerpo; Cuerpo de la función.
     * @return Objeto de tipo Funciones con la definición de la función.
     */
    public static Funciones definirFuncion(String nombre, String parametros, String cuerpo) {
        return new Funciones(nombre, parametros.split("\\s+"), cuerpo);
    }

    /**
     * Evalúa la ejecución de una función.
     * 
     * @return Mensaje de error indicando que las funciones no pueden ejecutarse.
     */
    @Override
    public String evaluar() {
        return "Error no se pueden ejecutar funcniones.";
    }
}
