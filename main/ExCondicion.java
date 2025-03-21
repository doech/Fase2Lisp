import java.util.Map;

public class ExCondicion extends Expresion {
    private String entrada;
    private Map<String, String> entornoVariables;

    public ExCondicion(String entrada, Map<String, String> entornoVariables) {
        this.entrada = entrada.trim();
        this.entornoVariables = entornoVariables;
    }

    @Override
    public String evaluar() {
        String[] tokens = entrada.split("\\)\\s*\\(");
        for (String token : tokens) {
            token = token.replace("(", "").replace(")", "").trim();
            String[] partes = token.split("\\s+", 2);

            if (partes.length < 2) {
                return "Error: Sintaxis incorrecta en cond.";
            }

            String condicion = partes[0];
            String resultado = partes[1];

            if (esTrue(condicion)) {
                return resultado.replace("\"", ""); 
            }
        }
        return "Error: Ninguna condición en cond se cumplió. Verifique las condiciones y las variables.";
    }

    private boolean esTrue(String condicion) {
        if (entornoVariables.containsKey(condicion)) {
            String valor = entornoVariables.get(condicion);
            return valor != null && valor.equals("true");
        }
        return condicion.equals("true");
    }

    @Override
    public boolean verificar() {
        return entrada != null && !entrada.isEmpty();
    }
}


