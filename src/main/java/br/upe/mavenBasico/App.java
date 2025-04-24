package br.upe.mavenBasico;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Mega-Sena ===");
        System.out.println("1 - Último resultado");
        System.out.println("2 - Listar resultados por ano");
        System.out.print("Escolha uma opção: ");

        int opc = sc.nextInt();
        sc.nextLine(); // Limpa o \n do buffer

        if (opc == 1) {
            String[] resultado = ResultadoMegaCena.obtemUltimoResultado();
            System.out.println("\nDezenas sorteadas:");
            for (String dezena : resultado) {
                System.out.print(dezena + " ");
            }
            System.out.println();

        } else if (opc == 2) {
            System.out.print("Digite o ano (ex.: 2024): ");
            String ano = sc.nextLine();

            String[] lista = ListarResultados.listar(ano);

            System.out.println("\nConcursos de " + ano + ":");
            for (int i = 0; i < lista.length; i++) {
                String data = lista[i];
                System.out.printf(i+1 + " - " + data + "\n");
            }

            System.out.print("Digite o índice do data que deseja(ex.: 1):");
            int indc = sc.nextInt();
            sc.nextLine();


            String[] resultadoData = ResultadoMegaCena.obtemResultadoData(ano, indc);

            System.out.println("\nDezenas sorteadas:");
            for (String dezena : resultadoData) {
                System.out.print(dezena + " ");
            }
            System.out.println();
            
        } else {
            System.out.println("Opção inválida!");
        }

        sc.close();
    }
}
