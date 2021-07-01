package app.data;

import app.character.Character;

/**
 * @author harrison
 */
public class BoatOperationRule implements GameRule {
    @Override
    public boolean validate(GameState state) {
        Character[] characters = state.boat.characters();
        return characters[0].isAdult() && characters[1].isAdult();
    }

    @Override
    public String detail() {
        return "Only adult can operate the boat";
    }
}
