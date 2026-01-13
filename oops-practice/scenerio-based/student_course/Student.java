package student_course;
import java.util.*;

public class Student extends Person{
	private ArrayList<Course> courses = new ArrayList<>();
    private static final int MAX_COURSES = 3;

    Student(int id, String name) {
        super(id, name);
    }

    public void enrollCourse(String courseName) throws CourseLimitExceededException {
        if (courses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded!");
        }
        courses.add(new Course(courseName));
    }

    public void dropCourse(String courseName) {
        courses.removeIf(c -> c.getCourseName().equals(courseName));
    }

    public void assignGrade(String courseName, String grade) {
        for (Course c : courses) {
            if (c.getCourseName().equals(courseName)) {
                c.setGrade(grade);
                return;
            }
        }
        System.out.println("Course not found");
    }

    public void displayReport() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Courses & Grades:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName() + " : " + c.getGrade());
        }
    }
}