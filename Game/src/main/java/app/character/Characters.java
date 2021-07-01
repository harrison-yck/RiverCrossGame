package app.character;

import java.util.Map;
import java.util.Set;

import static app.character.Identity.*;

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

    private static final Set<Identity> FAMILY = Set.of(DAD, MOM, SON, DAUGHTER);

    private static final Character[] DEFAULT_CHARACTERS = new Character[]{
            CHARACTERS.get(DAD),
            CHARACTERS.get(MOM),
            CHARACTERS.get(SON),
            CHARACTERS.get(SON),
            CHARACTERS.get(DAUGHTER),
            CHARACTERS.get(DAUGHTER),
            CHARACTERS.get(POLICEMAN),
            CHARACTERS.get(CRIMINAL)
    };

    public static Character[] getDefaultCharacter() {
        return DEFAULT_CHARACTERS;
    }

    public static Character of(Identity identity) {
        return CHARACTERS.get(identity);
    }

    public static boolean isFamilyMember(Identity identity) {
        return FAMILY.contains(identity);
    }
}
