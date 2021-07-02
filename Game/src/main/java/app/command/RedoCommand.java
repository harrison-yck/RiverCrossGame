package app.command;

import app.data.GameState;

/**
 * @author harrison
 */
public class RedoCommand implements Command {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        if (REDO_LIST.isEmpty()) {
            System.out.println();
            System.out.println("No redo action is available !");
            System.out.println();
            return null; // expected result, no exception is throw here
        } else {
            ReversibleCommand command = REDO_LIST.pop();
            return command.redo(state);
        }
    }

    @Override
    public String getDescription() {
        return "Usage: redo";
    }
}
