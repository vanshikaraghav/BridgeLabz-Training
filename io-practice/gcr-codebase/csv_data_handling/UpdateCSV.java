package csv_data_handling;
import java.io.*;

public class UpdateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        PrintWriter pw = new PrintWriter(new FileWriter("updated_employees.csv"));
        pw.println(br.readLine()); 
        String line;
        while((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if(d[2].equalsIgnoreCase("IT")) {
                double salary = Double.parseDouble(d[3]);
                salary *= 1.10;
                d[3] = String.valueOf(salary);
            }
            pw.println(String.join(",", d));
        }
        br.close();
        pw.close();
    }
}
