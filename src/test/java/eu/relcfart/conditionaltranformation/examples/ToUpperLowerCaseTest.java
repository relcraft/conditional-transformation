package eu.relcfart.conditionaltranformation.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToUpperLowerCaseTest {
    @Test
    void firstCharUpperCaseChangesWholeStringToUpperCase() {
        String changed = ToUpperLowerCase.change("Aaa");
        assertEquals("AAA", changed);
    }

    @Test
    void firstCharLowerCaseChangesWholeStringToLowerCase() {
        String changed = ToUpperLowerCase.change("aAA");
        assertEquals("aaa", changed);
    }

    @Test
    void firstCharNeitherUpperNorLowerNoChangeToWholeString() {
        String tested = "1aAa";
        String changed = ToUpperLowerCase.change(tested);
        assertEquals(tested, changed);
    }

    @Test
    void nullMeansNull() {
        String changed = ToUpperLowerCase.change(null);
        assertNull(changed);
    }

    @Test
    void noChangeToEmptyString() {
        String changed = ToUpperLowerCase.change("");
        assertEquals("", changed);
    }
}