package utils;

public class Validador {
    /**
     * Valida campos. Un campo no puede estar vacío, ni tener sólamente espacios,
     * ni tener espacios ni al principio ni al final del mismo.
     * @param campo Campo a validar
     * @return Campo válido
     */
    public static boolean validarCampo(String campo) {
        if (campo.isEmpty()) {
            return false;
        } else if (campo.trim().length() != campo.length()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Valida un campo númerico. Comprueba que es un número y que éste es mayor que 0.
     * @param numerico Posible número a testear
     * @return Campo válido
     */
    public static boolean validarCampoNumerico(String numerico) {
        // Antes que nada comprobamos que es un número.
        if (!esNumerico(numerico)) {
            return false;
        }

        // Parse seguro
        double numero = Double.parseDouble(numerico);


        if (numero <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Usa regex para comprobar si un string es un número válido.
     * Es mejor usar regex que usar try/catch, ya que éstos consumen muchos recursos.
     * @param str String a comprobar
     * @return Número válido
     */
    public static boolean esNumerico(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
