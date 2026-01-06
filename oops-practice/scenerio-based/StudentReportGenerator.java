package scenario_based;
import java.util.ArrayList;
import java.util.List;

class InvalidMarkException extends Exception {
    InvalidMarkException(String msg) {
        super(msg);
    }
}

class Student {
    String name;
    String[] subjects;
    int[] marks;

    Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
        validateMarks();
    }

    void validateMarks() throws InvalidMarkException {
        for (int m : marks) {
            if (m < 0 || m > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }
        }
    }

    double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / (double) marks.length;
    }

    String assignGrade() {
        double avg = calculateAverage();
        if (avg >= 80) return "A";
        if (avg >= 60) return "B";
        if (avg >= 40) return "C";
        return "Fail";
    }

    void displayReport() {
        System.out.println("Student Name: " + name);
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + assignGrade());
    }
}

public class StudentReportGenerator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        try{
            students.add(new Student(
                    "Anita",
                    new String[]{"Math", "Science", "English"},
                    new int[]{78, 85, 69}
            ));
            students.add(new Student(
                    "Rahul",
                    new String[]{"Math", "Science", "English"},
                    new int[]{55, 60, 58}));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for(Student s : students) {
            s.displayReport();
        }
    }
}
