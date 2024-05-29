package jogo;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner leitor = new Scanner(System.in);
        Random randola = new Random();
        int totalVitorias = 0;
        int totalErros = 0;

        System.out.print("Digite seu nome: ");
        String nome = leitor.nextLine();

        while (true) {
            System.out.print(nome + ", você deseja iniciar uma partida? (s/n): ");
            String resposta = leitor.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                int numeroSecreto = randola.nextInt(10) + 1;
                int tentativas = 0;
                boolean acertou = false;

                System.out.println("Um número entre 1 e 10 foi gerado. Tente adivinhar!!!");

                while (!acertou) {
                    System.out.print("Digite seu palpite: ");
                    int palpite = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha

                    tentativas++;

                    if (palpite == numeroSecreto) {
                        System.out.println("Parabéns!! " + nome + "! Você acertou o número em " + tentativas + " tentativas.");
                        totalVitorias++;
                        acertou = true;
                    } else if (palpite < numeroSecreto) {
                        System.out.println("O número aleatorio é maior que " + palpite + ".");
                    } else {
                        System.out.println("O número aleatorio é menor que " + palpite + ".");
                    }
                }

                System.out.print("Você deseja jogar novamente? (s/n): ");
                String jogarNovamente = leitor.nextLine();
                if (!jogarNovamente.equalsIgnoreCase("s")) {
                    break;
                }
            } else {
                System.out.println("Obrigado por jogar! Até a próxima.");
                break;
            }
        }

        System.out.println(nome + ", durante esta sessão você venceu " + totalVitorias + " vez(es) e errou " + totalErros + " vez(es).");
        leitor.close();
    }
}
        