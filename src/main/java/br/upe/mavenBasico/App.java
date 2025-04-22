package br.upe.mavenBasico;

public class App {
    public static void main(String[] args) {
        String[] resultado = ResultadoMegaCena.obtemUltimoResultado();
        System.out.println("Dezenas sorteadas:");
        for (String dezena : resultado) {
            System.out.print(dezena + " ");
        }
    }
}

