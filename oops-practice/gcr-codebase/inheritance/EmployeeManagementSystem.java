package inheritance;

public class EmployeeManagementSystem{
	public static void main(String args[]){
        Employee e1 = new Manager("Aman", 101, 60000, 5);
        Employee e2 = new Developer("Harshita", 102, 50000, "Java");
        Employee e3 = new Intern("Neha", 103, 15000, 6);
        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
	}
}

class Employee{
	 String name;
	 int id;
	 double salary;

	 Employee(String name, int id, double salary){
	     this.name = name;
	     this.id = id;
	     this.salary = salary;
	 }

	 void displayDetails(){
	     System.out.println("Name: " + name);
	     System.out.println("ID: " + id);
	     System.out.println("Salary: " + salary);
	 }
}

class Manager extends Employee{
	 int teamSize;
	
	 Manager(String name, int id, double salary, int teamSize){
	     super(name, id, salary);
	     this.teamSize = teamSize;
	 }

	 void displayDetails(){
	     super.displayDetails();
	     System.out.println("Team Size : " + teamSize+"\n"); 
	 }
}

class Developer extends Employee{
	 String programmingLanguage;
	
	 Developer(String name, int id, double salary, String programmingLanguage){
	     super(name, id, salary);
	     this.programmingLanguage = programmingLanguage;
	 }

	 void displayDetails(){
	     super.displayDetails();
	     System.out.println("Programming Language : " + programmingLanguage+"\n");
	 }
}

class Intern extends Employee{
	 int duration;  
	
	 Intern(String name, int id, double salary, int duration){
	     super(name, id, salary);
	     this.duration = duration;
	 }

	 void displayDetails(){
	     super.displayDetails();
	     System.out.println("Internship Duration : " + duration + " months");
	 }
}

