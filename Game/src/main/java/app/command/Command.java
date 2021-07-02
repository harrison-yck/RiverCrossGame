package app.command;

import app.data.GameState;

import java.util.Stack;

/**
 * @author harrison
 */
public interface Command {
    Stack<ReversibleCommand> UNDO_LIST = new Stack<>();
    Stack<ReversibleCommand> REDO_LIST = new Stack<>();

    GameState execute(GameState state, String[] parameters);

    String getDescription();
}
