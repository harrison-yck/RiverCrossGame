package app.core;

import app.character.Characters;
import app.command.Command;
import app.command.ReversibleCommand;
import app.command.factory.ReversibleCommandFactory;
import app.data.GameAreaView;
import app.data.GameState;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author harrison
 */
public class GameCommandController {
    private final Map<String, Command> commands;
    private final Map<String, ReversibleCommand> reversibleCommands;

    private final Map<String, ReversibleCommandFactory> factories;

    public GameCommandController(Map<String, Command> commands, Map<String, ReversibleCommandFactory> factories) {
        this.commands = commands;
        this.factories = factories;
        this.reversibleCommands = factories.entrySet().stream().collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> entry.getValue().createCommand()));
    }

    public GameState execute(String commandString, GameState state) {
        String[] inputs = commandString.trim().split(" ");

        System.out.println("Available Character: " + Characters.getAvailableIdentity());
        System.out.println("Available Area: " + Arrays.toString(GameAreaView.values()));

        if ("help".equalsIgnoreCase(inputs[0])) {
            listCommand();
            return state;
        } else if ("exit".equalsIgnoreCase(inputs[0])) {
            System.exit(0);
        }

        Command command = commands.get(inputs[0]);
        ReversibleCommandFactory factory = factories.get(inputs[0]);

        if (command == null && factory != null) command = factory.createCommand();

        if (command != null) {
            GameState newGameState = command.execute(state, Arrays.copyOfRange(inputs, 1, inputs.length));
            if (!state.equals(newGameState)) return newGameState;
        }

        throw new IllegalArgumentException();
    }

    public void listCommand() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Available Command(s): ");

        for (Map.Entry<String, Command> command : commands.entrySet()) {
            System.out.println("\"" + command.getKey() + "\" : " + command.getValue().getDescription());
        }
        System.out.println();

        System.out.println("Available Revertible Command(s): ");

        for (Map.Entry<String, ReversibleCommand> command : reversibleCommands.entrySet()) {
            System.out.println("\"" + command.getKey() + "\" : " + command.getValue().getDescription());
        }

        System.out.println("-------------------------------------------------------");
    }
}
