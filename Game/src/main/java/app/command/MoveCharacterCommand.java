package app.command;

import app.character.Character;
import app.character.Characters;
import app.character.Identity;
import app.data.GameAreaView;
import app.data.GameState;

import java.util.Locale;

/**
 * @author harrison
 */
public class MoveCharacterCommand extends ReversibleCommand {
    @Override
    public GameState execute(GameState state, String[] parameters) {
        Character firstCharacter = "null".equalsIgnoreCase(parameters[0]) ? null : Characters.of(Identity.valueOf(parameters[0].toUpperCase(Locale.ENGLISH)));
        Character secondCharacter = "null".equalsIgnoreCase(parameters[1]) ? null : Characters.of(Identity.valueOf(parameters[1].toUpperCase(Locale.ENGLISH)));
        GameAreaView fromArea = GameAreaView.valueOf(parameters[2].toUpperCase(Locale.ENGLISH));
        GameAreaView toArea = GameAreaView.valueOf(parameters[3].toUpperCase(Locale.ENGLISH));

        if (fromArea != GameAreaView.BOAT_AREA && toArea != GameAreaView.BOAT_AREA) throw new IllegalArgumentException();

        return state.move(firstCharacter, secondCharacter, fromArea, toArea);
    }

    @Override
    public String getDescription() {
        return "Usage: move <CHARACTER1> <CHARACTER2> <FROM_AREA> <TO_AREA>, put null in <CHARACTER> if move one character only";
    }
}
