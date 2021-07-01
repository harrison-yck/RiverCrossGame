package app.command;

import app.core.GameRuleValidator;

import java.util.Map;

/**
 * @author harrison
 */
public class Commands {
    // key = command alias
    private static final Map<String, Command> AVAILABLE_COMMANDS = Map.of(
        "undo", new UndoCommand(),
        "redo", new RedoCommand(),
        "restart", new RestartCommand()
    );

    private static final Map<String, RevertableCommandFactory> REVERTABLE_COMMANDS = Map.of(
        "move", new MoveCharacterCommandFactory()
    );

    public static Map<String, Command> getCommands() {
        return AVAILABLE_COMMANDS;
    }

    public static Map<String, RevertableCommandFactory> getRevertableCommandFactortories() {
        return REVERTABLE_COMMANDS;
    }
}
