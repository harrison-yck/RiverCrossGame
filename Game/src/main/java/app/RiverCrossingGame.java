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
        System.out.flush();
        System.out.println("---- Welcome to River Cross Game ----");
        System.out.println("> Enter \"help\" to check available commands");

        while (!gameStateManager.isEnded()) {
            gameInputManager.input(gameStateManager.getState()).ifPresent(gameStateManager::update);
        }
    }
}
