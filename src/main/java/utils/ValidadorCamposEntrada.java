package utils;

public class ValidadorCamposEntrada {
    /**
     * Valida los campos del nombre. Un nombre no puede estar vacío
     * @param campoAValidar Campo a validar
     * @return Campo válido
     */
    public static boolean validarCampo(String campoAValidar) {
        if (campoAValidar.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
