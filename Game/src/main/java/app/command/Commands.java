package app.command;


import app.command.factory.MoveCharacterCommandFactory;
import app.command.factory.ReversibleCommandFactory;

import java.util.Map;

/**
 * @author harrison
 */
public class Commands {
    // key = command alias
    private static final Map<String, Command> COMMANDS = Map.of(
    );

    private static final Map<String, ReversibleCommandFactory> REVERSIBLE_COMMANDS = Map.of(
        "move", new MoveCharacterCommandFactory()
    );

    public static Map<String, Command> getCommands() {
        return COMMANDS;
    }

    public static Map<String, ReversibleCommandFactory> getReversibleCommandFactories() {
        return REVERSIBLE_COMMANDS;
    }
}
