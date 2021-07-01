package app.rule;

import app.character.Identity;
import app.data.GameAreaView;
import app.data.GameState;

import java.util.Set;

/**
 * @author harrison
 */
public class MomRule implements GameRule {
    @Override
    public boolean isObeyed(GameState state) {
        return validate(state.getStartGameCharacterIdentity(state, GameAreaView.START_AREA)) && validate(state.getStartGameCharacterIdentity(state, GameAreaView.BOAT_AREA)) && validate(state.getStartGameCharacterIdentity(state, GameAreaView.END_AREA));
    }

    boolean validate(Set<Identity> identities) {
        return identities.isEmpty() || !identities.contains(Identity.MOM) || !identities.contains(Identity.SON) || (identities.contains(Identity.DAD) && identities.contains(Identity.SON));
    }

    @Override
    public String error() {
        return "Mom cannot be in the presence of son without Dad.";
    }
}
