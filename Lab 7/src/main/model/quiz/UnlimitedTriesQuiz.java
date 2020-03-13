package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.question.QuestionList;

public class UnlimitedTriesQuiz extends Quiz {
    private int numAttempts;

    public UnlimitedTriesQuiz(QuestionList questions) {
        super(questions);
        numAttempts = 0;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // does not modify max mark of current question;
    // throws AnswerIncorrectException if the user should re-try the question;
    public String submitAnswer(String answer) throws AnswerIncorrectException {
        boolean correct = super.checkAnswer(answer);
        numAttempts++;

        if (!correct) {
            throw new AnswerIncorrectException("Incorrect answer.");
        }
        return "Correct!";
    }

    // EFFECTS: returns number of attempts taken to answer questions so far
    public int getNumAttempts() {
        return numAttempts;
    }


    @Override
    public String endQuiz() {
        int numQuestion = questions.length();
        return "It took you " + getNumAttempts() + " attempts to answer " + numQuestion  + " questions correctly.";
    }
}
