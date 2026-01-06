package encapsulation_and_abstraction;

interface Department {
	 void assignDepartment(String deptName);
	 String getDepartmentDetails();
	}

abstract class Employee implements Department {
	 private int employeeId;
	 private String name;
	 private double baseSalary;
	 private String department;

	 Employee(int employeeId, String name, double baseSalary) {
	     this.employeeId = employeeId;
	     this.name = name;
	     this.baseSalary = baseSalary;
	 }

	 public int getEmployeeId() {
		 return employeeId;
	 }
	 
	 public String getName() { 
		 return name;
	 }
	 
	 public double getBaseSalary() { 
		 return baseSalary;
	 }

	 void setBaseSalary(double baseSalary) {
	     this.baseSalary = baseSalary;
	 }

	 @Override
	 public void assignDepartment(String deptName) {
	     this.department = deptName;
	 }

	 @Override
	 public String getDepartmentDetails() {
	     return department;
	 }

	 public abstract double calculateSalary();

	 public void displayDetails() {
	     System.out.println("Employee ID: " + employeeId);
	     System.out.println("Name: " + name);
	     System.out.println("Base Salary: " + baseSalary);
	     System.out.println("Department: " + getDepartmentDetails());
	     System.out.println("Final Salary: " + calculateSalary());
	     System.out.println("-----------------------------");
	 }
}

class FullTimeEmployee extends Employee {
	 private double bonus;

	 FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
	     super(employeeId, name, baseSalary);
	     this.bonus = bonus;
	 }

	 @Override
	 public double calculateSalary() {
	     return getBaseSalary() + bonus;
	 }
}

class PartTimeEmployee extends Employee {
	 private int hoursWorked;
	 private double hourlyRate;

	 PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
	     super(employeeId, name, 0); 
	     this.hoursWorked = hoursWorked;
	     this.hourlyRate = hourlyRate;
	 }

	 @Override
	 public double calculateSalary() {
	     return hoursWorked * hourlyRate;
	 }
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
	     Employee emp1 = new FullTimeEmployee(101, "Aman", 30000, 5000);
	     Employee emp2 = new PartTimeEmployee(102, "Harshita", 200, 120);
	     emp1.assignDepartment("HR");
	     emp2.assignDepartment("IT");
	     Employee[] employees = {emp1, emp2};
	     for(Employee emp : employees) {
	         emp.displayDetails();
	     }
	 }
}
