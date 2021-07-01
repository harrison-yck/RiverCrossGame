package app.data;

import app.character.Character;
import app.character.Characters;

/**
 * @author harrison
 */
public class GameState {
    private static final int TOTAL_PEOPLE = 8;
    private static final int BOAT_CAPACITY = 2;

    private final boolean isEnded;

    final GameArea startArea;
    final GameArea boatArea;
    final GameArea endArea;

    public GameState() {
        this(false, new GameArea(Characters.getDefaultCharacter()), new GameArea(new Character[BOAT_CAPACITY]), new GameArea(new Character[TOTAL_PEOPLE]));
    }

    public GameState(boolean isEnded, GameArea startArea, GameArea boatArea, GameArea endArea) {
        this.isEnded = isEnded;
        this.startArea = startArea;
        this.boatArea = boatArea;
        this.endArea = endArea;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public GameState move(Character character, GameAreaView fromArea, GameAreaView toArea) {

    }
}
