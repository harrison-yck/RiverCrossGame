package app.command;

import app.data.GameState;
import app.data.GameStateMemento;

/**
 * @author harrison
 */
public abstract class ReversibleCommand implements Command {
    protected GameStateMemento memento;

    @Override
    public abstract GameState execute(GameState state, String[] parameters);

    @Override
    public abstract String getDescription();

    public void save(GameStateMemento memento) {
        this.memento = memento;
    }

    public GameState restore() {
        return memento.restore();
    }
}
