package app.command;

import app.data.GameState;

import java.util.Stack;

/**
 * @author harrison
 */
public interface Command {
    Stack<RevertableCommand> undoList = new Stack<>();
    Stack<RevertableCommand> redoList = new Stack<>();

    GameState execute(GameState state, String[] parameters);

    String getDescription();
}
