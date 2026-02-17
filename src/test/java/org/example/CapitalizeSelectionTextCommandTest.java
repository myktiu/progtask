package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeSelectionTextCommandTest {

    @Test
    void testConstructorRejectsNullSelection() {
        assertThrows(IllegalArgumentException.class,
                () -> new CapitalizeSelectionTextCommand(null));
    }

    @Test
    void testConstructorRejectsEmptySelection() {
        assertThrows(IllegalArgumentException.class,
                () -> new CapitalizeSelectionTextCommand(""));
    }

    @Test
    void testGetSelectionReturnsOriginalValue() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");
        assertEquals("hello", cmd.getSelection());
    }

    @Test
    void testExecuteRejectsNullText() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testExecuteReplacesSelectionWithCapitalizedVersion() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");
        assertEquals("Hello world", cmd.execute("hello world"));
    }

    @Test
    void testExecuteReplacesMultipleOccurrences() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("test");
        assertEquals("Test Test Test", cmd.execute("test test test"));
    }

    @Test
    void testExecuteDoesNotAffectOtherWords() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("cat");
        assertEquals("Cat and dog", cmd.execute("cat and dog"));
    }

    @Test
    void testExecuteWhenSelectionIsAlreadyCapitalizedInText() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");
        assertEquals("Hello Hello", cmd.execute("Hello Hello"));
    }

    @Test
    void testExecuteNoMatch() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");
        assertEquals("world", cmd.execute("world"));
    }
}
