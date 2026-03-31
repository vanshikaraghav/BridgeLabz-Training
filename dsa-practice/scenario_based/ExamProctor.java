package scenario_based;
import java.util.*;

class ExamProctor {
    Stack<Integer> navigationStack = new Stack<>();
    HashMap<Integer, String> answers = new HashMap<>();
    HashMap<Integer, String> correctAnswers = new HashMap<>();

    void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    int calculateScore() {
        int score = 0;
        for(int quesid : correctAnswers.keySet()) {
            if(correctAnswers.get(quesid).equals(answers.get(quesid))) {
                score++;
            }
        }
        return score;
    }

    void goBack() {
        if(!navigationStack.isEmpty()) {
            System.out.println("Back from Question: " + navigationStack.pop());
        }else {
            System.out.println("No previous question.");
        }
    }

    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();
        exam.correctAnswers.put(1, "A");
        exam.correctAnswers.put(2, "B");
        exam.correctAnswers.put(3, "C");
        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");
        exam.visitQuestion(2);
        exam.submitAnswer(2, "B");
        exam.visitQuestion(3);
        exam.submitAnswer(3, "D");
        exam.goBack();
        int score = exam.calculateScore();
        System.out.println("Final Score: " + score);
    }
}
