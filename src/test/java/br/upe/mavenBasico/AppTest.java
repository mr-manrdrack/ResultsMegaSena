package br.upe.mavenBasico;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAppStartsWithoutException() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }

}
