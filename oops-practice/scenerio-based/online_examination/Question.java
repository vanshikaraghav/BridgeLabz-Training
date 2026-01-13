package online_examination;

public class Question {
	String questionText;
    String correctAnswer;
    int marks;
    EvaluationStrategy strategy;

    Question(String questionText, String correctAnswer, int marks, EvaluationStrategy strategy) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
        this.strategy = strategy;
    }

    int evaluateAnswer(String answer) {
        return strategy.evaluate(this, answer);
    }
}
