package app.character;

/**
 * @author harrison
 */
public class Policeman implements Character {
    @Override
    public boolean isAdult() {
        return true;
    }

    @Override
    public Identity identity() {
        return Identity.POLICEMAN;
    }
}
