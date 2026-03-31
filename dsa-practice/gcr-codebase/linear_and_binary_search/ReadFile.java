package linear_and_binary_search;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();
        }catch(IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}