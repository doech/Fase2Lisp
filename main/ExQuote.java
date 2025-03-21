public class ExQuote extends Expresion {
    private String contenido;

    public ExQuote(String entrada) {
        entrada = entrada.trim();
        if (entrada.startsWith("quote")) {
            contenido = entrada.substring(5).trim();
        } else {
            contenido = "";
        }
    }

    @Override
    public String evaluar() {
        return contenido;
    }

    @Override
    public boolean verificar() {
        return contenido != null && !contenido.isEmpty();
    }
}
