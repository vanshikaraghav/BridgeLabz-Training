package student_course;

public class CourseRegisterationSystem {
	public static void main(String[] args) {

        CourseRegistrationService service = new CourseRegistrationService();
        Student student = new Student(101, "Harshita");
        service.registerStudent(student);
        service.enrollCourse(student, "Java");
        service.enrollCourse(student, "DBMS");
        service.enrollCourse(student, "OS");
        service.enrollCourse(student, "CN");
        service.assignGrade(student, "Java", "A");
        service.assignGrade(student, "DBMS", "B+");
        student.displayReport();
    }
}
