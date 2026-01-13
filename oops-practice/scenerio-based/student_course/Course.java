package student_course;

public class Course {
	private String courseName;
    private String grade; 

    Course(String courseName) {
        this.courseName = courseName;
        this.grade = "Not Assigned";
    }

    public String getCourseName() {
        return courseName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}