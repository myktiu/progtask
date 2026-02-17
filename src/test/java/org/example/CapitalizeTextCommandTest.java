package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeTextCommandTest {

    private final CapitalizeTextCommand command = new CapitalizeTextCommand();

    @Test
    void testNullInput() {
        assertNull(command.execute(null));
    }

    @Test
    void testEmptyString() {
        assertEquals("", command.execute(""));
    }

    @Test
    void testSingleLowercaseWord() {
        assertEquals("Hello", command.execute("hello"));
    }

    @Test
    void testSingleUppercaseWord() {
        assertEquals("Hello", command.execute("Hello"));
    }

    @Test
    void testFirstCharacterOnlyCapitalized() {
        assertEquals("Hello world", command.execute("hello world"));
    }

    @Test
    void testNonLetterFirstCharacter() {
        assertEquals("1test", command.execute("1test"));
    }

    @Test
    void testWhitespaceAtStart() {
        // Leading whitespace stays; only first character of the string is considered
        assertEquals(" hello", command.execute(" hello"));
    }

    @Test
    void testAlreadyCapitalizedSentence() {
        assertEquals("Hello World", command.execute("Hello World"));
    }
}
