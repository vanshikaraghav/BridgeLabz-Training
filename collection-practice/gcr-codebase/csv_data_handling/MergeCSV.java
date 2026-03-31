package csv_data_handling;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        br1.readLine();
        String line;
        while((line = br1.readLine()) != null) {
            map.put(line.split(",")[0], line);
        }
        br1.close();
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        PrintWriter pw = new PrintWriter(new FileWriter("merged.csv"));
        pw.println("ID,Name,Age,Marks,Grade");
        br2.readLine();
        while ((line = br2.readLine()) != null) {
            String id = line.split(",")[0];
            pw.println(map.get(id) + "," + line.substring(id.length() + 1));
        }
        br2.close();
        pw.close();
    }
}
