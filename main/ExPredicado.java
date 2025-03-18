import java.util.ArrayList;
import java.util.List;

public class ExPredicado extends Expresion {
    private String operador;
    private List<String> argumentos;

    public ExPredicado(String entrada) {
        this.argumentos = new ArrayList<>();
        String[] tokens = entrada.split("\\s+");
        this.operador = tokens[0];

        for (int i = 1; i < tokens.length; i++) {
            argumentos.add(tokens[i]); 
        }
    }

    @Override
    public String evaluar() {
        if (argumentos.size() != 2) {
            return "Error: El predicado necesita 2 argumentos";
        }
    
        String arg1 = argumentos.get(0);
        String arg2 = argumentos.get(1);
        if (esNumerico(arg1) && esNumerico(arg2)) {
            int num1 = Integer.parseInt(arg1);
            int num2 = Integer.parseInt(arg2);
    
            switch (operador) {
                case ">":
                    if (num1 > num2) {
                        return "Mayor";
                    } else {
                        return "No mayor";
                    }
                case "<":
                    if (num1 < num2) {
                        return "Menor";
                    } else {
                        return "No menor";
                    }
                case "equal":
                    if (num1 == num2) {
                        return "Iguales";
                    } else {
                        return "Diferentes";
                    }
                default:
                    return "Error: Operador no reconocido " + operador;
            }
        } else {
            return "Error: Los argumentos deben ser numéricos";
        }
    }
    
    private boolean esNumerico(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;  
            }
        }
        return true;  
    }
    

    @Override
    public boolean verificar() {
        return argumentos.size() == 2;
    }
}