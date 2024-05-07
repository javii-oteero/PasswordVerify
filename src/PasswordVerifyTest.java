import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordVerifyTest {
    @Test
    public void testContrasenyaVacia() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify(""));
    }

    @Test
    public void testContrasenyaCorta() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("hola"));
    }

    @Test
    public void testContrasenyaSinNumerosNiEspecialesNiMayus() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holacaracola"));
    }

    @Test
    public void testContrasenyaSinMayusculasNiEspecialesNiLargo() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("hola12"));
    }

    @Test
    public void testContrasenyaSinNumerosNiLargoNiEspeciales() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holA"));
    }

    @Test
    public void testContrasenyaSinNumsNiMayusNiLargo() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("hola!"));
    }

    @Test
    public void testContrasenyaSoloSinNums(){
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holaA!"));
    }

    @Test
    public void testContrasenyaSoloSinMayus() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("hola12!"));
    }

    @Test
    public void testContrasenyaSinMayusculasNiEspeciales() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("hola12A"));
    }

    @Test
    public void testContrasenyaSinMayusNiEspecial() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holacaracola12"));
    }

    @Test
    public void testContrasenyaSinNumerosNiMayusculasNiEspeciales() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holacaracola!"));
    }

    @Test
    public void testContrasenyaSinNumerosNiEspeciales() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holacaracolA"));
    }

    @Test
    public void testContrasenyaSinCaracteresRequeridos() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("ho12A!"));
    }

    @Test
    public void testContrasenyaSinNumeros() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holacaracolaA!"));
    }

    @Test
    public void testContrasenyaSinMayusculas() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holacaracola12!"));
    }

    @Test
    public void testContrasenyaSinEspeciales() {
        PasswordVerify verifier = new PasswordVerify();
        assertFalse(verifier.verify("holacaracola12A"));
    }

    @Test
    public void testContrasenyaCompletaValida() {
        PasswordVerify verifier = new PasswordVerify();
        assertTrue(verifier.verify("holacaracola12A!"));
    }

    @Test
    public void testContrasenyaCompleja() {
        PasswordVerify verifier = new PasswordVerify();
        assertTrue(verifier.verify("#P4blit0cl4v0uncl4vit0#"));
    }
}