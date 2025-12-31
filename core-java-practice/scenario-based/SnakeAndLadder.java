package scenario_based;

public class SnakeAndLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int winningstart = 100;
		// UC 1: Start start at 0 and with single player
		int start = 0;
		int DiceCount
         = 0;
		
		// UC 4: Repeat the game until player reaches 100;
		while(start!=winningstart) {
		// UC 2: Random dice roll between 1 to 6
		int diceRoll = (int) (Math.random()*6)+1;  
		DiceCount
        ++;
		
		// UC 3: Random 3 options
		int options = (int) (Math.random()*3)+1;
		switch(options) {
		case 1:               // UC 3: Option - No play, player stays at same start
			System.out.println("Dice No.: "+diceRoll+" | Option: No Play | start: "+start);
			break;
		case 2:
			start = start+diceRoll;  // UC 3: Option - Ladder, player moves ahead by start as no of dice comes
			if(start>winningstart) {  // UC 5: If start is greater than 100 than player stays at same start
				start = winningstart;
			}
			System.out.println("Dice No.: "+diceRoll+" | Option: Ladder | start: "+start); // UC 6: also tells start after every dice roll. 
			break;
		case 3:
			start = start-diceRoll;
			if(start<0) {    // UC 3: Option - Snake, player moves behind by start as no of dice comes.
				start = 0;
			}
			System.out.println("Dice No.: "+diceRoll+" | Option: Snake | start: "+start);
			break;
		}
	}
		System.out.println("\nPlayer reached Winning start!");
		System.out.println("The no. of dice rolled to reach 100 are: "+DiceCount
        );  // UC 6: No. of times the dice rolled
		
		// UC 7: game for 2 players ----------------------------------------------------------
		int player1start = 0;
        int player2start = 0;  // start starts of both players
        int DiceCount
        P1 = 0;
        int DiceCount
        P2 = 0;
        boolean isPlayer1Turn = true;
        while(player1start!=winningstart && player2start!=winningstart) {  // until start not reaches 100
            int diceRollber = (int) (Math.random()*6)+1;  // Random dice rolled from 1 to 6
            int option = (int) (Math.random()*3)+1;   // Random options from 1 to 3
            if(isPlayer1Turn) {
                DiceCount
                P1++;
                System.out.println("\nPlayer 1 rolled dice no.: "+diceRollber);  // player 1 turns
                switch(option) {
                    case 1:                   // No Play
                        System.out.println("Option- No Play | start: "+player1start);
                        isPlayer1Turn = false;
                        break;
                    case 2:                   // Ladder
                        if(player1start+diceRollber<=winningstart) {
                            player1start = player1start+diceRollber;
                        }
                        System.out.println("Ladder | start: "+player1start);
                        // Player gets another chance if ladder comes
                        break;
                    case 3:                    // Snake
                        player1start = player1start-diceRollber;
                        if(player1start<0) {
                            player1start = 0;
                        }
                        System.out.println("Snake | start: "+player1start);
                        isPlayer1Turn = false;
                        break;
                }
            }else {
                DiceCount
                P2++;
                System.out.println("\nPlayer 2 rolled dice no.: "+diceRollber);  // player 2 turns
                switch (option) {
                    case 0:                   // No Play
                        System.out.println("No Play | start: "+player2start);
                        isPlayer1Turn = true;
                        break;

                    case 1:                   // Ladder
                        if(player2start+diceRollber<=winningstart) {
                            player2start = player2start+diceRollber;
                        }
                        System.out.println("Ladder | start: "+player2start);
                        break;
                    case 2:                   // Snake
                        player2start = player2start-diceRollber;
                        if(player2start<0) {
                            player2start = 0;
                        }
                        System.out.println(" Snake | start: "+player2start);
                        isPlayer1Turn = true;
                        break;
                }
            }
        }
        // Winner
        System.out.println("\nGAME OVER!!");
        if(player1start==winningstart) {
            System.out.println("Player 1 won the game!");
            System.out.println("Dice rolled by Player 1 are: " + DiceCount
            P1);
        }else {
            System.out.println("Player 2 won the game!");
            System.out.println("Dice rolled by Player 2 are: " + DiceCount
            P2);
        }
	}

}
