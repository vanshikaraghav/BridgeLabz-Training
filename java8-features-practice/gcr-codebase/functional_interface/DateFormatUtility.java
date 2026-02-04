package functional_interface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
	static String formatDate(LocalDate date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return date.format(formatter);
	}
}

public class DateFormatUtility {
	public static void main(String[] args) {
		LocalDate invoiceDate = LocalDate.now();
		String format1 = DateUtils.formatDate(invoiceDate, "dd-MM-yyyy");
		String format2 = DateUtils.formatDate(invoiceDate, "dd/MM/yyyy");
		String format3 = DateUtils.formatDate(invoiceDate, "yyyy-MM-dd");
		System.out.println("Invoice Date (DD-MM-YYYY): " + format1);
		System.out.println("Invoice Date (DD/MM/YYYY): " + format2);
		System.out.println("Invoice Date (YYYY-MM-DD): " + format3);
	}
}