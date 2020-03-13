package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnlimitedTriesQuizTest extends QuizTest {

    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        quiz = new UnlimitedTriesQuiz(questionList);
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals(6 , quiz.getMaxMark());
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
            assertEquals("It took you 2 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (Exception e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitSomeWrongAnswers() {
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
                String feedback = quiz.submitAnswer("Canada");
                assertEquals("Correct!", feedback);
                assertEquals(6, quiz.getMarkSoFar());
                assertFalse(quiz.hasMoreQuestions());
                assertEquals("It took you 3 attempts to answer 2 questions correctly.", quiz.endQuiz());
            } catch (Exception e1) {
                fail("No exception to be thrown");
            }

        }  catch (OutOfTriesException e) {
            fail("Should not throw OutOfTriesException during UnlimitedTries Quiz");
        }

    }

}
