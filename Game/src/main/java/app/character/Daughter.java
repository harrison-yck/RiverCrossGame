package app.character;

/**
 * @author harrison
 */
public class Daughter implements Character {
    @Override
    public boolean isAdult() {
        return false;
    }

    @Override
    public Identity identity() {
        return Identity.DAUGHTER;
    }
}
