package app.command.factory;

import app.command.ReversibleCommand;

/**
 * @author harrison
 */
public interface ReversibleCommandFactory {
    ReversibleCommand createCommand();
}
