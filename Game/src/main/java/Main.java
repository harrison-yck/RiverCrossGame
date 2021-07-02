import app.RiverCrossingGame;
import app.command.Commands;
import app.core.GameCommandController;
import app.core.GameInputManager;
import app.core.GameRuleValidator;
import app.core.GameStateManager;

/**
 * @author harrison
 */
public class Main {
    public static void main(String[] args) {
        var gameInputManager = new GameInputManager(new GameCommandController(Commands.getCommands(), Commands.getRevertableCommandFactortories(), new GameRuleValidator()));
        new RiverCrossingGame(gameInputManager, new GameStateManager()).start();
    }
}
