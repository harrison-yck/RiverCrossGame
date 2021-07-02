package app.command.factory;

import app.command.Command;
import app.command.MoveCharacterCommand;
import app.core.GameRuleValidator;

/**
 * @author harrison
 */
public class MoveCharacterCommandFactory implements RevertableCommandFactory {
    private final GameRuleValidator gameRuleValidator = new GameRuleValidator();

    @Override
    public Command createCommand() {
        return new MoveCharacterCommand(gameRuleValidator);
    }
}
