import java.util.Scanner;

public class jogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        int tentativas = 0;
        int palpite = 0;
        System.out.println("Bem-vinda(o) ao Jogo dos NÚMEROS!");
        System.out.println("Já pensei em um número de 0 a 100! Será que você consegue acertar?");

        while (palpite != numeroSecreto) {
            System.out.println("Diga seu palpite: ");
            palpite = scanner.nextInt();
            tentativas++;

            if (palpite < numeroSecreto) {
                System.out.println("Errou número muito baixo! Tente um maior");
            } else if (palpite > numeroSecreto) {
                System.out.println("Vish agora tá alto demais! Tente um menor");
            }

        }
        System.out.println("Acertou! Finalmente eim jesus");
        System.out.println("O número secreto era: " + numeroSecreto);
        System.out.println("Você teve: " + tentativas + " tentativas para acertar");
        scanner.close();
    }

}
