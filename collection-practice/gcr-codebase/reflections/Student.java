package reflections;

class Student {
    private String name;
    private int rollNo;

    public Student() {
        name = "Harshita";
        rollNo = 22;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}