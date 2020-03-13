package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LimitedTriesQuizTest extends QuizTest {

    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        quiz = new LimitedTriesQuiz(questionList);
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals(6, quiz.getMaxMark());
    }

    @Test
    void testSubmitAnswerAllCorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 6 out of 6", quiz.endQuiz());
        } catch (Exception e) {
            fail("Should not have thrown exception.");
        }
    }


    @Test
    void testAllAttemptsUsed() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("USA");
            fail("Should throw AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {
            assertEquals(4, quiz.getMarkSoFar());

            try {
                String feedback = quiz.submitAnswer("USA");
                fail("Should throw OutOfTriesException");
            } catch (AnswerIncorrectException ex) {
                fail("Out of attempts, should throw OutOfTriesException");
            } catch (OutOfTriesException ex) {
                assertEquals(4, quiz.getMarkSoFar());
                assertFalse(quiz.hasMoreQuestions());
                assertEquals("Your final mark is: 4 out of 6", quiz.endQuiz());            }

        } catch (OutOfTriesException e) {
            fail("Still have one more attempt");
        }
    }


}
