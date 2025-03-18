public class ExQuote extends Expresion {
    private String contenido;

    public ExQuote(String entrada) {
        String[] tokens = entrada.split("\\s+");
        
        if (tokens.length > 1) {
            contenido = tokens[1]; 
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
