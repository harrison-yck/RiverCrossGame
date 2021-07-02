package app.command;

import app.data.GameState;

/**
 * @author harrison
 */
public class RestartCommand implements Command {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
