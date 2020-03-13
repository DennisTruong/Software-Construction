package model.question;

import model.question.checker.AnswerChecker;
import model.question.checker.ArithmeticAnswerChecker;


public class ArithmeticQuestion extends Question {
    public enum Operation { ADDITION, SUBTRACTION, MULTIPLICATION }


    public ArithmeticQuestion(int maxMark, Operation operation, int firstOp, int secondOp) {
        super(maxMark,
                makeQuestionString(firstOp, operation, secondOp),
                new ArithmeticAnswerChecker(correctAnswer(firstOp, operation, secondOp)));
    }

    private static String makeQuestionString(int firstOp, Operation operation, int secondOp) {
        String questionString;
        String leftHandSide = Integer.toString(firstOp);
        String rightHandSide = Integer.toString(secondOp);

        if (operation == Operation.ADDITION) {
            questionString = ("What is " + leftHandSide + " + " + rightHandSide + " ?");
        } else if (operation == Operation.SUBTRACTION) {
            questionString = ("What is " + leftHandSide + " - " + rightHandSide + " ?");
        } else {
            questionString = ("What is " + leftHandSide + " * " + rightHandSide + " ?");
        }
        return questionString;
    }

    private static int correctAnswer(int firstOp, Operation operation, int secondOp) {
        int answer;

        if (operation == Operation.ADDITION) {
            answer = firstOp + secondOp;
        } else if (operation == Operation.SUBTRACTION) {
            answer = firstOp - secondOp;
        } else {
            answer = firstOp * secondOp;
        }
        return answer;
    }


}
