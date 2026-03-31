package online_examination;
import java.util.*;

public class OnlineExaminationSystem {
	public static void main(String[] args) {
        Exam exam = new Exam("Java Test");
        exam.addQuestion(new Question(
                "What is JVM?",
                "Java Virtual Machine",
                5,
                new ObjectiveEvaluation()
        ));

        exam.addQuestion(new Question(
                "Explain OOP concepts",
                "",
                10,
                new DescriptiveEvaluation()
        ));

        Student s1 = new Student(1, "Harshita");
        exam.enrollStudent(s1);
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Java Virtual Machine");
        answers.add("OOP includes encapsulation inheritance polymorphism abstraction");
        try {
            exam.submitAnswers(s1, answers);
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
        exam.endExam();
        exam.generateResult();
    }
}
