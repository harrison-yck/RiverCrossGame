package app.data;

import app.character.Character;
import app.character.Identity;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author harrison
 */
public interface GameRule {
    boolean validate(GameState state);

    String detail(GameState state);

    default Set<Identity> getStartAreaCharacterIdentity(GameState state) {
        return Arrays.stream(state.startArea.characters()).map(Character::identity).collect(Collectors.toUnmodifiableSet());
    }

    default Set<Identity> getBoatAreaCharacterIdentity(GameState state) {
        return Arrays.stream(state.boatArea.characters()).map(Character::identity).collect(Collectors.toUnmodifiableSet());
    }

    default Set<Identity> getEndAreaCharacterIdentity(GameState state) {
        return Arrays.stream(state.endArea.characters()).map(Character::identity).collect(Collectors.toUnmodifiableSet());
    }
}
