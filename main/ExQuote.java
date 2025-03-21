/**
 * Clase que representa la expresión 'quote' en el lenguaje interpretado.
 * Esta expresión devuelve el contenido sin evaluarlo.
 */
public class ExQuote extends Expresion {
    private String contenido;

    /**
     * Constructor que analiza la entrada y extrae el contenido de la expresión 'quote'.
     */
    public ExQuote(String entrada) {
        entrada = entrada.trim();
        if (entrada.startsWith("quote")) {
            contenido = entrada.substring(5).trim();
        } else {
            contenido = "";
        }
    }

    /**
     * Evalúa la expresión 'quote', devolviendo su contenido sin modificarlo.
     * @return El contenido de la expresión 'quote'.
     */
    @Override
    public String evaluar() {
        return contenido;
    }

    /**
     * Verifica si la expresión 'quote' es válida, asegurando que tiene contenido.
     * @return true si hay contenido, false si está vacío o es nulo.
     */
    @Override
    public boolean verificar() {
        return contenido != null && !contenido.isEmpty();
    }
}
