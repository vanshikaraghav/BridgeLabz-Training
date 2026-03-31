package scenario_based;
import java.util.Scanner;

public class LineComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Display welcome message
        System.out.println("Welcome to Line Comparison Computation Program on Master Branch\n");
        
        // UC 1: points for Line 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter points for Line 1: ");
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y1 = sc.nextInt();
        int y2 = sc.nextInt();
        
        // points for Line 2
        System.out.println("Enter points for Line 2: ");
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y3 = sc.nextInt();
        int y4 = sc.nextInt();

        // UC 1: Calculate length of both lines
        Double length1 = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        Double length2 = Math.sqrt(Math.pow(x4-x3,2)+Math.pow(y4-y3,2));
        System.out.println("\nLength of Line 1: "+length1);
        System.out.println("Length of Line 2: "+length2);
        
        // UC 2: Check equality by equals
        if(length1.equals(length2)) {
            System.out.println("\nBoth lines are Equal");
        }else {
            System.out.println("\nBoth lines are Not Equal");
        }

        // UC 3: Compare lines by compareTo
        int result = length1.compareTo(length2);
        if(result==0) {
            System.out.println("Line 1 is equal to Line 2");
        }else if(result>0) {
            System.out.println("Line 1 is greater than Line 2");
        }else {
            System.out.println("Line 1 is less than Line 2");
        }
	}

}
