package app.rule;

import app.character.Character;
import app.data.GameState;

import java.util.List;

import static app.data.GameAreaView.BOAT_AREA;

/**
 * @author harrison
 */
public class BoatOperationRule implements GameRule {
    @Override
    public boolean isObeyed(GameState state) {
        return validate(state.getCharacters(BOAT_AREA));
    }

    boolean validate(List<Character> characters) {
        return characters.isEmpty() || characters.get(0) != null && characters.get(0).isAdult() || characters.size() > 1 && characters.get(1).isAdult();
    }

    @Override
    public String error() {
        return "Only adult can operate the boat";
    }
}
