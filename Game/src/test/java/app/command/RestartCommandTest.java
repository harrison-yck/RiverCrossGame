package app.command;

import app.core.GameRuleValidator;
import app.data.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class RestartCommandTest {
    private GameState currentState;

    @BeforeEach
    void init() {
        MoveCharacterCommand moveCharacterCommand = new MoveCharacterCommand(new GameRuleValidator());
        currentState = moveCharacterCommand.execute(new GameState(), new String[]{"POLICEMAN", "CRIMINAL", "START_AREA", "BOAT_AREA"});
    }

    @Test
    void restartedCannotUndo() {
        currentState = new RestartCommand().execute(currentState, null);
        assertNull(new UndoCommand().execute(currentState, null));
    }

    @Test
    void restartedCannotRedo() {
        currentState = new UndoCommand().execute(currentState, null);
        currentState = new RestartCommand().execute(currentState, null);
        assertNull(new RedoCommand().execute(currentState, null));
    }
}
