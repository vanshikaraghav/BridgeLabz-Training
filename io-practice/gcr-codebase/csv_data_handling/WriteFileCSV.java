package csv_data_handling;
import java.io.*;

public class WriteFileCSV {
    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(new FileWriter("employees.csv"));
        pw.println("ID,Name,Department,Salary");
        pw.println("1,Harshita,IT,50000");
        pw.println("2,Vanshika,HR,40000");
        pw.println("3,Rahul,IT,60000");
        pw.println("4,Neha,Finance,55000");
        pw.println("5,Aditi,IT,65000");
        pw.close();
        System.out.println("CSV written successfully");
    }
}
