package streams;
import java.io.*;

public class CompareBufferedStreams {
    public static void copyUnbuffered(File src, File dest) throws IOException {
        long start = System.nanoTime();
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        byte[] buffer = new byte[4096];
        int bytes;
        while((bytes = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytes);
        }
        fis.close();
        fos.close();
        long end = System.nanoTime();
        System.out.println("Unbuffered Time: " + (end - start) / 1_000_000 + " ms");
    }

    public static void copyBuffered(File src, File dest) throws IOException {
        long start = System.nanoTime();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] buffer = new byte[4096];
        int bytes;
        while((bytes = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytes);
        }
        bis.close();
        bos.close();
        long end = System.nanoTime();
        System.out.println("Buffered Time: " + (end - start) / 1_000_000 + " ms");
    }

    public static void main(String[] args) throws IOException {
        File src = new File("source.txt");
        copyUnbuffered(src, new File("copy1.txt"));
        copyBuffered(src, new File("copy2.txt"));
    }
}
