package csv_data_handling;
import java.io.*;

public class CountRows {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("student.csv"));
        int count = 0;
        br.readLine();
        while(br.readLine() != null) {
            count++;
        }
        br.close();
        System.out.println("Total records: " + count);
    }
}
