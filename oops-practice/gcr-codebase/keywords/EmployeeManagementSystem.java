package this_static_final_instance;

class Employee{
	
	static String companyName = "Tech Solutions Inc.";
	static int totalEmployee = 0;
	
	final int id;
	String name;
	String designation;
	
	Employee(int id,String name,String designation){
		this.id = id;
		this.name = name;
		this.designation = designation;
		totalEmployee++;
	}
	
	static void displayTotalEmployee() {
		System.out.println("Total Employees: "+totalEmployee);
	}
	
	void displayEmployeeDetails(Object obj) {
		if(obj instanceof Employee) {
			System.out.println("Company Name: "+companyName+" | Employee ID: "+id+" | Name: "+name+" | Designation: "+designation);
		}
	}
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
        Employee emp1 = new Employee(101,"Thamarai","Software Engineer");
        Employee emp2 = new Employee(102,"Rohan","Project Manager");
        Employee.displayTotalEmployee();
        emp1.displayEmployeeDetails(emp1);
        emp2.displayEmployeeDetails(emp2);
	}
}
