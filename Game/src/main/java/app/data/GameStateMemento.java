package app.data;

/**
 * @author harrison
 */
public record GameStateMemento(GameState state) {
    public GameState restore() {
        return state;
    }
}
