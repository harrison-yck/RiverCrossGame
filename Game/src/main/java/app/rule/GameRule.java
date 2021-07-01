package app.rule;

import app.character.Character;
import app.character.Identity;
import app.data.GameAreaView;
import app.data.GameState;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static app.data.GameAreaView.*;

/**
 * @author harrison
 */
public interface GameRule {
    boolean isObeyed(GameState state);

    String error();
}
