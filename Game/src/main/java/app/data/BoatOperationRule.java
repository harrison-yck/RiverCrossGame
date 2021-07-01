package app.data;

import app.character.Character;

/**
 * @author harrison
 */
public class BoatOperationRule implements GameRule {
    @Override
    public boolean validate(GameState state) {
        Character[] characters = state.boatArea.characters();
        return characters.length < 2 || characters[0].isAdult() && characters[1].isAdult();
    }

    @Override
    public String detail(GameState state) {
        Character[] characters = state.boatArea.characters();
        return String.format("Only adult can operate the boat, provided={%s, %s}", characters[0], characters[1]);
    }
}
