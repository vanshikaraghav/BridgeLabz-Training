package csv_data_handling;
import java.io.*;

public class FilterRecordCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("student.csv"));
        br.readLine();
        String line;
        while((line = br.readLine()) != null) {
            String[] d = line.split(",");
            int marks = Integer.parseInt(d[3]);
            if(marks > 80) {
                System.out.println(line);
            }
        }
        br.close();
    }
}
