package br.upe.mavenBasico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResultadoMegaCenaTests {
    private final static int NUMERO_DE_DEZENAS = 6;

    @Test
    public void deveRetornarUltimoResultadoComSeisDezenasValidas() {
        String[] resultado = ResultadoMegaCena.obtemUltimoResultado();

        assertAll(
            () -> assertNotNull(resultado, "Resultado não pode ser nulo"),
            () -> assertEquals(NUMERO_DE_DEZENAS, resultado.length, "Deve conter exatamente 6 dezenas"),
            () -> {
                for (String dezena : resultado) {
                    assertNotNull(dezena, "Cada dezena não deve ser nula");
                    assertFalse(dezena.trim().isEmpty(), "Cada dezena não deve estar vazia");
                }
            }
        );
    }
}
