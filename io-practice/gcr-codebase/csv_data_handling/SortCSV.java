package csv_data_handling;
import java.io.*;
import java.util.*;

class Employee {
    String name;
    double salary;

    Employee(String n, double s) {
        name = n;
        salary = s;
    }
}

public class SortCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        List<Employee> list = new ArrayList<>();
        br.readLine();
        String line;
        while((line = br.readLine()) != null) {
            String[] d = line.split(",");
            list.add(new Employee(d[1], Double.parseDouble(d[3])));
        }
        br.close();
        list.sort((a, b) -> Double.compare(b.salary, a.salary));
        list.stream().limit(5).forEach(e -> System.out.println(e.name + " " + e.salary));
    }
}
