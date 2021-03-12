package teste;

import java.util.HashMap;
import java.util.Map;

/**
 * Automato Finito Deterministico (AFD)
 */
public class DeterministicFiniteAutomaton {

    /**
     * Estados do Automato Finito Deterministico (AFD)
     */
    private Map<Integer, State> states;

    /**
     * Constructor
     */
    public DeterministicFiniteAutomaton() {
        states = new HashMap<>();

        State q0 = new State(false);
        q0.addTransition('i', 1);
        states.put(0, q0);

        State q1 = new State(false);
        q1.addTransition('j', 2);
        q1.addTransition('k', 3);
        states.put(1, q1);

        State q2 = new State(false);
        q2.addTransition('i', 4);
        states.put(2, q2);

        State q3 = new State(false);
        q3.addTransition('k', 4);
        states.put(3, q3);

        State q4 = new State(true);
        q4.addTransition('i', 4);
        q4.addTransition('j', 4);
        q4.addTransition('k', 4);
        q4.addTransition('$', 4);
        states.put(4, q4);
    }

    /**
     * Formatar o estado para impressao
     *
     * @param state estado
     * @return estado formatado para impressao
     */
    private String formatState(Integer state) {
        if ((states.size() < 100) && (state < 10)) {
            return "\nq" + state + "  - ";
        }

        return "\nq" + state + " - ";
    }

    /**
     * Reconhecer a sentenca de entrada
     *
     * @param sentence sentenca de entrada
     * @return true caso a sentenca de entrada pertenca a linguagem, false em
     * caso contrario
     */
    public boolean recognize(String sentence) {
        String input = sentence + "$";

        System.out.print("Observação: \"$\" representa o fim da sentença");

        Integer state = 0;

        int length = input.length();

        for (int symbol = 0; symbol < length; symbol++) {
            System.out.print(formatState(state));

            for (int index = 0; index < length; index++) {
                if (index != symbol) {
                    System.out.print(" " + input.charAt(index) + " ");
                } else {
                    System.out.print("[" + input.charAt(index) + "]");
                }
            }

            state = states.get(state).getTransition(input.charAt(symbol));

            if (state == null) {
                System.out.println(" - REJEITA");

                return false;
            }
        }

        if (states.get(state).isAccept()) {
            System.out.println(" - ACEITA");
        } else {
            System.out.println(" - REJEITA");
        }

        return states.get(state).isAccept();
    }
}
