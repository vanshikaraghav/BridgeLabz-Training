package this_static_final_instance;

class Student {
    static String universityName = "Global University";
    static int totalStudents = 0;
    final int rollNumber;
    String name;
    String grade;

    Student(int rollNumber,String name,String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: "+totalStudents);
    }

    void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated to: "+newGrade);
    }

    void displayStudent(Object obj) {
        if(obj instanceof Student) {
            System.out.println("University Name: "+universityName);
            System.out.println("Roll Number: "+rollNumber);
            System.out.println("Name: "+name);
            System.out.println("Grade: "+grade);
        }
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student stud1 = new Student(101,"Hemashree","A");
        Student stud2 = new Student(102,"Sharmila","B");
        Student.displayTotalStudents();
        stud1.displayStudent(stud1);
        stud2.displayStudent(stud2);
        stud2.updateGrade("A");
        stud2.displayStudent(stud2);
    }
}
