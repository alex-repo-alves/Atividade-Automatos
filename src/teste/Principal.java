package teste;

import java.util.Scanner;

/**
 * Testar o Automato Finito Deterministico (AFD)
 */
public class Principal {

    /**
     * Constructor
     */
    private Principal() {

    }

    /**
     * Metodo principal da linguagem de programacao Java
     *
     * @param args argumentos da linha de comando (nao utilizado)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Analise a sentença: ");
        String sentence = scanner.nextLine().trim();

        scanner.close();

        if (sentence.indexOf("$") >= 0) {
            System.out.println("A sentença \"" + sentence + "\" é inválida");

            return;
        }

        DeterministicFiniteAutomaton afd = new DeterministicFiniteAutomaton();

        afd.recognize(sentence);
    }
}
