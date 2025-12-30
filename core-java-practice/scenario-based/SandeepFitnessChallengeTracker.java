package scenario_based;
import java.util.Scanner;

public class SandeepFitnessChallengeTracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pushUps = new int[n];
		for(int i=0;i<n;i++) {
			pushUps[i] = sc.nextInt();
		}
        int total = 0;
        int activeDays = 0;
        for(int count:pushUps) {
            if(count==0) {
                continue; 
            }
            total += count;
            activeDays++;
        }
        double average = total/(double)activeDays;
        System.out.println("Total Push ups: "+total);
        System.out.println("Average Push ups per active day: "+average);
	}

}
