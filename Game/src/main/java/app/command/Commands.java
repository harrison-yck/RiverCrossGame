package app.command;

import java.util.Map;

/**
 * @author harrison
 */
public class Commands {
    private static final Map<String, Command> AVAILABLE_COMMANDS = Map.of(

    );

    public static Map<String, Command> get() {
        return AVAILABLE_COMMANDS;
    }
}
