package online_examination;
import java.util.*;

public class Exam {
	String examName;
    ArrayList<Question> questions = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    boolean examActive = true;

    Exam(String examName) {
        this.examName = examName;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }

    void enrollStudent(Student s) {
        students.add(s);
    }

    void submitAnswers(Student s, ArrayList<String> answers) throws ExamTimeExpiredException {
        if(!examActive) {
            throw new ExamTimeExpiredException("Exam time is over!");
        }

        for(int i=0;i<questions.size();i++) {
            s.score += questions.get(i).evaluateAnswer(answers.get(i));
        }
    }

    void endExam() {
        examActive = false;
    }

    void generateResult() {
        System.out.println("Exam Results");
        for(Student s : students) {
            System.out.println("Student: " + s.name + " | Score: " + s.score);
        }
    }
}
