package class_and_objects;

public class Student {
	
	String name;
    String rollNumber;
    double marks1;
    double marks2;
    double marks3;

    String calculateStudentGrade() {
        double average = (marks1+marks2+marks3)/3;
        if(average>=75) {
            return "A";
        }else if(average>=60) {
            return "B";
        }else {
            return "C";
        }
    }

    void displayStudentDetails() {
        System.out.println("Student Name: "+name);
        System.out.println("Student RollNumber: "+rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Marks1: " +marks1);
        System.out.println("Marks2: " +marks2);
        System.out.println("Marks3: " +marks3);
        System.out.println("Grade " +calculateStudentGrade());
        System.out.println();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student();
        student1.name = "Thamarai";
        student1.rollNumber = "ECE001";
        student1.marks1 = 80.0;
        student1.marks2 = 70.0;
        student1.marks3 = 75.0;
        Student student2 = new Student();
        student2.name = "Kannan";
        student2.rollNumber = "CSC002";
        student2.marks1 = 60.0;
        student2.marks2 = 65.0;
        student2.marks3 = 50.0;
        student1.displayStudentDetails();
        student2.displayStudentDetails();
	}

}
