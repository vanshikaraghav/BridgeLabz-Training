package class_and_objects;

public class Employee {
	
	String name;
	int id;
    double salary;
    
    void displayDetails() {
	System.out.println("Employee Name: "+name);
	System.out.println("Employee id: "+id);
	System.out.println("Employee Salary: "+salary);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
        emp.name = "Rohan";
        emp.id = 1;
        emp.salary = 500000;
        emp.displayDetails();
	}

}
