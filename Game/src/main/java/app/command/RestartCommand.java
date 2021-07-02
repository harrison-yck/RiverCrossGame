package app.command;

import app.data.GameState;


/**
 * @author harrison
 */
public class RestartCommand implements Command {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        UNDO_LIST.removeAllElements();
        REDO_LIST.removeAllElements();
        return new GameState();
    }

    @Override
    public String getDescription() {
        return "Usage: restart";
    }
}
