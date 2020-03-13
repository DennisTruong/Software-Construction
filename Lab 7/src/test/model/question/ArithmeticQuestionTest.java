package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ArithmeticQuestionTest extends QuestionTest {
    private ArithmeticQuestion additionQuestion;
    private ArithmeticQuestion subtractionQuestion;
    private ArithmeticQuestion multiplicationQuestion;



    @BeforeEach
    void runBefore() {
        additionQuestion = new ArithmeticQuestion(5, ArithmeticQuestion.Operation.ADDITION,
                10, 5);
        subtractionQuestion = new ArithmeticQuestion(10, ArithmeticQuestion.Operation.SUBTRACTION,
                10, 5);
        multiplicationQuestion = new ArithmeticQuestion(50, ArithmeticQuestion.Operation.MULTIPLICATION,
                10, 5);
        question = additionQuestion;
    }

    @Test
    void testConstructor() {
        question = additionQuestion;
        assertEquals(5, additionQuestion.getMaxMark());
        question = subtractionQuestion;
        assertEquals(10, subtractionQuestion.getMaxMark());
        question = multiplicationQuestion;
        assertEquals(50, multiplicationQuestion.getMaxMark());
    }

    @Test
    void testAdditionQuestionString() {
        question = additionQuestion;
        assertEquals("What is 10 + 5 ? [5 points]", additionQuestion.getQuestionString());
        question = subtractionQuestion;
        assertEquals("What is 10 - 5 ? [10 points]", subtractionQuestion.getQuestionString());
        question = multiplicationQuestion;
        assertEquals("What is 10 * 5 ? [50 points]", multiplicationQuestion.getQuestionString());


    }

    @Test
    void testCheckAdditionAnswerCorrect() {
        question = additionQuestion;
        assertTrue(additionQuestion.isCorrect("15"));
    }

    @Test
    void testCheckAdditionAnswerIncorrect() {
        question = additionQuestion;
        assertFalse(additionQuestion.isCorrect("10"));
    }


    @Test
    void testCheckSubtractionAnswerCorrect() {
        question = subtractionQuestion;
        assertTrue(subtractionQuestion.isCorrect("5"));
    }

    @Test
    void testCheckSubtractionAnswerIncorrect() {
        question = subtractionQuestion;
        assertFalse(subtractionQuestion.isCorrect("10"));
    }

    ///////

    @Test
    void testCheckMultiplicationAnswerCorrect() {
        question = multiplicationQuestion;
        assertTrue(multiplicationQuestion.isCorrect("50"));
    }

    @Test
    void testCheckMultiplicationAnswerIncorrect() {
        question = multiplicationQuestion;
        assertFalse(multiplicationQuestion.isCorrect("500"));
    }



}
