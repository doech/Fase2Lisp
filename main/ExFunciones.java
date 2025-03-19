import java.util.HashMap;
import java.util.List;

public class ExFunciones extends Expresion {
    private String nombreFuncion;
    private List<String> parametros;
    private List<Expresion> cuerpo;
    private HashMap<String, String> contexto;
    private InterpreteLisp interprete;

    public ExFunciones(String nombreFuncion, List<String> parametros, List<Expresion> cuerpo, InterpreteLisp interprete) {
        this.nombreFuncion = nombreFuncion;
        this.parametros = parametros;
        this.cuerpo = cuerpo;
        this.interprete = interprete;
        this.contexto = new HashMap<>();
    }

    public String invocar(List<String> valores) {
        if (valores.size() != parametros.size()) {
            return "Error: número incorrecto de argumentos.";
        }
        for (int i = 0; i < parametros.size(); i++) {
            contexto.put(parametros.get(i), valores.get(i));
        }
        String resultado = "";
        for (Expresion expresion : cuerpo) {
            resultado = expresion.evaluar();
        }
        return resultado;
    }
}