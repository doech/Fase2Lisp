/**
 * Clase base para representar una expresión en el lenguaje interpretado.
 * Todas las expresiones deben heredar de esta clase y sobrescribir sus métodos.
 */
public class Expresion {

    /**
     * Método para evaluar la expresión y devolver un resultado.
     * Debe ser sobrescrito por las clases derivadas.
     * @return El resultado de la evaluación de la expresión.
     */
    public String evaluar() {
        return "";
    }

    /**
     * Método para verificar si la expresión es válida.
     * Puede ser sobrescrito por las clases derivadas según sea necesario.
     * @return true por defecto
     */
    public boolean verificar() {
        return true;
    }
}
