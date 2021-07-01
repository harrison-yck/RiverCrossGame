package app.core;

import app.rule.GameRules;
import app.data.GameState;
import app.rule.GameRule;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author harrison
 */
public class GameRuleValidator {
    private final Set<GameRule> rules;

    public GameRuleValidator() {
        this.rules = GameRules.get();
    }

    public boolean isValid(GameState state) {
        Set<GameRule> failedRules = rules.stream().filter(rule -> !rule.isObeyed(state)).collect(Collectors.toSet());

        if (!failedRules.isEmpty()) {
            failedRules.forEach(failedRule -> System.out.println(failedRule.error()));
            return false;
        }

        return true;
    }
}
