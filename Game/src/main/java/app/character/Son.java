package app.character;

/**
 * @author harrison
 */
public class Son implements Character {
    @Override
    public boolean isAdult() {
        return false;
    }

    @Override
    public Identity identity() {
        return Identity.SON;
    }
}
