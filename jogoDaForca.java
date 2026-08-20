import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class jogoDaForca {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] palavras = {"programacao", "java", "computador", "teclado", "mouse"};
        String palavraSecreta = palavras[random.nextInt(palavras.length)];
        
        char[] palavraOculta = new char[palavraSecreta.length()];
        for (int i = 0; i < palavraOculta.length; i++){
            palavraOculta[i] = '_';
        }
        int tentativasRestantes = 5;
        ArrayList<Character> letrasUsadas = new ArrayList<>();
        boolean acertou = false;
        System.out.println("=== Jogo da Forca ===");
        while (tentativasRestantes > 0 && !acertou) {
            System.out.println("Palavra:" + String.valueOf(palavraOculta));
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.println("Letras já usadas:");
            System.out.println("Digite uma letra:");

            String entrada = scanner.nextLine().toLowerCase();

            if (entrada.isEmpty() || entrada.length() > 1) {
                System.out.println("Entrada inválida. Digite apenas UMA letra.");
                continue;
            }

            char letra = entrada.charAt(0);
            if (letrasUsadas.contains(letra)) {
                System.out.println(" Você já tentou essa letra. Tente outra.");
                continue;
            }
            letrasUsadas.add(letra);
            boolean letraEncontrada = false;
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    palavraOculta[i] = letra;
                    letraEncontrada = true;
                }
            }
            if (letraEncontrada){
                System.out.println("Boa! A letra ' " + letra + "' está na palavra.");
            } else {
                tentativasRestantes--;
                System.out.println("A letra ' " + letra + "' não está na palavra.");
            }

            if (String.valueOf(palavraOculta).equals(palavraSecreta)) {
                acertou = true;
            }
        }

        System.out.println("=====================================");
        if (acertou) {
            System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
        } else {
            System.out.println("Game Over! A palavra era: " + palavraSecreta);
        }
        
        scanner.close();
    }
}