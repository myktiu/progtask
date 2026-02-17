package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrapTextCommandTest {

    @Test
    void testConstructorRejectsNullOpening() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapTextCommand(null, "]"));
    }

    @Test
    void testConstructorRejectsNullEnd() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapTextCommand("[", null));
    }

    @Test
    void testGettersReturnCorrectValues() {
        WrapTextCommand cmd = new WrapTextCommand("<<", ">>");
        assertEquals("<<", cmd.getOpening());
        assertEquals(">>", cmd.getEnd());
    }

    @Test
    void testExecuteRejectsNullText() {
        WrapTextCommand cmd = new WrapTextCommand("[", "]");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testWrapsTextCorrectly() {
        WrapTextCommand cmd = new WrapTextCommand("[", "]");
        assertEquals("[hello]", cmd.execute("hello"));
    }

    @Test
    void testWrapsEmptyString() {
        WrapTextCommand cmd = new WrapTextCommand("<", ">");
        assertEquals("<>", cmd.execute(""));
    }

    @Test
    void testWrapsTextWithMultiCharacterDelimiters() {
        WrapTextCommand cmd = new WrapTextCommand("{{", "}}");
        assertEquals("{{text}}", cmd.execute("text"));
    }

    @Test
    void testWrapsTextContainingWhitespace() {
        WrapTextCommand cmd = new WrapTextCommand("(", ")");
        assertEquals("(hello world)", cmd.execute("hello world"));
    }
}
