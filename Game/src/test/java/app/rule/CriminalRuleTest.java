package app.rule;

import app.character.Identity;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CriminalRuleTest {

    @Test
    void validate() {
        CriminalRule criminalRule = new CriminalRule();

        assertTrue(criminalRule.validate(Set.of()));
        assertTrue(criminalRule.validate(Set.of(Identity.CRIMINAL, Identity.POLICEMAN, Identity.DAD, Identity.MOM, Identity.DAUGHTER, Identity.SON)));
        assertTrue(criminalRule.validate(Set.of(Identity.CRIMINAL, Identity.POLICEMAN)));
        assertTrue(criminalRule.validate(Set.of(Identity.CRIMINAL)));
        assertTrue(criminalRule.validate(Set.of(Identity.POLICEMAN)));

        assertFalse(criminalRule.validate(Set.of(Identity.CRIMINAL, Identity.DAD, Identity.MOM, Identity.DAUGHTER, Identity.SON)));
        assertFalse(criminalRule.validate(Set.of(Identity.CRIMINAL, Identity.DAD)));
        assertFalse(criminalRule.validate(Set.of(Identity.CRIMINAL, Identity.MOM)));
        assertFalse(criminalRule.validate(Set.of(Identity.CRIMINAL, Identity.DAUGHTER)));
        assertFalse(criminalRule.validate(Set.of(Identity.CRIMINAL, Identity.SON)));
    }
}
