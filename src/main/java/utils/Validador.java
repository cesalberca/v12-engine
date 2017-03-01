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
}
