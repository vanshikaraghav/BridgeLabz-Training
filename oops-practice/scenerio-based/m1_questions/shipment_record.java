package m1_questions;
import java.util.*;
import java.util.regex.*;
import java.time.*;

public class shipment_record {
static Set<String> modes=new HashSet<>(Arrays.asList("AIR","SEA","ROAD","RAIL","EXPRESS","FREIGHT"));
static Set<String> status=new HashSet<>(Arrays.asList("DELIVERED","CANCELLED","IN_TRANSIT"));

public static void main (String [] args) {
	
	Scanner sc=new Scanner(System.in);
	int n=Integer.parseInt(sc.nextLine());
	
	for (int i=0;i<n;i++) {
		String record=sc.nextLine();
		if(validateRecord(record)) {
			System.out.println("COMPLIANT RECORD");
		}
		else {
			System.out.println("NON-COMPLIANT RECORD");
		}
	}
}
static boolean validateRecord(String record) {
	String [] parts=record.split("\\|");
	if(parts.length!=5)return false;
	String code=parts[0];
	String date=parts[1];
	String mode=parts[2];
	String weight=parts[3];
	String delivery=parts[4];
	
	return validateCode(code) && validateDate(date) && validateMode(mode) && 
			validateWeight(weight) && validateStatus(delivery);
}
static boolean validateCode( String code) {
	if(!code.matches("SHIP-[1-9][0-9]{5}"))
		return false;
	String digits=code.substring(5);
	int count=1;
	for(int i=1;i<digits.length();i++) {
		if(digits.charAt(i)==digits.charAt(i-1)) {
			count++;
			if(count>3) return false;}
			else {
				count=1;
			}
		}
		return true;
	
}
static boolean validateDate(String date) {
	try {
		LocalDate d=LocalDate.parse(date);
		int year=d.getYear();
		if(year< 2000 || year>2099)
			return false;
		return true;
	}
	catch(Exception e) {
		return false;
	}
}
static boolean validateMode(String mode) {
	return modes.contains(mode);
	
}
static boolean validateWeight(String weight) {
  if(!weight.matches("(0|[1-9]\\d{0,5})(\\.\\d{1,2})?"))
	  return false;
  double w=Double.parseDouble(weight);
  if(w<=0||w>999999.99)
	  return false;
  return true;
}
static boolean validateStatus(String delivery) {
	return status.contains(delivery);
}
}
