package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PatternMatcherTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> provideTestCases() {
        return Stream.of(
                of("", 0),
                of("T", 1),
                of("TE", 2),
                of("TES", 3),
                of("TEST", 4),
                of("TTEST", 4),
                of("TESTER", 4),
                of("123T456", 0),
                of("TESTTT", 4),
                of("TTTEST", 4),
                of("TESST", 1),
                of("TEX", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testPatternMatcher(String input, int expectedState) {
        PatternMatcher matcher = new PatternMatcher();

        for (char symbol : input.toCharArray()) {
            matcher.processSymbol(symbol);
        }

        assertEquals(expectedState, matcher.getCurrentState());
    }
}
