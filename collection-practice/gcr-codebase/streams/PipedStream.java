package streams; 
import java.io.*;

public class PipedStream {
    public static void main(String[] args) {
        try { 
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);  
            Thread writer = new Thread(() -> {
                String data = "Hello from Writer Thread!";
                try {
                    for(char ch : data.toCharArray()) {
                        pos.write(ch);  
                        Thread.sleep(100);  
                    }
                    pos.close();  
                }catch(IOException | InterruptedException e) {
                    System.out.println("Writer Thread Error: " + e.getMessage());
                }
            });
            Thread reader = new Thread(() -> {
                try {
                    int ch;
                    while((ch = pis.read()) != -1) { 
                        System.out.print((char) ch);
                    }
                    pis.close(); 
                }catch(IOException e) {
                    System.out.println("Reader Thread Error: " + e.getMessage());
                }
            });
            writer.start();
            reader.start(); 
            writer.join();
            reader.join();
        }catch(IOException | InterruptedException e) {
            System.out.println("Main Thread Error: " + e.getMessage());
        }
    }
}