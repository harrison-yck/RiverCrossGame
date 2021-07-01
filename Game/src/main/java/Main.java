import app.RiverCrossingGame;
import app.core.GameCommandController;
import app.core.GameInputManager;
import app.core.GameStateManager;

/**
 * @author harrison
 */
public class Main {
    public static void main(String[] args) {
        var gameInputManager = new GameInputManager(new GameCommandController());
        var gameStateManager = new GameStateManager();

        new RiverCrossingGame(gameInputManager, gameStateManager).start();
    }
}
