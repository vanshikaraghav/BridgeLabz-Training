package online_examination;

public class DescriptiveEvaluation implements EvaluationStrategy {
    public int evaluate(Question question, String studentAnswer) {
        return studentAnswer.length() >= 10 ? question.marks : question.marks / 2;
    }
}