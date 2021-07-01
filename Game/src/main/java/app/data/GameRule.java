package app.data;

import app.data.GameState;

/**
 * @author harrison
 */
public interface GameRule {
    boolean validate(GameState state);

    String detail();
}
