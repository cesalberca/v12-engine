package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidadorCamposEntradaTest {
    @Test
    public void validarCampo() throws Exception {
        boolean resultado1 = ValidadorCamposEntrada.validarCampo("");
        boolean resultado2 = ValidadorCamposEntrada.validarCampo("Campo válido");
        assertEquals(false, resultado1);
        assertEquals(true, resultado2);
    }

}