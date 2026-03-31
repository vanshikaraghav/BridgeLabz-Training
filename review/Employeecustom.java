package review;

import java.util.HashMap;


import java.util.HashMap;
//class Employee{
//	String name;
//	int salary;
//	public Employee( String name, int salary) {
//	
//		this.name=name;
//		this.salary=salary;
//	}
//	public String getName() {
//		return name;
//	}
//	public int getSalary() {
//		return salary;
//	}
//}
//public class Employeecustom {
//public static void main(String[] args) {
//	HashMap<Integer,Employee> employeemap=new HashMap<>();
//	employeemap.put(1,new Employee("Vanshika", 400));
//	employeemap.put(2,new Employee("Raghav",500));
//	employeemap.put(3,new Employee("Harshita",450));
//	employeemap.entrySet()
//    .stream()
//    .sorted((e1, e2) -> Integer.compare(e2.getValue().getSalary(), e1.getValue().getSalary())).skip(1)
//    .forEach(e -> System.out.println(e.getValue().getName() + " : " + e.getValue().getSalary()));
//}
//}



public class Employeecustom {
public static void main(String[] args) {
	HashMap<String,Integer> employeemap=new HashMap<>();
    employeemap.put("Vanshika", 400);
	employeemap.put("Raghav",500);
	employeemap.put("Harshita",450);
	employeemap.entrySet()
    .stream()
    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
    .skip(1).forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
}
}

