package app.command;

import app.data.GameState;

/**
 * @author harrison
 */
public class UndoCommand implements Command {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        if (UNDO_LIST.isEmpty()) {
            System.out.println();
            System.out.println("No undo action is available!");
            System.out.println();
            return null; // expected result, no exception is throw here
        } else {
            ReversibleCommand command = UNDO_LIST.pop();
            return command.undo(state);
        }
    }

    @Override
    public String getDescription() {
        return "Usage: undo";
    }
}
