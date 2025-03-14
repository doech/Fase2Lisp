import java.util.List;

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

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public void setParametros(String[] parametros) {
        this.parametros = parametros;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String invocar(List<Expresion> argumentos) {
        if (argumentos.size() != parametros.length) {
            return "Error: número incorrecto de argumentos.";
        }
    
        String resultado = "Invocando la función: " + nombreFuncion + "\n";
    
        for (int i = 0; i < parametros.length; i++) {
            resultado += parametros[i] + " = " + argumentos.get(i).evaluar() + "\n";
        }
    
        resultado += "Ejecutando el cuerpo de la función: " + cuerpo + "\n";
    
        return resultado;
    }
    
}

