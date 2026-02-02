package es.etg.dam.psp;

public class Calculadora {

    public static final String OPERADOR_SUMA = "+";
    public static final String OPERADOR_RESTA = "-";
    public static final String OPERADOR_MULTIPLICACION = "*";
    public static final String OPERADOR_DIVISION = "/";

    public static final String MSG_KO = "KO";

    public String calcular(String num1, String operador, String num2) {
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            return switch (operador) {
                case OPERADOR_SUMA -> String.valueOf(n1 + n2);
                case OPERADOR_RESTA -> String.valueOf(n1 - n2);
                case OPERADOR_MULTIPLICACION -> String.valueOf(n1 * n2);
                case OPERADOR_DIVISION -> n2 != 0 ? String.valueOf(n1 / n2) : MSG_KO;
                default -> MSG_KO;
            };

        } catch (NumberFormatException e) {
            return MSG_KO;
        }
    }
}


