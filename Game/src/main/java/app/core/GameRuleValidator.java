package app.core;

import app.data.GameRules;
import app.data.GameState;
import app.data.GameRule;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author harrison
 */
public class GameRuleValidator {
    private final Set<GameRule> rules;
    private final Printer printer;

    public GameRuleValidator(Printer printer) {
        this.rules = GameRules.get();
        this.printer = printer;
    }

    public boolean isValid(GameState state) {
        Set<GameRule> failedRules = rules.stream().takeWhile(rule -> !rule.validate(state)).collect(Collectors.toSet());

        if (!failedRules.isEmpty()) {
            failedRules.forEach(rule -> rule.detail(state));
            return false;
        }

        return true;
    }
}
