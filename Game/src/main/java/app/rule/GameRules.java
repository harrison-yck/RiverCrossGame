package app.rule;

import java.util.Set;

/**
 * @author harrison
 */
public class GameRules {
    private static final Set<GameRule> RULES = Set.of(
            new BoatOperationRule(),
            new CriminalRule(),
            new DadRule(),
            new MomRule()
    );

    public static Set<GameRule> get() {
        return RULES;
    }
}
