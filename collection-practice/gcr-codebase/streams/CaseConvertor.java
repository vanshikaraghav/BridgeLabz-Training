package streams; 

import java.io.*;

public class CaseConvertor {
	public static void main(String[] args) {
		String sourceFile = "source.txt";         
		String destinationFile = "destination.txt";   
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
				BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line.toLowerCase());  
				bw.newLine();  
			}
			System.out.println("File has been converted to lowercase and saved to: " + destinationFile);
		}catch(FileNotFoundException e) {
			System.out.println("Source file not found: " + sourceFile);
		}catch(IOException e) {
			System.out.println("An error occurred during file operation: " + e.getMessage());
		}
	}
}
