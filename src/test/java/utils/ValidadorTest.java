package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("debe validar los contenidos de un campo")
class ValidadorTest {
    @Test
    @DisplayName("debe comprobar que el campo es válido")
    public void validarCampos() {
        boolean resultado1 = Validador.validarCampo("test");
        assertEquals(true, resultado1);

        boolean resultado2 = Validador.validarCampo("test con espacios");
        assertEquals(true, resultado2);
    }

    @Test
    @DisplayName("debe comprobar que el campo no está vacío")
    public void validarCampoVacio() {
        boolean resultado = Validador.validarCampo("");
        assertEquals(false, resultado);
    }

    @Test
    @DisplayName("debe comprobar que el campo no tiene espacios ni al final ni al principio")
    public void validarCampoConSoloEspacios() {
        boolean resultado1 = Validador.validarCampo(" ");
        assertEquals(false, resultado1);

        boolean resultado2 = Validador.validarCampo("test ");
        assertEquals(false, resultado2);

        boolean resultado3 = Validador.validarCampo("  test ");
        assertEquals(false, resultado3);
    }
}