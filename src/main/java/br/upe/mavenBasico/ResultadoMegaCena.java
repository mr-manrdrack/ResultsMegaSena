package br.upe.mavenBasico;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ResultadoMegaCena {

    private final static String URL = "https://www.megasena.com/resultados/ano-2024";

    public static String[] obtemUltimoResultado() {
        try {
            // Faz a requisição HTTP e obtém o HTML
            Document doc = Jsoup.connect(URL).get();

            // Seleciona apenas o PRIMEIRO <ul class="balls -lg">, que representa o último resultado
            Element primeiraLista = doc.select("ul.balls.-lg").first();

            // Se não encontrou, retorna erro
            if (primeiraLista == null) {
                throw new RuntimeException("Não foi possível localizar o último resultado.");
            }

            // Pega todos os <li class="ball"> dentro da primeira lista
            Elements dezenas = primeiraLista.select("li.ball");

            // Cria array para armazenar as 6 dezenas
            String[] resultado = new String[dezenas.size()];

            for (int i = 0; i < dezenas.size(); i++) {
                resultado[i] = dezenas.get(i).text();
            }

            return resultado;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao obter os dados da Mega-Sena", e);
        }
    }
}

