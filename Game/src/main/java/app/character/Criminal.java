package app.character;

/**
 * @author harrison
 */
public class Criminal implements Character {
    @Override
    public boolean isAdult() {
        return true;
    }

    @Override
    public Identity identity() {
        return Identity.CRIMINAL;
    }

    @Override
    public String toString() {
        return identity().toString();
    }
}
