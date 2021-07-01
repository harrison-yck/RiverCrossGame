package app.core;

import app.command.Command;
import app.data.GameState;

import java.util.Arrays;
import java.util.Map;

/**
 * @author harrison
 */
public class GameCommandController {
    private final Map<String, Command> commands;

    public GameCommandController(Map<String, Command> commands) {
        this.commands = commands;
    }

    public GameState execute(String commandString, GameState state) throws NullPointerException {
        String[] inputs = commandString.split(" ");

        if (inputs[0].equals("help")) {
            list();
            return state;
        }

        try {
            return commands.get(inputs[0]).execute(state, Arrays.copyOfRange(inputs, 1, inputs.length - 1));
        } catch () {

        }
    }

    public void list() {
        System.out.println("Available Command(s): ");
        for (Map.Entry<String, Command> command : commands.entrySet()) {
            System.out.println(command.getKey() + " : " + command.getValue().getDescription());
        }
    }
}
