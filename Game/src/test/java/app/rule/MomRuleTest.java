package app.rule;

import app.character.Identity;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MomRuleTest {
    @Test
    void validate() {
        MomRule momRule = new MomRule();

        assertTrue(momRule.validate(Set.of()));
        assertTrue(momRule.validate(Set.of(Identity.MOM, Identity.DAUGHTER, Identity.SON, Identity.DAD, Identity.CRIMINAL, Identity.POLICEMAN)));
        assertTrue(momRule.validate(Set.of(Identity.MOM, Identity.SON, Identity.DAD)));
        assertTrue(momRule.validate(Set.of(Identity.MOM, Identity.CRIMINAL)));
        assertTrue(momRule.validate(Set.of(Identity.DAUGHTER, Identity.DAD)));
        assertTrue(momRule.validate(Set.of(Identity.MOM, Identity.CRIMINAL)));
        assertTrue(momRule.validate(Set.of(Identity.MOM)));
        assertTrue(momRule.validate(Set.of(Identity.SON)));

        assertFalse(momRule.validate(Set.of(Identity.MOM, Identity.SON)));
    }
}
