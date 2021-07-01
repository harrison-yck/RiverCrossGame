package app.command;

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
