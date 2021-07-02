package app.command;

import app.data.GameState;

/**
 * @author harrison
 */
public interface Command {
    GameState execute(GameState state, String[] parameters);

    String getDescription();
}
