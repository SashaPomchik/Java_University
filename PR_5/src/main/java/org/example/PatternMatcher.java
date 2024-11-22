package org.example;

import lombok.Getter;

public class PatternMatcher {
    private static final int STATE_S = 0;
    private static final int STATE_1 = 1;
    private static final int STATE_2 = 2;
    private static final int STATE_3 = 3;
    private static final int STATE_F = 4;

    @Getter
    private int currentState;
    private boolean matchFound;

    public PatternMatcher() {
        reset();
    }

    public void reset() {
        currentState = STATE_S;
        matchFound = false;
    }

    public int processSymbol(char inputSymbol) {
        if (matchFound) {
            return currentState;
        }

        switch (currentState) {
            case STATE_S -> {
                if (inputSymbol == 'T') {
                    currentState = STATE_1;
                } else {
                    currentState = STATE_S;
                }
            }
            case STATE_1 -> {
                if (inputSymbol == 'E') {
                    currentState = STATE_2;
                } else {
                    currentState = STATE_S;
                }
            }
            case STATE_2 -> {
                if (inputSymbol == 'S') {
                    currentState = STATE_3;
                } else {
                    currentState = STATE_S;
                }
            }
            case STATE_3 -> {
                if (inputSymbol == 'T') {
                    currentState = STATE_F;
                    matchFound = true;
                } else {
                    currentState = STATE_S;
                }
            }
            case STATE_F -> {
            }
        }
        return currentState;
    }

    public boolean isMatchDetected() {
        return matchFound;
    }
}
