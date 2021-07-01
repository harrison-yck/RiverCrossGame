package app.data;

import java.util.Set;

/**
 * @author harrison
 */
public class GameRules {
    private static final Set<GameRule> RULES = Set.of(new BoatOperationRule(), new DadRule());

    public static Set<GameRule> get() {
        return RULES;
    }
}
