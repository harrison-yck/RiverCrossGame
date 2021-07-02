package app.command;

import app.data.GameState;
import app.data.GameStateMemento;

/**
 * @author harrison
 */
public abstract class RevertableCommand implements Command {
    protected GameStateMemento memento;

    public abstract GameState execute(GameState state, String[] parameters);

    public abstract String getDescription();

    public GameState undo(GameState state) {
        GameState oldState = memento.restore();
        memento = new GameStateMemento(state);
        this.redoList.push(this);
        return oldState;
    }

    public GameState redo(GameState state) {
        GameState oldState = memento.restore();
        memento = new GameStateMemento(state);
        undoList.push(this);
        return oldState;
    }
}
