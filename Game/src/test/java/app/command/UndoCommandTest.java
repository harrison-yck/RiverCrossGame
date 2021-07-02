package app.command;

import app.data.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class UndoCommandTest {
    @Test
    void noUndoOperation() {
        assertNull(new UndoCommand().execute(new GameState(), null));
    }
}
