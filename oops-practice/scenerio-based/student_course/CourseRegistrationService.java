package student_course;

public class CourseRegistrationService extends RegistrationService {

    public void registerStudent(Student s) {
        System.out.println("Student Registered: " + s.name);
    }

    public void enrollCourse(Student s, String course) {
        try {
            s.enrollCourse(course);
            System.out.println("Enrolled in " + course);
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    public void assignGrade(Student s, String course, String grade) {
        s.assignGrade(course, grade);
        System.out.println("Grade Assigned");
    }
}
