package csv_data_handling;
import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;

    Student(int i, String n) {
        id = i;
        name = n;
    }

    public String toString() {
        return id + " " + name;
    }
}

public class CSVToObject {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("student.csv"));
        List<Student> list = new ArrayList<>();
        br.readLine();
        String line;
        while((line = br.readLine()) != null) {
            String[] d = line.split(",");
            list.add(new Student(Integer.parseInt(d[0]), d[1]));
        }
        br.close();
        list.forEach(System.out::println);
    }
}
