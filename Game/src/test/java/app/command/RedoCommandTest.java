package app.command;

import app.data.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedoCommandTest {
    @Test
    void noRedoOperation() {
        assertNull(new RedoCommand().execute(new GameState(), null));
    }
}
