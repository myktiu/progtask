package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceFirstTextCommandTest {

    @Test
    void testConstructorRejectsNullTarget() {
        assertThrows(IllegalArgumentException.class,
                () -> new ReplaceFirstTextCommand(null, "x"));
    }

    @Test
    void testConstructorRejectsEmptyTarget() {
        assertThrows(IllegalArgumentException.class,
                () -> new ReplaceFirstTextCommand("", "x"));
    }

    @Test
    void testConstructorRejectsNullReplacement() {
        assertThrows(IllegalArgumentException.class,
                () -> new ReplaceFirstTextCommand("a", null));
    }

    @Test
    void testExecuteRejectsNullText() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("a", "b");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testReplacesOnlyFirstOccurrence() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("test", "done");
        assertEquals("done test test", cmd.execute("test test test"));
    }

    @Test
    void testNoMatchReturnsOriginalText() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("cat", "dog");
        assertEquals("hello world", cmd.execute("hello world"));
    }

    @Test
    void testRegexCharactersAreTreatedLiterally() {
        // Pattern.quote ensures "." is not treated as regex
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand(".", "DOT");
        assertEquals("DOTabc.def", cmd.execute(".abc.def"));
    }

    @Test
    void testReplacementCanBeEmpty() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("a", "");
        assertEquals("banana".replaceFirst("a", ""), cmd.execute("banana"));
        assertEquals("bnana", cmd.execute("banana"));
    }

    @Test
    void testOverlappingSubstringBehavior() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("ana", "X");
        assertEquals("bXna", cmd.execute("banana"));
    }
}
