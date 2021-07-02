package app.rule;

import app.data.GameState;

/**
 * @author harrison
 */
public interface GameRule {
    boolean isObeyed(GameState state);

    String error();
}
