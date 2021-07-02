package app.rule;

import app.character.Character;
import app.character.Characters;
import app.character.Identity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoatOperationRuleTest {

    @Test
    void validate() {
        BoatOperationRule boatOperationRule = new BoatOperationRule();

        Character dad = Characters.of(Identity.DAD);
        Character mom = Characters.of(Identity.MOM);
        Character son = Characters.of(Identity.SON);
        Character daughter = Characters.of(Identity.DAUGHTER);
        Character criminal = Characters.of(Identity.CRIMINAL);
        Character police = Characters.of(Identity.POLICEMAN);

        assertTrue(boatOperationRule.validate(List.of()));
        assertTrue(boatOperationRule.validate(List.of(dad)));
        assertTrue(boatOperationRule.validate(List.of(mom)));
        assertTrue(boatOperationRule.validate(List.of(criminal)));
        assertTrue(boatOperationRule.validate(List.of(police)));

        assertTrue(boatOperationRule.validate(List.of(dad, son)));
        assertTrue(boatOperationRule.validate(List.of(dad, daughter)));
        assertTrue(boatOperationRule.validate(List.of(mom, son)));
        assertTrue(boatOperationRule.validate(List.of(mom, daughter)));
        assertTrue(boatOperationRule.validate(List.of(dad, mom)));
        assertTrue(boatOperationRule.validate(List.of(police, criminal)));
        assertTrue(boatOperationRule.validate(List.of(son, criminal)));
        assertTrue(boatOperationRule.validate(List.of(daughter, criminal)));

        assertFalse(boatOperationRule.validate(List.of(son)));
        assertFalse(boatOperationRule.validate(List.of(daughter)));
        assertFalse(boatOperationRule.validate(List.of(son, son)));
        assertFalse(boatOperationRule.validate(List.of(daughter, daughter)));
        assertFalse(boatOperationRule.validate(List.of(son, daughter)));
    }
}
