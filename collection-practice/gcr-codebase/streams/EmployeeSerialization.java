package streams;
import java.io.*;
import java.util.*;
 
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Dept=" + department + ", Salary=" + salary + "]";
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        String filename = "employees.ser";
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Harshita", "IT", 50000));
        employees.add(new Employee(102, "Aman", "HR", 45000));
        employees.add(new Employee(103, "Vanshika", "Finance", 60000));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized to " + filename);
        }catch(IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}