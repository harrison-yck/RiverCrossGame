package app.character;

/**
 * @author harrison
 */
public class Mom implements Character {
    @Override
    public boolean isAdult() {
        return true;
    }

    @Override
    public Identity identity() {
        return Identity.MOM;
    }

    @Override
    public String toString() {
        return identity().toString();
    }
}
