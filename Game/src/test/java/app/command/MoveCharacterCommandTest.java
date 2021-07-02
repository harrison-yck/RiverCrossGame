package app.command;


import app.character.Characters;
import app.character.Identity;
import app.core.GameRuleValidator;
import app.data.GameArea;
import app.data.GameAreaView;
import app.data.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MoveCharacterCommandTest {
    private GameState firstState;
    private MoveCharacterCommand command;

    @BeforeEach
    void init() {
        firstState = new GameState().move(Characters.of(Identity.POLICEMAN), Characters.of(Identity.CRIMINAL), GameAreaView.START_AREA, GameAreaView.BOAT_AREA);
        command = new MoveCharacterCommand(new GameRuleValidator());
    }

    @Test
    void execute() {
        Map<GameAreaView, GameArea> gameArea = Map.of(
                GameAreaView.START_AREA, new GameArea(List.of(
                        Characters.of(Identity.DAD),
                        Characters.of(Identity.MOM),
                        Characters.of(Identity.SON),
                        Characters.of(Identity.SON),
                        Characters.of(Identity.DAUGHTER),
                        Characters.of(Identity.DAUGHTER)
                )),
                GameAreaView.BOAT_AREA, new GameArea(List.of()),
                GameAreaView.END_AREA, new GameArea(List.of(
                        Characters.of(Identity.POLICEMAN),
                        Characters.of(Identity.CRIMINAL)
                ))
        );

        GameState secondState = new GameState(gameArea, 2);

        GameState executedState = command.execute(firstState, new String[]{"POLICEMAN", "CRIMINAL", "BOAT_AREA", "END_AREA"});
        assertThat(executedState).usingRecursiveComparison().isEqualTo(secondState);
    }

    @Test
    void undo() {
        GameState currentState = command.execute(firstState, new String[]{"POLICEMAN", "CRIMINAL", "BOAT_AREA", "END_AREA"});

        currentState = command.undo(currentState);

        assertThat(currentState).usingRecursiveComparison().isEqualTo(firstState);
    }

    @Test
    void redo() {
        GameState currentState = command.execute(firstState, new String[]{"POLICEMAN", "CRIMINAL", "BOAT_AREA", "END_AREA"});
        GameState secondState = currentState;

        currentState = command.undo(currentState);
        currentState = command.redo(currentState);

        assertThat(currentState).isEqualTo(secondState);
    }
}