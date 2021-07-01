package app.rule;

import app.character.Identity;
import app.data.GameAreaView;
import app.data.GameState;

import java.util.Set;

/**
 * @author harrison
 */
public class CriminalRule implements GameRule {
    @Override
    public boolean isObeyed(GameState state) {
        return validate(state.getStartGameCharacterIdentity(state, GameAreaView.START_AREA)) && validate(state.getStartGameCharacterIdentity(state, GameAreaView.BOAT_AREA)) && validate(state.getStartGameCharacterIdentity(state, GameAreaView.END_AREA));
    }

    boolean validate(Set<Identity> identities) {
        return identities.isEmpty() || identities.size() == 1 || !identities.contains(Identity.CRIMINAL) || identities.contains(Identity.POLICEMAN);
    }

    @Override
    public String error() {
        return "Criminal cannot be alone with any of the family without the policeman";
    }
}
