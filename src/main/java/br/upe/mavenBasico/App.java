package br.upe.mavenBasico;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Digite 1, para obter o último resultado da Mega-Sena\n"+
        "Digite 2 para obter o resultado de uma data específica");

        Scanner sc = new Scanner(System.in);
        int opc = sc.nextInt();

        if(opc == 1){
            String[] resultado = ResultadoMegaCena.obtemUltimoResultado();
            System.out.println("Dezenas sorteadas:");
            for (int i = 0; i<resultado.length;i++) {
                String dezena = resultado[i];
                System.out.print(dezena + " ");
            }
        } else if(opc == 2){
            
        }
        
    }
}

