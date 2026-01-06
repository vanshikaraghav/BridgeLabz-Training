package scenario_based;
import java.util.Scanner;

public class StudentScoreAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++) {
            while(true) {
                try{
                    System.out.print("Enter score for student " + (i + 1) + ": ");
                    int score = sc.nextInt();
                    if(score<0) {
                        System.out.println("Score cannot be negative. Try again.");
                    }else {
                        scores[i] = score;
                        sum += score;
                        break;
                    }
                }catch(Exception e) {
                    System.out.println("Invalid input. Enter numbers only.");
                    sc.next();
                }
            }
        }
        double average = (double)sum/n;
        System.out.println("\nAverage Score: " + average);
        int highest = scores[0];
        int lowest = scores[0];
        for(int score : scores) {
            if(score>highest)
                highest = score;
            if(score<lowest)
                lowest = score;
        }
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("\nScores above average:");
        for(int score : scores) {
            if(score>average) {
                System.out.println(score);
            }
        }
    }
}
