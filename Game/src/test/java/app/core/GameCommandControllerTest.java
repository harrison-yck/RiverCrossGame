package app.core;

import app.command.Commands;
import app.data.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class GameCommandControllerTest {
    private GameCommandController controller;

    @BeforeEach
    void init() {
        controller = new GameCommandController(Commands.getCommands(), Commands.getRevertableCommandFactortories(), new GameRuleValidator());
    }

    @Test
    void undoEmpty() {
        assertNull(controller.undoCommand(new GameState()));
    }

    @Test
    void redoEmpty() {
        assertNull(controller.redoCommand(new GameState()));
    }

    @Test
    void undo() {
        GameCommandController controller = new GameCommandController(Commands.getCommands(), Commands.getRevertableCommandFactortories(), new GameRuleValidator());
        GameState originalState = new GameState();

        GameState currentState = controller.execute("move POLICEMAN CRIMINAL START_AREA BOAT_AREA", originalState);
        currentState = controller.undoCommand(currentState);
        assertThat(currentState).usingRecursiveComparison().isEqualTo(originalState);
    }

    @Test
    void redo() {
        GameCommandController controller = new GameCommandController(Commands.getCommands(), Commands.getRevertableCommandFactortories(), new GameRuleValidator());
        GameState currentState = controller.execute("move POLICEMAN CRIMINAL START_AREA BOAT_AREA", new GameState());
        GameState secondState = currentState;

        currentState = controller.undoCommand(currentState);
        currentState = controller.redoCommand(currentState);

        assertThat(currentState).usingRecursiveComparison().isEqualTo(secondState);
    }

    @Test
    void restartedCannotUndo() {
        controller.execute("move POLICEMAN CRIMINAL START_AREA BOAT_AREA", new GameState());
        GameState currentState = controller.restartCommand();
        assertNull(controller.undoCommand(currentState));
    }

    @Test
    void restartedCannotRedo() {
        GameState currentState = controller.execute("move POLICEMAN CRIMINAL START_AREA BOAT_AREA", new GameState());
        currentState = controller.undoCommand(currentState);

        controller.restartCommand();
        assertNull(controller.undoCommand(currentState));
    }
}
