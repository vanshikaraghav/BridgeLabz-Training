package programming_elements;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc=new Scanner(System.in);
       float a=sc.nextFloat();
       float b=sc.nextFloat();
       float sum=a+b;
       float diff=a-b;
       float mul=a*b;
       float div=a/b;
       System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+a+" and "+b+" is "+sum+" ,"+diff+" ,"+mul+ " and "+div);
	}

}
