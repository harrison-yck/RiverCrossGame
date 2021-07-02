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

    public GameState undo(GameState state) {
        GameState oldState = memento.restore();
        memento = new GameStateMemento(state);
        this.REDO_LIST.push(this);
        return oldState;
    }

    public GameState redo(GameState state) {
        GameState oldState = memento.restore();
        memento = new GameStateMemento(state);
        UNDO_LIST.push(this);
        return oldState;
    }
}
