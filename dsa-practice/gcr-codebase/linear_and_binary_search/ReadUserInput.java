package linear_and_binary_search;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadUserInput {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        FileWriter fw = new FileWriter("file.txt");
        String line;
        System.out.println("Enter text (type 'exit' to finish):");
        while(true) {
            line = br.readLine();
            if(line.equals("exit")) {
                break;
            }
            fw.write(line + "\n");
        }
        fw.close();
        br.close();
        isr.close();
    }
}