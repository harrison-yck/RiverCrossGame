package app.core;

import app.data.GameState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author harrison
 */
public class GameStateManager {
    private GameState currentState;

    public GameStateManager() {
        currentState = new GameState();
    }

    public boolean isEnded() {
        return currentState.isEnded();
    }

    public GameState getState() {
        return currentState;
    }

    public void update(GameState state) {
        currentState = state;
    }
}
