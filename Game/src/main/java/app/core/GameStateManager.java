package app.core;

import app.data.GameState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author harrison
 */
public class GameStateManager {
    private final List<GameState> savePoints;
    private GameState currentState;

    public GameStateManager() {
        savePoints = new ArrayList<>();
    }

    public boolean isEnded() {
        return currentState.isEnded();
    }

    public void update(GameState state) {
        currentState = state;
    }

    public void undo() {

    }

    public void restart() {
        currentState = new GameState();
    }

    public void save() {
        savePoints.add(currentState);
    }

    public void load(GameState state) {
        currentState = state;
    }

    public List<GameState> listSavePoints() {
        return Collections.unmodifiableList(savePoints);
    }
}
