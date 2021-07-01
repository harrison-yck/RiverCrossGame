package app.command;

import app.data.GameState;

/**
 * @author harrison
 */
public class RedoCommand implements Command {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        if (redoList.isEmpty()) {
            System.out.println();
            System.out.println("No redo action is available !");
            System.out.println();
            return null;
        } else {
            RevertableCommand command = redoList.pop();
            return command.redo(state);
        }
    }

    @Override
    public String getDescription() {
        return "Usage: redo";
    }
}
