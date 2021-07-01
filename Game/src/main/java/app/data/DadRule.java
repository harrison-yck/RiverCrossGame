package app.data;

import app.character.Character;
import app.character.Identity;

import java.util.Set;


/**
 * @author harrison
 */
public class DadRule implements GameRule {
    @Override
    public boolean validate(GameState state) {
        return validate(getStartAreaCharacterIdentity(state)) && validate(getBoatAreaCharacterIdentity(state)) && validate(getEndAreaCharacterIdentity(state));
    }

    private boolean validate(Set<Identity> identities) {
        return identities.contains(Identity.DAD) && identities.contains(Identity.DAUGHTER) && !identities.contains(Identity.MOM);
    }

    @Override
    public String detail(GameState state) {
        return null;
    }
}
