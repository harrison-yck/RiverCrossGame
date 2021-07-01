package app.core;

import app.data.GameState;
import app.data.GameRule;

import java.util.List;

/**
 * @author harrison
 */
public class GameRuleValidator {
    private final List<GameRule> rules;
    private final Printer printer;

    public GameRuleValidator(List<GameRule> rules, Printer printer) {
        this.rules = rules;
        this.printer = printer;
    }

    public boolean isValid(GameState state) {
        if (!rules.stream().allMatch(rule -> rule.validate(state))) {
//            printer;
            return false;
        }

        return true;
    }
}
