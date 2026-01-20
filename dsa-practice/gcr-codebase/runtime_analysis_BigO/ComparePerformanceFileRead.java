package runtime_analysis_BigO;
import java.io.*;

public class ComparePerformanceFileRead {
    public static void main(String[] args) throws Exception {
        String filePath = "file.txt";
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        int words = 0;
        String line;
        while((line = br.readLine()) != null) {
            words += line.split("\\s+").length;
        }
        br.close();
        System.out.println("FileReader Words: " + words);
        System.out.println("FileReader Time: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        words = 0;
        while((line = br.readLine()) != null) {
            words += line.split("\\s+").length;
        }
        br.close();
        System.out.println("InputStreamReader Words: " + words);
        System.out.println("InputStreamReader Time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
