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
    private final GameRuleValidator validator;

    public GameInputManager(GameCommandController commandController) {
        this.scanner = new Scanner(System.in);
        this.commandController = commandController;
        this.validator = new GameRuleValidator(new ConsolePrinter());
    }

    public Optional<GameState> input(GameState state) {
        String str = scanner.next();

        try {
            GameState newGameState = commandController.execute(str, state);

            if (state == newGameState) return Optional.empty();
            if (validator.isValid(newGameState)) return Optional.of(newGameState);
        } catch (NullPointerException ex) {
            System.out.println("Unsupported command: " + str);
        }

        return Optional.empty();
    }
}
