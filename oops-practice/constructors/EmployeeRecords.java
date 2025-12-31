package constructors_and_variables;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }
}

class Manager extends Employee {
    void displayDetails() {
        System.out.println("Employee ID: "+employeeID+" | Department: "+department+" | Salary: "+getSalary());
    }
}

public class EmployeeRecords {
	public static void main(String[] args) {
        Manager mg = new Manager();
        mg.employeeID = 101;
        mg.department = "Tech";
        mg.setSalary(70000);
        mg.displayDetails();
        mg.setSalary(55000);
        System.out.println("Updated Salary: ₹"+mg.getSalary());
    }
}
