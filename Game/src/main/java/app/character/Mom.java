package app.character;

import com.sun.tools.javah.Gen;

/**
 * @author harrison
 */
public class Mom implements Character {
    @Override
    public boolean isAdult() {
        return true;
    }

    @Override
    public Gender gender() {
        return Gender.GIRL;
    }

    @Override
    public Identity identity() {
        return null;
    }
}
