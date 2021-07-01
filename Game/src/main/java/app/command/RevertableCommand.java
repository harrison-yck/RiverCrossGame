package app.command;

import app.data.GameState;

import java.util.Stack;

/**
 * @author harrison
 */
public abstract class RevertableCommand implements Command {
    public abstract GameState execute(GameState state, String[] parameters);

    public abstract String getDescription();

    public abstract GameState undo(GameState state);

    public abstract GameState redo(GameState state);
}
