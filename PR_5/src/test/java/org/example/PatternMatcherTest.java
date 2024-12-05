package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class PatternMatcherTest {

    @ParameterizedTest
    @ArgumentsSource(PatternMatcherSource.class)
    void testPatternMatcher(String input, int expectedState) {
        PatternMatcher matcher = new PatternMatcher();

        for (char symbol : input.toCharArray()) {
            matcher.processSymbol(symbol);
        }

        assertEquals(expectedState, matcher.getCurrentState());
    }
}
