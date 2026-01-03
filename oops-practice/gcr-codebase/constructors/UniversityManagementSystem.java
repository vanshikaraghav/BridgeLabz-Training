package constructors_and_variables;

class Student {
	
    public int rollNumber;
    protected String name;
    private double CGPA;

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    void displayDetails() {
        System.out.println("Roll Number: "+rollNumber+" | Name: "+name+" | CGPA: "+getCGPA());
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        PostgraduateStudent stud = new PostgraduateStudent();
        stud.rollNumber = 22;
        stud.name = "Aman";
        stud.setCGPA(7.0);
        stud.displayDetails();
        stud.setCGPA(9.1);
        System.out.println("Updated CGPA: " + stud.getCGPA());
    }
}
