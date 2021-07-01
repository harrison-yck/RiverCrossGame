package app.data;

import app.character.Character;

/**
 * @author harrison
 */
public class GameState {
    private static final int TOTAL_PEOPLE = 8;
    private static final int BOAT_CAPACITY = 2;

    private final boolean isEnded;

    GameArea startArea;
    GameArea boat;
    GameArea endArea;

    public GameState() {
        this(false, new GameArea(new Character[TOTAL_PEOPLE]), new GameArea(new Character[BOAT_CAPACITY]), new GameArea(new Character[TOTAL_PEOPLE]));
        startArea = initState();
    }

    public GameState(boolean isEnded, GameArea startArea, GameArea boat, GameArea endArea) {
        this.isEnded = isEnded;
        this.startArea = startArea;
        this.boat = boat;
        this.endArea = endArea;
    }

    public boolean isEnded() {
        return isEnded;
    }

    private GameArea initState() {
        return null;
    }
}
