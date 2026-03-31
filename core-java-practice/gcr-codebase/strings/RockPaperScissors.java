package strings;

import java.util.Scanner;

public class RockPaperScissors {

	public static String computerChoice() {
        int r = (int) (Math.random() * 3);
        return (r == 0) ? "Rock" : (r == 1) ? "Paper" : "Scissors";
    }

    public static String winner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        }
        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        }
        return "Computer";
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int userWins = 0, computerWins = 0;
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        for (int i = 1; i <= games; i++) {
            System.out.print("Enter choice (Rock/Paper/Scissors): ");
            String user = sc.next();
            String computer = computerChoice();
            String result = winner(user, computer);
            System.out.println("Computer chose: " + computer);
            System.out.println("Winner: " + result);
            if (result.equals("User")) userWins++;
            else if (result.equals("Computer")) computerWins++;
        }
        System.out.println("\nUser Wins     : " + userWins);
        System.out.println("Computer Wins : " + computerWins);
	}

}
