package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeWordsTextCommandTest {
    private final CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
    @Test
    void testNullInput() {
        assertNull(command.execute(null));
    }
    @Test
    void testEmptyString() {
        assertEquals("", command.execute(""));
    }
    @Test
    void testSingleWord() {
        assertEquals("Hello", command.execute("hello"));
    }
    @Test
    void testMultipleWords() {
        assertEquals("Hello World", command.execute("hello world")); }

    @Test
    void testNewLines() {
        String input = "hello\nworld"; String expected = "Hello\nWorld"; assertEquals(expected, command.execute(input));}
    @Test
    void testMixedWhitespace() {
        String input = "hello\nworld test\njava"; String expected = "Hello\nWorld Test\nJava"; assertEquals(expected, command.execute(input)); }

    @Test void testAlreadyCapitalized() {
        assertEquals("Hello World", command.execute("Hello World")); }
}