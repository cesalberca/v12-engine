package utils;

public class Validador {
    /**
     * Valida los campos del nombre. Un nombre no puede estar vacío
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
