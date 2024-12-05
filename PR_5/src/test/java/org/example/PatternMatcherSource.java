package org.example;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.stream.Stream;

public class PatternMatcherSource implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("T", 1),
                Arguments.of("TE", 2),
                Arguments.of("TES", 3),
                Arguments.of("TEST", 4),
                Arguments.of("TESTER", 4),
                Arguments.of("123T456", 0),
                Arguments.of("TESTTT", 4),
                Arguments.of("TTTEST", 4),
                Arguments.of("TESST", 1),
                Arguments.of("TEX", 0)
        );
    }
}
