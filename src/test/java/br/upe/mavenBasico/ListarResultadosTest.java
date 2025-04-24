package br.upe.mavenBasico;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListarResultadosTest {

    @Test
    public void testListarComAnoValido() {
        String ano = "2023";
        String[] datas = ListarResultados.listar(ano);

        assertNotNull(datas, "A lista de datas não pode ser nula");
        assertTrue(datas.length > 0, "Deve haver pelo menos um resultado para o ano " + ano);
    }

    @Test
    public void testListarComAnoInvalido() {
        String anoInvalido = "3024"; // Ano futuro provavelmente sem sorteios

        Exception exception = assertThrows(RuntimeException.class, () -> {
            ListarResultados.listar(anoInvalido);
        });

        String mensagemEsperada = "Erro ao obter as datas";
        String mensagemAtual = exception.getMessage();

        assertTrue(mensagemAtual.contains(mensagemEsperada));
    }
}

