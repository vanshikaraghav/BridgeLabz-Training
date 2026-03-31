package test.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.Test;

public class FileProcessorTest {

    FileProcessor processor = new FileProcessor();

    @Test
    void testWriteAndRead() throws IOException {
        String filename = "test.txt";
        processor.writeToFile(filename, "Hello JUnit");
        assertEquals("Hello JUnit", processor.readFromFile(filename));
    }

    @Test
    void testFileExists() throws IOException {
        String filename = "exist.txt";
        processor.writeToFile(filename, "Data");
        assertTrue(new File(filename).exists());
    }

    @Test
    void testReadNonExistingFile() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nofile.txt");
        });
    }
}