package built_in_Functions;
import java.util.Scanner;

public class NumberGuessingGame {
	
	public static int generateGuess(int low, int high) {
        return low + (int)(Math.random()*(high-low + 1));
    }

    public static String getUserFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "? (Enter 'low', 'high', or 'correct')");
        return sc.next();
    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean guessNum = false;
        while(!guessNum && low<=high) {
            int guess = generateGuess(low,high);
            String feedback = getUserFeedback(sc,guess);
            if(feedback.equals("low")) {
                low = guess + 1;
            }else if(feedback.equals("high")) {
                high = guess - 1;
            }else if(feedback.equals("correct")) {
                System.out.println("The computer guessed your number: " + guess);
                guessNum = true;
            }
        }
        if(!guessNum) {
            System.out.println("Inconsistent responses. Game over.");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playGame();
	}

}
