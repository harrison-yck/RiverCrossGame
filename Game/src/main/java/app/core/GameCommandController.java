package app.core;

import app.command.Command;
import app.data.GameState;

import java.util.Map;

/**
 * @author harrison
 */
public class GameCommandController {
    private final Map<String, Command> commands;

    public GameCommandController(Map<String, Command> commands) {
        this.commands = commands;
    }

    public GameState execute(String commandString) throws NullPointerException {
        return commands.get(commandString).execute();
    }

    public void list() {
        System.out.println("Available Command(s): ");
        for (Map.Entry<String, Command> command : commands.entrySet()) {
            System.out.println(command.getKey() + ": " + command.getValue().getDescription());
        }
    }
}
