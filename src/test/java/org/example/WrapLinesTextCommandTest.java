package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrapLinesTextCommandTest {

    @Test
    void testConstructorRejectsNullOpening() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapLinesTextCommand(null, "]"));
    }

    @Test
    void testConstructorRejectsNullEnd() {
        assertThrows(IllegalArgumentException.class,
                () -> new WrapLinesTextCommand("[", null));
    }

    @Test
    void testExecuteRejectsNullText() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("[", "]");
        assertThrows(IllegalArgumentException.class, () -> cmd.execute(null));
    }

    @Test
    void testWrapsSingleLine() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("[", "]");
        assertEquals("[hello]", cmd.execute("hello"));
    }

    @Test
    void testWrapsMultipleLines() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("<", ">");
        String input = "a\nb\nc";
        String expected = "<a>\n<b>\n<c>";
        assertEquals(expected, cmd.execute(input));
    }

    @Test
    void testPreservesEmptyLines() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("(", ")");
        String input = "line1\n\nline3";
        String expected = "(line1)\n()\n(line3)";
        assertEquals(expected, cmd.execute(input));
    }

    @Test
    void testEndsWithNewlineProducesWrappedEmptyLine() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("{", "}");
        String input = "hello\n";
        String expected = "{hello}\n{}";
        assertEquals(expected, cmd.execute(input));
    }

    @Test
    void testEmptyStringProducesSingleWrappedEmptyLine() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("[", "]");
        assertEquals("[]", cmd.execute(""));
    }

    @Test
    void testMultiCharacterDelimiters() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("<<", ">>");
        assertEquals("<<x>>\n<<y>>", cmd.execute("x\ny"));
    }
}
