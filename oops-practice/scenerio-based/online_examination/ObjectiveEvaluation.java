package online_examination;

public class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(Question question, String studentAnswer) {
        return question.correctAnswer.equalsIgnoreCase(studentAnswer) ? question.marks : 0;
    }
}
