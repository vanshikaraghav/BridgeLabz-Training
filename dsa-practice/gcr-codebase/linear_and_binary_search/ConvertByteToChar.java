package linear_and_binary_search;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConvertByteToChar {

    public static void main(String[] args) {
        String filePath = "file.txt";
        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr)
        ) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
