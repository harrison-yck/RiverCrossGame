package app.command;

import app.character.Character;
import app.character.Characters;
import app.character.Identity;
import app.data.GameArea;
import app.data.GameAreaView;
import app.data.GameState;

/**
 * @author harrison
 */
public class MoveCharacterCommand implements Command {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        Character character = Characters.of(Identity.valueOf(parameters[0]));
        GameAreaView fromArea = GameAreaView.valueOf(parameters[1]);
        GameAreaView toArea = GameAreaView.valueOf(parameters[2]);
        return state.move(character, fromArea, toArea);
    }

    @Override
    public String getDescription() {
        return "Usage: move <CHARACTER> <FROM_AREA> <TO_AREA>";
    }
}
