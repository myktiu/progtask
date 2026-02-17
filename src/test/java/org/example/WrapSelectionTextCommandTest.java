package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrapSelectionTextCommandTest {

    @Test
    void testConstructorRejectsNullOpening() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapSelectionTextCommand(null, "]", "hello"));
    }

    @Test
    void testConstructorRejectsNullEnd() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapSelectionTextCommand("[", null, "hello"));
    }

    @Test
    void testConstructorRejectsNullSelection() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapSelectionTextCommand("[", "]", null));
    }

    @Test
    void testConstructorRejectsEmptySelection() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapSelectionTextCommand("[", "]", ""));
    }

    @Test
    void testGetSelectionReturnsCorrectValue() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("(", ")", "cat");
        assertEquals("cat", cmd.getSelection());
    }

    @Test
    void testExecuteRejectsNullText() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("[", "]", "hello");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testWrapsSingleOccurrence() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("[", "]", "hello");
        assertEquals("[hello] world", cmd.execute("hello world"));
    }

    @Test
    void testWrapsMultipleOccurrences() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<", ">", "test");
        assertEquals("<test> <test> <test>", cmd.execute("test test test"));
    }

    @Test
    void testNoMatchReturnsOriginalText() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("{", "}", "cat");
        assertEquals("hello world", cmd.execute("hello world"));
    }

    @Test
    void testWrapsSelectionInsideLargerWords() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("(", ")", "ana");
        assertEquals("b(ana)na", cmd.execute("banana"));
    }

    @Test
    void testWrapsEmptyText() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("[", "]", "x");
        assertEquals("", cmd.execute(""));
    }
}
