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

    public Optional<GameState> input(GameState state) {
        state.print();
        System.out.println("> Enter \"help\" to check available commands");

        String str = scanner.nextLine();
        try {
            return Optional.ofNullable(commandController.execute(str, state));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            System.out.println("Invalid command: " + str);
        } catch (NullPointerException ex) {
            System.out.println("Unsupported command: " + str);
        }

        return Optional.empty();
    }
}
