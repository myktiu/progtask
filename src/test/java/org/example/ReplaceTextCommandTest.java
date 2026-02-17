package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceTextCommandTest {

    @Test
    void testConstructorRejectsNullTarget() {
        assertThrows(IllegalArgumentException.class,
                () -> new ReplaceTextCommand(null, "x"));
    }

    @Test
    void testConstructorRejectsEmptyTarget() {
        assertThrows(IllegalArgumentException.class,
                () -> new ReplaceTextCommand("", "x"));
    }

    @Test
    void testConstructorRejectsNullReplacement() {
        assertThrows(IllegalArgumentException.class,
                () -> new ReplaceTextCommand("a", null));
    }

    @Test
    void testGettersReturnCorrectValues() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("cat", "dog");
        assertEquals("cat", cmd.getTarget());
        assertEquals("dog", cmd.getReplacement());
    }

    @Test
    void testExecuteRejectsNullText() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("a", "b");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testExecuteReplacesSingleOccurrence() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("hello", "hi");
        assertEquals("hi world", cmd.execute("hello world"));
    }

    @Test
    void testExecuteReplacesMultipleOccurrences() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("test", "done");
        assertEquals("done done done", cmd.execute("test test test"));
    }

    @Test
    void testExecuteNoMatchReturnsOriginalText() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("cat", "dog");
        assertEquals("hello world", cmd.execute("hello world"));
    }

    @Test
    void testExecuteAllowsEmptyReplacement() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("a", "");
        assertEquals("bnn", cmd.execute("banana"));
    }
}
