package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PatternMatcherTest {

    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "'123T456', 0",
            "'T', 1",
            "'TEX', 0",
            "'TES', 3",
            "'TE', 2",
            "'TEST', 4",
            "'TESTING', 4",
            "'TESTER', 4",
            "'TESTX', 4",
            "'TES123', 0",
            "'SOMETEST', 4",
            "'TESTABCTES', 4",
            "'ABCTEST', 4",
            "'TEXABC', 0",
            "'TESTTT', 4",
            "'TTTEST', 4",
            "'TESST', 1",
            "'TEEST', 1",
            "'TESTX', 4"
    })
    void testPatternMatcher(String input, int expectedState) {
        PatternMatcher matcher = new PatternMatcher();

        for (char symbol : input.toCharArray()) {
            matcher.processSymbol(symbol);
        }

        assertEquals(expectedState, matcher.getCurrentState());
    }
}
