package csv_data_handling;
import java.io.*;

public class SearchEmployeeCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String searchName = "Rahul";
        br.readLine();
        String line;
        while((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if(d[1].equalsIgnoreCase(searchName)) {
                System.out.println("Dept: " + d[2] + ", Salary: " + d[3]);
            }
        }
        br.close();
    }
}
