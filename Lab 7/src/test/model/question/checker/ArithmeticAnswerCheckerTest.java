package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticAnswerCheckerTest {
    private ArithmeticAnswerChecker arithmeticAnswerChecker;

    @BeforeEach
    void runBefore() {
        arithmeticAnswerChecker =  new ArithmeticAnswerChecker(10);
    }

    @Test
    void correctAnswerTest() {
        assertTrue(arithmeticAnswerChecker.checkAnswer("10"));
    }

    @Test
    void incorrectAnswerTest() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("5"));
    }

    @Test
    void doubleAnswerTest() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("10.0"));
    }

    @Test
    void wordAnswerTest() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("ten"));
    }


}
