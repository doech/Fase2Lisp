
public class Funciones {

    private String nombreFuncion;   
    private String[] parametros;    
    private String cuerpo;          

    public Funciones(String nombreFuncion, String[] parametros, String cuerpo) {
        this.nombreFuncion = nombreFuncion;
        this.parametros = parametros;
        this.cuerpo = cuerpo;
    }

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public String[] getParametros() {
        return parametros;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String invocar(String[] args, CargadorArchivo cargador) {
        return "Error no se puede ejectuar funciones";
    }
}

