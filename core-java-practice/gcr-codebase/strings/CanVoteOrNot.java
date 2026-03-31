package strings;
import java.util.Scanner;

public class CanVoteOrNot {
	
	public static String[][] checkVoting(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18)
                result[i][1] = "Can Vote";
            else
                result[i][1] = "Cannot Vote";
        }
        return result;
    }

    public static void display(String[][] data) {
        System.out.println("Age\tStatus");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        String[][] result = checkVoting(ages);
        display(result);
    }
}
