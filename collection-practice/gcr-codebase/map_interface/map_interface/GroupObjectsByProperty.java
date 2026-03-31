package map_interface;
import java.util.*;

public class GroupObjectsByProperty {
	
	static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String toString() {
            return name;
        }
    }

    static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();
        for(Employee e : employees) {
            map.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }
        return map;
    }
    
    public static void main(String[] args) {
    	List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );
        System.out.println("Grouped Employees: " + groupByDepartment(employees));
	}
}
