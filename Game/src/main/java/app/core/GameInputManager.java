package app.core;

import app.data.GameState;

import java.util.Optional;
import java.util.Scanner;

/**
 * @author harrison
 */
public class GameInputManager {
    private final Scanner scanner;
    private final GameCommandController commandController;

    public GameInputManager(GameCommandController commandController) {
        this.scanner = new Scanner(System.in);
        this.commandController = commandController;
    }

    public Optional<GameState> waitingForInput() {
        String str = scanner.next();

        try {
            return Optional.of(commandController.execute(str));
        } catch (NullPointerException ex) {
            System.out.println("Unsupported command: " + str);
        }

        return Optional.empty();
    }
}
