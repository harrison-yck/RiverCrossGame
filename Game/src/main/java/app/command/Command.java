package app.command;

import app.data.GameState;

/**
 * @author harrison
 */
public interface Command {
    GameState execute();

    String getDescription();
}
