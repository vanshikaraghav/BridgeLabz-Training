package student_course;

abstract class RegistrationService {
    abstract void registerStudent(Student s);
    abstract void enrollCourse(Student s, String course);
    abstract void assignGrade(Student s, String course, String grade);
}
