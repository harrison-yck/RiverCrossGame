package app;

import app.core.GameInputManager;
import app.core.GameStateManager;


/**
 * @author harrison
 */
public class RiverCrossingGame {
    private final GameInputManager gameInputManager;
    private final GameStateManager gameStateManager;

    public RiverCrossingGame(GameInputManager gameInputManager, GameStateManager gameStateManager) {
        this.gameInputManager = gameInputManager;
        this.gameStateManager = gameStateManager;
    }

    public void start() {
        while (!gameStateManager.isEnded()) {
            gameInputManager.waitingForInput().ifPresent(gameStateManager::update);
        }
    }
}
