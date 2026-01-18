package linear_and_binary_search;
import java.io.*;

public class CompareChallengeQuestion {

    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // StringBuilder
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (end - start) + " ms");

        // StringBuffer
        start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for(int i = 0; i < iterations; i++) {
            sbuf.append(text);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (end - start) + " ms");
        String filePath = "file.txt"; 
        try {
        	
            // FileReader
            start = System.currentTimeMillis();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int wordCount = 0;
            String line;
            while((line = br.readLine()) != null) {
                if(!line.isEmpty()) {
                    wordCount += line.split("\\s+").length;
                }
            }
            br.close();
            end = System.currentTimeMillis();
            System.out.println("\nFileReader Words: " + wordCount);
            System.out.println("FileReader Time: " + (end - start) + " ms");

            // InputStreamReader
            start = System.currentTimeMillis();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")
            );
            wordCount = 0;
            while((line = br.readLine()) != null) {
                if(!line.isEmpty()) {
                    wordCount += line.split("\\s+").length;
                }
            }
            br.close();
            end = System.currentTimeMillis();
            System.out.println("\nInputStreamReader Words: " + wordCount);
            System.out.println("InputStreamReader Time: " + (end - start) + " ms");
        }catch(IOException e){
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
