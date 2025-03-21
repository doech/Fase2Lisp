/**
 * Clase que se  encarga de representar una función dentro de un programa, con un nombre,
 * parámetros y un cuerpo. Permite obtener información sobre la función y simular su invocación.
 */
public class Funciones {

    private String nombreFuncion;   
    private String[] parametros;    
    private String cuerpo;   

    /**
     * Constructor de la clase 
    */
    public Funciones(String nombreFuncion, String[] parametros, String cuerpo) {
        this.nombreFuncion = nombreFuncion;
        this.parametros = parametros;
        this.cuerpo = cuerpo;
    }

    /**
     * Obtiene el nombre de la función.
     */
    public String getNombreFuncion() {
        return nombreFuncion;
    }

    /**
     * Obtiene los parámetros de la función.
     * @return Un arreglo  que contiene los parámetros de la función.
     */
    public String[] getParametros() {
        return parametros;
    }

    /**
     * Obtiene el cuerpo de la función.
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * Invoca la función con los argumentos proporcionados.
     *@return un mensaje de error
     */
    public String invocar(String[] args, CargadorArchivo cargador) {
        return "Error no se puede ejectuar funciones";
    }
}

