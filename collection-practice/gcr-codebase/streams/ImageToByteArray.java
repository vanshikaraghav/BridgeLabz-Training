package streams;
import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("wallpaperflare.com_wallpaper.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytes;
            while((bytes = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytes);
            }
            fis.close();
            byte[] imageBytes = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream("output.jpg");
            while((bytes = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytes);
            }
            fos.close();
            System.out.println("Image copied successfully");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
