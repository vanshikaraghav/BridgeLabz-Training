package methods;
import java.util.Scanner;

public class SpringSeason {
	
	public static boolean isSpring(int month,int day) {
		if((month == 3 && day >= 20) || (month==4) || (month==5) || (month==6 && day<=20)){
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.print("Enter day: ");
        int day = sc.nextInt();
        if(isSpring(month,day)) {
        	System.out.println("Spring Season");
        }else {
        	System.out.println("Not spring season");
        }
	}

}
