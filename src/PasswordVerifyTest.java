import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordVerifyTest {
    private final String msgCaracter = "La contrasenya ha de tenir almenys 8 caràcters\n";
    private final String msgNums = "La contrasenya ha de contenir almenys 2 números\n";
    private final String msgMayus = "La contrasenya ha de contenir almenys una lletra majúscula\n";
    private final String msgEsp = "La contrasenya ha de contenir almenys un caràcter especial";

    @Test
    public void testContrasenyaVacia() {
        EsCorrecta pass = PasswordVerify.verify("");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgNums + msgMayus + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaCorta() {
        EsCorrecta pass = PasswordVerify.verify("hola");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgNums + msgMayus + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaSinNumerosMayusculas() {
        EsCorrecta pass = PasswordVerify.verify("holacaracola");
        assertFalse(pass.isCorrecta());
        assertEquals(msgNums + msgMayus + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaCortaConNumero() {
        EsCorrecta pass = PasswordVerify.verify("hola12");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgMayus + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaCortaConMayuscula() {
        EsCorrecta pass = PasswordVerify.verify("holA");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgNums + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaCortaConNumeroYCaracterEspecial() {
        EsCorrecta pass = PasswordVerify.verify("hola!");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgNums + msgMayus, pass.getError());
    }

    @Test
    public void testContrasenyaCortaConMayusculaYCaracterEspecial() {
        EsCorrecta pass = PasswordVerify.verify("holaA!");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgNums, pass.getError());
    }

    @Test
    public void testContrasenyaCortaConNumeroYCaracterEspecialSinMayuscula() {
        EsCorrecta pass = PasswordVerify.verify("hola12!");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgMayus, pass.getError());
    }

    @Test
    public void testContrasenyaCortaConMayusculaYNumeroSinCaracterEspecial() {
        EsCorrecta pass = PasswordVerify.verify("hola12A");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaLargaSinMayusculaNumeroYCaracterEspecial() {
        EsCorrecta pass = PasswordVerify.verify("holacaracola12");
        assertFalse(pass.isCorrecta());
        assertEquals(msgMayus + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaSolamenteCaracterEspecial() {
        EsCorrecta pass = PasswordVerify.verify("holacaracola!");
        assertFalse(pass.isCorrecta());
        assertEquals(msgNums + msgMayus, pass.getError());
    }

    @Test
    public void testContrasenyaSolamenteLetraMayuscula() {
        EsCorrecta pass = PasswordVerify.verify("holacaracolA");
        assertFalse(pass.isCorrecta());
        assertEquals(msgNums + msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaLargaConMayusculaNumeroYCaracterEspecialSinLongitud() {
        EsCorrecta pass = PasswordVerify.verify("ho12A!");
        assertFalse(pass.isCorrecta());
        assertEquals(msgCaracter, pass.getError());
    }

    @Test
    public void testContrasenyaLargaConMayusculaYCaracterEspecialSinNumeros() {
        EsCorrecta pass = PasswordVerify.verify("holacaracolaA!");
        assertFalse(pass.isCorrecta());
        assertEquals(msgNums, pass.getError());
    }

    @Test
    public void testContrasenyaLargaConNumeroYCaracterEspecialSinMayuscula() {
        EsCorrecta pass = PasswordVerify.verify("holacaracola12!");
        assertFalse(pass.isCorrecta());
        assertEquals(msgMayus, pass.getError());
    }

    @Test
    public void testContrasenyaLargaConMayusculaNumeroYLongitudSinCaracterEspecial() {
        EsCorrecta pass = PasswordVerify.verify("holacaracola12A");
        assertFalse(pass.isCorrecta());
        assertEquals(msgEsp, pass.getError());
    }

    @Test
    public void testContrasenyaValidaConTodosLosRequisitos() {
        EsCorrecta pass = PasswordVerify.verify("holacaracola12A!");
        assertTrue(pass.isCorrecta());
        assertEquals("", pass.getError());
    }

    @Test
    public void testContrasenyaValidaCompleja() {
        EsCorrecta pass = PasswordVerify.verify("#P4blit0cl4v0uncl4vit0#");
        assertTrue(pass.isCorrecta());
        assertEquals("", pass.getError());
    }


}