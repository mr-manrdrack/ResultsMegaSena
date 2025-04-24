package br.upe.mavenBasico;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ListarResultados {

    public static String[] listar(String ano) {
        String URL = "https://www.megasena.com/resultados/ano-";
        String linkAno = URL + ano;

        try {
            Document site = Jsoup.connect(linkAno).get();
            Elements datasSite = site.select("div.date");

            String[] datas = new String[datasSite.size()];
            for (int i = 0; i < datasSite.size(); i++) {
                datas[i] = datasSite.get(i).text();
            }

            return datas;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao obter as datas", e);
        }
    }
}
