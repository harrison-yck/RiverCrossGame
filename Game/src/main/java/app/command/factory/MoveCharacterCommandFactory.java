package app.command.factory;

import app.command.MoveCharacterCommand;
import app.command.ReversibleCommand;
import app.core.GameRuleValidator;

/**
 * @author harrison
 */
public class MoveCharacterCommandFactory implements ReversibleCommandFactory {
    private final GameRuleValidator gameRuleValidator = new GameRuleValidator();

    @Override
    public ReversibleCommand createCommand() {
        return new MoveCharacterCommand(gameRuleValidator);
    }
}
