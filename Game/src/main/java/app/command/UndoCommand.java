package app.command;

import app.data.GameState;

/**
 * @author harrison
 */
public class UndoCommand implements Command {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        if (undoList.isEmpty()) {
            System.out.println();
            System.out.println("No undo action is available!");
            System.out.println();
            return null;
        } else {
            RevertableCommand command = undoList.pop();
            return command.undo(state);
        }
    }

    @Override
    public String getDescription() {
        return "Usage: undo";
    }
}
