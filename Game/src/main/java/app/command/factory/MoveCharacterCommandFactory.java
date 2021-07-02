package app.command.factory;

import app.command.MoveCharacterCommand;
import app.command.ReversibleCommand;

/**
 * @author harrison
 */
public class MoveCharacterCommandFactory implements ReversibleCommandFactory {
    @Override
    public ReversibleCommand createCommand() {
        return new MoveCharacterCommand();
    }
}
