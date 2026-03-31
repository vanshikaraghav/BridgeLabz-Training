package built_in_Functions;
import java.util.Scanner;

public class BasicCalculator {
	
	public static int add(int a,int b) {
		return a + b;
	}

    public static int subtract(int a,int b) {
    	return a - b;
    }

    public static int multiply(int a,int b) { 
    	return a * b;
    }

    public static double divide(int a,int b) {
        if(b==0) {
           return 0;
        }
        return (double)a/b;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int operation = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(operation==1) {
        	System.out.println("Sum = " +add(a,b));
        }else if(operation==2) {
        	System.out.println("Difference = " +subtract(a,b));
        }else if(operation==3) {
        	System.out.println("Product = " +multiply(a,b));
        }else if(operation==4) {
        	System.out.println("Quotient = " +divide(a,b));
        }else {
        	System.out.println("Invalid operation.");
        }
	}

}
