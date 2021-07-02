package app.core;

import app.character.Characters;
import app.command.Command;
import app.command.ReversibleCommand;
import app.command.factory.ReversibleCommandFactory;
import app.data.GameAreaView;
import app.data.GameState;
import app.data.GameStateMemento;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author harrison
 */
public class GameCommandController {
    private final Map<String, Command> commands;
    private final Map<String, ReversibleCommand> reversibleCommands;
    private final Map<String, ReversibleCommandFactory> factories;
    private final Stack<ReversibleCommand> undoList = new Stack<>();
    private final Stack<ReversibleCommand> redoList = new Stack<>();

    private final GameRuleValidator validator;

    public GameCommandController(Map<String, Command> commands, Map<String, ReversibleCommandFactory> factories, GameRuleValidator validator) {
        this.commands = commands;
        this.factories = factories;
        this.reversibleCommands = factories.entrySet().stream().collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> entry.getValue().createCommand()));
        this.validator = validator;
    }

    public GameState execute(String commandStrings, GameState state) {
        String[] inputs = commandStrings.trim().split(" ");

        String commandString = inputs[0];

        System.out.println("Available Character: " + Characters.getAvailableIdentity());
        System.out.println("Available Area: " + Arrays.toString(GameAreaView.values()));

        if ("help".equalsIgnoreCase(commandString)) {
            listCommand();
            return state;
        } else if ("undo".equalsIgnoreCase(commandString)) {
            return undoCommand(state);
        } else if ("redo".equalsIgnoreCase(commandString)) {
            return redoCommand(state);
        } else if ("restart".equalsIgnoreCase(commandString)) {
            return restartCommand();
        } else if ("exit".equalsIgnoreCase(commandString)) {
            System.exit(0);
        }

        ReversibleCommandFactory factory = factories.get(commandString);

        Command command = commands.get(commandString);
        ReversibleCommand reversibleCommand = null;
        GameState newGameState = null;

        if (command != null) {
            newGameState = command.execute(state, Arrays.copyOfRange(inputs, 1, inputs.length));
        } else if (factory != null) {
            reversibleCommand = factory.createCommand();
            newGameState = reversibleCommand.execute(state, Arrays.copyOfRange(inputs, 1, inputs.length));
        }

        if (newGameState != null && !state.equals(newGameState) && validator.isValid(newGameState)) {
            if (reversibleCommand != null) {
                GameStateMemento memento = new GameStateMemento(state);
                reversibleCommand.save(memento);
                undoList.push(reversibleCommand);
            }

            return newGameState;
        }

        throw new IllegalArgumentException();
    }

    GameState undoCommand(GameState state) {
        if (undoList.isEmpty()) {
            System.out.println();
            System.out.println("No undo action is available!");
            System.out.println();
        } else {
            ReversibleCommand reversibleCommand = undoList.pop();
            GameState restoredState = reversibleCommand.restore();

            var memento = new GameStateMemento(state);
            reversibleCommand.save(memento);
            redoList.push(reversibleCommand);

            return restoredState;
        }
        return null;
    }

    GameState redoCommand(GameState state) {
        if (redoList.isEmpty()) {
            System.out.println();
            System.out.println("No redo action is available !");
            System.out.println();
        } else {
            ReversibleCommand reversibleCommand = redoList.pop();
            GameState restoredState = reversibleCommand.restore();

            var memento = new GameStateMemento(state);
            reversibleCommand.save(memento);
            undoList.push(reversibleCommand);

            return restoredState;
        }
        return null;
    }

    GameState restartCommand() {
        undoList.removeAllElements();
        redoList.removeAllElements();
        return new GameState();
    }

    public void listCommand() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Available Command(s): ");
        System.out.println("\"undo\" : Usage: undo");
        System.out.println("\"redo\" : Usage: redo");
        System.out.println("\"restart\" : Usage: restart");
        System.out.println("\"exit\" : Usage: exit");

        for (Map.Entry<String, Command> command : commands.entrySet()) {
            System.out.println("\"" + command.getKey() + "\" : " + command.getValue().getDescription());
        }
        System.out.println();

        System.out.println("Available Reversible Command(s): ");

        for (Map.Entry<String, ReversibleCommand> command : reversibleCommands.entrySet()) {
            System.out.println("\"" + command.getKey() + "\" : " + command.getValue().getDescription());
        }

        System.out.println("-------------------------------------------------------");
    }
}
