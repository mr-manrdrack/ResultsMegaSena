package br.upe.mavenBasico;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ResultadoMegaCena {

    private final static String URL = "https://www.megasena.com/resultados";
    private static String urlAno = "https://www.megasena.com/resultados/ano-";

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

    public static String[] obtemResultadoData(String ano, int indice) {
        try {
            Document doc = Jsoup.connect(urlAno + ano).get();
    
            Elements listas = doc.select("ul.balls.-lg");
    
            if (listas.isEmpty() || indice < 1 || indice > listas.size()) {
                throw new IllegalArgumentException("Índice inválido.");
            }
    
            Element listaSelecionada = listas.get(indice - 1); // índice - 1 pois lista começa em 0
            Elements dezenas = listaSelecionada.select("li.ball");
    
            String[] resultado = new String[dezenas.size()];
            for (int i = 0; i < dezenas.size(); i++) {
                resultado[i] = dezenas.get(i).text();
            }
    
            return resultado;
    
        } catch (IOException e) {
            throw new RuntimeException("Erro ao acessar os dados da Mega-Sena.", e);
        }
    }
    
}