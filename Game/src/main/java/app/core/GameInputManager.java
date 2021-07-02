package app.core;

import app.data.GameState;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author harrison
 */
public class GameInputManager {
    private final Scanner scanner;
    private final GameCommandController commandController;

    public GameInputManager(GameCommandController commandController) {
        this.scanner = new Scanner(System.in, Charset.defaultCharset());
        this.commandController = commandController;
    }

    public Optional<GameState> input(GameState state) {
        state.print();
        System.out.println("> Enter \"help\" to check available commands, \"exit\" to close the game");

        String str = scanner.nextLine();
        try {
            return Optional.ofNullable(commandController.execute(str, state));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            System.out.println("Invalid command");
        }

        return Optional.empty();
    }
}
