package app.rule;

import app.character.Identity;
import app.rule.DadRule;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DadRuleTest {
    @Test
    void validate() {
        DadRule dadRule = new DadRule();

        assertTrue(dadRule.validate(Set.of()));
        assertTrue(dadRule.validate(Set.of(Identity.DAD, Identity.DAUGHTER, Identity.SON, Identity.MOM, Identity.CRIMINAL, Identity.POLICEMAN)));
        assertTrue(dadRule.validate(Set.of(Identity.DAD, Identity.DAUGHTER, Identity.MOM)));
        assertTrue(dadRule.validate(Set.of(Identity.DAD, Identity.CRIMINAL)));
        assertTrue(dadRule.validate(Set.of(Identity.SON, Identity.MOM)));
        assertTrue(dadRule.validate(Set.of(Identity.DAD, Identity.CRIMINAL)));
        assertTrue(dadRule.validate(Set.of(Identity.DAD)));
        assertTrue(dadRule.validate(Set.of(Identity.DAUGHTER)));

        assertFalse(dadRule.validate(Set.of(Identity.DAD, Identity.DAUGHTER)));
    }
}