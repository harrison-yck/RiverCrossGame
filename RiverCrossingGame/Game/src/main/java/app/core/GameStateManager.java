package app.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author harrison
 */
public class GameStateManager {
    private final List<GameState> savePoints = new ArrayList<>();
    private GameState currentState;

    public void update() {

    }

    public void undo() {

    }

    public void save(GameState command) {

    }

    public List<GameState> listSavePoints() {
        return null;
    }

    public void restart() {

    }
}
