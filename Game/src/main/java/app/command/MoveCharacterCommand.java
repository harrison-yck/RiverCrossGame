package app.command;

import app.character.Character;
import app.character.Characters;
import app.character.Identity;
import app.core.GameRuleValidator;
import app.data.GameAreaView;
import app.data.GameState;
import app.data.GameStateMemento;

/**
 * @author harrison
 */
public class MoveCharacterCommand extends RevertableCommand {
    private final GameRuleValidator validator;

    public MoveCharacterCommand(GameRuleValidator validator) {
        this.validator = validator;
    }

    @Override
    public GameState execute(GameState state, String[] parameters) throws IllegalArgumentException, IndexOutOfBoundsException {
        Character firstCharacter = "null".equalsIgnoreCase(parameters[0]) ? null : Characters.of(Identity.valueOf(parameters[0].toUpperCase()));
        Character secondCharacter = "null".equalsIgnoreCase(parameters[1]) ? null : Characters.of(Identity.valueOf(parameters[1].toUpperCase()));
        GameAreaView fromArea = GameAreaView.valueOf(parameters[2].toUpperCase());
        GameAreaView toArea = GameAreaView.valueOf(parameters[3].toUpperCase());

        if (fromArea != GameAreaView.BOAT_AREA && toArea != GameAreaView.BOAT_AREA)
            throw new IllegalArgumentException();

        GameState newState = state.move(firstCharacter, secondCharacter, fromArea, toArea);

        if (validator.isValid(newState)) {
            memento = new GameStateMemento(state);
            undoList.push(this);
            return newState;
        }

        return null;
    }

    @Override
    public String getDescription() {
        return "Usage: move <CHARACTER1> <CHARACTER2> <FROM_AREA> <TO_AREA>, put null in <CHARACTER> if move one character only";
    }
}
