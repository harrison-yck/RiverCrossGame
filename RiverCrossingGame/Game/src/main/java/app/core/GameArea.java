package app.core;

import app.character.Character;

/**
 * @author harrison
 */
public class GameArea {
    private final Character[] characters;

    public GameArea(int maxCapacity) {
        this.characters = new Character[maxCapacity];
    }
}
