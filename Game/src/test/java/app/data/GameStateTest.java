package app.data;

import app.character.Characters;
import app.character.Identity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameStateTest {
    private GameState state;

    @BeforeEach
    void init() {
        state = new GameState();
    }

    @Test
    void moveFromStartToBoat() {
        GameState actualState = state.move(Characters.of(Identity.POLICEMAN), Characters.of(Identity.CRIMINAL), GameAreaView.START_AREA, GameAreaView.BOAT_AREA);

        Map<GameAreaView, GameArea> gameArea = Map.of(
                GameAreaView.START_AREA, new GameArea(List.of(
                        Characters.of(Identity.DAD),
                        Characters.of(Identity.MOM),
                        Characters.of(Identity.SON),
                        Characters.of(Identity.SON),
                        Characters.of(Identity.DAUGHTER),
                        Characters.of(Identity.DAUGHTER)
                )),
                GameAreaView.BOAT_AREA, new GameArea(List.of(
                        Characters.of(Identity.POLICEMAN),
                        Characters.of(Identity.CRIMINAL)
                )),
                GameAreaView.END_AREA, new GameArea(List.of())
        );

        GameState expectedState = new GameState(gameArea, 1);
        assertThat(expectedState).usingRecursiveComparison().isEqualTo(actualState);
    }

    @Test
    void moveFromBoatToEnd() {
        state = state.move(Characters.of(Identity.POLICEMAN), Characters.of(Identity.CRIMINAL), GameAreaView.START_AREA, GameAreaView.BOAT_AREA);
        GameState actualState = state.move(Characters.of(Identity.POLICEMAN), Characters.of(Identity.CRIMINAL), GameAreaView.BOAT_AREA, GameAreaView.END_AREA);

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

        GameState expectedState = new GameState(gameArea, 2);
        assertThat(expectedState).usingRecursiveComparison().isEqualTo(actualState);
    }
}