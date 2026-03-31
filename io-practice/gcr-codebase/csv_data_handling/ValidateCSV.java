package csv_data_handling;
import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
	public static void main(String[] args) {
		String file = "data.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			br.readLine();
			while((line = br.readLine()) != null) {
				String[] col = line.split(",");
				if(col.length >= 4) {
					if(!col[2].matches("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}")) {
						System.out.println("invalid email... " );
					}
					if(!col[3].matches("[0-9]{10}")) {
						System.out.println("Invalid phone number");
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}