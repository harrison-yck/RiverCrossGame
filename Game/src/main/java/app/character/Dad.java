package app.character;

/**
 * @author harrison
 */
public class Dad implements Character {
    @Override
    public boolean isAdult() {
        return true;
    }

    @Override
    public Identity identity() {
        return Identity.DAD;
    }
}
