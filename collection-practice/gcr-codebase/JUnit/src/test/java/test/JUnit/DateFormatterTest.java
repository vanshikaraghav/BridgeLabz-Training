package test.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("25-12-2024", formatter.formatDate("2024-12-25"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("25/12/2024");
        });
    }
}