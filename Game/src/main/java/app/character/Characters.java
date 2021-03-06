package app.character;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static app.character.Identity.CRIMINAL;
import static app.character.Identity.DAD;
import static app.character.Identity.DAUGHTER;
import static app.character.Identity.MOM;
import static app.character.Identity.POLICEMAN;
import static app.character.Identity.SON;

/**
 * @author harrison
 */
public class Characters {
    private static final Map<Identity, Character> CHARACTERS = Map.of(
            DAD, new Dad(),
            MOM, new Mom(),
            SON, new Son(),
            DAUGHTER, new Daughter(),
            POLICEMAN, new Policeman(),
            CRIMINAL, new Criminal()
    );

    private static final List<Character> DEFAULT_CHARACTERS = List.of(
            CHARACTERS.get(DAD),
            CHARACTERS.get(MOM),
            CHARACTERS.get(SON),
            CHARACTERS.get(SON),
            CHARACTERS.get(DAUGHTER),
            CHARACTERS.get(DAUGHTER),
            CHARACTERS.get(POLICEMAN),
            CHARACTERS.get(CRIMINAL)
    );

    public static List<Character> getDefaultCharacters() {
        return DEFAULT_CHARACTERS;
    }

    public static Set<Identity> getAvailableIdentity() {
        return CHARACTERS.keySet();
    }

    public static Character of(Identity identity) {
        return CHARACTERS.get(identity);
    }
}
