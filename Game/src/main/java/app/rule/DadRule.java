package app.rule;

import app.character.Identity;
import app.data.GameAreaView;
import app.data.GameState;

import java.util.Set;


/**
 * @author harrison
 */
public class DadRule implements GameRule {
    @Override
    public boolean isObeyed(GameState state) {
        return validate(state.getStartGameCharacterIdentity(state, GameAreaView.START_AREA)) && validate(state.getStartGameCharacterIdentity(state, GameAreaView.BOAT_AREA)) && validate(state.getStartGameCharacterIdentity(state, GameAreaView.END_AREA));
    }

    boolean validate(Set<Identity> identities) {
        return identities.isEmpty() || !identities.contains(Identity.DAD) || !identities.contains(Identity.DAUGHTER) || identities.contains(Identity.MOM);
    }

    @Override
    public String error() {
        return "Dad cannot be in the presence of daughter without Mom";
    }
}
