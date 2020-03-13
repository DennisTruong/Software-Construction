package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.Question;
import model.question.QuestionList;

public class LimitedTriesQuiz extends Quiz {
    int questionScore;

    public LimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    @Override
    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // if the answer is incorrect, decrements the max mark of the current question by one;
    // throws AnswerIncorrectException if the user should re-try the question
    // throws an OutOfTriesException if the answer is incorrect and no more
    // attempts are allowed
    public String submitAnswer(String answer) throws AnswerIncorrectException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);

        if (!correct) {
            questionScore = curQuestion.getMaxMark() - 1;
            curQuestion.setMaxMark(questionScore);
            if (questionScore <= 0) {
                throw new OutOfTriesException("Answered incorrectly too many times.");
            } else {
                throw new AnswerIncorrectException("Incorrect answer");
            }
        }
        return "Correct!";
    }




}
