package teste;

import java.util.HashMap;
import java.util.Map;

/**
 * Estado do Automato Finito Deterministico
 */
public class State {

    /**
     * Estado eh de aceitacao
     */
    private boolean accept;

    /**
     * Transicao de estados
     */
    private Map<Character, Integer> transitions;

    /**
     * Constructor
     *
     * @param accept estado eh de aceitacao
     */
    public State(boolean accept) {
        this.accept = accept;

        transitions = new HashMap<>();
    }

    /**
     * Retornar se o estado eh de aceitacao
     *
     * @return true se o estado eh de aceitacao, false em caso contrario
     */
    public boolean isAccept() {
        return accept;
    }

    /**
     * Adicionar uma transicao de estado
     *
     * @param symbol simbolo corrente
     * @param state novo estado
     */
    public void addTransition(Character symbol, Integer state) {
        transitions.put(symbol, state);
    }

    /**
     * Retornar o novo estado
     *
     * @param symbol simbolo corrente
     * @return novo estado
     */
    public Integer getTransition(Character symbol) {
        return transitions.get(symbol);
    }
}
