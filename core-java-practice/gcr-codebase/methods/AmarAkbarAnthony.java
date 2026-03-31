package methods;
import java.util.Scanner;

public class AmarAkbarAnthony {
	
	public static int Youngest(int[] age) {
        int minIndex = 0;
        for(int i=1;i<age.length;i++) {
            if(age[i]<age[minIndex]) {
            	minIndex = i;
            }
        }
        return minIndex;
    }

    public static int Tallest(double[] height) {
        int maxIndex = 0;
        for (int i=1;i<height.length;i++) {
            if (height[i]>height[maxIndex]) {
            	maxIndex = i;
            }
        }
        return maxIndex;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] age = new int[3];
        double[] height = new double[3];
        String[] names = {"Amar","Akbar","Anthony"};
        for (int i=0;i<3;i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }
        System.out.println("Youngest: " + names[Youngest(age)]);
        System.out.println("Tallest: " + names[Tallest(height)]);
	}

}
