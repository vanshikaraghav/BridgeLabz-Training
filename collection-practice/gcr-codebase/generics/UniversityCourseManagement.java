package generics;
import java.util.*;

abstract class CourseType {
    protected String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    abstract void evaluate();
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }

    public void evaluate() {
        System.out.println(courseName + " evaluated via Exam");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }

    public void evaluate() {
        System.out.println(courseName + " evaluated via Assignments");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }

    public void evaluate() {
        System.out.println(courseName + " evaluated via Research");
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }
}

class CourseUtil {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            c.evaluate();
        }
    }
}

class UniversityCourseManagement {
	public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Maths"));
        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research"));
        CourseUtil.displayCourses(examCourses.getCourses());
        CourseUtil.displayCourses(researchCourses.getCourses());
    }
}
