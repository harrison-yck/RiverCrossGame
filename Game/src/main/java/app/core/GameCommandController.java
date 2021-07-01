package app.core;

import app.character.Characters;
import app.command.Command;
import app.command.RevertableCommandFactory;
import app.data.GameAreaView;
import app.data.GameState;

import java.util.Arrays;
import java.util.Map;

/**
 * @author harrison
 */
public class GameCommandController {
    private final Map<String, Command> commands;
    private final Map<String, RevertableCommandFactory> factories;

    public GameCommandController(Map<String, Command> commands, Map<String, RevertableCommandFactory> factories) {
        this.commands = commands;
        this.factories = factories;
    }

    public GameState execute(String commandString, GameState state) throws NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
        String[] inputs = commandString.trim().split(" ");

        System.out.println("Available Character: " + Characters.getAvailableIdentity());
        System.out.println("Available Area: " + Arrays.toString(GameAreaView.values()));

        if ("help".equalsIgnoreCase(inputs[0])) {
            listCommand();
            return state;
        }

        Command command = commands.get(inputs[0]) != null ? commands.get(inputs[0]) : factories.get(inputs[0]).createCommand();
        GameState newGameState = command.execute(state, Arrays.copyOfRange(inputs, 1, inputs.length));
        if (state != newGameState) return newGameState;

        return null;
    }

    public void listCommand() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Available Command(s): ");
        for (Map.Entry<String, Command> command : commands.entrySet()) {
            System.out.println("\"" + command.getKey() + "\" : " + command.getValue().getDescription());
        }
        System.out.println("-------------------------------------------------------");
    }
}
