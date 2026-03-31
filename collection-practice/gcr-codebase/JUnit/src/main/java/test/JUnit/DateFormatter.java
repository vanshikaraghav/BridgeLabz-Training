package test.JUnit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate);
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch(Exception e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}