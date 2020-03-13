package model.question.checker;

public class ArithmeticAnswerChecker  extends AnswerChecker {
    private int answer;

    // EFFECTS: constructs checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String answerStr) {
        try {
            return answer == Integer.parseInt(answerStr);
        } catch (NumberFormatException e) {
            return  false;
        }
    }
}
