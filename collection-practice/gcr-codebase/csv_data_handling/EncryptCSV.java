package csv_data_handling;

import java.io.*;
import java.util.Base64;

public class EncryptCSV {
    public static void main(String[] args) throws Exception {

        String data = "salary@email.com";
        String encrypted = Base64.getEncoder().encodeToString(data.getBytes());
        String decrypted = new String(Base64.getDecoder().decode(encrypted));

        System.out.println(encrypted);
        System.out.println(decrypted);
    }
}

