package app.command.factory;

import app.command.Command;

/**
 * @author harrison
 */
public interface RevertableCommandFactory {
    Command createCommand();
}
