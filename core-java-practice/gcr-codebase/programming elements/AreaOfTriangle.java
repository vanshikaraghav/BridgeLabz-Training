package programming_elements;

import java.util.Scanner;

public class AreaOfTriangle{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc=new Scanner(System.in);
       int base=sc.nextInt();
       int height=sc.nextInt();
       int area=(base*height)/2;
       System.out.println("Area of triangle is "+area);
	}

}
